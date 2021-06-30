package com.company.wyrazenia;

import com.company.Robson;

public class True extends Stala {
    private String typ;

    public True() {
        super(true);
        typ = "True";
    }

    public double wykonaj() {
        return 1.0;
    }


    public String toJavaCode() {
        String wynik = "";
        StringBuilder sB = new StringBuilder(wynik);
        sB.append("public static double funkcja").append(Robson.nrFunkcji);
        Robson.nrFunkcji++;
        sB.append("() { return 1.0; }\n");

        return sB.toString();
    }
}
