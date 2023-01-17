//Разработать иерархию классов персонажей описанных в таблице.
//Провести анализ(абстракция) полей необходимых данных и перенести обьщие в базовый класс.
//Так же в базовом классе переопределить метод toString для вывода подробной информации о персонаже.
//Описать удобный конструктор базового класса и классов наследников так,
//чтобы необходимые параметры передавались вызовом пустого конструктора класса наследника.
//В основном классе создать список и заполнить его экземплярами каждого нового класса.
//Вывести в консоль содержание списка переопределённым иетодом toString().
//*Создать список из 50 персонажей выбранных случайным числом и статический метод выбирающий из списка
//только элементы конкретного, переданного в параметре класса и выводящий их описание в консоль!

import java.util.ArrayList;
import java.util.Random;

public class Task {
    public static void main(String[] args) {
        ArrayList<BaseHero> commonlist = new ArrayList<>();
        commonlist.add(new Peasant("Peasant"));
        commonlist.add(new Rogue("Rogue"));
        commonlist.add(new Sniper("Sniper"));
        commonlist.add(new Witch("Witch"));
        commonlist.add(new Spearman("Spearman"));
        commonlist.add(new Crossbowman("Crossbowman"));
        commonlist.add(new Monk("Monk"));
        System.out.println("Список из экземпляров каждого класса: ");
        for (BaseHero item : commonlist) {
            System.out.println(item);
        }
        System.out.println("--------------------------------");

        ArrayList<BaseHero> general = new ArrayList<>();
        String[] name = {"Peasant", "Rogue", "Sniper", "Witch", "Spearman", "Crossbowman", "Monk"};
        Random rnd = new Random();
        for (int i = 0; i < 50; i++) {
            int r = rnd.nextInt(0, 7);           
            switch (r) {
                case 0:
                    general.add(new Peasant(name[r]));
                    break;
                case 1:
                    general.add(new Rogue(name[r]));
                    break;
                case 2:
                    general.add(new Sniper(name[r]));
                    break;
                case 3:
                    general.add(new Witch(name[r]));
                    break;
                case 4:
                    general.add(new Spearman(name[r]));
                    break;
                case 5:
                    general.add(new Crossbowman(name[r]));
                    break;
                case 6:
                    general.add(new Monk(name[r]));
                    break;                         
            }
        }
        System.out.println("Общий список из 50 случайных экземпляров: ");
        for (BaseHero item : general) {
            System.out.println(item);
        }
        System.out.println("--------------------------------");

        sample("Peasant", general);
        sample("Rogue", general);
        sample("Sniper", general);
        sample("Witch", general);
        sample("Spearman", general);
        sample("Crossbowman", general);
        sample("Monk", general);    
    } 


    public static void sample(String name, ArrayList<BaseHero> general) {
        System.out.println("Выборка экземпляров класса " + name + ": ");
        for (BaseHero obj : general) {
            if (obj.getClass().getName().equals(name)) {
                System.out.println(obj);
            }
        }
        System.out.println("--------------------------------");
    }
}
