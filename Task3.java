// Проделать код ревью своих работ! Оптимизиривать интерфейс так, чтобы в клиент коде было видно только
// публичные поля. Добавить поведение (метод step) для лучников.
// 1.Если стрел больше нуля заглушка выстрел и уменьшение количества стрел
// 2.Проверить есть ли крестьяне и свободны ли хоть один из них. Если да, то вернуть одну стрелу и
// сбросить флаг свободен у крестьянина.
// 3.Крестьяне должны уметь поднимать свой статус "свободен"
// 4.Сделать так, чтобы по нажатию Enter программа повторяла вывод на экран состояние персонажей и
// вызов метода step.

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        ArrayList<BaseHero> teamOne = new ArrayList<>();
        ArrayList<BaseHero> peasantOne = new ArrayList<>();
        ArrayList<BaseHero> teamTwo = new ArrayList<>();
        ArrayList<BaseHero> peasantTwo = new ArrayList<>();
        Random rnd = new Random();
        String[] nameOne = {"Peasant", "Rogue", "Sniper", "Witch"};
        String[] nameTwo = {"Peasant", "Spearman", "Crossbowman", "Monk"};
        for (int i = 0; i < 10; i++) {
            int r = rnd.nextInt(0, 4);
            switch (r) {
                case 0:
                    peasantOne.add(new Peasant(nameOne[r]));
                    peasantTwo.add(new Peasant(nameTwo[r]));
                break;
                case 1:
                    teamOne.add(new Rogue(nameOne[r]));
                    teamTwo.add(new Spearman(nameTwo[r]));
                break;
                case 2:
                    teamOne.add(new Sniper(nameOne[r]));
                    teamTwo.add(new Crossbowman(nameTwo[r]));
                break;
                case 3:
                    teamOne.add(0, new Witch(nameOne[r]));
                    teamTwo.add(0, new Monk(nameTwo[r]));
                break;
                }       
        }
        teamOne.addAll(peasantOne);
        teamTwo.addAll(peasantTwo);

        System.out.println("Первая команда из 10 экземпляров (после случайных повреждений): ");
        for (BaseHero item : teamOne) {
            System.out.println(item);
        }
        System.out.println("--------------------------------");
        System.out.println("Вторая команда из 10 экземпляров (после случайных повреждений): ");
        for (BaseHero item : teamTwo) {
            System.out.println(item);
        }
        System.out.println("--------------------------------");
        
        Scanner in = new Scanner(System.in);
        int x = 0;
        System.out.println(" Нажмите 'ENTER' для хода или любой СИМВОЛ и 'ENTER' для выхода: ");
        while (in.nextLine().length() == 0) {
            x ++;
            System.out.println(x + " Ход бойцов Первой команды:");
            for (BaseHero item : teamOne) {
                item.step(teamOne);
            }
            System.out.println("--------------------------------");
            System.out.println(x + " Ход бойцов Второй команды:");
            for (BaseHero item : teamTwo) {
                item.step(teamTwo);
            }
            System.out.println("=====");
            System.out.println("Результат " + x + " хода Первой команды: ==========");
            for (BaseHero item : teamOne) {
                System.out.println(item);
            }
            System.out.println("--------------------------------");

            System.out.println("Результат " + x + " хода Второй команды: ==========");
            for (BaseHero item : teamTwo) {
                System.out.println(item);
            }
            System.out.println("--------------------------------");
            System.out.println(" Нажмите 'ENTER' для хода или любой СИМВОЛ и 'ENTER' для выхода: ");
        }
            in.close();
            System.out.println(" Завершение схватки...");
    }  
}
