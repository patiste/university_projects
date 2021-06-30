#ifndef MAKE_AND_PRINT_OUTPUT_H
#define MAKE_AND_PRINT_OUTPUT_H

#include "structs.h"

void printAndFreeOutput(size_t numberOfGroups, struct outputGroup* output);
struct outputGroup* createAndSortOutput(size_t numberOfLines, size_t* numberOfGroups);

#endif /* MAKE_AND_PRINT_OUTPUT_H */