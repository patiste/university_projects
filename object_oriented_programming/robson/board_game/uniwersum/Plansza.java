package zad1.uniwersum;

import zad1.rob.Rob;
import zad1.symulacja.Symuluj;

public class Plansza {
    private final int rozmiar_planszy_x;
    private final int rozmiar_planszy_y;
    private Pole[][] plansza;

    public Plansza(int rozmiar_planszy_x, int rozmiar_planszy_y) {
        this.rozmiar_planszy_x = rozmiar_planszy_x;
        this.rozmiar_planszy_y = rozmiar_planszy_y;
        this.plansza = new Pole[rozmiar_planszy_x][rozmiar_planszy_y];
    }

    public void jedz(Rob rob) {
        int moj_wsp_x = rob.getWsp_x();
        int moj_wsp_y = rob.getWsp_y();

        Wsp[] sasiedzi = daj_wspolrzedne_8_sasiadow();
        for (int i = 0; i < 8; i++) {
            Pole sasiad = daj_sasiada(moj_wsp_x, moj_wsp_y, sasiedzi[i].getWsp_x(), sasiedzi[i].getWsp_y());

            if (sasiad.isCzy_jest_jedzenie()) {
                przesun_i_karm_roba(rob, sasiad);
                return;
            }
        }
    }

    public void wachaj(Rob rob) {
        int moj_wsp_x = rob.getWsp_x();
        int moj_wsp_y = rob.getWsp_y();

        Wsp[] sasiedzi = daj_wspolrzedne_4_sasiadow();

        for (int i = 0; i < 4; i++) {
            Pole sasiad = daj_sasiada(moj_wsp_x, moj_wsp_y, sasiedzi[i].getWsp_x(), sasiedzi[i].getWsp_y());

            if (sasiad.isCzy_jest_jedzenie()) {
                rob.setKierunek(sasiedzi[i].getKierunek());
                return;
            }
        }
    }

    public void idz(Rob rob) {
        int moj_wsp_x = rob.getWsp_x();
        int moj_wsp_y = rob.getWsp_y();
        Kierunek kierunek = rob.getKierunek();

        Pole sasiad = daj_sasiada(moj_wsp_x, moj_wsp_y, kierunek);
        przesun_i_karm_roba(rob, sasiad);
    }


    public void umiesc_roba(Rob nowy_rob, int ind_x, int ind_y) {
        plansza[ind_x][ind_y].odbierz_roba(nowy_rob);
    }

    public void usun_martwego_roba(Rob rob) {
        plansza[rob.getWsp_x()][rob.getWsp_y()].usun_roba(rob);
    }

    public void wypisz_stan_symulacji() {
        for(int j = 0; j < rozmiar_planszy_y; j++) {
            for(int i = 0; i < rozmiar_planszy_x; i++) {
                System.out.println("Pole (" + i + ", " + j + ") :");

                if(plansza[i][j].isCzy_jest_jedzenie()) {
                    System.out.println("Na polu jest jedzenie");
                }

                System.out.println("Liczba robow: " + plansza[i][j].getIle_robow());

                if(plansza[i][j].getIle_robow() > 0) {
                    System.out.println("-----------------");
                    plansza[i][j].wypisz_roby_na_polu();
                }
                System.out.println();
            }
        }
    }

    public void aktualizuj_liczbe_robow(Symuluj symulacja) {
        int liczba_robow = 0;
        for (int i = 0; i < rozmiar_planszy_x; i++) {
            for (int j = 0; j < rozmiar_planszy_y; j++) {
                liczba_robow += plansza[i][j].getIle_robow();
            }
        }
        symulacja.setLiczba_robow(liczba_robow);
    }

    public void aktualizuj_pola_zywnosc(Symuluj symulacja) {
        int liczba_pol = 0;
        for (int i = 0; i < rozmiar_planszy_x; i++) {
            for (int j = 0; j < rozmiar_planszy_y; j++) {
                if (plansza[i][j].isCzy_jest_jedzenie()) {
                    liczba_pol++;
                }
            }
        }
        symulacja.setLiczba_pol_z_zywnoscia(liczba_pol);
    }

    public void aktualizuj_dl_programow(Symuluj symulacja) {
        if (symulacja.getLiczba_robow() == 0) {
            symulacja.setMaks_dl_programu(0);
            symulacja.setMin_dl_programu(0);
            symulacja.setSr_dl_programu(0);
            return;
        }
        int min_dl = 2147483647;
        int maks_dl = 0;
        int suma = 0;

        for (int i = 0; i < rozmiar_planszy_x; i++) {
            for (int j = 0; j < rozmiar_planszy_y; j++) {
                if (plansza[i][j].getIle_robow() > 0) {
                    int akt_min_dl = plansza[i][j].min_dl_programu();
                    if (akt_min_dl < min_dl) {
                        min_dl = akt_min_dl;
                    }

                    int akt_maks_dl = plansza[i][j].maks_dl_programu();
                    if (akt_maks_dl > maks_dl) {
                        maks_dl = akt_maks_dl;
                    }

                    suma += plansza[i][j].suma_dl_programu();
                }
            }
        }
        symulacja.setMaks_dl_programu(maks_dl);
        symulacja.setMin_dl_programu(min_dl);
        int ile_robow = symulacja.getLiczba_robow();

        if (ile_robow == 0) {
            symulacja.setSr_dl_programu(0);
        } else {
            symulacja.setSr_dl_programu((double) suma / ile_robow);
        }
    }

    public void aktualizuj_energie_robow(Symuluj symulacja) {
        if (symulacja.getLiczba_robow() == 0) {
            symulacja.setMin_energia_roba(0);
            symulacja.setMaks_energia_roba(0);
            symulacja.setSr_energia_roba(0);
            return;
        }
        int min_energia = 2147483647;
        int maks_energia = 0;
        int suma = 0;

        for (int i = 0; i < rozmiar_planszy_x; i++) {
            for (int j = 0; j < rozmiar_planszy_y; j++) {
                if (plansza[i][j].getIle_robow() > 0) {
                    int akt_min_energia = plansza[i][j].min_energia_roba();
                    if (akt_min_energia < min_energia) {
                        min_energia = akt_min_energia;
                    }

                    int akt_maks_energia = plansza[i][j].maks_energia_roba();
                    if (akt_maks_energia > maks_energia) {
                        maks_energia = akt_maks_energia;
                    }

                    suma += plansza[i][j].suma_energii_robow();
                }
            }
        }
        symulacja.setMin_energia_roba(min_energia);
        symulacja.setMaks_energia_roba(maks_energia);
        int ile_robow = symulacja.getLiczba_robow();
        if (ile_robow == 0) {
            symulacja.setSr_energia_roba(0);
        } else {
            symulacja.setSr_energia_roba((double) suma / ile_robow);
        }
    }

    public void aktualizuj_wiek_robow(Symuluj symulacja) {
        if (symulacja.getLiczba_robow() == 0) {
            symulacja.setMin_wiek_roba(0);
            symulacja.setMaks_wiek_roba(0);
            symulacja.setSr_wiek_roba(0);
            return;
        }
        int min_wiek = 2147483647;
        int maks_wiek = 0;
        int suma = 0;

        for (int i = 0; i < rozmiar_planszy_x; i++) {
            for (int j = 0; j < rozmiar_planszy_y; j++) {
                if (plansza[i][j].getIle_robow() > 0) {
                    int akt_min_wiek = plansza[i][j].min_wiek_roba();
                    if (akt_min_wiek < min_wiek) {
                        min_wiek = akt_min_wiek;
                    }

                    int akt_maks_wiek = plansza[i][j].maks_wiek_roba();
                    if (akt_maks_wiek > maks_wiek) {
                        maks_wiek = akt_maks_wiek;
                    }
                    suma += plansza[i][j].suma_wieku_robow();
                }
            }
        }

        symulacja.setMin_wiek_roba(min_wiek);
        symulacja.setMaks_wiek_roba(maks_wiek);
        int ile_robow = symulacja.getLiczba_robow();
        if (ile_robow == 0) {
            symulacja.setSr_wiek_roba(0);
        } else {
            symulacja.setSr_wiek_roba((double) suma / ile_robow);
        }
    }

    public Pole daj_sasiada(int wsp_x, int wsp_y, int ruch_x, int ruch_y) {
        int nowy_x;
        int nowy_y;

        if (wsp_x + ruch_x == rozmiar_planszy_x) {
            nowy_x = 0;
        } else if (wsp_x + ruch_x == -1) {
            nowy_x = rozmiar_planszy_x - 1;
        } else {
            nowy_x = wsp_x + ruch_x;
        }

        if (wsp_y + ruch_y == rozmiar_planszy_y) {
            nowy_y = 0;
        } else if (wsp_y + ruch_y == -1) {
            nowy_y = rozmiar_planszy_y - 1;
        } else {
            nowy_y = wsp_y + ruch_y;
        }

        return plansza[nowy_x][nowy_y];
    }

    public Pole daj_sasiada(int wsp_x, int wsp_y, Kierunek kierunek) {
        switch (kierunek) {
            case GORA:
                return daj_sasiada(wsp_x, wsp_y, 0, -1);
            case DOL:
                return daj_sasiada(wsp_x, wsp_y, 0, 1);
            case PRAWO:
                return daj_sasiada(wsp_x, wsp_y, 1, 0);
            case LEWO:
                return daj_sasiada(wsp_x, wsp_y, -1, 0);
            default:
                return daj_sasiada(wsp_x, wsp_y, 0, 0);
        }
    }

    public void rosnij_jedzenie() {
        for (int i = 0; i < rozmiar_planszy_x; i++) {
            for (int j = 0; j < rozmiar_planszy_y; j++) {
                plansza[i][j].urosnij_jedzenie();
            }
        }
    }

    public void symuluj_ture() {
        for (int j = 0; j < rozmiar_planszy_y; j++) {
            for (int i = 0; i < rozmiar_planszy_x; i++) {
                plansza[i][j].uruchom_roby(this);
            }
        }
    }

    public void uplyn_czas() {
        for (int j = 0; j < rozmiar_planszy_y; j++) {
            for (int i = 0; i < rozmiar_planszy_x; i++) {
                plansza[i][j].postarz_roby();
            }
        }
    }

    public void akt_czy_ruszone_roby() {
        for (int i = 0; i < rozmiar_planszy_x; i++) {
            for (int j = 0; j < rozmiar_planszy_y; j++) {
                plansza[i][j].aktualizuj_czy_ruszony();
            }
        }
    }

    public void przesun_i_karm_roba(Rob rob, Pole nowe_pole) {
        // powiązane ze sobą bo jeść można tylko po wykonaniu ruchu

        int wsp_x = rob.getWsp_x();
        int wsp_y = rob.getWsp_y();

        plansza[wsp_x][wsp_y].usun_roba(rob);
        nowe_pole.odbierz_roba(rob);

        rob.setWsp_x(nowe_pole.getInd_x());
        rob.setWsp_y(nowe_pole.getInd_y());

        if (nowe_pole.isCzy_jest_jedzenie()) {
            nowe_pole.nakarm_roba(rob);
        }
    }

    public static class Wsp {
        private final int wsp_x;
        private final int wsp_y;
        private Kierunek kierunek;

        public Wsp(int wsp_x, int wsp_y) {
            this.wsp_x = wsp_x;
            this.wsp_y = wsp_y;
        }

        public Wsp(int wsp_x, int wsp_y, Kierunek kierunek) {
            this.wsp_x = wsp_x;
            this.wsp_y = wsp_y;
            this.kierunek = kierunek;
        }

        public int getWsp_x() {
            return wsp_x;
        }

        public int getWsp_y() {
            return wsp_y;
        }

        public Kierunek getKierunek() {
            return kierunek;
        }
    }

    private Wsp[] daj_wspolrzedne_8_sasiadow() {
        Wsp[] wspolrzedne = new Wsp[8];
        wspolrzedne[0] = new Wsp(0, 1);
        wspolrzedne[1] = new Wsp(1, 0);
        wspolrzedne[2] = new Wsp(0, -1);
        wspolrzedne[3] = new Wsp(-1, 0);
        wspolrzedne[4] = new Wsp(1, 1);
        wspolrzedne[5] = new Wsp(-1, 1);
        wspolrzedne[6] = new Wsp(1, -1);
        wspolrzedne[7] = new Wsp(-1, -1);

        return wspolrzedne;
    }

    private Wsp[] daj_wspolrzedne_4_sasiadow() {
        Wsp[] wspolrzedne = new Wsp[4];
        wspolrzedne[0] = new Wsp(0, 1, Kierunek.DOL);
        wspolrzedne[1] = new Wsp(1, 0, Kierunek.PRAWO);
        wspolrzedne[2] = new Wsp(0, -1, Kierunek.GORA);
        wspolrzedne[3] = new Wsp(-1, 0, Kierunek.LEWO);

        return wspolrzedne;
    }

    public void setPole(int ind_x, int ind_y, Pole pole) {
        plansza[ind_x][ind_y] = pole;
    }
}
