public class Spearman extends BaseHero {

    public Spearman(String name, int attack, int protection, int[] damage, int health, int speed) {
        super(name, attack, protection, damage, health, speed);
    }

    public Spearman(String name) {
        super(name, 4, 5, new int[] {1, 3}, 10, 4);
    }
}
