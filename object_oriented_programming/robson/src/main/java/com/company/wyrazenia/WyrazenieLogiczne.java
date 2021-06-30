package com.company.wyrazenia;

import com.company.Robson;

public abstract class WyrazenieLogiczne extends Wyrazenie2Arg {
    protected transient String znak;

    public WyrazenieLogiczne(Wyrazenie argument1, Wyrazenie argument2, String znak) {
        super(argument1, argument2);
        this.znak = znak;
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
        sB.append("if( ( funkcja").append(nrArg1).append("() ").append(znak).append(" funkcja").append(nrArg2).append("() )) {");
        sB.append(" return 1.0;").append(" } ").append(" else { ").append(" return 0.0; ").append("} }\n");


        return sB.toString();
    }
}
