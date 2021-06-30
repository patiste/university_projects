package com.company.wyrazenia;

import com.company.Robson;

public class Dzielenie extends WyrazenieArytmetyczne {
    private String typ;

    public Dzielenie(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2, "/");
        typ = "Dzielenie";
    }

    public double wykonaj() throws Robson.BladWykonania {
        if (argument2.wykonaj() == 0.0) {
            throw new Robson.BladWykonania("Próba dzielenia przez 0!");
        }
        return argument1.wykonaj() / argument2.wykonaj();
    }
}
