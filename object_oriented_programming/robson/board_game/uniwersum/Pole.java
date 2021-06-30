package zad1.uniwersum;

import zad1.rob.Rob;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Pole {
    private int ile_robow;
    private ArrayList<Rob> roby;
    private final int ind_x;
    private final int ind_y;

    public Pole(int ind_x, int ind_y) {
        this.ile_robow = 0;
        this.roby = new ArrayList<>(Collections.emptyList());
        this.ind_x = ind_x;
        this.ind_y = ind_y;
    }

    public abstract boolean isCzy_jest_jedzenie();

    public abstract void nakarm_roba(Rob rob);

    public abstract void urosnij_jedzenie();

    public void uruchom_roby(Plansza plansza) {
        // dzięki tablicy uwzględniam to że roby mogą przejść na inne pole
        for (Object rob : roby.toArray()) {
            if (!(((Rob) rob).isCzy_wykonalem_ture())) {
                ((Rob) rob).uruchom_program(plansza);
            }
        }
    }

    public void odbierz_roba(Rob nowy_rob) {
        ile_robow++;
        roby.add(nowy_rob);
    }

    public void usun_roba(Rob rob) {
        ile_robow--;
        roby.remove(rob);
    }

    public void wypisz_roby_na_polu() {
        for (int i = 0; i < ile_robow; i++) {
            System.out.println("Rob" + (i + 1));
            roby.get(i).wypisz_roba();
            System.out.println("-----------------");
        }
    }

     public void aktualizuj_czy_ruszony() {
        for (int i = 0; i < ile_robow; i++) {
            roby.get(i).setCzy_wykonalem_ture(false);
        }
    }

    public void postarz_roby() {
        for (int i = 0; i < ile_robow; i++) {
            roby.get(i).postarz();
        }
    }

    public int min_dl_programu() {
        if (ile_robow == 0) {
            return 0;
        }

        int wynik = 2147483647;
        for (int i = 0; i < ile_robow; i++) {
            if (roby.get(i).getDl_programu() < wynik) {
                wynik = roby.get(i).getDl_programu();
            }
        }
        return wynik;
    }

    public int min_energia_roba() {
        if (ile_robow == 0) {
            return 0;
        }

        int wynik = 2147483647;
        for (int i = 0; i < ile_robow; i++) {
            if (roby.get(i).getEnergia() < wynik) {
                wynik = roby.get(i).getEnergia();
            }
        }
        return wynik;
    }

    public int min_wiek_roba() {
        if (ile_robow == 0) {
            return 0;
        }

        int wynik = 2147483647;
        for (int i = 0; i < ile_robow; i++) {
            if (roby.get(i).getWiek() < wynik) {
                wynik = roby.get(i).getWiek();
            }
        }
        return wynik;
    }

    public int maks_dl_programu() {
        int wynik = 0;
        for (int i = 0; i < ile_robow; i++) {
            if (roby.get(i).getDl_programu() > wynik) {
                wynik = roby.get(i).getDl_programu();
            }
        }
        return wynik;
    }

    public int maks_energia_roba() {
        int wynik = 0;
        for (int i = 0; i < ile_robow; i++) {
            if (roby.get(i).getEnergia() > wynik) {
                wynik = roby.get(i).getEnergia();
            }
        }
        return wynik;
    }

    public int maks_wiek_roba() {
        int wynik = 0;
        for (int i = 0; i < ile_robow; i++) {
            if (roby.get(i).getWiek() > wynik) {
                wynik = roby.get(i).getWiek();
            }
        }
        return wynik;
    }

    public double suma_dl_programu() {
        double suma = 0;
        for (int i = 0; i < ile_robow; i++) {
            suma += roby.get(i).getDl_programu();
        }
        return suma;
    }

    public double suma_energii_robow() {
        double suma = 0;
        for (int i = 0; i < ile_robow; i++) {
            suma += roby.get(i).getEnergia();
        }
        return suma;
    }

    public double suma_wieku_robow() {
        double suma = 0;
        for (int i = 0; i < ile_robow; i++) {
            suma += roby.get(i).getWiek();
        }
        return suma;
    }

    public int getIle_robow() {
        return ile_robow;
    }

    public int getInd_x() {
        return ind_x;
    }

    public int getInd_y() {
        return ind_y;
    }
}

