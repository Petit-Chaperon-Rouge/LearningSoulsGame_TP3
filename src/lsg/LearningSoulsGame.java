package lsg;

import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.buffs.rings.DragonSlayerRing;
import lsg.buffs.rings.RingOfDeath;
import lsg.characters.Hero;
import lsg.characters.Lycanthrope;
import lsg.characters.Monster;
import lsg.weapons.Claw;
import lsg.weapons.Sword;
import java.util.Scanner;

/**
 * Created by alecoeuc on 22/09/17.
 */
public class LearningSoulsGame {

    private Hero hero;
    private Monster monster;
    private Scanner scanner = new Scanner(System.in);



    // Méthodes



    private void refresh() {
        this.hero.printStats();
        this.monster.printStats();
    }


    private void fight1v1() {
            refresh();

            boolean heroTurn = true;
            int damage;
            int attack;

        while (hero.isAlive() && monster.isAlive()) {
            System.out.println("\nHit enter key for next move > ");
            String str = scanner.nextLine();

            if (heroTurn) {
                attack = hero.attack();
                damage = monster.getHitWith(attack);

                System.out.println(hero.getName() + " attacks " + monster.getName() + " with " + hero.getWeapon().getName() + " (ATTACK:" + attack + " | DMG : " + damage + ")");

                heroTurn = false;
            }
            else {
                attack = monster.attack();
                damage = hero.getHitWith(attack);

                System.out.println(monster.getName() + " attacks " + hero.getName() + " with " + monster.getWeapon().getName() + " (ATTACK:" + attack + " | DMG : " + damage + ")");

                heroTurn = true;
            }

            refresh();
        }

        if (hero.isAlive()) {
            System.out.println("\n--- " + hero.getName() + " WINS !!! ---");
        }
        else {
            System.out.println("\n--- " + hero.getName() + " LOSE... ---");
        }

    }


    private void init() {
        Sword sword = new Sword();
        Claw claw = new Claw();

        hero = new Hero();
        monster = new Monster();

        hero.setWeapon(sword);
        monster.setWeapon(claw);
    }

    private void play_v1() {
        init();
        fight1v1();
    }

    private void play_v2() {
        init();
        hero.setArmorItem(new DragonSlayerLeggings(), 1);

        fight1v1();
    }

    private void play_v3() {
        init();
        hero.setArmorItem(new DragonSlayerLeggings(), 1);
        monster = new Lycanthrope();
        hero.setRing(new RingOfDeath(), 1);
        hero.setRing(new DragonSlayerRing(), 2);
        fight1v1();
    }


    public static void main(String[] args) {

        LearningSoulsGame game = new LearningSoulsGame();

        //game.play_v1();
        //game.play_v2();
        game.play_v3();


    }
}