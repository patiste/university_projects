#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

#define GROUND '+'
#define ROCK '#'
#define SPACE ' '
#define DIAMOND '$'
#define STONE 'O'
#define EXIT 'X'
#define ROCKFORD '@'
#define UP 'w'
#define RIGHT 'd'
#define DOWN 's'
#define LEFT 'a'

struct R {
  int iR;
  int jR;
  bool on_board;
  int diamonds;
};

int **board;
int rows;     // number of rows
int columns;  // number of columns

// Allocates memory for board
void allocate_board() {
  if (scanf("%d %d", &rows, &columns) != EOF) {
    board = malloc(sizeof(int *) * (unsigned)(columns));

    for (int i = 0; i < columns; i++)
      board[i] = malloc(sizeof(int) * (unsigned)(rows));
  }
}

// Returns the element in column i row j
// Arguments: coordinates of the element
int el(int i, int j) {
  return board[i][j];
}
// Changes the value of element in column i row j
// Arguments: coordinates of the element to be changed, new value
void change_el(int i, int j, int new_value) {
  board[i][j] = new_value;
}
// Prints whole board
void print_board() {
  printf("%d %d\n", rows, columns);

  for (int j = 0; j < rows; j++) {
    for (int i = 0; i < columns; i++) {
      printf("%c", el(i, j));
    }
    printf("\n");
  }
}
// Reads board from input, remembers Rockford's coordinates
// and number of diamonds on on_board
// Arguments: Rockford's position, number of diamonds on board
void read_input(struct R *Rockford) {
  for (int j = 0; j < rows; j++) {
    for (int i = 0; i < columns; i++) {
      int check_input = getchar();

      while (check_input == '\n') {
        check_input = getchar();
      }
      change_el(i, j, check_input);

      if (el(i, j) == DIAMOND) (Rockford->diamonds)++;
      if (el(i, j) == ROCKFORD) {
        Rockford->iR = i;
        Rockford->jR = j;
      }
    }
  }
}
// Swaps elements
// Arguments: coordinates of the elements to be swaped
void swap_el(int i1, int j1, int i2, int j2) {
  int temp = el(i1, j1);
  change_el(i1, j1, el(i2, j2));
  change_el(i2, j2, temp);
}
// Returns true if there is space in column i row j
// Returns false if there is something there
// Arguments: coordinates of the field to be cheked
bool is_empty(int i, int j) {
  return (el(i, j) == SPACE);
}
// Changes position of stone or diamond if they fall down
// Arguments: position of element
void update_element(int i, int j) {
  int remember_j = j;
  while (is_empty(i, j + 1)) j++;

  swap_el(i, remember_j, i, j);
}
// Puts a column in a stable condition
// Arguments: number of column
void update_column(int n_of_column) {
  for (int j = rows - 1; j >= 0; j--) {
    if (el(n_of_column, j) == STONE || el(n_of_column, j) == DIAMOND)
      update_element(n_of_column, j);
  }
}
// Changes board to a stable condition
void update_board() {
  for (int i = 0; i < columns; i++)
    update_column(i);
}
// Move to the empty field on the left or right
// Arguments: Rockford's position, coordinates of the target
void go_row(int i1, int j1, int i2, int j2) {
  change_el(i1, j1, SPACE);
  change_el(i2, j2, ROCKFORD);
  update_column(i1);
}
// Move to the empty field up or down
// Arguments: Rockford's position, coordinates of the target
void go_column(int i1, int j1, int i2, int j2) {
  change_el(i1, j1, SPACE);
  change_el(i2, j2, ROCKFORD);
  update_column(i1);
}
// Move to the field with a stone left or right
// Arguments: Rockford's position, stone's position
void go_row_stone(int i1, int j1, int i2, int j2) {
  int i3 = 0;
  int j3 = j1;
  if (i2 > i1)
    i3 = i2 + 1;
  else
    i3 = i2 - 1;

  if (el(i3, j3) == SPACE) {
    change_el(i1, j1, SPACE);
    change_el(i2, j2, ROCKFORD);
    change_el(i3, j3, STONE);
  }
  update_column(i1);
  update_column(i3);
}
// Move to exit
// Arguments: Rockford's position
void go_exit(int i1, int j1) {
  change_el(i1, j1, SPACE);
  update_column(i1);
}
// Decides what to do if the player presses 'a' or 'd' key,
// moves Rockford in that direction
// Arguments: Rockford's position, number of diamonds, key pressed
void go_vertical(struct R *Rockford, int direction) {
  int i = Rockford->iR;
  int j = Rockford->jR;

  int next = 0;
  if (direction == UP)
    next = -1;
  else
    next = 1;

  switch (el(i, j + next)) {
    case GROUND:
      go_column(i, j, i, j + next);
      Rockford->jR = Rockford->jR + next;
      break;

    case ROCK:
      break;

    case SPACE:
      go_column(i, j, i, j + next);
      Rockford->jR = Rockford->jR + next;
      break;

    case DIAMOND:
      go_column(i, j, i, j + next);
      Rockford->jR = Rockford->jR + next;
      (Rockford->diamonds)--;
      break;

    case STONE:
      break;

    case EXIT:
      if (Rockford->diamonds == 0) {
        go_exit(i, j);
        Rockford->iR = -1;
        Rockford->jR = -1;
      }
      break;
  }
}
// Decides what to do if the player presses 'w' or 's' key,
// moves Rockford in that direction
// Arguments: Rockford's position, number of diamonds, key pressed
void go_horizontal(struct R *Rockford, int direction) {
  int i = Rockford->iR;
  int j = Rockford->jR;

  int next = 0;
  if (direction == LEFT)
    next = -1;
  else
    next = 1;

  switch (el(i + next, j)) {
    case GROUND:
      go_row(i, j, i + next, j);
      Rockford->iR = Rockford->iR + next;
      break;

    case ROCK:
      break;

    case SPACE:
      go_row(i, j, i + next, j);
      Rockford->iR = Rockford->iR + next;
      break;

    case DIAMOND:
      go_row(i, j, i + next, j);
      Rockford->iR = Rockford->iR + next;
      (Rockford->diamonds)--;
      break;

    case STONE:
      if (el(i + 2 * next, j) == SPACE) Rockford->iR = Rockford->iR + next;
      go_row_stone(i, j, i + next, j);
      break;

    case EXIT:
      if (Rockford->diamonds == 0) {
        go_exit(i, j);
        Rockford->iR = -1;
        Rockford->jR = -1;
      }
      break;
  }
}
// Decides where to move Rockford
// Arguments: Rockford's position, pressed key
void move(struct R *Rockford, int key) {
  switch (key) {
    case UP:
      go_vertical(Rockford, UP);
      break;
    case RIGHT:
      go_horizontal(Rockford, RIGHT);
      break;
    case DOWN:
      go_vertical(Rockford, DOWN);
      break;
    case LEFT:
      go_horizontal(Rockford, LEFT);
      break;
  }
}
// Checks if Rockford is initially on board, puts board in stable condition
void prepare_game(struct R *Rockford) {
  if (Rockford->iR > -1 && Rockford->jR > -1)
    Rockford->on_board = 1;

  update_board();
  print_board();
}
// Reads pressed key from input and either moves Rockford in the expected
// direction or prints board Arguments: Rockford's position, number of diamonds
void play_game(struct R *Rockford) {
  int command, count = 0;

  while ((command = getchar()) != EOF) {
    if (Rockford->on_board) {
      if (command == '\n' && count != 0)
        print_board();
      else
        move(Rockford, command);
    } else {
      getchar();
      print_board();
    }

    if (Rockford->on_board && Rockford->iR == -1 && Rockford->jR == -1) {
      Rockford->on_board = 0;
    }
    count++;
  }
}
// Frees memory used for board
void free_board() {
  for (int i = 0; i < columns; i++)
    free(board[i]);

  free(board);
}
// Sets initial Rockford's position
void set_Rockford(struct R *Rockford) {
  Rockford->iR = -1;
  Rockford->jR = -1;
  Rockford->on_board = 0;
  Rockford->diamonds = 0;
}
int main() {
  allocate_board();

  struct R Rockford;

  set_Rockford(&Rockford);
  read_input(&Rockford);
  prepare_game(&Rockford);
  play_game(&Rockford);

  free_board();

  return 0;
}
