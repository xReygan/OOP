public class Witch extends BaseHero {

    int magic;

    public Witch(String name, int attack, int protection, int[] damage, int health, int speed, int magic) {
        super(name, attack, protection, damage, health, speed);
        
        this.magic = magic;
    }

    public Witch(String name) {
        super(name, 17, 12, new int[] {-5, -5}, 30, 9);
        this.magic = 1;
    }

    @Override
    public String toString() {
    return super.toString() + ", Magic: " + magic; 
}
}
