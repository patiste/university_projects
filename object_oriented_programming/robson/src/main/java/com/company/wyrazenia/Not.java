package com.company.wyrazenia;

import com.company.Robson;

public class Not extends Wyrazenie {
    private final Wyrazenie argument;
    private String typ;

    public Not(Wyrazenie argument) {
        this.argument = argument;
        typ = "Not";
    }

    public double wykonaj() throws Robson.BladWykonania {
        boolean wart1 = argument.wykonaj() != 0;

        if (wart1) {
            return 0.0;
        } else {
            return 1.0;
        }
    }

    public String toJavaCode() {
        String wynik = "";
        StringBuilder sB = new StringBuilder(wynik);
        sB.append("public static double funkcja");
        sB.append(Robson.nrFunkcji);
        Robson.nrFunkcji++;
        sB.append("() { ");
        sB.append("if( funkcja").append(Robson.nrFunkcji).append("() == 0.0) {");
        sB.append(" return 1.0; } else { return 0.0; } }\n");

        sB.append(argument.toJavaCode());

        return sB.toString();
    }
}
