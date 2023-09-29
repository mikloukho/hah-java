package creatures;

import helpers.Randomizer;

import java.time.temporal.ValueRange;

abstract public class Creature {
    private final int attack;
    private final int protect;
    private final int maxDamage;
    private final int minDamage;
    private int healthPoints;
    private final int maxHealthPoints;


    protected Creature(int protect, int attack,  int minDamage, int maxDamage, int maxHealthPoints) {
        this.attack = attack;
        this.protect = protect;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.healthPoints = this.maxHealthPoints = maxHealthPoints;
    }

    public void takeDamage(int damage) {
        var newHealthPoints = getHealthPoints() - damage;

        setHealthPoints(newHealthPoints);
    }

    public boolean isAlive() {
        return getHealthPoints() > 0;
    }

    public int getAttack() {
        return attack;
    }

    public int getProtect() {
        return protect;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int newHealthPoints) {
        this.healthPoints = Math.max(Math.min(newHealthPoints, getMaxHealthPoints()), 0);
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

}
