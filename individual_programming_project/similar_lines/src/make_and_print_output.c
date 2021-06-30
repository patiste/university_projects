#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include "make_and_print_output.h"
#include "sort_lines.h"
#include "structs.h"

#define INIT_ARRAY_SIZE 4

static int compareInt(const void* a, const void* b) {
    return *(int *) a - *(int *) b;
}
static int compareGroups(const void* a, const void* b) {
    struct outputGroup *groupA = (struct outputGroup *) a;
    struct outputGroup *groupB = (struct outputGroup *) b;

    return groupA->group[0] - groupB->group[0];
}
static size_t makeGroup(size_t startIndex, size_t numberOfLines,
                        size_t groupNumber, struct outputGroup* output) {
    bool equal = true;
    size_t currentIndex = startIndex;

    output[groupNumber].group = malloc(INIT_ARRAY_SIZE * sizeof(int));
    if (output[groupNumber].group == NULL) {
        exit(1);
    }
    size_t memorySize = INIT_ARRAY_SIZE;

    //while lines next to each other are equal add them to group
    while (equal && currentIndex < numberOfLines) {
        if (compareLines(&data[startIndex], &data[currentIndex]) == 0) {

            //resize array for a group
            if (currentIndex - startIndex + 1 == memorySize) {
                output[groupNumber].group = realloc(output[groupNumber].group, memorySize * 2 * sizeof(int));
                if (output[groupNumber].group == NULL) {
                    exit(1);
                }
                memorySize *= 2;
            }

            output[groupNumber].group[currentIndex - startIndex] = data[currentIndex].index;
            currentIndex++;
        } else {
            equal = false;
        }
    }
    output[groupNumber].length = currentIndex - startIndex;

    return currentIndex;
}
static void sortOutput(size_t numberOfGroups, struct outputGroup* output){
    //sorts one group
    for (size_t i = 0; i < numberOfGroups; i++) {
        qsort(output[i].group, output[i].length, sizeof(int), compareInt);
    }
    //sorts all groups
    qsort(output, numberOfGroups, sizeof(struct outputGroup), compareGroups);
}
void printAndFreeOutput(size_t numberOfGroups, struct outputGroup* output) {
    for (size_t j = 0; j < numberOfGroups; j++) {
        for (size_t k = 0; k < output[j].length; k++) {
            if (k == output[j].length - 1) {
                printf("%d", output[j].group[k]);
            } else {
                printf("%d ", output[j].group[k]);
            }
        }
        printf("\n");
    }

    for (size_t j = 0; j < numberOfGroups; j++) {
        free(output[j].group);
    }
    free(output);
}

struct outputGroup* createAndSortOutput(size_t numberOfLines,
        size_t* numberOfGroups) {
    struct outputGroup* output = malloc(INIT_ARRAY_SIZE * sizeof(struct outputGroup));
    if (output == NULL) {
        exit(1);
    }
    size_t memorySize = INIT_ARRAY_SIZE;
    size_t i = 0;
    size_t groupNumber = 0;

    //skip comments, empty lines and incorrect signs
    while (i < numberOfLines && data[i].oneLineLength == 0) {
        i++;
    }

    while (i < numberOfLines) {
        if (groupNumber + 1 == memorySize) {
            output = realloc(output, memorySize * 2 * sizeof(struct outputGroup));
            if (output == NULL) {
                exit(1);
            }
            memorySize *= 2;
        }

        i = makeGroup(i, numberOfLines, groupNumber, output);
        groupNumber++;
    }
    *numberOfGroups = groupNumber;

    sortOutput(*numberOfGroups, output);
    return output;
}