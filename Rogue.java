import java.util.ArrayList;

public class Rogue extends BaseHero {

    public Rogue(String name, int attack, int protection, int[] damage, int health, int speed, int x, int y) {
        super(name, attack, protection, damage, health, speed, x, y);
        super.position = new Vector2(x, y);
    }

    public Rogue(String name, int x, int y) {
        super(name, 8, 3, new int[] { 2, 4 }, 10, 6, x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> anyTeam) {
        if (this.health == 0) {
            return;
        }
        float px = position.x;
        float py = position.y;
        float distance;
        int minIndex = 0;
        float tmpDis = 2 * team.size();
        int slaughter = damage[1];
        for (int i = 0; i < team.size(); i++) {
            if (anyTeam.get(i).health != 0) {
                distance = anyTeam.get(i).getPosition().getDistance(px, py);
                if (tmpDis > distance) {
                    tmpDis = distance;
                    minIndex = i;
                }
            }
        }
        if (tmpDis == 2 * team.size()) return;
        if (tmpDis <= 1) {
            anyTeam.get(minIndex).setHealth(anyTeam.get(minIndex).health - slaughter);
            if (anyTeam.get(minIndex).health <= 0) {
                anyTeam.get(minIndex).setHealth(0);
                anyTeam.get(minIndex).setName("XDead");
            }
            System.out.println("Мощный удар поразил врага: ->> ");
        } else {
            if (px < anyTeam.get(minIndex).getPosition().x) {
                position.x = position.x + 1;
            } else if (px > anyTeam.get(minIndex).getPosition().x) {
                position.x = position.x - 1;
            }
            if (py < anyTeam.get(minIndex).getPosition().y) {
                position.y = position.y + 1;
            } else if (py > anyTeam.get(minIndex).getPosition().y) {
                position.y = position.y - 1;
            }
        }
    }
}
