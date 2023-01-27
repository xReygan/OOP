import java.util.ArrayList;

public class Crossbowman extends BaseHero {

    int shots;
    int maxShots;

    public Crossbowman(String name, int attack, int protection, int[] damage, int health, int speed, int x, int y, int shots) {
        super(name, attack, protection, damage, health, speed, x, y);

        this.shots = shots;
        this.maxShots = shots;
        super.position = new Vector2(x, y);
    }

    public Crossbowman(String name, int x, int y) {
        super(name, 6, 3, new int[] {2, 3}, 10, 4, x, y);
        this.shots = 16;
    }

    @Override
    public String toString() {
    return super.toString() + ", Shots: " + shots; 
    }

    @Override
    public void step(ArrayList<BaseHero> team) {
        if (this.shots > 0) {
            this.shots = this.shots - 1;
            System.out.println("Мощный выстрел и стрела ушла во врага: ---> ");
        }           
        for (int i = 0; i < team.size(); i ++) {                   
            if (team.get(i).getDelivery() > 0) {
                if (this.shots != this.maxShots ) {
                    this.shots = this.shots + 1;
                }
                team.get(i).setDelivery(0);
                System.out.println("Передача стрел от: <-- " + team.get(i));
                break;
            }
        }
    }
}
