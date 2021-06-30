import java.util.TreeMap;

public class Fibonacci_wynik {
    public static TreeMap<String, Double> ZmienneGlobalne = new TreeMap<>();
    public Double get(String nazwa) {
        return ZmienneGlobalne.get(nazwa);
    }
    public void ustaw(String nazwa, Double nowaWartosc) {
        ZmienneGlobalne.put(nazwa, nowaWartosc);
    }
public static double funkcja2() { double nowaWartosc = funkcja3(); ZmienneGlobalne.put("numer", nowaWartosc); return nowaWartosc; }
public static double funkcja3() { return 10.0; }
public static double funkcja6() { return ZmienneGlobalne.getOrDefault( "numer", 0.0); }
public static double funkcja7() { return 2.0; }
public static double funkcja5() { if( ( funkcja6() <= funkcja7() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja9() { return 1.0; }
public static double funkcja8() { return funkcja9(); } 
public static double funkcja11() { double nowaWartosc = funkcja12(); ZmienneGlobalne.put("x1", nowaWartosc); return nowaWartosc; }
public static double funkcja12() { return 1.0; }
public static double funkcja13() { double nowaWartosc = funkcja14(); ZmienneGlobalne.put("x2", nowaWartosc); return nowaWartosc; }
public static double funkcja14() { return 1.0; }
public static double funkcja15() { double nowaWartosc = funkcja16(); ZmienneGlobalne.put("index", nowaWartosc); return nowaWartosc; }
public static double funkcja16() { return 3.0; }
public static double funkcja19() { return ZmienneGlobalne.getOrDefault( "index", 0.0); }
public static double funkcja20() { return ZmienneGlobalne.getOrDefault( "numer", 0.0); }
public static double funkcja18() { if( ( funkcja19() <= funkcja20() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja22() { double nowaWartosc = funkcja23(); ZmienneGlobalne.put("temp", nowaWartosc); return nowaWartosc; }
public static double funkcja24() { return ZmienneGlobalne.getOrDefault( "x1", 0.0); }
public static double funkcja25() { return ZmienneGlobalne.getOrDefault( "x2", 0.0); }
public static double funkcja23() { return funkcja24() + funkcja25(); } 
public static double funkcja26() { double nowaWartosc = funkcja27(); ZmienneGlobalne.put("x1", nowaWartosc); return nowaWartosc; }
public static double funkcja27() { return ZmienneGlobalne.getOrDefault( "x2", 0.0); }
public static double funkcja28() { double nowaWartosc = funkcja29(); ZmienneGlobalne.put("x2", nowaWartosc); return nowaWartosc; }
public static double funkcja29() { return ZmienneGlobalne.getOrDefault( "temp", 0.0); }
public static double funkcja30() { double nowaWartosc = funkcja31(); ZmienneGlobalne.put("index", nowaWartosc); return nowaWartosc; }
public static double funkcja32() { return ZmienneGlobalne.getOrDefault( "index", 0.0); }
public static double funkcja33() { return 1.0; }
public static double funkcja31() { return funkcja32() + funkcja33(); } 
public static double funkcja21() { funkcja22(); funkcja26(); funkcja28(); return funkcja30(); } 
public static double funkcja17() { while( funkcja18() != 0.0) { funkcja21(); } return 0.0; }
public static double funkcja34() { return ZmienneGlobalne.getOrDefault( "x2", 0.0); }
public static double funkcja10() { funkcja11(); funkcja13(); funkcja15(); funkcja17(); return funkcja34(); } 
public static double funkcja4() { if( funkcja5() != 0.0) { return funkcja8(); } else { return funkcja10(); } }
public static double funkcja1() { funkcja2(); return funkcja4(); } 
public static void main(String[] args) {
      System.out.println( funkcja1() );
} 
}