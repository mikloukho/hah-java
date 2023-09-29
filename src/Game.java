import creatures.*;
import services.FightService;

import java.time.temporal.ValueRange;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public static void main(String[] args) {

        Hero hero = CreatureFactory.getHero(8,20,10,30, 150);
        List<Monster> monsters = List.of(
                CreatureFactory.getMonster(6,15,5,20, 100),
                CreatureFactory.getMonster(6,15,5,20, 100),
                CreatureFactory.getMonster(6,15,5,20, 100),
                CreatureFactory.getMonster(6,15,5,20, 100)
        );

        FightService.fight(hero, monsters);
    }
}