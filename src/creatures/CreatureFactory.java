package creatures;

public class CreatureFactory {

    public static Hero getHero(int protect, int attack, int minDamage, int maxDamage, int healthPoints) {
        validate(protect, attack, minDamage, maxDamage, healthPoints);
        return new Hero(protect, attack, minDamage, maxDamage, healthPoints);
    }

    public static Monster getMonster(int protect, int attack, int minDamage, int maxDamage, int healthPoints) {
        validate(protect, attack, minDamage, maxDamage, healthPoints);
        return new Monster(protect, attack, minDamage, maxDamage, healthPoints);
    }

    private static void validate(int protect, int attack, int minDamage, int maxDamage, int healthPoints) {
        if (protect < 1 || protect > 30) {
            throw new IllegalArgumentException("Protect value must be between 1 and 30");
        }

        if (attack < 1 || attack > 30) {
            throw new IllegalArgumentException("Attack value must be between 1 and 30");
        }

        if (minDamage > maxDamage) {
            throw new IllegalArgumentException("Smallest minDamage value must be less than largest maxDamage");
        }

        if (healthPoints < 1) {
            throw new IllegalArgumentException("HP value must be greater than 0");
        }
    }
}
