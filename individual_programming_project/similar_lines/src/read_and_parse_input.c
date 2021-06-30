#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <limits.h>
#include <ctype.h>
#include <errno.h>
#include "check_type_functions.h"
#include "read_and_parse_input.h"
#include "structs.h"

#define INIT_ARRAY_SIZE 4
#define SPACE 32
#define WRONG_SIGN 127

static char* readOneLineAndCheckForEOF(bool* continueReading) {
    char* newLine = NULL;
    size_t length = 0;
    ssize_t lineSize = 0;

    lineSize = getline(&newLine, &length, stdin);
    if (errno == ENOMEM) {
        exit(1);
    }
    if (lineSize == EOF) {
        *continueReading = false;
        free(newLine);
        return NULL;
    }
    //'\0' inside of a line
    //not an elegant solution
    if(lineSize != (unsigned) strlen(newLine) && strlen(newLine) != 0) {
        newLine[0] = WRONG_SIGN;
    }
    return newLine;
}
static bool isSignWhitespace(char sign) {
    return sign == SPACE || (sign >= 9 && sign <= 13);
}
static size_t iterateTillFirstNotWhitespace(size_t i, size_t lineLength, char* line) {
    char currentSign = line[i];
    while (i + 1 < lineLength && (isSignWhitespace(currentSign) || currentSign == '\0')) {
        currentSign = line[++i];
    }
    //returns index of first not whitespace
    return i;
}
static size_t iterateTillFirstWhitespace(size_t i, size_t lineLength, char* line) {
    char currentSign = line[i];
    while (i + 1 < lineLength && !isSignWhitespace(currentSign)) {
        currentSign = line[++i];
    }
    //return index of first whitespace
    return i;
}
static char* extractOneWordFromLine(size_t* ind, size_t lineLength, char* line) {
    size_t i = *ind;

    i = iterateTillFirstNotWhitespace(i, lineLength, line);
    size_t wordBegin = i;
    char *word = &line[wordBegin];

    i = iterateTillFirstWhitespace(i, lineLength, line);
    size_t firstWhitespaceAfterWord = i;

    //if file ends with EOF without newline
    if(!(isSignWhitespace(line[firstWhitespaceAfterWord]))) {
        firstWhitespaceAfterWord++;
    }

    line[firstWhitespaceAfterWord] = '\0';
    i = iterateTillFirstNotWhitespace(i, lineLength, line);
    *ind = i;

    size_t sizeOfExtractedWord = firstWhitespaceAfterWord - wordBegin + 1;

    char *extractedWord = malloc(sizeOfExtractedWord * sizeof(char));
    if (extractedWord == NULL) {
        exit(1);
    }
    sscanf(word, "%s", extractedWord);

    return extractedWord;
}
static void checkNumberBase(char* word, size_t wordSize, bool* isOctal,
                            bool* isDecimal, bool* isHexadecimal) {
    if (isOnlyPlusOrMinus(word, wordSize)) {
        *isDecimal = false;
    }
    if (!doesWordBeginWithZero(word)) {
        *isOctal = *isHexadecimal = false;
    }
    if (isSecondSignNotX(word, wordSize)) {
        *isHexadecimal = false;
    }
    for (size_t i = 0; i < wordSize; i++) {

        if (!(isSignFromHexSystem(word, i))) {
            *isHexadecimal = false;
        }
        if (!(isSignFromOctSystem(word, i))) {
            *isOctal = false;
        }
        if (!(isSignFromDecSystem(word, i))) {
            *isDecimal = false;
        }
    }
}
static int is_8_10_16_decimal(char* word, size_t wordSize) {
    bool isOctal = true;
    bool isDecimal = true;
    bool isHexadecimal = true;

    checkNumberBase(word, wordSize, &isOctal, &isDecimal, &isHexadecimal);

    if (isHexadecimal)
        return 16;
    if (isOctal)
        return 8;
    if (isDecimal)
        return 10;
    return 0;
}
static void toLowerWord(char** word, size_t wordSize) {
    for (size_t i = 0; i < wordSize; i++) {
        (*word)[i] = tolower((*word)[i]);
    }
}
static void saveNotANumber(char* word, size_t wordSize,
                           size_t lineNumber, size_t wordNumber) {
    toLowerWord(&word, wordSize);
    data[lineNumber].oneLine[wordNumber].word.NotANumber = word;
    data[lineNumber].oneLine[wordNumber].type = 'c';
}
static void saveNumber(char* word, size_t wordSize,
                       size_t lineNumber, size_t wordNumber, int base) {
    char* eptr = NULL;
    long long int numberTempMinus = 0;
    unsigned long long int numberTemp = 0;
    long double number;

    if (word[0] == '-') {
        numberTempMinus = strtoll(word, &eptr, base);
    } else {
        numberTemp = strtoull(word, &eptr, base);
    }

    if (numberTemp == ULLONG_MAX || numberTempMinus == LLONG_MIN) {
        saveNotANumber(word, wordSize, lineNumber, wordNumber);
    } else {
        if (word[0] == '-') {
            number = (long double) numberTempMinus;
        } else {
            number = (long double) numberTemp;
        }
        data[lineNumber].oneLine[wordNumber].word.Number = number;
        data[lineNumber].oneLine[wordNumber].type = 'n';
        free(word);
    }
}
static void saveNumberDouble(char* word, size_t lineNumber, size_t wordNumber) {
    char *eptr;
    long double number = strtold(word, &eptr);
    free(word);
    data[lineNumber].oneLine[wordNumber].word.Number = number;
    data[lineNumber].oneLine[wordNumber].type = 'n';
}
static int determineTypeOfWord(char* word, size_t wordSize) {
    int type; //8 - octal, 16 - hexadecimal, 10 - decimal, 0 - double, -1 - nan
    type = is_8_10_16_decimal(word, wordSize);

    if (type == 0) {
        bool isWordADouble = isDouble(word, wordSize);
        //if it is not hexadecimal, octal, decimal or double
        //then it must be "not a number"
        if (isWordADouble == false) {
            type = -1;
        }
    }
    return type;
}
static void parseWord(char* word, size_t wordSize,
                      size_t lineNumber, size_t wordNumber) {
    int typeOfWord = determineTypeOfWord(word, wordSize);

    switch (typeOfWord) {
        case 8:
            saveNumber(word, wordSize, lineNumber, wordNumber, 8);
            break;
        case 16:
            saveNumber(word, wordSize, lineNumber, wordNumber, 16);
            break;
        case 10:
            saveNumber(word, wordSize, lineNumber, wordNumber, 10);
            break;
        case 0:
            saveNumberDouble(word, lineNumber, wordNumber);
            break;
        case -1:
            saveNotANumber(word, wordSize, lineNumber, wordNumber);
            break;
    }
}
static size_t countNumberOfWordsInLine(char* line, size_t lineLength) {
    size_t result = 0;
    size_t i = 0;
    while (i + 1 < lineLength) {
        i = iterateTillFirstNotWhitespace(i, lineLength, line);
        if (i + 1 < lineLength) {
            result++;
        }
        i = iterateTillFirstWhitespace(i, lineLength, line);
    }
    return result;
}
static bool isCorrectLine(char* line, size_t lineLength, size_t lineNumber) {
    if (lineLength == 0) {
        fprintf(stderr, "ERROR %ld\n", lineNumber);
        return false;
    }
    for (size_t i = 0; i < lineLength; i++) {
        if (!((line[i] >= 33 && line[i] <= 126) || line[i] == 0
              || line[i] == 32 || (line[i] >= 9 && line[i] <= 13))) {
            fprintf(stderr, "ERROR %ld\n", lineNumber);
            return false;
        }
    }
    return true;
}
static void breakLineIntoWords(char* line, size_t lineNumber) {
    size_t lineLength = strlen(line);
    size_t ind = 0;
    size_t wordNumber = 0;
    size_t numberOfWordsInLine = 0;

    if (line[0] == '#'){
        numberOfWordsInLine = 0;
    } else if (!(isCorrectLine(line, lineLength, lineNumber + 1))) {
        numberOfWordsInLine = 0;
    } else {
        numberOfWordsInLine = countNumberOfWordsInLine(line, lineLength);
    }

    //array is zero-indexed but lines are indexed normally
    data[lineNumber].index = lineNumber + 1;
    data[lineNumber].oneLineLength = numberOfWordsInLine;
    data[lineNumber].oneLine = NULL;

    if (numberOfWordsInLine > 0) {
        data[lineNumber].oneLine = malloc(sizeof(struct Word) * numberOfWordsInLine);
        if (data[lineNumber].oneLine == NULL) {
            exit(1);
        }

        while (ind + 1 < lineLength) {
            char *wordToParse = extractOneWordFromLine(&ind, lineLength, line);
            if (wordToParse != NULL) {
                size_t wordSize = strlen(wordToParse);
                //parses the word and saves in global array
                parseWord(wordToParse, wordSize, lineNumber, wordNumber);
                wordNumber++;
            }
        }
    }
}

size_t readAndParseInput() {
    data = malloc(INIT_ARRAY_SIZE * sizeof(struct Line));
    if (data == NULL) {
        exit(1);
    }
    size_t currentDataSize = INIT_ARRAY_SIZE;
    bool continueReading = true;
    size_t lineNumber = 0;

    while (continueReading) {
        char *line = readOneLineAndCheckForEOF(&continueReading);
        if (line != NULL) {
            if (lineNumber + 1 == currentDataSize) {
                data = realloc(data, currentDataSize * 2 * sizeof(struct Line));
                if (data == NULL) {
                    exit(1);
                }
                currentDataSize *= 2;
            }
            breakLineIntoWords(line, lineNumber);
            free(line);
            lineNumber++;
        }
    }
    return lineNumber;
}
