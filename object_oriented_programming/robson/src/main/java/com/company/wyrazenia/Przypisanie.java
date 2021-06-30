package com.company.wyrazenia;

import com.company.Robson;

public class Przypisanie extends Wyrazenie {
    private final String nazwa;
    private final Wyrazenie wartosc;
    private String typ;

    public Przypisanie(String nazwa, Wyrazenie wartosc) {
        this.nazwa = nazwa;
        this.wartosc = wartosc;
        typ = "Przypisanie";
    }

    public double wykonaj() throws Robson.BladWykonania {
        double nowaWartosc = wartosc.wykonaj();
        Robson.zmienneGlobalne.put(nazwa, nowaWartosc);
        return nowaWartosc;
    }

    public String toJavaCode() {
        String wynik = "";
        StringBuilder sB = new StringBuilder(wynik);
        sB.append("public static double funkcja");
        sB.append(Robson.nrFunkcji);
        Robson.nrFunkcji++;
        sB.append("() { double nowaWartosc = funkcja").append(Robson.nrFunkcji).append("(); ");
        sB.append("ZmienneGlobalne.put(\"").append(nazwa).append("\", nowaWartosc); return nowaWartosc; }\n");
        sB.append(wartosc.toJavaCode());

        return sB.toString();
    }
}
