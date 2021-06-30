package com.company.wyrazenia;

import com.company.Robson;

public class False extends Stala {
    private String typ;

    public False() {
        super(false);
        typ = "False";
    }

    public double wykonaj() {
        return 0.0;
    }

    public String toJavaCode() {
        String wynik = "";
        StringBuilder sB = new StringBuilder(wynik);
        sB.append("public static double funkcja").append(Robson.nrFunkcji);
        Robson.nrFunkcji++;
        sB.append("() { return 0.0; }\n");

        return sB.toString();
    }
}
