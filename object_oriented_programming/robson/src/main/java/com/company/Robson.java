package com.company;

import com.company.wyrazenia.Wyrazenie;
import com.google.gson.*;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Robson {
    public static Wyrazenie wczytanyProgram;
    public static TreeMap<String, Double> zmienneGlobalne;

    public double wykonaj() throws BladWykonania {
        if(wczytanyProgram == null) {
            throw new BladWykonania("Obiekt klasy Robson nie istnieje");
        }
        return wczytanyProgram.wykonaj();
    }

    public void fromJSON(String filename) throws NieprawidlowyProgram {
        WczytywanieZJson wczytaj = new WczytywanieZJson();

        zmienneGlobalne  = new TreeMap<>();
        File input = new File(filename);
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();

            String typ = fileObject.get("typ").getAsString();
            wczytanyProgram = wczytaj.rozpoznajIWczytajWyrazenie(typ, fileObject);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void toJson(String filename) throws BladWykonania {
        if(wczytanyProgram == null) {
            throw new BladWykonania("Obiekt klasy Robson nie istnieje");
        }
        Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(wczytanyProgram);
        saveInFile(filename, json);
    }

    public static int nrFunkcji;
    public void toJava(String filename) throws BladWykonania {
        Path path = Paths.get(filename);
        Path nazwaPliku = path.getFileName();

        String nazwaKlasy = nazwaPliku.toString().substring(0, nazwaPliku.toString().indexOf("."));

        if(wczytanyProgram == null) {
            throw new BladWykonania("Obiekt klasy Robson nie istnieje");
        }
        nrFunkcji = 1;
        String wynik = "";

        String javaProgram = wynik + "import java.util.TreeMap;\n" +
                "\n" +
                "public class " + nazwaKlasy + " {\n" +
                "    public static TreeMap<String, Double> ZmienneGlobalne = new TreeMap<>();\n" +
                "    public Double get(String nazwa) {\n" +
                "        return ZmienneGlobalne.get(nazwa);\n" +
                "    }\n" +
                "    public void ustaw(String nazwa, Double nowaWartosc) {\n" +
                "        ZmienneGlobalne.put(nazwa, nowaWartosc);\n" +
                "    }\n" +
                wczytanyProgram.toJavaCode() +
                """
                        public static void main(String[] args) {
                              System.out.println( funkcja1() );
                        }\s
                        }""";
        saveInFile(filename, javaProgram);
    }

    public static void saveInFile(String filename, String stringToSave) {
        FileWriter locFile = null;
        try {
            locFile = new FileWriter(filename);
            locFile.write(stringToSave);
        } catch(IOException e) {
            System.out.println("Błąd zapisu do pliku");
            e.printStackTrace();
        } finally {
            try {
                if(locFile != null) {
                    locFile.close();
                }
            } catch(IOException e) {
                System.out.println("Błąd zapisu do pliku");
                e.printStackTrace();
            }
        }
    }

    public static class NieprawidlowyProgram extends Exception {
        public NieprawidlowyProgram(String wiadomosc) {
            super(wiadomosc);
        }
    }

    public static class BladWykonania extends Exception {
        public BladWykonania(String wiadomosc) {
            super(wiadomosc);
        }
    }

}
