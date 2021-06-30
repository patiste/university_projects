package com.company.wyrazenia;

import com.company.Robson;

public class Minus extends WyrazenieArytmetyczne {
    private String typ;

    public Minus(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2, "-");
        typ = "Minus";
    }

    public double wykonaj() throws Robson.BladWykonania {
        return argument1.wykonaj() - argument2.wykonaj();
    }
}
