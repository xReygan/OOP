//import java.util.Collection;
import java.util.Collections;
//import java.util.Locale;

public class ConsoleView {

    private static int step = 1;
    //----------------РѕС‚СЂРёСЃРѕРІРєР° СЃС‚СЂРѕС‡РµРє РїСЃРµРІРґРѕРіСЂР°С„РёРєРё С‚Р°Р±Р»РёС†С‹ ---------РЅР°С‡Р°Р»Рѕ ----------------
    private static final String top10 = formateDiv("a") + String.join("",
            Collections.nCopies(Task5.GANG_SIZE - 1,formateDiv("-b"))) + formateDiv("-c");
    private static final String mid10 = formateDiv("d") + String.join("",
            Collections.nCopies(Task5.GANG_SIZE - 1,formateDiv("-e"))) + formateDiv("-f");
    private static final String bott10 = formateDiv("g") + String.join("",
            Collections.nCopies(Task5.GANG_SIZE - 1,formateDiv("-h"))) + formateDiv("-i");

    //----------------РѕС‚СЂРёСЃРѕРІРєР° СЃС‚СЂРѕС‡РµРє РїСЃРµРІРґРѕРіСЂР°С„РёРєРё С‚Р°Р±Р»РёС†С‹ --------РєРѕРЅРµС†-----------------
    public static void view(){

        if (ConsoleView.step == 1 ){
            System.out.println("First step");
        } else {
            System.out.println("Step " + step + ".");
        }
        step++;

        System.out.println(ConsoleView.top10);

        for (int i = 1; i <= Task5.GANG_SIZE - 1; i++) {
            for (int j = 1; j <= Task5.GANG_SIZE; j++) {
                System.out.print(getHeroChar(new Vector2(j,i)));
            }
//            System.out.println("|");
            System.out.println();
//            System.out.println(Main.darkSide.get(i).getInfo());
            System.out.println(ConsoleView.mid10);
        }
        for (int j = 1; j <= Task5.GANG_SIZE; j++) {
            System.out.print(getHeroChar(new Vector2(j,Task5.GANG_SIZE)));
        }
//        System.out.println("|");
        System.out.println();
        System.out.println(ConsoleView.bott10);
        System.out.println("Press Enter");


    }

    private static String formateDiv(String str){
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getHeroChar(Vector2 position){
        String str = "| ";
        for (int i = 0; i < Task5.GANG_SIZE; i++) {
            if (Task5.darkSide.get(i).getPosition().isEquals(position)) {
                str = "|" + Task5.darkSide.get(i).getName().toUpperCase().charAt(0) + "|"
                        + " ".repeat(3) + Task5.whiteSide.get(i).getInfo2() 
                        + " ".repeat(3) + "\t\t\b" + Task5.darkSide.get(i).getInfo2();
            }

            if (Task5.whiteSide.get(i).getPosition().isEquals(position)){
                str = "|" + Task5.whiteSide.get(i).getName().toUpperCase().charAt(0);
            }
        }
        return str;
    }
}
