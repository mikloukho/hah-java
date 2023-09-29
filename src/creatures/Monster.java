package creatures;

import java.time.temporal.ValueRange;

public class Monster extends Creature {


    protected Monster(int protect, int attack, int minDamage, int maxDamage, int maxHealthPoints) {
        super(protect, attack, minDamage, maxDamage, maxHealthPoints);
    }
}
