public class Spearman extends BaseHero {

    public Spearman(String name, int attack, int protection, int[] damage, int health, int speed, int x, int y) {
        super(name, attack, protection, damage, health, speed, x, y);
        super.position = new Vector2(x, y);
    }

    public Spearman(String name, int x, int y) {
        super(name, 4, 5, new int[] {1, 3}, 10, 4, x, y);
    }
}
