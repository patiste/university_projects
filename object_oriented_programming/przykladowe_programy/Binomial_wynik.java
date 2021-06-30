import java.util.TreeMap;

public class Binomial_wynik {
    public static TreeMap<String, Double> ZmienneGlobalne = new TreeMap<>();
    public Double get(String nazwa) {
        return ZmienneGlobalne.get(nazwa);
    }
    public void ustaw(String nazwa, Double nowaWartosc) {
        ZmienneGlobalne.put(nazwa, nowaWartosc);
    }
public static double funkcja2() { double nowaWartosc = funkcja3(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja3() { return 10.0; }
public static double funkcja4() { double nowaWartosc = funkcja5(); ZmienneGlobalne.put("y", nowaWartosc); return nowaWartosc; }
public static double funkcja5() { return 6.0; }
public static double funkcja6() { double nowaWartosc = funkcja7(); ZmienneGlobalne.put("aaa", nowaWartosc); return nowaWartosc; }
public static double funkcja8() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja9() { return ZmienneGlobalne.getOrDefault( "y", 0.0); }
public static double funkcja7() { return funkcja8() - funkcja9(); } 
public static double funkcja10() { double nowaWartosc = funkcja11(); ZmienneGlobalne.put("xxx", nowaWartosc); return nowaWartosc; }
public static double funkcja11() { return 1.0; }
public static double funkcja14() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja15() { return 1.0; }
public static double funkcja13() { if( ( funkcja14() > funkcja15() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja17() { double nowaWartosc = funkcja18(); ZmienneGlobalne.put("xxx", nowaWartosc); return nowaWartosc; }
public static double funkcja19() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja20() { return ZmienneGlobalne.getOrDefault( "xxx", 0.0); }
public static double funkcja18() { return funkcja19() * funkcja20(); } 
public static double funkcja21() { double nowaWartosc = funkcja22(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja23() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja24() { return 1.0; }
public static double funkcja22() { return funkcja23() - funkcja24(); } 
public static double funkcja16() { funkcja17(); return funkcja21(); } 
public static double funkcja12() { while( funkcja13() != 0.0) { funkcja16(); } return 0.0; }
public static double funkcja25() { double nowaWartosc = funkcja26(); ZmienneGlobalne.put("yyy", nowaWartosc); return nowaWartosc; }
public static double funkcja26() { return 1.0; }
public static double funkcja29() { return ZmienneGlobalne.getOrDefault( "y", 0.0); }
public static double funkcja30() { return 1.0; }
public static double funkcja28() { if( ( funkcja29() > funkcja30() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja32() { double nowaWartosc = funkcja33(); ZmienneGlobalne.put("yyy", nowaWartosc); return nowaWartosc; }
public static double funkcja34() { return ZmienneGlobalne.getOrDefault( "y", 0.0); }
public static double funkcja35() { return ZmienneGlobalne.getOrDefault( "yyy", 0.0); }
public static double funkcja33() { return funkcja34() * funkcja35(); } 
public static double funkcja36() { double nowaWartosc = funkcja37(); ZmienneGlobalne.put("y", nowaWartosc); return nowaWartosc; }
public static double funkcja38() { return ZmienneGlobalne.getOrDefault( "y", 0.0); }
public static double funkcja39() { return 1.0; }
public static double funkcja37() { return funkcja38() - funkcja39(); } 
public static double funkcja31() { funkcja32(); return funkcja36(); } 
public static double funkcja27() { while( funkcja28() != 0.0) { funkcja31(); } return 0.0; }
public static double funkcja40() { double nowaWartosc = funkcja41(); ZmienneGlobalne.put("xxx", nowaWartosc); return nowaWartosc; }
public static double funkcja42() { return ZmienneGlobalne.getOrDefault( "xxx", 0.0); }
public static double funkcja43() { return ZmienneGlobalne.getOrDefault( "yyy", 0.0); }
public static double funkcja41() { return funkcja42() / funkcja43(); } 
public static double funkcja44() { double nowaWartosc = funkcja45(); ZmienneGlobalne.put("zzz", nowaWartosc); return nowaWartosc; }
public static double funkcja45() { return 1.0; }
public static double funkcja48() { return ZmienneGlobalne.getOrDefault( "aaa", 0.0); }
public static double funkcja49() { return 1.0; }
public static double funkcja47() { if( ( funkcja48() > funkcja49() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja51() { double nowaWartosc = funkcja52(); ZmienneGlobalne.put("zzz", nowaWartosc); return nowaWartosc; }
public static double funkcja53() { return ZmienneGlobalne.getOrDefault( "aaa", 0.0); }
public static double funkcja54() { return ZmienneGlobalne.getOrDefault( "zzz", 0.0); }
public static double funkcja52() { return funkcja53() * funkcja54(); } 
public static double funkcja55() { double nowaWartosc = funkcja56(); ZmienneGlobalne.put("aaa", nowaWartosc); return nowaWartosc; }
public static double funkcja57() { return ZmienneGlobalne.getOrDefault( "aaa", 0.0); }
public static double funkcja58() { return 1.0; }
public static double funkcja56() { return funkcja57() - funkcja58(); } 
public static double funkcja50() { funkcja51(); return funkcja55(); } 
public static double funkcja46() { while( funkcja47() != 0.0) { funkcja50(); } return 0.0; }
public static double funkcja59() { double nowaWartosc = funkcja60(); ZmienneGlobalne.put("xxx", nowaWartosc); return nowaWartosc; }
public static double funkcja61() { return ZmienneGlobalne.getOrDefault( "xxx", 0.0); }
public static double funkcja62() { return ZmienneGlobalne.getOrDefault( "zzz", 0.0); }
public static double funkcja60() { return funkcja61() / funkcja62(); } 
public static double funkcja63() { return ZmienneGlobalne.getOrDefault( "xxx", 0.0); }
public static double funkcja1() { funkcja2(); funkcja4(); funkcja6(); funkcja10(); funkcja12(); funkcja25(); funkcja27(); funkcja40(); funkcja44(); funkcja46(); funkcja59(); return funkcja63(); } 
public static void main(String[] args) {
      System.out.println( funkcja1() );
} 
}