package com.company.wyrazenia;

public abstract class Wyrazenie2Arg extends Wyrazenie {
    protected Wyrazenie argument1;
    protected Wyrazenie argument2;

    public Wyrazenie2Arg(Wyrazenie argument1, Wyrazenie argument2) {
        this.argument1 = argument1;
        this.argument2 = argument2;
    }
}
