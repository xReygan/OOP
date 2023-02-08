import java.util.ArrayList;
import java.util.Arrays;

public abstract class BaseHero implements Interface {
    String name;
    int attack, protection, health, maxHealth, speed;
    int[] damage;
    public int delivery;
    int x;
    int y;
    Vector2 position;

public BaseHero(String name, int attack, int protection, int[] damage, int health, int speed, int x, int y) {
    this.name = name;
    this.attack = attack;
    this.protection = protection;
    this.damage = damage;
    this.maxHealth = health;
    this.health = maxHealth;  // - new Random().nextInt(0, maxHealth);
    this.speed = speed;
    this.position = new Vector2(x, y);
}

@Override
public String toString() {
    return "Name: " + name + ", Attack: " + attack + ", Protection: " + protection + ", Damage: " + Arrays.toString(damage) + ", Health: " + health + ", Speed: " + speed + ", Deca:" + position.x + "|" + position.y; 
}

@Override
public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> anyTeam) {

}

@Override
public String getInfo() {
    return name + " " + String.valueOf(maxHealth) + " " + String.valueOf(health);
}

//@Override
public String getInfo2() {
    //String outStr = String.format("⚔ %d\t\uD83D\uDEE1 %d\t♥%.1f\t☠%d", attack, protection, health, (damage[0] + damage[1]) / 2, speed);
    String outStr = String.format("%s: Атака %s %s  Защита %s %s  Жизнь %s %s/%s  Урон %s %s/%s  %s|%s", name, (char)33, attack, (char)35, protection, (char)164, health, maxHealth, (char)37, damage[0], damage[1], position.x, position.y);
    return outStr;
}


public void setDelivery(int delivery) {
    this.delivery = delivery;
}
public int getDelivery() {
    return delivery;
}


public Vector2 getPosition() {
    return position;
}


public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}


public void setHealth(int health) {
    this.health = health;
}
public int getHealth() {
    return health;
}


public void setSpeed(int health) {
    this.health = speed;
}
public int getSpeed() {
    return speed;
}
}
