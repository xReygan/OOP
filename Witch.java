import java.util.ArrayList;
import java.util.Random;

public class Witch extends BaseHero {

    int magic;

    public Witch(String name, int attack, int protection, int[] damage, int health, int speed, int x, int y, int magic) {
        super(name, attack, protection, damage, health, speed, x, y);
        
        this.magic = magic;
        super.position = new Vector2(x, y);
    }

    public Witch(String name, int x, int y) {
        super(name, 17, 12, new int[] {-5, -5}, 30, 9, x, y);
        this.magic = 1;
    }

    @Override
    public String toString() {
    return super.toString() + ", Magic: " + magic; 
    }

    @Override
    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> anyTeam) {
        if (this.health == 0) {
            return;
        }
        if (this.magic == 0) {
            this.magic = 1;
            return;
        }
        int min = 0;
        String[] info = team.get(min).getInfo().split(" ");
        int tmp = Integer.parseInt(info[2]) * 100 / Integer.parseInt(info[1]);    
        for (int i = 0; i < team.size(); i ++) { 
            if (team.get(i).health == 0) {
                if (this.magic > 0) {
                    this.magic = 0;
                    int x = team.get(i).getPosition().x;
                    int y = team.get(i).getPosition().y;
                    team.remove(i);
                    switch (new Random().nextInt(4)) {
                        case 0:
                        team.add(i, new Peasant("Peasant", x, y));
                            break;
                        case 1:
                        team.add(i, new Spearman("Spearman", x, y));
                            break;
                        case 2:
                        team.add(i, new Crossbowman("Crossbowman", x, y));
                            break;
                        default:
                        team.add(i, new Witch("Witch", x, y));
                            break;
                    }
                    System.out.println("Возродился: " + team.get(i));
                } else {
                   break; 
                }
                


            }   
            info = team.get(i).getInfo().split(" ");            
            if (tmp > Integer.parseInt(info[2]) * 100 / Integer.parseInt(info[1])) {
                min = i;
                tmp = Integer.parseInt(info[2]) * 100 / Integer.parseInt(info[1]);
            }
        }
        // System.out.println("Самый поврежденный юнит: ");
        // System.out.println(team.get(min));
        if (min == 0) return;
        if (team.get(min).health - damage[1] > team.get(min).maxHealth) {
            team.get(min).health = team.get(min).maxHealth;
        } else {
            team.get(min).health = team.get(min).health - damage[1];
        }
        System.out.println("Был пролечен: +++ " + team.get(min));
    }
}
