package com.company.wyrazenia;

import com.company.Robson;

public class Or extends Wyrazenie2Arg {
    private String typ;

    public Or(Wyrazenie argument1, Wyrazenie argument2) {
        super(argument1, argument2);
        typ = "Or";
    }

    public double wykonaj() throws Robson.BladWykonania {
        boolean wart1 = argument1.wykonaj() != 0;
        boolean wart2 = argument2.wykonaj() != 0;

        if (wart1 || wart2) {
            return 1.0;
        } else {
            return 0.0;
        }
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

        sB.append("() { ");
        sB.append("if( ( (funkcja").append(nrArg1).append("() != 0.0) || (funkcja").append(nrArg2).append("() != 0.0) )) {");
        sB.append(" return 1.0;").append(" } ").append(" else { ").append(" return 0.0; ").append("} }\n");

        return sB.toString();
    }
}
