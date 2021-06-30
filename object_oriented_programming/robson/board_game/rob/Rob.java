package zad1.rob;

import zad1.uniwersum.Kierunek;
import zad1.uniwersum.Plansza;

import java.util.ArrayList;
import java.util.Random;

public class Rob {
    private final int koszt_tury;
    private int dl_programu;
    private Program program;
    private Kierunek kierunek;
    private int energia;
    private final double pr_powielenia;
    private final int ulamek_energii_rodzica;
    private final int limit_powielania;
    private int wiek;
    private int wsp_x;
    private int wsp_y;
    private boolean czy_wykonalem_ture;
    private final ArrayList<SpisInstrukcji> spis_instr;

    public Rob(int koszt_tury, Program program, ArrayList<SpisInstrukcji> spis_instr, Kierunek kierunek,
               int pocz_energia, double pr_powielenia, int ulamek_energii_rodzica,
               int limit_powielania, int wsp_x, int wsp_y) {
        this.koszt_tury = koszt_tury;
        this.program = program;
        this.dl_programu = program.getDl_programu();
        this.spis_instr = spis_instr;
        this.kierunek = kierunek;
        this.energia = pocz_energia;
        this.pr_powielenia = pr_powielenia;
        this.ulamek_energii_rodzica = ulamek_energii_rodzica;
        this.limit_powielania = limit_powielania;
        this.wsp_x = wsp_x;
        this.wsp_y = wsp_y;
        this.wiek = 0;
        this.czy_wykonalem_ture = false;
    }

    public void powiel(Plansza plansza) {
        Kierunek kierunek_dziecka = kierunek;
        switch (kierunek) {
            case DOL:
                kierunek_dziecka = Kierunek.GORA;
                break;
            case GORA:
                kierunek_dziecka = Kierunek.DOL;
                break;
            case PRAWO:
                kierunek_dziecka = Kierunek.LEWO;
                break;
            case LEWO:
                kierunek_dziecka = Kierunek.PRAWO;
                break;
        }
        Program program_dziecka = this.program.mutuj(spis_instr);
        energia -= ulamek_energii_rodzica;

        Rob maly_rob = new Rob(koszt_tury, program_dziecka, spis_instr, kierunek_dziecka, ulamek_energii_rodzica,
                pr_powielenia, ulamek_energii_rodzica, limit_powielania, wsp_x, wsp_y);

        plansza.umiesc_roba(maly_rob, wsp_x, wsp_y);
    }

    public void uruchom_program(Plansza plansza) {
        if(energia >= limit_powielania) {
            Random rand = new Random();
            if(rand.nextDouble() <= pr_powielenia) {
                powiel(plansza);
                if (energia <= 0) {
                    plansza.usun_martwego_roba(this);
                    return;
                }
            }
        }

        for(int ii = 0; ii < program.getDl_programu(); ii++) {
            if (energia <= 0) {
                plansza.usun_martwego_roba(this);
                return;
            }

            SpisInstrukcji akt_instrukcja = program.daj_instrukcje(ii);
            zuzyj_energie(1);

            switch (akt_instrukcja) {
                case l:
                    obrot(true);
                    break;
                case p:
                    obrot(false);
                    break;
                case i:
                    plansza.idz(this);
                    break;
                case w:
                    plansza.wachaj(this);
                    break;
                case j:
                    plansza.jedz(this);
                    break;
            }
        }

        energia -= koszt_tury;

        if(energia <= 0) {
            plansza.usun_martwego_roba(this);
            return;
        }

        czy_wykonalem_ture = true;
    }

    private void obrot(boolean czy_w_lewo) {
        if(czy_w_lewo) {
            switch (kierunek) {
                case LEWO:
                    kierunek = Kierunek.DOL;
                    break;
                case DOL:
                    kierunek = Kierunek.PRAWO;
                    break;
                case PRAWO:
                    kierunek = Kierunek.GORA;
                    break;
                case GORA:
                    kierunek = Kierunek.LEWO;
                    break;
            }
        } else {
            switch (kierunek) {
                case LEWO:
                    kierunek = Kierunek.GORA;
                    break;
                case DOL:
                    kierunek = Kierunek.LEWO;
                    break;
                case PRAWO:
                    kierunek = Kierunek.DOL;
                    break;
                case GORA:
                    kierunek = Kierunek.PRAWO;
                    break;
            }
        }
    }

    public void wypisz_roba() {
        System.out.println("dl_programu: " + dl_programu);
        System.out.print("program: ");
        program.wypisz_program();
        System.out.println("");
        System.out.println("kierunek: " + kierunek);
        System.out.println("energia " + energia);
        System.out.println("wiek: " + wiek);
    }

    public void zjedz(int ile_energii) {
        energia += ile_energii;
    }

    public void postarz() {
        wiek++;
    }

    public void zuzyj_energie(int ile_energii) {
        energia -= ile_energii;
    }

    public int getWsp_x() {
        return wsp_x;
    }

    public int getWsp_y() {
        return wsp_y;
    }

    public void setWsp_x(int wsp_x) {
        this.wsp_x = wsp_x;
    }

    public void setWsp_y(int wsp_y) {
        this.wsp_y = wsp_y;
    }

    public void setKierunek(Kierunek kierunek) {
        this.kierunek = kierunek;
    }

    public Kierunek getKierunek() {
        return kierunek;
    }

    public int getDl_programu() {
        return dl_programu;
    }

    public int getEnergia() {
        return energia;
    }

    public int getWiek() {
        return wiek;
    }

    public boolean isCzy_wykonalem_ture() {
        return czy_wykonalem_ture;
    }

    public void setCzy_wykonalem_ture(boolean czy_ruszony_w_tej_turze) {
        this.czy_wykonalem_ture = czy_ruszony_w_tej_turze;
    }
}
