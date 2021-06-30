#ifndef CHECK_TYPE_FUNCTIONS_H
#define CHECK_TYPE_FUNCTIONS_H

#include<stdbool.h>

bool isOnlyPlusOrMinus(char* word, size_t wordSize);
bool doesWordBeginWithZero(char* word);
bool isSecondSignNotX(char* word, size_t wordSize);
bool isSignFromHexSystem (char* word, size_t i);
bool isSignFromOctSystem (char* word, size_t i);
bool isSignFromDecSystem (char* word, size_t i);
bool isDouble(char* word, size_t wordSize);

#endif /* CHECK_TYPE_FUNCTIONS_H */