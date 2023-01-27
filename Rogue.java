public class Rogue extends BaseHero {

    public Rogue(String name, int attack, int protection, int[] damage, int health, int speed, int x, int y) {
        super(name, attack, protection, damage, health, speed, x, y);
        super.position = new Vector2(x, y);
    }
    
    public Rogue(String name, int x, int y) {
        super(name, 8, 3, new int[] {2, 4}, 10, 6, x, y);
    }
}
