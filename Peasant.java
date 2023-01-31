import java.util.ArrayList;

public class Peasant extends BaseHero {

    int delivery;

    public Peasant(String name, int attack, int protection, int[] damage, int health, int speed, int x, int y, int delivery) {
        super(name, attack, protection, damage, health, speed, x, y);
        
        this.delivery = delivery;
        super.position = new Vector2(x, y);
    }

    public Peasant(String name, int x, int y) {
        super(name, 1, 1, new int[] {1, 1}, 1, 3, x, y);
        this.delivery = 1;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }
    
    public int getDelivery() {
        return delivery;
    }

    @Override
    public String toString() {
    return super.toString() + ", Delivery: " + delivery; 
    }

    @Override
    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> anyTeam) {
        if (this.health == 0) {
            return;
        }                
        if (this.delivery <= 0) {
            this.delivery = 1;
            System.out.println("У Крестьянина была реактивирована доставка стрел: o^-o ");
        }        
    }
}
