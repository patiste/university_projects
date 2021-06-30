package com.company.wyrazenia;

import com.company.Robson;

public class Zmienna extends Wyrazenie {
    private final String nazwa;
    private String typ;

    public Zmienna(String nazwa) {
        this.nazwa = nazwa;
        typ = "Zmienna";
    }

    public double wykonaj() {
        return Robson.zmienneGlobalne.getOrDefault(nazwa, 0.0);
    }

    public String toJavaCode() {
        String wynik = "";
        StringBuilder sB = new StringBuilder(wynik);
        sB.append("public static double funkcja").append(Robson.nrFunkcji);
        Robson.nrFunkcji++;
        sB.append("() { return ").append("ZmienneGlobalne.getOrDefault( \"").append(nazwa).append("\", 0.0)").append("; }\n");

        return sB.toString();
    }
}
