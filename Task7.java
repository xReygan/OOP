// Реализовать очерёдность ходов основываясь на скорости персонажа вне зависимости от комманды.
// Добавить магам возможность возрождать. Возрождённый персонаж может стать любым из доступных в
// комманде и займёт место убитого. После возрождения маг один ход пропускает.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Task7 {
    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseHero> whiteSide;
    public static ArrayList<BaseHero> darkSide;
    public static ArrayList<BaseHero> general;

    public static ArrayList<BaseHero> general2;

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        while (true){
            ConsoleView.view();
            for (int i = 0; i < GANG_SIZE * 2; i ++) {
                if (darkSide.contains(general.get(i))) {
                    System.out.println("Ход " + general.get(i).getName() + " Темных: ");
                    general.get(i).step(darkSide, whiteSide);                    
                } else {
                    System.out.println("Ход " + general.get(i).getName() + " Светлых: ");
                    general.get(i).step(whiteSide, darkSide);                   
                 }
            }
            scanner.nextLine();
        }
    }

    private static void init() {
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();
        general = new ArrayList<>();

        general2 = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    darkSide.add(new Peasant("Peasant", x, y++));
                    break;
                case 1:
                    darkSide.add(new Rogue("Rogue", x, y++));
                    break;
                case 2:
                    darkSide.add(new Sniper("Sniper", x, y++));
                    break;
                default:
                    darkSide.add(new Monk("Monk", x, y++));
                    break;
            }
        }
        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    whiteSide.add(new Peasant("Peasant", x, y++));
                    break;
                case 1:
                    whiteSide.add(new Spearman("Spearman", x, y++));
                    break;
                case 2:
                    whiteSide.add(new Crossbowman("Crossbowman", x, y++));
                    break;
                default:
                    whiteSide.add(new Witch("Witch", x, y++));
                    break;
            }
        }
        general.addAll(darkSide);
        general.addAll(whiteSide);
        Collections.shuffle(general);
        general.sort(Comparator.comparing(BaseHero::getSpeed, Comparator.reverseOrder()));
    }
}
