package com.company;

public class Main {

    public static void main(String[] args) throws Robson.NieprawidlowyProgram, Robson.BladWykonania {
        // przyklad uzycia biblioteki Robson
        Robson robson = new Robson();
        robson.fromJSON("przykladowe_programy/fibonacci.json");
        System.out.println(robson.wykonaj());
        robson.toJson("przykladowe_programy/fibonacci_wynik.json");
        robson.toJava("przykladowe_programy/Fibonacci_wynik.java");
    }
}
