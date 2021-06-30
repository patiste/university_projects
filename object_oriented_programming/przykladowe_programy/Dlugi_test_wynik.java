import java.util.TreeMap;

public class Dlugi_test_wynik {
    public static TreeMap<String, Double> ZmienneGlobalne = new TreeMap<>();
    public Double get(String nazwa) {
        return ZmienneGlobalne.get(nazwa);
    }
    public void ustaw(String nazwa, Double nowaWartosc) {
        ZmienneGlobalne.put(nazwa, nowaWartosc);
    }
public static double funkcja10() { return 0.0; }
public static double funkcja13() { double nowaWartosc = funkcja14(); ZmienneGlobalne.put("y", nowaWartosc); return nowaWartosc; }
public static double funkcja17() { return 0.0; }
public static double funkcja19() { return 0.0; }
public static double funkcja24() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja25() { double nowaWartosc = funkcja26(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja26() { return 5.0; }
public static double funkcja23() { funkcja24(); return funkcja25(); } 
public static double funkcja27() { return 4.5; }
public static double funkcja22() { if( ( funkcja23() > funkcja27() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja28() { return 1.0; }
public static double funkcja21() { if( ( funkcja22() == funkcja28() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja29() { return 0.0; }
public static double funkcja20() { if( ( (funkcja21() != 0.0) || (funkcja29() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja18() { if( ( (funkcja19() != 0.0) || (funkcja20() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja16() { if( ( (funkcja17() != 0.0) || (funkcja18() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja31() { return 0.0; }
public static double funkcja33() { return 0.0; }
public static double funkcja38() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja39() { double nowaWartosc = funkcja40(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja40() { return 5.0; }
public static double funkcja37() { funkcja38(); return funkcja39(); } 
public static double funkcja41() { return 4.5; }
public static double funkcja36() { if( ( funkcja37() > funkcja41() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja42() { return 1.0; }
public static double funkcja35() { if( ( funkcja36() == funkcja42() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja43() { return 0.0; }
public static double funkcja34() { if( ( (funkcja35() != 0.0) || (funkcja43() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja32() { if( ( (funkcja33() != 0.0) || (funkcja34() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja30() { if( ( (funkcja31() != 0.0) || (funkcja32() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja15() { return funkcja16() + funkcja30(); } 
public static double funkcja46() { return 0.0; }
public static double funkcja48() { return 0.0; }
public static double funkcja53() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja54() { double nowaWartosc = funkcja55(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja55() { return 5.0; }
public static double funkcja52() { funkcja53(); return funkcja54(); } 
public static double funkcja56() { return 4.5; }
public static double funkcja51() { if( ( funkcja52() > funkcja56() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja57() { return 1.0; }
public static double funkcja50() { if( ( funkcja51() == funkcja57() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja58() { return 0.0; }
public static double funkcja49() { if( ( (funkcja50() != 0.0) || (funkcja58() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja47() { if( ( (funkcja48() != 0.0) || (funkcja49() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja45() { if( ( (funkcja46() != 0.0) || (funkcja47() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja60() { return 0.0; }
public static double funkcja62() { return 0.0; }
public static double funkcja67() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja68() { double nowaWartosc = funkcja69(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja69() { return 5.0; }
public static double funkcja66() { funkcja67(); return funkcja68(); } 
public static double funkcja70() { return 4.5; }
public static double funkcja65() { if( ( funkcja66() > funkcja70() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja71() { return 1.0; }
public static double funkcja64() { if( ( funkcja65() == funkcja71() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja72() { return 0.0; }
public static double funkcja63() { if( ( (funkcja64() != 0.0) || (funkcja72() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja61() { if( ( (funkcja62() != 0.0) || (funkcja63() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja59() { if( ( (funkcja60() != 0.0) || (funkcja61() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja44() { return funkcja45() + funkcja59(); } 
public static double funkcja14() { return funkcja15() + funkcja44(); } 
public static double funkcja73() { return 4.0; }
public static double funkcja12() { if( ( funkcja13() == funkcja73() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja74() { return 1.0; }
public static double funkcja11() { if( ( funkcja12() == funkcja74() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja9() { if( ( funkcja10() < funkcja11() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja76() { return 0.0; }
public static double funkcja79() { double nowaWartosc = funkcja80(); ZmienneGlobalne.put("y", nowaWartosc); return nowaWartosc; }
public static double funkcja83() { return 0.0; }
public static double funkcja85() { return 0.0; }
public static double funkcja90() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja91() { double nowaWartosc = funkcja92(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja92() { return 5.0; }
public static double funkcja89() { funkcja90(); return funkcja91(); } 
public static double funkcja93() { return 4.5; }
public static double funkcja88() { if( ( funkcja89() > funkcja93() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja94() { return 1.0; }
public static double funkcja87() { if( ( funkcja88() == funkcja94() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja95() { return 0.0; }
public static double funkcja86() { if( ( (funkcja87() != 0.0) || (funkcja95() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja84() { if( ( (funkcja85() != 0.0) || (funkcja86() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja82() { if( ( (funkcja83() != 0.0) || (funkcja84() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja97() { return 0.0; }
public static double funkcja99() { return 0.0; }
public static double funkcja104() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja105() { double nowaWartosc = funkcja106(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja106() { return 5.0; }
public static double funkcja103() { funkcja104(); return funkcja105(); } 
public static double funkcja107() { return 4.5; }
public static double funkcja102() { if( ( funkcja103() > funkcja107() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja108() { return 1.0; }
public static double funkcja101() { if( ( funkcja102() == funkcja108() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja109() { return 0.0; }
public static double funkcja100() { if( ( (funkcja101() != 0.0) || (funkcja109() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja98() { if( ( (funkcja99() != 0.0) || (funkcja100() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja96() { if( ( (funkcja97() != 0.0) || (funkcja98() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja81() { return funkcja82() + funkcja96(); } 
public static double funkcja112() { return 0.0; }
public static double funkcja114() { return 0.0; }
public static double funkcja119() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja120() { double nowaWartosc = funkcja121(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja121() { return 5.0; }
public static double funkcja118() { funkcja119(); return funkcja120(); } 
public static double funkcja122() { return 4.5; }
public static double funkcja117() { if( ( funkcja118() > funkcja122() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja123() { return 1.0; }
public static double funkcja116() { if( ( funkcja117() == funkcja123() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja124() { return 0.0; }
public static double funkcja115() { if( ( (funkcja116() != 0.0) || (funkcja124() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja113() { if( ( (funkcja114() != 0.0) || (funkcja115() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja111() { if( ( (funkcja112() != 0.0) || (funkcja113() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja126() { return 0.0; }
public static double funkcja128() { return 0.0; }
public static double funkcja133() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja134() { double nowaWartosc = funkcja135(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja135() { return 5.0; }
public static double funkcja132() { funkcja133(); return funkcja134(); } 
public static double funkcja136() { return 4.5; }
public static double funkcja131() { if( ( funkcja132() > funkcja136() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja137() { return 1.0; }
public static double funkcja130() { if( ( funkcja131() == funkcja137() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja138() { return 0.0; }
public static double funkcja129() { if( ( (funkcja130() != 0.0) || (funkcja138() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja127() { if( ( (funkcja128() != 0.0) || (funkcja129() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja125() { if( ( (funkcja126() != 0.0) || (funkcja127() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja110() { return funkcja111() + funkcja125(); } 
public static double funkcja80() { return funkcja81() + funkcja110(); } 
public static double funkcja139() { return 4.0; }
public static double funkcja78() { if( ( funkcja79() == funkcja139() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja140() { return 1.0; }
public static double funkcja77() { if( ( funkcja78() == funkcja140() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja75() { if( ( funkcja76() < funkcja77() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja8() { if( ( funkcja9() <= funkcja75() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja142() { return 0.0; }
public static double funkcja145() { double nowaWartosc = funkcja146(); ZmienneGlobalne.put("y", nowaWartosc); return nowaWartosc; }
public static double funkcja149() { return 0.0; }
public static double funkcja151() { return 0.0; }
public static double funkcja156() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja157() { double nowaWartosc = funkcja158(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja158() { return 5.0; }
public static double funkcja155() { funkcja156(); return funkcja157(); } 
public static double funkcja159() { return 4.5; }
public static double funkcja154() { if( ( funkcja155() > funkcja159() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja160() { return 1.0; }
public static double funkcja153() { if( ( funkcja154() == funkcja160() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja161() { return 0.0; }
public static double funkcja152() { if( ( (funkcja153() != 0.0) || (funkcja161() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja150() { if( ( (funkcja151() != 0.0) || (funkcja152() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja148() { if( ( (funkcja149() != 0.0) || (funkcja150() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja163() { return 0.0; }
public static double funkcja165() { return 0.0; }
public static double funkcja170() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja171() { double nowaWartosc = funkcja172(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja172() { return 5.0; }
public static double funkcja169() { funkcja170(); return funkcja171(); } 
public static double funkcja173() { return 4.5; }
public static double funkcja168() { if( ( funkcja169() > funkcja173() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja174() { return 1.0; }
public static double funkcja167() { if( ( funkcja168() == funkcja174() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja175() { return 0.0; }
public static double funkcja166() { if( ( (funkcja167() != 0.0) || (funkcja175() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja164() { if( ( (funkcja165() != 0.0) || (funkcja166() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja162() { if( ( (funkcja163() != 0.0) || (funkcja164() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja147() { return funkcja148() + funkcja162(); } 
public static double funkcja178() { return 0.0; }
public static double funkcja180() { return 0.0; }
public static double funkcja185() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja186() { double nowaWartosc = funkcja187(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja187() { return 5.0; }
public static double funkcja184() { funkcja185(); return funkcja186(); } 
public static double funkcja188() { return 4.5; }
public static double funkcja183() { if( ( funkcja184() > funkcja188() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja189() { return 1.0; }
public static double funkcja182() { if( ( funkcja183() == funkcja189() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja190() { return 0.0; }
public static double funkcja181() { if( ( (funkcja182() != 0.0) || (funkcja190() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja179() { if( ( (funkcja180() != 0.0) || (funkcja181() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja177() { if( ( (funkcja178() != 0.0) || (funkcja179() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja192() { return 0.0; }
public static double funkcja194() { return 0.0; }
public static double funkcja199() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja200() { double nowaWartosc = funkcja201(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja201() { return 5.0; }
public static double funkcja198() { funkcja199(); return funkcja200(); } 
public static double funkcja202() { return 4.5; }
public static double funkcja197() { if( ( funkcja198() > funkcja202() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja203() { return 1.0; }
public static double funkcja196() { if( ( funkcja197() == funkcja203() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja204() { return 0.0; }
public static double funkcja195() { if( ( (funkcja196() != 0.0) || (funkcja204() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja193() { if( ( (funkcja194() != 0.0) || (funkcja195() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja191() { if( ( (funkcja192() != 0.0) || (funkcja193() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja176() { return funkcja177() + funkcja191(); } 
public static double funkcja146() { return funkcja147() + funkcja176(); } 
public static double funkcja205() { return 4.0; }
public static double funkcja144() { if( ( funkcja145() == funkcja205() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja206() { return 1.0; }
public static double funkcja143() { if( ( funkcja144() == funkcja206() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja141() { if( ( funkcja142() < funkcja143() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja7() { if( ( funkcja8() >= funkcja141() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja207() { return 12.0; }
public static double funkcja6() { return funkcja7() * funkcja207(); } 
public static double funkcja208() { return 4.0; }
public static double funkcja5() { return funkcja6() / funkcja208(); } 
public static double funkcja209() { return 3.0; }
public static double funkcja4() { if( ( funkcja5() == funkcja209() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja210() { return 0.5; }
public static double funkcja3() { return funkcja4() / funkcja210(); } 
public static double funkcja211() { return 2.0; }
public static double funkcja2() { if( ( funkcja3() == funkcja211() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja221() { return 0.0; }
public static double funkcja224() { double nowaWartosc = funkcja225(); ZmienneGlobalne.put("y", nowaWartosc); return nowaWartosc; }
public static double funkcja228() { return 0.0; }
public static double funkcja230() { return 0.0; }
public static double funkcja235() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja236() { double nowaWartosc = funkcja237(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja237() { return 5.0; }
public static double funkcja234() { funkcja235(); return funkcja236(); } 
public static double funkcja238() { return 4.5; }
public static double funkcja233() { if( ( funkcja234() > funkcja238() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja239() { return 1.0; }
public static double funkcja232() { if( ( funkcja233() == funkcja239() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja240() { return 0.0; }
public static double funkcja231() { if( ( (funkcja232() != 0.0) || (funkcja240() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja229() { if( ( (funkcja230() != 0.0) || (funkcja231() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja227() { if( ( (funkcja228() != 0.0) || (funkcja229() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja242() { return 0.0; }
public static double funkcja244() { return 0.0; }
public static double funkcja249() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja250() { double nowaWartosc = funkcja251(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja251() { return 5.0; }
public static double funkcja248() { funkcja249(); return funkcja250(); } 
public static double funkcja252() { return 4.5; }
public static double funkcja247() { if( ( funkcja248() > funkcja252() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja253() { return 1.0; }
public static double funkcja246() { if( ( funkcja247() == funkcja253() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja254() { return 0.0; }
public static double funkcja245() { if( ( (funkcja246() != 0.0) || (funkcja254() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja243() { if( ( (funkcja244() != 0.0) || (funkcja245() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja241() { if( ( (funkcja242() != 0.0) || (funkcja243() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja226() { return funkcja227() + funkcja241(); } 
public static double funkcja257() { return 0.0; }
public static double funkcja259() { return 0.0; }
public static double funkcja264() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja265() { double nowaWartosc = funkcja266(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja266() { return 5.0; }
public static double funkcja263() { funkcja264(); return funkcja265(); } 
public static double funkcja267() { return 4.5; }
public static double funkcja262() { if( ( funkcja263() > funkcja267() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja268() { return 1.0; }
public static double funkcja261() { if( ( funkcja262() == funkcja268() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja269() { return 0.0; }
public static double funkcja260() { if( ( (funkcja261() != 0.0) || (funkcja269() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja258() { if( ( (funkcja259() != 0.0) || (funkcja260() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja256() { if( ( (funkcja257() != 0.0) || (funkcja258() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja271() { return 0.0; }
public static double funkcja273() { return 0.0; }
public static double funkcja278() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja279() { double nowaWartosc = funkcja280(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja280() { return 5.0; }
public static double funkcja277() { funkcja278(); return funkcja279(); } 
public static double funkcja281() { return 4.5; }
public static double funkcja276() { if( ( funkcja277() > funkcja281() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja282() { return 1.0; }
public static double funkcja275() { if( ( funkcja276() == funkcja282() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja283() { return 0.0; }
public static double funkcja274() { if( ( (funkcja275() != 0.0) || (funkcja283() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja272() { if( ( (funkcja273() != 0.0) || (funkcja274() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja270() { if( ( (funkcja271() != 0.0) || (funkcja272() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja255() { return funkcja256() + funkcja270(); } 
public static double funkcja225() { return funkcja226() + funkcja255(); } 
public static double funkcja284() { return 4.0; }
public static double funkcja223() { if( ( funkcja224() == funkcja284() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja285() { return 1.0; }
public static double funkcja222() { if( ( funkcja223() == funkcja285() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja220() { if( ( funkcja221() < funkcja222() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja287() { return 0.0; }
public static double funkcja290() { double nowaWartosc = funkcja291(); ZmienneGlobalne.put("y", nowaWartosc); return nowaWartosc; }
public static double funkcja294() { return 0.0; }
public static double funkcja296() { return 0.0; }
public static double funkcja301() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja302() { double nowaWartosc = funkcja303(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja303() { return 5.0; }
public static double funkcja300() { funkcja301(); return funkcja302(); } 
public static double funkcja304() { return 4.5; }
public static double funkcja299() { if( ( funkcja300() > funkcja304() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja305() { return 1.0; }
public static double funkcja298() { if( ( funkcja299() == funkcja305() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja306() { return 0.0; }
public static double funkcja297() { if( ( (funkcja298() != 0.0) || (funkcja306() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja295() { if( ( (funkcja296() != 0.0) || (funkcja297() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja293() { if( ( (funkcja294() != 0.0) || (funkcja295() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja308() { return 0.0; }
public static double funkcja310() { return 0.0; }
public static double funkcja315() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja316() { double nowaWartosc = funkcja317(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja317() { return 5.0; }
public static double funkcja314() { funkcja315(); return funkcja316(); } 
public static double funkcja318() { return 4.5; }
public static double funkcja313() { if( ( funkcja314() > funkcja318() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja319() { return 1.0; }
public static double funkcja312() { if( ( funkcja313() == funkcja319() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja320() { return 0.0; }
public static double funkcja311() { if( ( (funkcja312() != 0.0) || (funkcja320() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja309() { if( ( (funkcja310() != 0.0) || (funkcja311() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja307() { if( ( (funkcja308() != 0.0) || (funkcja309() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja292() { return funkcja293() + funkcja307(); } 
public static double funkcja323() { return 0.0; }
public static double funkcja325() { return 0.0; }
public static double funkcja330() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja331() { double nowaWartosc = funkcja332(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja332() { return 5.0; }
public static double funkcja329() { funkcja330(); return funkcja331(); } 
public static double funkcja333() { return 4.5; }
public static double funkcja328() { if( ( funkcja329() > funkcja333() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja334() { return 1.0; }
public static double funkcja327() { if( ( funkcja328() == funkcja334() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja335() { return 0.0; }
public static double funkcja326() { if( ( (funkcja327() != 0.0) || (funkcja335() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja324() { if( ( (funkcja325() != 0.0) || (funkcja326() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja322() { if( ( (funkcja323() != 0.0) || (funkcja324() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja337() { return 0.0; }
public static double funkcja339() { return 0.0; }
public static double funkcja344() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja345() { double nowaWartosc = funkcja346(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja346() { return 5.0; }
public static double funkcja343() { funkcja344(); return funkcja345(); } 
public static double funkcja347() { return 4.5; }
public static double funkcja342() { if( ( funkcja343() > funkcja347() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja348() { return 1.0; }
public static double funkcja341() { if( ( funkcja342() == funkcja348() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja349() { return 0.0; }
public static double funkcja340() { if( ( (funkcja341() != 0.0) || (funkcja349() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja338() { if( ( (funkcja339() != 0.0) || (funkcja340() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja336() { if( ( (funkcja337() != 0.0) || (funkcja338() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja321() { return funkcja322() + funkcja336(); } 
public static double funkcja291() { return funkcja292() + funkcja321(); } 
public static double funkcja350() { return 4.0; }
public static double funkcja289() { if( ( funkcja290() == funkcja350() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja351() { return 1.0; }
public static double funkcja288() { if( ( funkcja289() == funkcja351() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja286() { if( ( funkcja287() < funkcja288() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja219() { if( ( funkcja220() <= funkcja286() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja353() { return 0.0; }
public static double funkcja356() { double nowaWartosc = funkcja357(); ZmienneGlobalne.put("y", nowaWartosc); return nowaWartosc; }
public static double funkcja360() { return 0.0; }
public static double funkcja362() { return 0.0; }
public static double funkcja367() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja368() { double nowaWartosc = funkcja369(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja369() { return 5.0; }
public static double funkcja366() { funkcja367(); return funkcja368(); } 
public static double funkcja370() { return 4.5; }
public static double funkcja365() { if( ( funkcja366() > funkcja370() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja371() { return 1.0; }
public static double funkcja364() { if( ( funkcja365() == funkcja371() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja372() { return 0.0; }
public static double funkcja363() { if( ( (funkcja364() != 0.0) || (funkcja372() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja361() { if( ( (funkcja362() != 0.0) || (funkcja363() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja359() { if( ( (funkcja360() != 0.0) || (funkcja361() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja374() { return 0.0; }
public static double funkcja376() { return 0.0; }
public static double funkcja381() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja382() { double nowaWartosc = funkcja383(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja383() { return 5.0; }
public static double funkcja380() { funkcja381(); return funkcja382(); } 
public static double funkcja384() { return 4.5; }
public static double funkcja379() { if( ( funkcja380() > funkcja384() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja385() { return 1.0; }
public static double funkcja378() { if( ( funkcja379() == funkcja385() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja386() { return 0.0; }
public static double funkcja377() { if( ( (funkcja378() != 0.0) || (funkcja386() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja375() { if( ( (funkcja376() != 0.0) || (funkcja377() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja373() { if( ( (funkcja374() != 0.0) || (funkcja375() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja358() { return funkcja359() + funkcja373(); } 
public static double funkcja389() { return 0.0; }
public static double funkcja391() { return 0.0; }
public static double funkcja396() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja397() { double nowaWartosc = funkcja398(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja398() { return 5.0; }
public static double funkcja395() { funkcja396(); return funkcja397(); } 
public static double funkcja399() { return 4.5; }
public static double funkcja394() { if( ( funkcja395() > funkcja399() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja400() { return 1.0; }
public static double funkcja393() { if( ( funkcja394() == funkcja400() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja401() { return 0.0; }
public static double funkcja392() { if( ( (funkcja393() != 0.0) || (funkcja401() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja390() { if( ( (funkcja391() != 0.0) || (funkcja392() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja388() { if( ( (funkcja389() != 0.0) || (funkcja390() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja403() { return 0.0; }
public static double funkcja405() { return 0.0; }
public static double funkcja410() { return ZmienneGlobalne.getOrDefault( "x", 0.0); }
public static double funkcja411() { double nowaWartosc = funkcja412(); ZmienneGlobalne.put("x", nowaWartosc); return nowaWartosc; }
public static double funkcja412() { return 5.0; }
public static double funkcja409() { funkcja410(); return funkcja411(); } 
public static double funkcja413() { return 4.5; }
public static double funkcja408() { if( ( funkcja409() > funkcja413() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja414() { return 1.0; }
public static double funkcja407() { if( ( funkcja408() == funkcja414() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja415() { return 0.0; }
public static double funkcja406() { if( ( (funkcja407() != 0.0) || (funkcja415() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja404() { if( ( (funkcja405() != 0.0) || (funkcja406() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja402() { if( ( (funkcja403() != 0.0) || (funkcja404() != 0.0) )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja387() { return funkcja388() + funkcja402(); } 
public static double funkcja357() { return funkcja358() + funkcja387(); } 
public static double funkcja416() { return 4.0; }
public static double funkcja355() { if( ( funkcja356() == funkcja416() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja417() { return 1.0; }
public static double funkcja354() { if( ( funkcja355() == funkcja417() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja352() { if( ( funkcja353() < funkcja354() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja218() { if( ( funkcja219() >= funkcja352() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja418() { return 12.0; }
public static double funkcja217() { return funkcja218() * funkcja418(); } 
public static double funkcja419() { return 4.0; }
public static double funkcja216() { return funkcja217() / funkcja419(); } 
public static double funkcja420() { return 3.0; }
public static double funkcja215() { if( ( funkcja216() == funkcja420() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja421() { return 0.5; }
public static double funkcja214() { return funkcja215() / funkcja421(); } 
public static double funkcja422() { return 2.0; }
public static double funkcja213() { if( ( funkcja214() == funkcja422() )) { return 1.0; }  else {  return 0.0; } }
public static double funkcja212() { return funkcja213(); } 
public static double funkcja424() { return 5.0; }
public static double funkcja423() { return funkcja424(); } 
public static double funkcja1() { if( funkcja2() != 0.0) { return funkcja212(); } else { return funkcja423(); } }
public static void main(String[] args) {
      System.out.println( funkcja1() );
} 
}