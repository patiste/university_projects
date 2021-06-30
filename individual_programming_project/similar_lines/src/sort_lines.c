#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "structs.h"
#include "sort_lines.h"

static int compareDataInLine(const void* A, const void* B) {
    struct Word *wordA = (struct Word *) A;
    struct Word *wordB = (struct Word *) B;

    if (wordA->type == 'c' && wordB->type == 'c')
        return strcmp(wordA->word.NotANumber, wordB->word.NotANumber);
    if (wordA->type == 'c' && wordB->type != 'c')
        return -1;
    if (wordA->type != 'c' && wordB->type == 'c')
        return 1;
    if (wordA->type == 'n' && wordB->type == 'n') {
        if (wordA->word.Number < wordB->word.Number)
            return -1;
        else if (wordA->word.Number > wordB->word.Number)
            return 1;
        else
            return 0;
    }
    return 0;
}
int compareLines(const void* a, const void* b) {
    struct Line *lineA = (struct Line *) a;
    struct Line *lineB = (struct Line *) b;

    if (lineA->oneLineLength != lineB->oneLineLength) {
        if (lineA->oneLineLength < lineB->oneLineLength)
            return -1;
        if (lineA->oneLineLength > lineB->oneLineLength)
            return 1;
    } else {
        for (size_t i = 0; i < lineA->oneLineLength; i++) {
            int compare = compareDataInLine(&(lineA->oneLine[i]), &(lineB->oneLine[i]));
            if (compare < 0)
                return -1;
            if (compare > 0)
                return 1;
        }
    }

    return 0;
}
void sortLines(size_t numberOfLines) {
    for (size_t i = 0; i < numberOfLines; i++) {
        qsort(data[i].oneLine, data[i].oneLineLength, sizeof(struct Word), compareDataInLine);
    }
    qsort(data, numberOfLines, sizeof(struct Line), compareLines);
}