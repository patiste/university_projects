package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobsonTest {

    @Test
    public void wykonajDodaj() {
        Robson robson = new Robson();
        try {
            robson.fromJSON("przykladowe_programy/dodaj.json");
        } catch (Robson.NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        try {
            assertEquals(15.0, robson.wykonaj(), 0.1);
        } catch (Robson.BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }
    }

    @Test
    public void wykonajFib() {
        Robson robson = new Robson();
        try {
            robson.fromJSON("przykladowe_programy/fibonacci.json");
        } catch (Robson.NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        try {
            assertEquals(55.0, robson.wykonaj(), 0.1);
        } catch (Robson.BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }
    }

    @Test
    public void wykonajDlugiTest() {
        Robson robson = new Robson();
        try {
            robson.fromJSON("przykladowe_programy/dlugi_test.json");
        } catch (Robson.NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        try {
            assertEquals(1, robson.wykonaj(), 0.1);
        } catch (Robson.BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }
    }

    @Test
    public void wykonajBinomial() {
        Robson robson = new Robson();
        try {
            robson.fromJSON("przykladowe_programy/binomial.json");
        } catch (Robson.NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        try {
            assertEquals(210, robson.wykonaj(), 0.1);
        } catch (Robson.BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }
    }

    @Test
    public void wykonajSilnia() {
        Robson robson = new Robson();
        try {
            robson.fromJSON("przykladowe_programy/silnia.json");
        } catch (Robson.NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
        try {
            assertEquals(3628800.0, robson.wykonaj(), 0.1);
        } catch (Robson.BladWykonania bladWykonania) {
            bladWykonania.printStackTrace();
        }
    }
}