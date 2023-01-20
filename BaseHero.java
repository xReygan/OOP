import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BaseHero implements Interface {
    String name;
    int attack, protection, health, maxHealth, speed;
    int[] damage;

public BaseHero(String name, int attack, int protection, int[] damage, int health, int speed) {
    this.name = name;
    this.attack = attack;
    this.protection = protection;
    this.damage = damage;
    this.maxHealth = health;
    this.health = maxHealth - new Random().nextInt(0, maxHealth);
    this.speed = speed;
}

@Override
public String toString() {
    return "Name: " + name + ", Attack: " + attack + ", Protection: " + protection + ", Damage: " + Arrays.toString(damage) + ", Health: " + health + ", Speed: " + speed; 
}

@Override
public void step(ArrayList<BaseHero> team) {

}

@Override
public String getInfo() {
    return name + " " + String.valueOf(maxHealth) + " " + String.valueOf(health);
}
}
