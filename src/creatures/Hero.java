package creatures;

import java.time.temporal.ValueRange;

public class Hero extends Creature implements Healer {
    int healCharges = 4;

    protected Hero(int protect, int attack, int minDamage, int maxDamage, int maxHealthPoints) {
        super(protect, attack, minDamage, maxDamage, maxHealthPoints);
    }


    @Override
    public void heal() {
        int healPercent = 30;
        if(!canHeal()){
            return;
        }

        int heal = (getMaxHealthPoints() / 100) * healPercent;
        int newHealPoints = getHealthPoints() + heal;
        setHealthPoints(newHealPoints);
        healCharges--;
    }

    @Override
    public boolean canHeal() {
        return healCharges > 1 && getMaxHealthPoints() > getHealthPoints();
    }
}
