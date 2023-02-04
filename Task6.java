// Рефакторинг и\или оптимизация проекта предыдущего дз с учетом
// теоретических основ SOLID’а

//import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task6 {
    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseHero> whiteSide;
    public static ArrayList<BaseHero> darkSide;

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        while (true){
            ConsoleView.view();
            System.out.println("Ход Светлых: ");
            whiteSide.forEach(n -> n.step(whiteSide, darkSide));
            System.out.println("Ход Темных: ");
            darkSide.forEach(n -> n.step(darkSide, whiteSide));
            scanner.nextLine();
        }
    }

    
    private static void init() {
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0: darkSide.add(new Peasant("Peasant", x, y++)); break;
                case 1: darkSide.add(new Rogue("Rogue", x, y++)); break;
                case 2: darkSide.add(new Sniper("Sniper", x, y++)); break;
                default: darkSide.add(new Monk("Monk", x, y++)); break;
            }
        }
        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0: whiteSide.add(new Peasant("Peasant", x, y++)); break;
                case 1: whiteSide.add(new Spearman("Spearman", x, y++)); break;
                case 2: whiteSide.add(new Crossbowman("Crossbowman", x, y++)); break;
                default: whiteSide.add(new Witch("Witch", x, y++)); break;
            }
        }
    }
}
