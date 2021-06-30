#include <stdio.h>
#include <stdlib.h>
#include "read_and_parse_input.h"
#include "sort_lines.h"
#include "make_and_print_output.h"
#include "structs.h"

void freeData(size_t numberOfLinesRead) {
    for (size_t i = 0; i < numberOfLinesRead; i++) {
        for (size_t j = 0; j < data[i].oneLineLength; j++) {
            if (data[i].oneLine[j].type == 'c') {
                free(data[i].oneLine[j].word.NotANumber);
            }
        }
        free(data[i].oneLine);
    }
    free(data);
}

int main(void) {

    size_t numberOfLinesRead = 0;
    size_t numberOfGroups = 0;

    numberOfLinesRead = readAndParseInput();
    sortLines(numberOfLinesRead);
    struct outputGroup* output = createAndSortOutput(numberOfLinesRead, &numberOfGroups);
    printAndFreeOutput(numberOfGroups, output);
    freeData(numberOfLinesRead);

    return 0;
}