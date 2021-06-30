package com.company.wyrazenia;

import com.company.Robson;

public abstract class Wyrazenie {
    public abstract double wykonaj() throws Robson.BladWykonania;

    public abstract String toJavaCode();
}
