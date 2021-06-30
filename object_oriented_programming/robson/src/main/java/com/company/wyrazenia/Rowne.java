package com.company.wyrazenia;

import com.company.Robson;

public class Rowne extends WyrazenieLogiczne {
    private String typ;

    public Rowne(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2, "==");
        typ = "==";
    }

    public double wykonaj() throws Robson.BladWykonania {
        if (argument1.wykonaj() == argument2.wykonaj()) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
}
