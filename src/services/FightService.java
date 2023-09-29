package services;

import creatures.Creature;
import creatures.Healer;
import creatures.Hero;
import creatures.Monster;
import helpers.Randomizer;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FightService {
    public static void fight(Hero hero, List<Monster> monsters) {
        List<Creature> aliveMonsters = monsters.stream().filter(Creature::isAlive).collect(Collectors.toList());
        while (hero.isAlive() && aliveMonsters.size() != 0) {
            for (Creature monster : aliveMonsters) {
                if (hero instanceof Healer && hero.canHeal()) {
                    Scanner in = new Scanner(System.in);
                    System.out.printf("Health Points %d/%d. You can use heal? Y/n", hero.getHealthPoints(), hero.getMaxHealthPoints());
                    String yesOrNo = in.nextLine();
                    if (yesOrNo.equals("Y")) {
                        hero.heal();
                    }
//                    double percent = (double) hero.getHealthPoints() / hero.getMaxHealthPoints();
//                    if(percent < .6){
//                        hero.heal();
//                    }

                } else if (!hero.isAlive()) {
                    break;
                }
                attack(monster, hero);
                attack(hero, monster);

                aliveMonsters = aliveMonsters.stream().filter(Creature::isAlive).collect(Collectors.toList());
            }
        }

        if (hero.isAlive()) {
            System.out.printf("Герой победил, осталось HP: %d %n", hero.getHealthPoints());
        } else {
            System.out.printf("Монстры победили, в живых осталось %d монстров %n", aliveMonsters.size());
        }
    }

    private static void attack(Creature attacker, Creature attacked) {

        var attackModifier = (attacker.getAttack() - attacked.getProtect()) + 1;

        System.out.println(attacked.getClass().getName() + " атакует " + attacker.getClass().getName());

        if (attackIsSuccess(attackModifier)) {
            int damage = (attackModifier + attacker.getMinDamage() + attacker.getMaxDamage()) / 3;
            attacked.takeDamage(damage);
            System.out.printf("Есть пробитие -%d hp %n", damage);
        } else {
            System.out.println("Не пробил");
        }
    }

    private static boolean attackIsSuccess(int attackModifier) {
        var throwsCount = 1;
        do {
            var result = Randomizer.generate(1, 6);

            if (result == 5 || result == 6) {
                return true;
            }

            throwsCount++;
        } while (attackModifier > throwsCount);

        return false;
    }
}
