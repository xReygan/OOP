import java.util.Arrays;

public class BaseHero {
    String name;
    int attack, protection, health, speed;
    int[] damage;

public BaseHero(String name, int attack, int protection, int[] damage, int health, int speed) {
    this.name = name;
    this.attack = attack;
    this.protection = protection;
    this.damage = damage;
    this.health = health;
    this.speed = speed;
}
@Override
public String toString() {
    return "Name: " + name + ", Attack: " + attack + ", Protection: " + protection + ", Damage: " + Arrays.toString(damage) + ", Health: " + health + ", Speed: " + speed; 
}

}