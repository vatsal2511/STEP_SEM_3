package STEP_SEM_3.Week_7_Assignment;

// Domain Class
class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        this.health = Math.max(0, this.health - amount);
    }

    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        this.health = Math.min(this.maxHealth, this.health + amount);
    }
}

// Main Driver Class
public class CharacterApp {
    public static void main(String[] args) {
        Character c = new Character(100);
        
        c.takeDamage(30);
        System.out.println("Health after 30 damage: " + c.getHealth());

        c.heal(50);
        System.out.println("Health after 50 heal (capped): " + c.getHealth());

        c.takeDamage(150);
        System.out.println("Health after 150 damage (floored): " + c.getHealth());
    }
}
