import java.util.TreeMap;

public class Dodaj_wynik {
    public static TreeMap<String, Double> ZmienneGlobalne = new TreeMap<>();
    public Double get(String nazwa) {
        return ZmienneGlobalne.get(nazwa);
    }
    public void ustaw(String nazwa, Double nowaWartosc) {
        ZmienneGlobalne.put(nazwa, nowaWartosc);
    }
public static double funkcja3() { return 7.0; }
public static double funkcja4() { return 8.0; }
public static double funkcja2() { return funkcja3() + funkcja4(); } 
public static double funkcja1() { return funkcja2(); } 
public static void main(String[] args) {
      System.out.println( funkcja1() );
} 
}