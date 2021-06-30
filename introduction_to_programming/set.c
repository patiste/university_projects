#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct card {
    int values;
    int a;
    int b;
    int c;
    int d;
    bool in_game;
};

struct card tab[81];

/* Sets all the features of a certain card
/ Arguments: index of the card
*/
void read_card (int n) {

    int val = tab[n].values;

    tab[n].d = val % 10;
    val/=10;
    tab[n].c = val % 10;
    val/=10;
    tab[n].b = val % 10;
    val/=10;
    tab[n].a = val;

    if(n >= 12)
        tab[n].in_game = 0;
    else
        tab[n].in_game = 1;

    return;
}

/* Checks if three values meet the set condition
/ Arguments: three chosen values
*/
bool cond (int A, int B, int C) {

    if((A == B && B == C) || (A != B && A != C && B != C))
        return true;
    else
        return false;
}

/* Checks if three cards create a set
/ Arguments: indexes of three cards
*/
bool set_cond (int c1, int c2, int c3) {

    if (cond(tab[c1].a, tab[c2].a, tab[c3].a) &&
        cond(tab[c1].b, tab[c2].b, tab[c3].b) &&
        cond(tab[c1].c, tab[c2].c, tab[c3].c) &&
        cond(tab[c1].d, tab[c2].d, tab[c3].d)) {
        return true;
    }
    else {
        return false;
    }
}

/* Prints three cards if they create a set,
/  returns false if cards don't create a set
/  Arguments: three cards which are in game but we don'y know if they create a set
*/
bool print_set (int c1, int c2, int c3) {

    if (set_cond(c1, c2, c3)) {
        tab[c1].in_game = 0;
        tab[c2].in_game = 0;
        tab[c3].in_game = 0;

        printf("- %d %d %d", tab[c1].values,tab[c2].values, tab[c3].values);
        printf("\n");

        return true;
    }
    else {
        return false;
    }
}

/* Checks if we can create a set from the cards lying on table and prints the first set
/ Arguments: Index of the last card lying on the table
*/
bool set_exists (int last) {

    int c1 = -1;
    int c2 = -1;
    int c3 = -1;

    for (int i = 0; i < last; i++) {
        while (i < last && !tab[i].in_game)
             i++;
        c1 = i;

        for (int j = i+1; j < last; j++) {
            while (j< last && !tab[j].in_game)
                j++;
            c2 = j;

            for (int k = j+1; k < last; k++) {
                while (k< last && !tab[k].in_game)
                    k++;
                c3 = k;

                if (i!=-1 && j!= -1 && k!= -1) {
                    if (print_set(c1, c2, c3))
                        return true;
                }

            }
        }
    }
    return false;
}

/* Prints all the cards on the table
/ Arguments: Number of cards lying on the table
*/
void print_table (int on_table) {

    printf("=");

    int i = 0; int count = 0;

    while (count < on_table && i<81) {
        if (tab[i].in_game) {
            printf(" %d", tab[i].values);
            count++;
        }
        i++;
    }

    printf("\n");

    return;
}

/* Updates the number of the last card lying on table after a set is removed
/ Arguments: Index of the last card on the table before set is removed
*/
void change_last (int *last) {

    int i = *last - 1;

    while (!tab[i].in_game)
        i--;

    *last = i + 1;

    return;
}

/* Sets number of cards lying on the table and in deck,
/  sets the index of the last card lying on the table
/  Arguments: number of cards in game, other values at the beginning set to zero
*/
void prep_values (int c_in_game, int *table, int *last, int *deck) {

    if (c_in_game < 12) {
        *table = c_in_game;
        *last = c_in_game;
    }
    else {
        *table = 12;
        *last = 12;
    }

    *deck = c_in_game - *table;

    return;
}

/* (If set doesn't exist and there are cards in deck) Adds three cards to the table,
/  updates the number of cards in deck and on the table
/  Arguments: Number of cards in game, on table, index of the last card on table and number of cards in deck
*/
void play_not_exists (int c_in_game, int *table, int *last, int *deck) {

    printf("+\n");

    for (int i = 0; i < 3; i++)
        tab[c_in_game - *deck + i].in_game = 1;

    *deck -= 3;
    *last = c_in_game - *deck;
    *table += 3;

    return;
}

/* Removes three cards creating a set from the table, updates number of cards in certain places
/ Arguments: Number of cards in game, on table, index of the last card on table and number of cards in deck
*/
void play_exists (int c_in_game, int *table, int *last, int *deck) {


    *table -= 3;

   if(*table != 0)
       change_last(last);


    if (*table < 12 && *deck != 0) {

        for (int i = 0; i < 3; i++)
            tab[c_in_game - *deck + i].in_game = 1;

        *deck -= 3;
        *last = c_in_game - *deck;
        *table += 3;

    }
    return;
}

/* Controls the course of the game
/ Arguments: Number of cards in game, on table, index of the last card on table and number of cards in deck
/ at the beginning of the game
*/
void play (int c_in_game, int *table, int *last, int *deck) {

    while(1) {

       // printf("koniec\n");
        print_table(*table);

        if (set_exists(*last)) {

            play_exists(c_in_game, table, last, deck);

        }
        else {

            if (*deck != 0) {
                play_not_exists(c_in_game, table, last, deck);
            }
            else {
                //printf("TUUU\n");
                return;
            }
        }
    }
}
/* Sets number of cards on the table, in deck and index of the last card on the table (before game starts)
/ Starts playing the game
/ Arguments: Number of cards in game, on table, index of the last card on table and number of cards in deck
/ at the beginning set to zero
*/
void game (int c_in_game, int *table, int *last, int *deck) {

    prep_values(c_in_game, table, last, deck);

    play(c_in_game, table, last, deck);

    return;
}
int main() {

    bool stop = 1;
    int check_input = 0;
    int how_many_cards = 0;
    int temp = 0;

    while (stop) {

        check_input = scanf("%d", &temp);

        if (check_input == EOF) {
            stop = 0;
        }
        else {
            tab[how_many_cards].values = temp;
            read_card(how_many_cards);
            how_many_cards++;
        }
    }

    int table = 0;
    int last = 0;
    int deck = 0;

    game(how_many_cards, &table, &last, &deck);

    return 0;
}
