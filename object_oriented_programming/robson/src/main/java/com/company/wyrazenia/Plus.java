package com.company.wyrazenia;

import com.company.Robson;

public class Plus extends WyrazenieArytmetyczne {
    private String typ;

    public Plus(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2, "+");
        typ = "Plus";
    }

    public double wykonaj() throws Robson.BladWykonania {
        return argument1.wykonaj() + argument2.wykonaj();
    }
}
