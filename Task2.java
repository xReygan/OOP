//Добавить файл с описанием интерфейса. В котором описать два метода,
//void step(); и String getInfo(); Реализовать интерфейс в абстрактном классе.
//Создать два списка в классе main. В каждый из списков добавить по десять экземпляров наследников BaseHero.
//Крестьянин, Разбойник, Снайпер и Колдун могут быть в одном и
//Крестьянин, Копейщик, Арбалетчик и Монах в другой.
//Реализовать метод step() для магов таким образом, чтобы они могли лечить самого повреждённого из своих однополчан!)
//Удалить ненужные методы из абстрактного класса, если такие есть.


import java.util.ArrayList;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<BaseHero> teamOne = new ArrayList<>();
        ArrayList<BaseHero> teamTwo = new ArrayList<>();
        Random rnd = new Random();
        String[] nameOne = {"Peasant", "Rogue", "Sniper", "Witch"};
        String[] nameTwo = {"Peasant", "Spearman", "Crossbowman", "Monk"};
        for (int i = 0; i < 10; i++) {
            int r = rnd.nextInt(0, 4);
            switch (r) {
                case 0:
                    teamOne.add(new Peasant(nameOne[r]));
                    teamTwo.add(new Peasant(nameTwo[r]));
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
                    teamOne.add(new Witch(nameOne[r]));
                    teamTwo.add(new Monk(nameTwo[r]));
                break;
                }       
        }           
        System.out.println("Первая команда из 10 экземпляров (после случайных повреждений) + вывод getInfo под каждым: ");
        for (BaseHero item : teamOne) {
            System.out.println(item);
            System.out.println(item.getInfo());
        }
        System.out.println("--------------------------------");
        System.out.println("Вторая команда из 10 экземпляров (после случайных повреждений) + вывод getInfo под каждым: ");
        for (BaseHero item : teamTwo) {
            System.out.println(item);
            System.out.println(item.getInfo());
        }
        System.out.println("--------------------------------");
        
        System.out.println("Лечение бойцов Первой команды:");
        for (BaseHero item : teamOne) {
            item.step(teamOne);
        }
        System.out.println("--------------------------------");
        System.out.println("Лечение бойцов Второй команды:");
        for (BaseHero item : teamTwo) {
            item.step(teamTwo);
        }
    }  
}
