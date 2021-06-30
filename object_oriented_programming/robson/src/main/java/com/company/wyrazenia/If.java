package com.company.wyrazenia;

import com.company.Robson;

public class If extends Wyrazenie {
    private final Wyrazenie warunek;
    private final Wyrazenie blok_prawda;
    private final Wyrazenie blok_falsz;
    private String typ;

    public If(Wyrazenie warunek, Wyrazenie blok_prawda, Wyrazenie blok_falsz) {

        this.warunek = warunek;
        this.blok_prawda = blok_prawda;
        this.blok_falsz = blok_falsz;
        typ = "If";
    }

    public If(Wyrazenie warunek, Wyrazenie blok_prawda) {
        this.warunek = warunek;
        this.blok_prawda = blok_prawda;
        this.blok_falsz = null;
    }

    public double wykonaj() throws Robson.BladWykonania {
        if (warunek.wykonaj() != 0) {
            return blok_prawda.wykonaj();
        } else {
            if (blok_falsz == null) {
                return 0.0;
            }
            return blok_falsz.wykonaj();
        }
    }

    public String toJavaCode() {
        int aktNr = Robson.nrFunkcji;
        Robson.nrFunkcji++;

        String wynik = "";
        StringBuilder sB = new StringBuilder(wynik);

        int nrWarunku = Robson.nrFunkcji;
        sB.append(warunek.toJavaCode());
        int nrBlokuPrawda = Robson.nrFunkcji;
        sB.append(blok_prawda.toJavaCode());
        int nrBlokuFalsz = 0;
        if (blok_falsz != null) {
            nrBlokuFalsz = Robson.nrFunkcji;
            sB.append(blok_falsz.toJavaCode());
        }

        sB.append("public static double funkcja");
        sB.append(aktNr);
        sB.append("() { ");
        sB.append("if( funkcja").append(nrWarunku).append("() != 0.0) {");
        sB.append(" return funkcja").append(nrBlokuPrawda).append("(); }");
        if (blok_falsz != null) {
            sB.append(" else { return funkcja").append(nrBlokuFalsz).append("(); } ");
        } else {
            sB.append(" else { return 0.0; }");
        }
        sB.append("}\n");


        return sB.toString();
    }
}
