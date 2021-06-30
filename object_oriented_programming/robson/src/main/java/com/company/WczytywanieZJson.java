package com.company;

import com.company.wyrazenia.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class WczytywanieZJson {
    public Wyrazenie rozpoznajIWczytajWyrazenie(String typ, JsonObject instrObject) {
        return switch (typ) {
            case "Blok" -> wczytajBlok(instrObject);
            case "If" -> wczytajIf(instrObject);
            case "While" -> wczytajWhile(instrObject);
            case "Przypisanie" -> wczytajPrzypisanie(instrObject);
            case "Plus", "Minus", "Razy", "Dzielenie", "And", "Or", "<=", ">=", "<", ">", "==" -> wczytajWyrazenie2Arg(typ, instrObject);
            case "Not" -> wczytajWyrazenie1Arg(instrObject);
            case "Liczba" -> wczytajLiczbe(instrObject);
            case "Zmienna" -> wczytajZmienna(instrObject);
            case "True", "False" -> wczytajStala(typ);
            default -> null;
        };
    }

    private Wyrazenie wczytajWyrazenieZObiektuJson(JsonObject JsonWyrazenie) {
        String typ = JsonWyrazenie.get("typ").getAsString();
        return rozpoznajIWczytajWyrazenie(typ, JsonWyrazenie);
    }

    private BlokInstrukcji wczytajBlok(JsonObject fileObject) {
        JsonArray wczytaneINstrukcje = fileObject.get("instrukcje").getAsJsonArray();

        ArrayList<Wyrazenie> instrukcjeBloku = new ArrayList<>();

        for (JsonElement instrElement : wczytaneINstrukcje) {
            JsonObject instrObject = instrElement.getAsJsonObject();

            String typ = instrObject.get("typ").getAsString();
            Wyrazenie wyr = rozpoznajIWczytajWyrazenie(typ, instrObject);
            if (wyr != null)
                instrukcjeBloku.add(wyr);
        }
        return new BlokInstrukcji(instrukcjeBloku);
    }

    private Liczba wczytajLiczbe(JsonObject instrObject) {
        double wart = instrObject.get("wartosc").getAsDouble();
        return new Liczba(wart);
    }

    private If wczytajIf(JsonObject instrObject) {
        JsonObject JsonWarunek = instrObject.get("warunek").getAsJsonObject();
        Wyrazenie warunek = wczytajWyrazenieZObiektuJson(JsonWarunek);

        JsonObject JsonBlokPrawda = instrObject.get("blok_prawda").getAsJsonObject();
        Wyrazenie blokPrawda = wczytajWyrazenieZObiektuJson(JsonBlokPrawda);

        if (instrObject.has("blok_falsz")) {
            JsonObject JsonBlokFalsz = instrObject.get("blok_falsz").getAsJsonObject();
            Wyrazenie blokFalsz = wczytajWyrazenieZObiektuJson(JsonBlokFalsz);
            return new If(warunek, blokPrawda, blokFalsz);
        }
        return new If(warunek, blokPrawda);

    }

    private While wczytajWhile(JsonObject instrObject) {
        JsonObject JsonWarunek = instrObject.get("warunek").getAsJsonObject();
        Wyrazenie warunek = wczytajWyrazenieZObiektuJson(JsonWarunek);

        JsonObject JsonBlok = instrObject.get("blok").getAsJsonObject();
        Wyrazenie blok = wczytajWyrazenieZObiektuJson(JsonBlok);

        return new While(warunek, blok);
    }

    private Przypisanie wczytajPrzypisanie(JsonObject instrObject) {
        String nazwa = instrObject.get("nazwa").getAsString();

        JsonObject JsonWyrazenie = instrObject.get("wartosc").getAsJsonObject();
        Wyrazenie wartosc = wczytajWyrazenieZObiektuJson(JsonWyrazenie);

        Robson.zmienneGlobalne.put(nazwa, 0.);

        return new Przypisanie(nazwa, wartosc);
    }

    private Zmienna wczytajZmienna(JsonObject instrObject) {
        String nazwa = instrObject.get("nazwa").getAsString();
        return new Zmienna(nazwa);
    }

    private Stala wczytajStala(String typ) {
        return switch (typ) {
            case "True" -> new True();
            case "False" -> new False();
            default -> null;
        };
    }

    private Wyrazenie wczytajWyrazenie2Arg(String typ, JsonObject instrObject) {
        JsonObject JsonArg1 = instrObject.get("argument1").getAsJsonObject();
        Wyrazenie argument1 = wczytajWyrazenieZObiektuJson(JsonArg1);

        JsonObject JsonArg2 = instrObject.get("argument2").getAsJsonObject();
        Wyrazenie argument2 = wczytajWyrazenieZObiektuJson(JsonArg2);

        return switch (typ) {
            case "Plus" -> new Plus(argument1, argument2);
            case "Minus" -> new Minus(argument1, argument2);
            case "Razy" -> new Razy(argument1, argument2);
            case "Dzielenie" -> new Dzielenie(argument1, argument2);
            case "And" -> new And(argument1, argument2);
            case "Or" -> new Or(argument1, argument2);
            case "<" -> new Mniejsze(argument1, argument2);
            case ">" -> new Wieksze(argument1, argument2);
            case "==" -> new Rowne(argument1, argument2);
            case "<=" -> new MniejszeRowne(argument1, argument2);
            case ">=" -> new WiekszeRowne(argument1, argument2);
            default -> null;
        };
    }

    private Wyrazenie wczytajWyrazenie1Arg(JsonObject instrObject) {
        JsonObject JsonArg = instrObject.get("argument").getAsJsonObject();
        Wyrazenie argument = wczytajWyrazenieZObiektuJson(JsonArg);
        return new Not(argument);
    }
}
