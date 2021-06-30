package zad1;

import zad1.czytanie_z_pliku.*;
import zad1.symulacja.Symuluj;
import zad1.uniwersum.Plansza;

import java.io.File;

public class Symulacja {

    public static class ZlaIloscPlikow extends Exception {
        public ZlaIloscPlikow(String wiadomosc) {
            super(wiadomosc);
        }
    }

    public static class ZlaNazwaPliku extends Exception {
        public ZlaNazwaPliku(String wiadomosc) {
            super(wiadomosc);
        }
    }

    public static void main(String[] args) {
        Generator generator = new Generator();
        File plik_plansza;
        File plik_parametry;
        try {
            if (args.length != 2) {
                throw new ZlaIloscPlikow("Niepoprawna ilość plików");
            }

            if(!args[0].equals("plansza.txt")) {
                throw new ZlaNazwaPliku("Niepoprawna nazwa pliku zawierającego planszę");
            }

            if(!args[1].equals("parametry.txt")) {
                throw new ZlaNazwaPliku("Niepoprawna nazwa pliku zawierającego parametry");
            }

            plik_plansza = new File(args[0]);
            plik_parametry = new File(args[1]);
            generator.wczytaj_plan_planszy(plik_plansza);
            generator.wczytaj_parametry(plik_parametry);

            Plansza plansza = generator.generuj_plansze();
            generator.desant_robow_na_plansze(plansza);

            Symuluj symulacja = generator.generuj_symulacje(plansza);
            symulacja.rozpocznij_symulacje();
        }
        catch (ZlaIloscPlikow | ZlaNazwaPliku | Generator.NiepoprawneParametry | Generator.NiedozwolonaInstrukcja e) {
            System.out.println("Wystąpił błąd.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
