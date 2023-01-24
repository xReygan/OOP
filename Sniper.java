import java.util.ArrayList;

public class Sniper extends BaseHero {

    int shots;
    int maxShots;

    public Sniper(String name, int attack, int protection, int[] damage, int health, int speed, int shots) {
        super(name, attack, protection, damage, health, speed);
        
        this.shots = shots;
        this.maxShots = shots;
    }

    public Sniper(String name) {
        super(name, 12, 10, new int[] {8, 10}, 15, 9);
        this.shots = 32;
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
