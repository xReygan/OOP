//import chars.HeroTeam;
//import chars.Vector2;
import java.util.Collections;

public class ConsoleView {
    public static int step = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(Task7.GANG_SIZE-1, formatDiv("-b"))) + formatDiv("-c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(Task7.GANG_SIZE-1, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(Task7.GANG_SIZE-1, formatDiv("-h"))) + formatDiv("-i");

    public static void view(){
        if (step++ == 0) {
            System.out.print(AnsiColors.ANSI_RED+"First step!"+AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(Task7.GANG_SIZE*2, formatDiv(" "))) + "Dark Side" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(Task7.GANG_SIZE*6, formatDiv(" "))) + "White Side" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step: "+step+AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(Task7.GANG_SIZE*2, formatDiv(" "))) + "Dark Side" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(Task7.GANG_SIZE*6, formatDiv(" "))) + "White Side" + AnsiColors.ANSI_RESET);
        }

        System.out.println(ConsoleView.top10);

        int npcIndex = 0;

        for (int j = 1; j <= Task7.GANG_SIZE - 1; j ++) {
            for (int i = 1; i <= Task7.GANG_SIZE; i ++) {
                System.out.print(getChar(new Vector2(i, j)));
            }
            System.out.print("|");
            System.out.println(PrintInfo(npcIndex));
            System.out.println(ConsoleView.mid10);
            npcIndex++;
        }

        for (int j = 1; j <= Task7.GANG_SIZE; j++) {
            System.out.print(getChar(new Vector2(j, Task7.GANG_SIZE)));
        }
        System.out.print("|");
        System.out.println(PrintInfo(npcIndex));
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(Vector2 position){

        String str = "| ";
        boolean alive = false;
        for (int i = 0; i < Task7.GANG_SIZE; i++) {
            if (Task7.whiteSide.get(i).getPosition().isEquals(position))
            {
                if(Task7.whiteSide.get(i).getName().equals("XDead"))
                    str ="|"+AnsiColors.ANSI_RED+Task7.whiteSide.get(i).getName().toUpperCase().charAt(0)+AnsiColors.ANSI_RESET;
                else {
                    str ="|"+AnsiColors.ANSI_GREEN+Task7.whiteSide.get(i).getName().toUpperCase().charAt(0)+AnsiColors.ANSI_RESET;
                    alive = true;
                }
            }
            if (Task7.darkSide.get(i).getPosition().isEquals(position) && !alive)
            {
                if(Task7.darkSide.get(i).getName().equals("XDead"))
                    str ="|"+AnsiColors.ANSI_RED+ Task7.darkSide.get(i).getName().toUpperCase().charAt(0)+AnsiColors.ANSI_RESET;
                else str ="|"+AnsiColors.ANSI_BLUE+ Task7.darkSide.get(i).getName().toUpperCase().charAt(0)+AnsiColors.ANSI_RESET;
            }
        }
        return str;
    }

    private static String PrintInfo(int npcIndex)
    {
        String str = "";

        if(Task7.darkSide.get(npcIndex).getName().equals("XDead"))
            str +="     " + AnsiColors.ANSI_RED+Task7.darkSide.get(npcIndex).getInfo2()+AnsiColors.ANSI_RESET;
        else str +="     " + AnsiColors.ANSI_BLUE+Task7.darkSide.get(npcIndex).getInfo2()+AnsiColors.ANSI_RESET;
        if(Task7.whiteSide.get(npcIndex).getName().equals("XDead"))
            str +="     " + AnsiColors.ANSI_RED+Task7.whiteSide.get(npcIndex).getInfo2()+AnsiColors.ANSI_RESET;
        else str +="     " + AnsiColors.ANSI_GREEN+Task7.whiteSide.get(npcIndex).getInfo2()+AnsiColors.ANSI_RESET;

        return str;
    }

    private static String formatDiv(String str){
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500')
                .replace("s", "...")
                .replace("o", "___");
    }
}
