package com.company.wyrazenia;

import com.company.Robson;

public class Razy extends WyrazenieArytmetyczne {
    private String typ;

    public Razy(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2, "*");
        typ = "Razy";
    }

    public double wykonaj() throws Robson.BladWykonania {
        return argument1.wykonaj() * argument2.wykonaj();
    }
}
