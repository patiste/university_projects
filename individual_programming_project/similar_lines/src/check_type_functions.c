#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include "check_type_functions.h"

bool isOnlyPlusOrMinus(char* word, size_t wordSize) {
    return wordSize == 1 && (word[0] == '+' || word[0] == '-');
}
bool doesWordBeginWithZero(char* word) {
    return word[0] == '0';
}
bool isSecondSignNotX(char* word, size_t wordSize) {
    return wordSize == 1 || ((wordSize > 1) &&
                             (word[1] != 'x' && word[1] != 'X'));
}
bool isSignFromHexSystem(char* word, size_t i) {
    if (i < 2) {
        return true;
    }
    if (word[i] >= '0' && word[i] <= '9') {
        return true;
    }
    if (word[i] >= 'A' && word[i] <= 'F') {
        return true;
    }
    if (word[i] >= 'a' && word[i] <= 'f') {
        return true;
    }
    return false;
}
bool isSignFromOctSystem(char* word, size_t i) {
    if (i < 1) {
        return true;
    }
    if (word[i] >= '0' && word[i] <= '7') {
        return true;
    }
    return false;
}
bool isSignFromDecSystem(char* word, size_t i) {
    if (i == 0 && (word[i] != '+' && word[i] != '-' &&
                   !(word[i] >= '0' && word[i] <= '9'))) {
        return false;
    }
    if (i > 0 && !(word[i] >= '0' && word[i] <= '9')) {
        return false;
    }
    return true;
}

static bool isSignedInfinityCondition(char* word, size_t wordSize) {
    if (wordSize != 4) {
        return false;
    }
    return (word[0] == '+' || word[0] == '-') &&
           (word[1] == 'i' || word[1] == 'I') &&
           (word[2] == 'n' || word[2] == 'N') &&
           (word[3] == 'f' || word[3] == 'F');
}
static bool isUnsignedInfinityCondition(char* word, size_t wordSize) {
    if (wordSize != 3) {
        return false;
    }
    return (word[0] == 'i' || word[0] == 'I') &&
           (word[1] == 'n' || word[1] == 'N') &&
           (word[2] == 'f' || word[2] == 'F');
}
static bool isInfinity(char* word, size_t wordSize) {
    return isSignedInfinityCondition(word, wordSize) ||
           isUnsignedInfinityCondition(word, wordSize);
}
static bool isFirstSignOkDouble(char* word, size_t i) {
    return (word[i] == '.') || (word[i] == '+') ||
           (word[i] == '-') || (word[i] >= '0' && word[i] <= '9');
}
static bool isLastSignOkDouble(char* word, size_t i) {
    return (word[i] >= '0' && word[i] <= '9') || word[i] == '.';
}
static bool isEOkDouble(char* word, bool wasE, size_t wordSize, size_t i) {
    if(wasE) {
        return false;
    }
    if(word[i-1] == '+' || word[i-1] == '-') {
        return false;
    }
    if(i == 0 || i == (wordSize - 1)){
        return false;
    }
    return true;
}
static bool isDotOkDouble(char* word, size_t wordSize, size_t i,
                          bool wasDot, bool wasE, size_t indE) {
    if (wasDot) {
        return false;
    }
    if (i != 0 && i != (wordSize - 1)) {
        if ((word[i - 1] == '+' || word[i - 1] == '-') &&
            (word[i + 1] == 'e' || word[i + 1] == 'E')) {
            return false;
        }
    }
    if (i == 0 && (word[i + 1] == 'e' || word[i + 1] == 'E')) {
        return false;
    }
    if (i == 1 && wordSize == 2 && (word[i - 1] == '+' || word[i - 1] == '-')) {
        return false;
    }
    if (wasE && i > indE) {
        return false;
    }
    if (wordSize == 1) {
        return false;
    }
    return true;
}
static bool isSignOkDouble(char* word, size_t i) {
    return (word[i] >= '0' && word[i] <= '9') ||
           (word[i] == '+') || (word[i] == '-') ||
           (word[i] == '.') || (word[i] == 'e') ||
           (word[i] == 'E');
}
static bool isPlusMinusOkDouble(char* word, size_t i) {
    if (i != 0) {
        if (!(word[i - 1] == 'e' || word[i - 1] == 'E')) {
            return false;
        }
    }
    return true;
}

bool isDouble(char* word, size_t wordSize) {
    size_t indE = 0;
    bool wasE = false;
    bool wasDot = false;

    if (isInfinity(word, wordSize)) {
        return true;
    }

    for (size_t i = 0; i < wordSize; i++) {
        if (i == 0) {
            if (!(isFirstSignOkDouble(word, i))) {
                return false;
            }
        }
        if (i == (wordSize - 1)) {
            if (!(isLastSignOkDouble(word, i))) {
                return false;
            }
        }
        if (word[i] == 'e' || word[i] == 'E') {
            if (!(isEOkDouble(word, wasE, wordSize, i))) {
                return false;
            }
            indE = i;
            wasE = true;
        }
        if (word[i] == '.') {
            if (!(isDotOkDouble(word, wordSize, i, wasDot, wasE, indE))) {
                return false;
            }
            wasDot = true;
        }
        if (word[i] == '+' || word[i] == '-') {
            if (!(isPlusMinusOkDouble(word, i))) {
                return false;
            }
        }
        if (!(isSignOkDouble(word, i))) {
            return false;
        }
    }
    return true;
}