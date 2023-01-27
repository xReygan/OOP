import java.util.ArrayList;

public class Monk extends BaseHero {

    int magic;

    public Monk(String name, int attack, int protection, int[] damage, int health, int speed, int x, int y, int magic) {
        super(name, attack, protection, damage, health, speed, x, y);

        this.magic = magic;
        super.position = new Vector2(x, y);
    }

    public Monk(String name, int x, int y) {
        super(name, 12, 7, new int[] {-4, -4}, 30, 5, x, y);
        this.magic = 16;
    }

    @Override
    public String toString() {
    return super.toString() + ", Magic: " + magic; 
    }

    @Override
    public void step(ArrayList<BaseHero> team) {
        int min = 0;
        String[] info = team.get(min).getInfo().split(" ");
        int tmp = Integer.parseInt(info[2]) * 100 / Integer.parseInt(info[1]);    
        for (int i = 0; i < team.size(); i ++) {    
            info = team.get(i).getInfo().split(" ");            
            if (tmp > Integer.parseInt(info[2]) * 100 / Integer.parseInt(info[1])) {
                min = i;
                tmp = Integer.parseInt(info[2]) * 100 / Integer.parseInt(info[1]);
            }
        }
        // System.out.println("Самый поврежденный юнит: ");
        // System.out.println(team.get(min));
        if (team.get(min).health - damage[1] > team.get(min).maxHealth) {
            team.get(min).health = team.get(min).maxHealth;
        } else {
            team.get(min).health = team.get(min).health - damage[1];
        }
        System.out.println("Был пролечен: +++ " + team.get(min));
    }
}
