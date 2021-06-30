import java.util.TreeMap;

public class Silnia_wynik {
    public static TreeMap<String, Double> ZmienneGlobalne = new TreeMap<>();
    public Double get(String nazwa) {
        return ZmienneGlobalne.get(nazwa);
    }
    public void ustaw(String nazwa, Double nowaWartosc) {
        ZmienneGlobalne.put(nazwa, nowaWartosc);
    }
public static double funkcja2() { double nowaWartosc = funkcja3(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja3() { return 10.0; }
public static double funkcja4() { double nowaWartosc = funkcja5(); ZmienneGlobalne.put("xxx", nowaWartosc); return nowaWartosc; }
public static double funkcja5() { return 1.0; }
public static double funkcja8() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja9() { return 1.0; }
public static double funkcja7() { if( (funkcja8() != 0.0 > funkcja9() != 0.0 )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja11() { double nowaWartosc = funkcja12(); ZmienneGlobalne.put("xxx", nowaWartosc); return nowaWartosc; }
public static double funkcja13() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja14() { return ZmienneGlobalne.getOrDefault( "xxx", 0.0); }
public static double funkcja12() { return funkcja13() * funkcja14(); } 
public static double funkcja15() { double nowaWartosc = funkcja16(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja17() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja18() { return 1.0; }
public static double funkcja16() { return funkcja17() - funkcja18(); } 
public static double funkcja10() { funkcja11(); return funkcja15(); } 
public static double funkcja6() { while( funkcja7() != 0.0) { funkcja10(); } return 0.0; }
public static double funkcja19() { return ZmienneGlobalne.getOrDefault( "xxx", 0.0); }
public static double funkcja1() { funkcja2(); funkcja4(); funkcja6(); return funkcja19(); } 
public static void main(String[] args) {
      System.out.println( funkcja1() );
} 
}