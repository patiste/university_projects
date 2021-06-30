package com.company.wyrazenia;
import com.company.Robson;

public class While extends Wyrazenie {
    private final Wyrazenie warunek;
    private final Wyrazenie blok;
    private String typ;

    public While(Wyrazenie warunek, Wyrazenie blok) {
        this.warunek = warunek;
        this.blok = blok;
        typ = "While";
    }

    public double wykonaj() throws Robson.BladWykonania {
        while (warunek.wykonaj() != 0) {
            blok.wykonaj();
        }
        return 0;
    }

    public String toJavaCode() {
        int aktNr = Robson.nrFunkcji;
        Robson.nrFunkcji++;

        String wynik = "";
        StringBuilder sB = new StringBuilder(wynik);

        int nrWarunku = Robson.nrFunkcji;
        sB.append(warunek.toJavaCode());
        int nrBloku = Robson.nrFunkcji;
        sB.append(blok.toJavaCode());

        sB.append("public static double funkcja").append(aktNr).append("() { while( funkcja").append(nrWarunku);
        sB.append("() != 0.0) { funkcja").append(nrBloku).append("(); } return 0.0; }\n");

        return sB.toString();
    }
}
