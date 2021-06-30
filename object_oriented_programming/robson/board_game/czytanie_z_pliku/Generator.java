package zad1.czytanie_z_pliku;

import zad1.symulacja.Symuluj;
import zad1.rob.Program;
import zad1.rob.Rob;
import zad1.rob.SpisInstrukcji;
import zad1.uniwersum.Kierunek;
import zad1.uniwersum.Plansza;
import zad1.uniwersum.PolePuste;
import zad1.uniwersum.PoleZywieniowe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Generator {
    private int rozmiar_planszy_x;
    private int rozmiar_planszy_y;

    private int pocz_ile_robow;
    private int ile_tur;
    private final ArrayList<SpisInstrukcji> pocz_progr = new ArrayList<>();
    private final ArrayList<SpisInstrukcji> spis_instr = new ArrayList<>();
    private int pocz_energia;
    private double pr_powielenia;
    private int ulamek_energii_rodzica;
    private int limit_powielania;
    private int co_ile_wypisz;
    private double pr_usuniecia_instr;
    private double pr_dodania_instr;
    private double pr_zmiany_instr;
    private int koszt_tury;
    private int ile_daje_jedzenie;
    private int ile_rosnie_jedzenie;

    // wczytany z pliku plan planszy
    private char[][] plan_planszy;

    public static class NiepoprawneParametry extends Exception {
        public NiepoprawneParametry(String wiadomosc) {
            super(wiadomosc);
        }
    }

    public static class NiedozwolonaInstrukcja extends Exception {
        public NiedozwolonaInstrukcja(String wiadomosc) {
            super(wiadomosc);
        }
    }

    private void parsuj_i_zapamietaj_parametry(String nazwa_param, String parametr,
                                               ArrayList<String> wczytane_parametry)
                                               throws NiepoprawneParametry, NiedozwolonaInstrukcja {

        if (wczytane_parametry.contains(nazwa_param)) {
            throw new NiepoprawneParametry("Parametr '" + nazwa_param + "' wystapil wiecej niz raz.");
        }
        wczytane_parametry.add(nazwa_param);

        try {
            switch (nazwa_param) {
                case "ile_tur":
                    this.ile_tur = Integer.parseInt(parametr);
                    break;
                case "pocz_ile_robow":
                    this.pocz_ile_robow = Integer.parseInt(parametr);
                    break;
                case "pocz_progr":
                    for (int i = 0; i < parametr.length(); i++) {
                        String instrukcja = Character.toString(parametr.charAt(i));
                        try {
                            this.pocz_progr.add(SpisInstrukcji.valueOf(instrukcja));
                        } catch (IllegalArgumentException e) {
                            throw new NiedozwolonaInstrukcja("Początkowy program zawiera niedozwolony znak '" + instrukcja + "'");
                        }
                    }
                    break;
                case "spis_instr":
                    for (int i = 0; i < parametr.length(); i++) {
                        String instrukcja = Character.toString(parametr.charAt(i));
                        try {
                            if (!spis_instr.contains(SpisInstrukcji.valueOf(instrukcja))) {
                                this.spis_instr.add(SpisInstrukcji.valueOf(instrukcja));
                            }
                        } catch (IllegalArgumentException e) {
                            throw new NiedozwolonaInstrukcja("Spis instrukcji zawiera niedozwolony znak '" + instrukcja + "'");
                        }
                    }
                    break;
                case "pocz_energia":
                    this.pocz_energia = Integer.parseInt(parametr);
                    break;
                case "pr_powielenia":
                    this.pr_powielenia = Double.parseDouble(parametr);
                    break;
                case "ulamek_energii_rodzica":
                    this.ulamek_energii_rodzica = Integer.parseInt(parametr);
                    break;
                case "limit_powielania":
                    this.limit_powielania = Integer.parseInt(parametr);
                    break;
                case "co_ile_wypisz":
                    this.co_ile_wypisz = Integer.parseInt(parametr);
                    break;
                case "pr_usuniecia_instr":
                    this.pr_usuniecia_instr = Double.parseDouble(parametr);
                    break;
                case "pr_dodania_instr":
                    this.pr_dodania_instr = Double.parseDouble(parametr);
                    break;
                case "pr_zmiany_instr":
                    this.pr_zmiany_instr = Double.parseDouble(parametr);
                    break;
                case "koszt_tury":
                    this.koszt_tury = Integer.parseInt(parametr);
                    break;
                case "ile_daje_jedzenie":
                    this.ile_daje_jedzenie = Integer.parseInt(parametr);
                    break;
                case "ile_rosnie_jedzenie":
                    this.ile_rosnie_jedzenie = Integer.parseInt(parametr);
                    break;
                default:
                    throw new NiepoprawneParametry("Nieprawidlowa nazwa parametru: '" + nazwa_param + "'");
            }
        } catch (NumberFormatException e) {
            if (nazwa_param.equals("pr_zmiany_instr") || nazwa_param.equals("pr_dodania_instr") ||
                    nazwa_param.equals("pr_usuniecia_instr") || nazwa_param.equals("pr_powielenia")) {
                throw new NiepoprawneParametry("Nieprawidlowy format parametru. Parametr powinien być typu zmiennoprzecinkowego z kropka.");
            } else {
                throw new NiepoprawneParametry("Nieprawidlowy format parametru. Parametr powinien być typu calkowitoliczbowego.");
            }
        }
    }

    public void wczytaj_parametry(File plik_parametry) throws NiepoprawneParametry, NiedozwolonaInstrukcja {
        ArrayList<String> wczytane_parametry = new ArrayList<>();

        try {
            Scanner scan = new Scanner(plik_parametry);

            while (scan.hasNextLine()) {
                String wiersz = scan.nextLine();
                if(wiersz.equals("pocz_progr ")) {
                    if (wczytane_parametry.contains("pocz_progr ")) {
                        throw new NiepoprawneParametry("Parametr 'pocz_progr' wystapil wiecej niz raz.");
                    }
                    wczytane_parametry.add("pocz_progr");
                    // pocz_progr jest zainicjalizowany jako pusta arrayLista, ok
                } else if(wiersz.equals("spis_instr ")) {
                    if (wczytane_parametry.contains("spis_instr")) {
                        throw new NiepoprawneParametry("Parametr 'spis_instr' wystapil wiecej niz raz.");
                    }
                    wczytane_parametry.add("spis_instr");
                    // spis_instr jest zainicjalizowany jako pusta arrayLista, ok
                } else {
                    String[] podziel = wiersz.split(" ");

                    if (podziel.length != 2) {
                        throw new NiepoprawneParametry("Nieprawidlowy format parametru '" + wiersz + "'." +
                                " Parametr powinien zawierac nazwe i wartosc oddzielone spacja.");
                    }

                    String nazwa_param = podziel[0];
                    String parametr = podziel[1];
                    parsuj_i_zapamietaj_parametry(nazwa_param, parametr, wczytane_parametry);
                }
            }
            scan.close();

            if (wczytane_parametry.size() < 15) {
                throw new NiepoprawneParametry("Podano za malo parametrow.");
            }
            for (SpisInstrukcji spisInstrukcji : pocz_progr) {
                if (!spis_instr.contains(spisInstrukcji)) {
                    throw new NiedozwolonaInstrukcja("Poczatkowy program zawiera instrukcje" +
                            " niedostepna w spisie instrukcji");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Wystąpił błąd.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private char[][] zapisz_plan_planszy(ArrayList<String> wiersze) {
        char[][] plan = new char[rozmiar_planszy_x][rozmiar_planszy_y];

        for (int j = 0; j < wiersze.size(); j++) {
            for (int i = 0; i < wiersze.get(0).length(); i++) {
                plan[i][j] = wiersze.get(j).charAt(i);
            }
        }
        return plan;
    }

    public static class NiepoprawnyPlikZPlansza extends Exception {
        public NiepoprawnyPlikZPlansza(String wiadomosc) {
            super(wiadomosc);
        }
    }

    public boolean czy_wiersz_ok_znaki(String wiersz) {
        for (int i = 0; i < wiersz.length(); i++) {
            if (wiersz.charAt(i) != 'x' && wiersz.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public void wczytaj_plan_planszy(File plik_plansza) {
        try {
            Scanner scan = new Scanner(plik_plansza);
            ArrayList<String> wiersze = new ArrayList<String>();

            while (scan.hasNextLine()) {
                String pierwszy_wiersz = scan.nextLine();
                wiersze.add(pierwszy_wiersz);
                this.setRozmiar_planszy_x(pierwszy_wiersz.length());
                if (!czy_wiersz_ok_znaki(pierwszy_wiersz)) {
                    throw new NiepoprawnyPlikZPlansza("Plansza zawiera niedozwolony znak");
                }
            }

            while (scan.hasNextLine()) {
                String wiersz = scan.nextLine();
                if (wiersz.length() != rozmiar_planszy_x) {
                    throw new NiepoprawnyPlikZPlansza("Rozna dlugosc wierszy");
                }
                if (!czy_wiersz_ok_znaki(wiersz)) {
                    throw new NiepoprawnyPlikZPlansza("Plansza zawiera niedozwolony znak");
                }
                wiersze.add(wiersz);
            }

            if (wiersze.size() == 0) {
                throw new NiepoprawnyPlikZPlansza("Podano pustą planszę");
            }
            this.setRozmiar_planszy_y(wiersze.size());
            this.plan_planszy = zapisz_plan_planszy(wiersze);
            scan.close();
        } catch (FileNotFoundException | NiepoprawnyPlikZPlansza e) {
            System.out.println("Wystąpił błąd.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public Plansza generuj_plansze() {
        Plansza plansza = new Plansza(rozmiar_planszy_x, rozmiar_planszy_y);

        for (int j = 0; j < rozmiar_planszy_y; j++) {
            for (int i = 0; i < rozmiar_planszy_x; i++) {
                switch (plan_planszy[i][j]) {
                    case ' ':
                        plansza.setPole(i, j, new PolePuste(i, j));
                        break;
                    case 'x':
                        plansza.setPole(i, j, new PoleZywieniowe(i, j, ile_daje_jedzenie, ile_rosnie_jedzenie));
                        break;
                }
            }
        }
        return plansza;
    }

    private Program generuj_pocz_progr() {
        return new Program(pocz_progr, pr_usuniecia_instr, pr_dodania_instr, pr_zmiany_instr);
    }

    private Rob generuj_pocz_roba(int ind_x, int ind_y) {
        Random rand = new Random();
        int ktory = rand.nextInt(Kierunek.values().length);
        Kierunek kierunek_roba = Kierunek.values()[ktory];

        Program pocz_program = generuj_pocz_progr();

        return new Rob(koszt_tury, pocz_program, spis_instr, kierunek_roba,
                pocz_energia, pr_powielenia, ulamek_energii_rodzica,
                limit_powielania, ind_x, ind_y);
    }

    public void desant_robow_na_plansze(Plansza plansza) {
        Random rand = new Random();
        for (int i = 0; i < pocz_ile_robow; i++) {
            int ind_x = rand.nextInt(rozmiar_planszy_x);
            int ind_y = rand.nextInt(rozmiar_planszy_y);
            Rob nowy_rob = generuj_pocz_roba(ind_x, ind_y);

            plansza.umiesc_roba(nowy_rob, ind_x, ind_y);
        }
    }

    public Symuluj generuj_symulacje(Plansza plansza) {
        return new Symuluj(ile_tur, co_ile_wypisz, plansza, pocz_ile_robow);
    }

    public void setRozmiar_planszy_x(int rozmiar_planszy_x) {
        this.rozmiar_planszy_x = rozmiar_planszy_x;
    }

    public void setRozmiar_planszy_y(int rozmiar_planszy_y) {
        this.rozmiar_planszy_y = rozmiar_planszy_y;
    }
}
