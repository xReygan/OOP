public class Peasant extends BaseHero {

    int delivery;

    public Peasant(String name, int attack, int protection, int[] damage, int health, int speed, int delivery) {
        super(name, attack, protection, damage, health, speed);
        
        this.delivery = delivery;
    }

    public Peasant(String name) {
        super(name, 1, 1, new int[] {1, 1}, 1, 3);
        this.delivery = 1;
    }

    @Override
    public String toString() {
    return super.toString() + ", Delivery: " + delivery; 
}
}
