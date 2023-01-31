import java.util.ArrayList;

public class Sniper extends BaseHero {

    int shots;
    int maxShots;

    public Sniper(String name, int attack, int protection, int[] damage, int health, int speed, int x, int y, int shots) {
        super(name, attack, protection, damage, health, speed, x, y);
        
        this.shots = shots;
        this.maxShots = shots;
        super.position = new Vector2(x, y);
    }

    public Sniper(String name, int x, int y) {
        super(name, 12, 10, new int[] {8, 10}, 15, 9, x, y);
        this.shots = 32;
    }
    
    @Override
    public String toString() {
    return super.toString() + ", Shots: " + shots; 
    }

    @Override
    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> anyTeam) {
        if (this.health == 0) {
            return;
        }
        if (this.shots > 0) {
            this.shots = this.shots - 1;
            int slaughter; // убой выстрела
            float distance;
            int minIndex = 0;
            float tmpDis = 2 * team.size();
            for (int i = 0; i < team.size(); i++) {
                if (this.health == 0) {
                    return;
                }
                float x = position.x; // Стрелок Свой
                float y = position.y;
                if (anyTeam.get(i).health != 0) {
                    distance = anyTeam.get(i).getPosition().getDistance(x, y);
                    if (tmpDis > distance) {
                        tmpDis = distance;
                        minIndex = i;
                    }
                }
            }
                if (tmpDis <= 4) {
                    slaughter = damage[1];
                } else if (tmpDis >= 12) {
                    slaughter = damage[0];
                } else {
                    slaughter = damage[0] + (damage[0] + damage[1])/2;
                }
                if (anyTeam.get(minIndex).health > 0) {
                    anyTeam.get(minIndex).setHealth(anyTeam.get(minIndex).health - slaughter);
                    if (anyTeam.get(minIndex).health <= 0) {
                        anyTeam.get(minIndex).setHealth(0);
                        anyTeam.get(minIndex).setName("XDead");
                    }
                }
            System.out.println("Мощный выстрел и стрела ушла во врага: ---> ");
        }
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getDelivery() > 0) {
                if (this.shots != this.maxShots) {
                    this.shots = this.shots + 1;
                }
                team.get(i).setDelivery(0);
                System.out.println("Передача стрел от: <-- " + team.get(i));
                break;
            }
        }
    }
}
