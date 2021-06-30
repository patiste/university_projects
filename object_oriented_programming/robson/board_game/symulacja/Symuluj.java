package zad1.symulacja;

import zad1.uniwersum.Plansza;

import java.text.DecimalFormat;

public class Symuluj {
    private final int ile_tur;
    private final int co_ile_wypisz;
    private Plansza plansza;

    private int liczba_robow;
    private int liczba_pol_z_zywnoscia;
    private int min_dl_programu;
    private double sr_dl_programu;
    private int maks_dl_programu;
    private int min_energia_roba;
    private double sr_energia_roba;
    private int maks_energia_roba;
    private int min_wiek_roba;
    private int maks_wiek_roba;
    private double sr_wiek_roba;

    public Symuluj(int ile_tur, int co_ile_wypisz, Plansza plansza, int ile_robow) {
        this.ile_tur = ile_tur;
        this.co_ile_wypisz = co_ile_wypisz;
        this.plansza = plansza;
        this.liczba_robow = ile_robow;
    }

    public void rozpocznij_symulacje() {
        System.out.println("Stan poczatkowy: ");
        plansza.wypisz_stan_symulacji();
        int tury_od_wypisania = 0;

        for (int h = 1; h <= ile_tur; h++) {
            plansza.symuluj_ture();
            plansza.akt_czy_ruszone_roby();
            plansza.rosnij_jedzenie();
            plansza.uplyn_czas();
            aktualizuj_podstawowe_dane();

            if(tury_od_wypisania == co_ile_wypisz) {
                System.out.println("Stan symulacji po " + h + " turach:");
                 plansza.wypisz_stan_symulacji();
             }
             tury_od_wypisania++;

            wypisz_podstawowe_dane(h);
            System.out.println();
        }

        System.out.println("Stan po zakonczeniu symulacji: ");
        plansza.wypisz_stan_symulacji();
    }

    private void aktualizuj_podstawowe_dane() {
        plansza.aktualizuj_liczbe_robow(this);
        plansza.aktualizuj_pola_zywnosc(this);
        plansza.aktualizuj_dl_programow(this);
        plansza.aktualizuj_energie_robow(this);
        plansza.aktualizuj_wiek_robow(this);
    }

    private void wypisz_podstawowe_dane(int numer_tury) {
        final DecimalFormat df = new DecimalFormat("#0.00");

        System.out.print(numer_tury + ", ");
        System.out.print("rob: " + liczba_robow + ", ");
        System.out.print("żyw: " + liczba_pol_z_zywnoscia + ", ");
        System.out.print("prg: " + min_dl_programu + "/");
        System.out.print(df.format(sr_dl_programu) + "/");
        System.out.print(maks_dl_programu + ", ");
        System.out.print("energ: " + min_energia_roba + "/");
        System.out.print(df.format(sr_energia_roba) + "/");
        System.out.print(maks_energia_roba + ", ");
        System.out.print("wiek: " + min_wiek_roba + "/");
        System.out.print(df.format(sr_wiek_roba) + "/");
        System.out.println(maks_wiek_roba);
    }

    public void setLiczba_robow(int liczba_robow) {
        this.liczba_robow = liczba_robow;
    }

    public void setLiczba_pol_z_zywnoscia(int liczba_pol_z_zywnoscia) {
        this.liczba_pol_z_zywnoscia = liczba_pol_z_zywnoscia;
    }

    public void setMin_dl_programu(int min_dl_programu) {
        this.min_dl_programu = min_dl_programu;
    }

    public void setSr_dl_programu(double sr_dl_programu) {
        this.sr_dl_programu = sr_dl_programu;
    }

    public void setMaks_dl_programu(int maks_dl_programu) {
        this.maks_dl_programu = maks_dl_programu;
    }

    public void setMin_energia_roba(int min_energia_roba) {
        this.min_energia_roba = min_energia_roba;
    }

    public void setSr_energia_roba(double sr_energia_roba) {
        this.sr_energia_roba = sr_energia_roba;
    }

    public void setMaks_energia_roba(int maks_energia_roba) {
        this.maks_energia_roba = maks_energia_roba;
    }

    public void setMin_wiek_roba(int min_wiek_roba) {
        this.min_wiek_roba = min_wiek_roba;
    }

    public void setMaks_wiek_roba(int maks_wiek_roba) {
        this.maks_wiek_roba = maks_wiek_roba;
    }

    public void setSr_wiek_roba(double sr_wiek_roba) {
        this.sr_wiek_roba = sr_wiek_roba;
    }

    public int getLiczba_robow() {
        return liczba_robow;
    }
}
