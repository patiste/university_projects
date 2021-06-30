package com.company.wyrazenia;

import com.company.Robson;

public class Liczba extends Wyrazenie {
    private double wartosc;
    private String typ;

    public Liczba(double wartosc) {
        this.wartosc = wartosc;
        typ = "Liczba";
    }

    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    public double wykonaj() {
        return wartosc;
    }

    public String toJavaCode() {
        String wynik = "";
        StringBuilder sB = new StringBuilder(wynik);
        sB.append("public static double funkcja");
        sB.append(Robson.nrFunkcji);
        Robson.nrFunkcji++;
        sB.append("() { return ");
        sB.append(wartosc);
        sB.append("; }\n");

        return sB.toString();
    }
}
