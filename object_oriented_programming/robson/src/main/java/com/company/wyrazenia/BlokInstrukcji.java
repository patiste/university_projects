package com.company.wyrazenia;
import com.company.Robson;

import java.util.ArrayList;
import java.util.List;

public class BlokInstrukcji extends com.company.wyrazenia.Wyrazenie {
    protected List<com.company.wyrazenia.Wyrazenie> instrukcje;
    private String typ;

    public BlokInstrukcji(ArrayList<com.company.wyrazenia.Wyrazenie> instrukcje) {
        this.instrukcje = instrukcje;
        typ = "Blok";
    }

    public double wykonaj() throws Robson.BladWykonania {
        double aktWywolanie = 0.;
        for (com.company.wyrazenia.Wyrazenie el : instrukcje) {
            aktWywolanie = el.wykonaj();
        }
        return aktWywolanie;
    }

    public String toJavaCode() {
        int aktNr = Robson.nrFunkcji;
        Robson.nrFunkcji++;

        String wynik = "";
        StringBuilder sB = new StringBuilder(wynik);
        int[] numeryFunkcji = new int[instrukcje.size()];

        for (int i = 0; i < instrukcje.size(); i++) {
            numeryFunkcji[i] = Robson.nrFunkcji;
            sB.append(instrukcje.get(i).toJavaCode());
        }

        sB.append("public static double funkcja");
        sB.append(aktNr);
        sB.append("() { ");

        for (int i = 0; i < instrukcje.size() - 1; i++) {
            sB.append("funkcja").append(numeryFunkcji[i]).append("(); ");
        }
        sB.append("return funkcja").append(numeryFunkcji[instrukcje.size() - 1]).append("(); } \n");

        return sB.toString();
    }
}