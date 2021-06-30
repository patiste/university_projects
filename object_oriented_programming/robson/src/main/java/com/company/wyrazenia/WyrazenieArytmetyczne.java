package com.company.wyrazenia;

import com.company.Robson;

public abstract class WyrazenieArytmetyczne extends Wyrazenie2Arg {
    private final transient String dzialanie;

    public WyrazenieArytmetyczne(Wyrazenie argument1, Wyrazenie argument2, String dzialanie) {
        super(argument1, argument2);
        this.dzialanie = dzialanie;
    }

    public String toJavaCode() {
        int aktNr = Robson.nrFunkcji;
        Robson.nrFunkcji++;

        String wynik = "";
        StringBuilder sB = new StringBuilder(wynik);

        int nrArg1 = Robson.nrFunkcji;
        sB.append(argument1.toJavaCode());
        int nrArg2 = Robson.nrFunkcji;
        sB.append(argument2.toJavaCode());

        sB.append("public static double funkcja");
        sB.append(aktNr);
        sB.append("() { return funkcja").append(nrArg1).append("() ").append(dzialanie).append(" funkcja").append(nrArg2).append("(); } \n");

        return sB.toString();
    }
}
