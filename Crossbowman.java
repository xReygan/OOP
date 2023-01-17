public class Crossbowman extends BaseHero {

    int shots;

    public Crossbowman(String name, int attack, int protection, int[] damage, int health, int speed, int shots) {
        super(name, attack, protection, damage, health, speed);

        this.shots = shots;
    }

    public Crossbowman(String name) {
        super(name, 6, 3, new int[] {2, 3}, 10, 4);
        this.shots = 16;
    }

    @Override
    public String toString() {
    return super.toString() + ", Shots: " + shots; 
}
}
