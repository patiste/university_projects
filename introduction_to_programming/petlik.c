#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N_VARIABLES 26
#define INI_SIZE 4
#define INI_LAST_DIGIT 0
#define SIZE_OF_INSTR 4
#define SYSTEM_BASE 10000
#define MAX_SINGLE_INT 9999

typedef struct variable {
    int total_size;
    int last;
    int *value;
} var;

typedef struct instr {
    char instruction[SIZE_OF_INSTR];
    int var1;
    int var2;
} instr;

typedef struct indx {
    int ind_machine;
    int ind_prog;
} indx;

instr *machine_code = NULL;

// returns maximum of two values
// Arguments: values to be compared
int maxi(int A, int B) {
    if (A > B)
        return A;
    else
        return B;
}
// appends INC instruction and the value to be incremented at the end of the
// machine code Arguments: current index of array with machine code, array with
// program in petlik, current index of array with petlik
void append_INC_instr(int ind_machine, char *programm, int ind_prog) {
    char temp[SIZE_OF_INSTR] = "INC";
    strcpy(machine_code[ind_machine].instruction, temp);
    machine_code[ind_machine].var1 = programm[ind_prog];
    machine_code[ind_machine].var2 = 0;
}
// appends ADD instruction and the values to be added at the end of the machine
// code Arguments: current index of array with machine code, array with program
// in petlik, first variable in the optimised loop, current index of array with
// petlik
void append_ADD_instr(int ind_machine, char *programm, int main_var,
                      int ind_prog) {
    char temp[SIZE_OF_INSTR] = "ADD";
    strcpy(machine_code[ind_machine].instruction, temp);
    machine_code[ind_machine].var1 = programm[ind_prog];
    machine_code[ind_machine].var2 = main_var;
}
// appends DJZ instruction and the values to be updated at the end of the
// machine code Arguments: current index of array with machine code, array with
// program in petlik, current index of array with petlik
void append_DJZ_instr(int ind_machine, char *programm, int ind_prog) {
    char temp[SIZE_OF_INSTR] = "DJZ";
    strcpy(machine_code[ind_machine].instruction, temp);
    machine_code[ind_machine].var1 = programm[ind_prog + 1];
    machine_code[ind_machine].var2 = -1;
}
// appends JMP instruction and the index where it jumps to at the end of the
// machine code Arguments: current index of array with machine code, index of
// where the loop started
void append_JMP_instr(int ind_machine, int left_bracket_ind) {
    char temp[SIZE_OF_INSTR] = "JMP";
    strcpy(machine_code[ind_machine].instruction, temp);
    machine_code[ind_machine].var1 = left_bracket_ind;
    machine_code[ind_machine].var2 = 0;
    machine_code[left_bracket_ind].var2 = ind_machine + 1;
}
// appends CLR instruction and the value to be cleared at the end of the machine
// code Arguments: current index of array with machine code, first variable in
// the optimised loop
void append_CLR_instr(int ind_machine, int main_var) {
    char temp[SIZE_OF_INSTR] = "CLR";
    strcpy(machine_code[ind_machine].instruction, temp);
    machine_code[ind_machine].var1 = main_var;
    machine_code[ind_machine].var2 = 0;
}
// appends HLT instruction and the value at the end of the machine code
// Arguments: current index of array with machine code
void append_HLT_instr(int ind_machine) {
    char temp[SIZE_OF_INSTR] = "HLT";
    strcpy(machine_code[ind_machine].instruction, temp);
    machine_code[ind_machine].var1 = 0;
    machine_code[ind_machine].var2 = 0;
}
// Allocates memory for array with all 26 Variables
// Arguments: Array with 26 variables
void allocate_variables(var Variables[]) {
    for (int i = 0; i < N_VARIABLES; i++) {
        Variables[i].total_size = INI_SIZE;
        Variables[i].last = INI_LAST_DIGIT;
        Variables[i].value = calloc(INI_SIZE, sizeof(int));
    }
}
// Outputs the value of the variable after "=" instruction
// Arguments: array Variables, variable to be displayed
void display_var(var Variables[], int v_name) {
    v_name = v_name - 'a';
    for (int i = 0; i <= Variables[v_name].last; i++) {
        int v = Variables[v_name].value[i];
        if (i != 0) {
            printf("%0*d", 4, v);
        } else {
            printf("%d", v);
        }
    }
    v_name = getchar();
    printf("\n");
}
// Function to help in incrementing the value
// If incrementation changes the number of bits in the variable it allocates
// more memory for it
// Arguments: number of bits currently being used, size of memory already
// allocated, array Variables, variable to be changed
void increment_if_only_9(int size, int total_size, var Variables[],
                         int v_name) {
    if (size == total_size - 1) {
        total_size *= 2;
        Variables[v_name].total_size = Variables[v_name].total_size * 2;
        Variables[v_name].value =
            realloc(Variables[v_name].value,
                    (unsigned)Variables[v_name].total_size * sizeof(int));
    }
    size += 1;
    Variables[v_name].last += 1;
    Variables[v_name].value[0] = 1;
    for (int j = 1; j <= size; j++) {
        Variables[v_name].value[j] = 0;
    }
}
// increments value of the variable
// Arguments: array with the variables, variable to be incremented
void increment_var(var Variables[], char variable) {
    int v_name = variable - 'a';
    int size = Variables[v_name].last;
    int total_size = Variables[v_name].total_size;

    if (Variables[v_name].value[size] + 1 == SYSTEM_BASE) {
        int i = size;
        while (i >= 0 && Variables[v_name].value[i] + 1 == SYSTEM_BASE) {
            i--;
        }
        if (i < 0) {
            increment_if_only_9(size, total_size, Variables, v_name);
        } else {
            Variables[v_name].value[i++] += 1;
            for (; i <= size; i++) {
                Variables[v_name].value[i] = 0;
            }
        }
    } else {
        Variables[v_name].value[size] += 1;
    }
}
// changes the size of the variable to initial size and sets the variable to
// check_if_zero Arguments: array with variables, variable to be cleared
void clear_var(var Variables[], char variable) {
    int v_name = variable - 'a';

    Variables[v_name].last = INI_LAST_DIGIT;
    Variables[v_name].total_size = INI_SIZE;
    Variables[v_name].value =
        realloc(Variables[v_name].value, INI_SIZE * (unsigned)sizeof(int));

    for (int i = 0; i < INI_SIZE; i++) {
        Variables[v_name].value[i] = 0;
    }
}
// Returns 1 if variable is equal to zero, 0 in other cases
// Arguments: array with variables, variable to be checked
bool check_if_zero(var Variables[], char variable) {
    int v_name = (int)(variable - 'a');
    return Variables[v_name].value[0] == 0;
}
// Decrements variable
// Arguments" array with variables, variable to be decremented
void decrement_var(var Variables[], char variable) {
    int v_name = variable - 'a';
    int size_1 = Variables[v_name].last;
    int ind_make_9_on_the_right;

    if (Variables[v_name].value[size_1] == 0) {
        int i = size_1;
        while (Variables[v_name].value[i] == 0 && i > 0) {
            i--;
        }
        if (i == 0 && Variables[v_name].value[i] == 1) {
            ind_make_9_on_the_right = i;
            size_1--;
            Variables[v_name].last = size_1;
        } else {
            Variables[v_name].value[i]--;
            ind_make_9_on_the_right = i + 1;
        }
        for (int j = ind_make_9_on_the_right; j <= size_1; j++) {
            Variables[v_name].value[j] = MAX_SINGLE_INT;
        }
    } else {
        Variables[v_name].value[size_1]--;
    }
}
// Function to help with adding numbers,adds two bits in a column
// Arguments: array with variables, array to temporary store result, index in
// first variable, index in second variable, index in array to store result,
// first variable (to which we add), second variable (we add it to another),
// excess when adding in columns
void add_when_two_variables(var Variables[], int new_array[], int *indA,
                            int *indB, int *ind_new, int v_nameA, int v_nameB,
                            int *excess) {
    while (*indA >= 0 && *indB >= 0) {
        if (Variables[v_nameA].value[*indA] + Variables[v_nameB].value[*indB] +
                *excess >=
            SYSTEM_BASE) {
            new_array[*ind_new] = Variables[v_nameA].value[*indA] +
                                  Variables[v_nameB].value[*indB] + *excess -
                                  SYSTEM_BASE;
            *excess = 1;
        } else {
            new_array[*ind_new] = Variables[v_nameA].value[*indA] +
                                  Variables[v_nameB].value[*indB] + *excess;
            *excess = 0;
        }
        (*indA)--;
        (*indB)--;
        (*ind_new)--;
    }
}
// Function to help with adding numbers, adds one bit in a column
// Arguments: array with variables, array to temporary store result, index in
// variable, index in array to store result, variable, excess when adding in
// columns
void add_when_one_variable(var Variables[], int new_array[], int *ind,
                           int *ind_new, int v_name, int *excess) {
    while (*ind >= 0) {
        if (Variables[v_name].value[*ind] + *excess >= SYSTEM_BASE) {
            new_array[*ind_new] =
                Variables[v_name].value[*ind] + *excess - SYSTEM_BASE;
            *excess = 1;
        } else {
            new_array[*ind_new] = Variables[v_name].value[*ind] + *excess;
            *excess = 0;
        }
        (*ind)--;
        (*ind_new)--;
    }
}
// Function to help with adding numbers, copies the value from array which
// temporary stores result to first variable Arguments: array with variables,
// array to temporary store result, index in array to store result anbd ints
// initial value (copy), variable, size of changed variable
void copy_new_array_to_varA(var Variables[], int new_array[], int *ind_new,
                            int ind_new_copy, int v_nameA, int size_new) {
    int start;
    if (*ind_new == -1) {
        *ind_new = ind_new_copy;
        start = 0;
    } else {
        *ind_new = ind_new_copy - 1;
        start = 1;
    }
    Variables[v_nameA].last = *ind_new;
    Variables[v_nameA].total_size = size_new;

    Variables[v_nameA].value =
        realloc(Variables[v_nameA].value, sizeof(int) * (unsigned)size_new);
    for (int j = 0; j <= *ind_new; j++)
        Variables[v_nameA].value[j] = new_array[j + start];

    if (*ind_new < ind_new_copy)
        Variables[v_nameA].value[ind_new_copy] = 0;
}
// Adds two values
// Arguments: array with variables, variable to which we add,
// variable which we add to another
void add_variables(var Variables[], int varA, int varB) {
    int v_nameA = varA - 'a';
    int v_nameB = varB - 'a';
    int size_A = Variables[v_nameA].last;
    int size_B = Variables[v_nameB].last;
    int indA = size_A;
    int indB = size_B;

    int ind_new = maxi(indA, indB) + 1;
    int ind_new_copy = ind_new;
    int size_new = ind_new + 1;

    int excess = 0;

    int *new_array = malloc(sizeof(int) * (unsigned)size_new);
    add_when_two_variables(Variables, new_array, &indA, &indB, &ind_new,
                           v_nameA, v_nameB, &excess);
    if (indA >= 0)
        add_when_one_variable(Variables, new_array, &indA, &ind_new, v_nameA,
                              &excess);
    if (indB >= 0)
        add_when_one_variable(Variables, new_array, &indB, &ind_new, v_nameB,
                              &excess);

    if (excess > 0) {
        new_array[ind_new] = excess;
        ind_new--;
    }
    copy_new_array_to_varA(Variables, new_array, &ind_new, ind_new_copy,
                           v_nameA, size_new);
    free(new_array);
}
// Reads program in Petlik from input and saves it in an array "program",
// remebers length of the program
// Arguments: array to store program, length of it
void read_program(char **program, int *length) {

    char *program_temp = NULL;
    int length_temp = 0;

    int program_memory = INI_SIZE;

    program_temp = malloc((unsigned)program_memory * sizeof(char));
    int sign;
    while ((sign = getchar()) != '\n') {
        if (length_temp == program_memory) {
            program_memory *= 2;
            program_temp =
                realloc(program_temp, (unsigned)program_memory * sizeof(char));
        }
        program_temp[length_temp] = (char)sign;
        length_temp++;
    }
    *program = program_temp;
    *length = length_temp;
}
// Translates loop that can be optimised from Petlik to machine code
// Arguments: array with program in Petlik, index in program, index of array
// with machine code
// returns: indexes of array with program and with machine code
indx inner_loop(char *program, int ind_prog, int ind_machine) {
    int main_var = program[++ind_prog];

    while (program[++ind_prog] != ')') {
        append_ADD_instr(ind_machine, program, main_var, ind_prog);
        ind_machine++;
    }
    append_CLR_instr(ind_machine, main_var);

    indx indexes;
    indexes.ind_machine = ind_machine;
    indexes.ind_prog = ind_prog;

    return indexes;
}
// Checks if loop can be optimised
// Arguments: array with program, index in array with program
bool is_inner_loop(char *program, int ind_prog) {
    int main_var = program[++ind_prog];
    while (1) {
        ind_prog++;
        if (program[ind_prog] == '(' || program[ind_prog] == main_var)
            return false;
        if (program[ind_prog] == ')')
            return true;
    }
}
// Recursive function to translate loops from Petlik to machine code
// Arguments: array with program in Petlik, index in program in Petlik,
// index in array with machine code, length of the program in petlik
// Returns: indexes of arrays with Petlik and with machine code
indx loop(char *program, int ind_prog, int ind_machine, int program_length) {
    indx indexes;
    int left_bracket_ind = ind_machine;

    if (is_inner_loop(program, ind_prog)) {
        indexes = inner_loop(program, ind_prog, ind_machine);
        return indexes;
    } else {
        append_DJZ_instr(ind_machine, program, ind_prog);
        ind_machine++;
        ind_prog += 2;

        while (ind_prog < program_length) {

            if (program[ind_prog] == ')') {
                append_JMP_instr(ind_machine, left_bracket_ind);
                indexes.ind_machine = ind_machine;
                indexes.ind_prog = ind_prog;
                return indexes;
            } else if (program[ind_prog] == '(') {
                indexes = loop(program, ind_prog, ind_machine, program_length);
                ind_machine = indexes.ind_machine + 1;
                ind_prog = indexes.ind_prog + 1;
            } else {
                append_INC_instr(ind_machine, program, ind_prog);
                ind_machine++;
                ind_prog++;
            }
        }
        indexes.ind_machine = ind_machine;
        indexes.ind_prog = ind_prog;
        return indexes;
    }
}
// Translates program in Petlik to machine code
// Arguments: array with program in Petlik, length of this arrays
// Returns: index in array with machine code (effectively size of it)
int compile(char *program, int length) {
    machine_code = malloc((unsigned)length * 2 * sizeof(instr));
    indx indexes;
    int ind_machine = 0;

    for (int ind_prog = 0; ind_prog < length; ind_prog++) {
        if (program[ind_prog] == '(') {
            indexes = loop(program, ind_prog, ind_machine, length);
            ind_machine = indexes.ind_machine;
            ind_prog = indexes.ind_prog;
        } else {
            append_INC_instr(ind_machine, program, ind_prog);
        }
        ind_machine++;
    }
    append_HLT_instr(ind_machine);

    return ind_machine + 1;
}
// Executes machine code
// Arguments: array with variable, index in array with machine code
void interpret_machine_code(var Variables[], int ind_machine) {
    for (int i = 0; i < ind_machine; i++) {
        char check = machine_code[i].instruction[0];

        switch (check) {
        case 'A':
            add_variables(Variables, machine_code[i].var1,
                          machine_code[i].var2);
            break;
        case 'I':
            increment_var(Variables, (char)machine_code[i].var1);
            break;
        case 'D':
            if (check_if_zero(Variables, (char)machine_code[i].var1))
                i = machine_code[i].var2 - 1;
            else
                decrement_var(Variables, (char)machine_code[i].var1);
            break;
        case 'J':
            i = machine_code[i].var1 - 1;
            break;
        case 'C':
            clear_var(Variables, (char)machine_code[i].var1);
            break;
        case 'H':
            return;
        }
    }

    return;
}
// Reads program in Petlik from input, translates it into machine code
// and executes machine code
// Arguments: array with variables
void compile_and_interpret(var Variables[]) {
    char *program = NULL;
    int length = 0;

    read_program(&program, &length);
    int ind_machine = compile(program, length);
    interpret_machine_code(Variables, ind_machine);

    free(program);
    free(machine_code);
}
// Reads form input and decides to display variable
// or translate code in petlik
// Arguments: array with Variables
void read_input(var Variables[]) {
    int first_sign = getchar();

    while (first_sign != EOF) {

        if (first_sign == '=') {
            int v_name = getchar();
            display_var(Variables, v_name);
        } else {
            ungetc(first_sign, stdin);
            compile_and_interpret(Variables);
        }
        first_sign = getchar();
    }
}
// Frees array with variables
// Arguments: array with variables
void free_variables(var Variables[]) {
    for (int i = 0; i < N_VARIABLES; i++) {
        free(Variables[i].value);
    }
}
int main() {

    var Variables[N_VARIABLES];

    allocate_variables(Variables);
    read_input(Variables);
    free_variables(Variables);

    return 0;
}
