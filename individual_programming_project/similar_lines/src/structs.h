#ifndef STRUCTS_H
#define STRUCTS_H

struct Word {
    char type;
    union {
        long double Number;
        char* NotANumber;
    } word;
};

struct Line {
    size_t index;
    size_t oneLineLength;
    struct Word* oneLine;
};

//global array with parsed words
struct Line* data;

struct outputGroup {
    size_t length;
    int* group;
};

#endif /* STRUCTS_H */