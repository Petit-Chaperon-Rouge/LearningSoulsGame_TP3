package lsg;

import lsg.characters.Hero;
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

        while (hero.isAlive() && monster.isAlive()) {
            System.out.println("\nHit enter key for next move >\n");
            String str = scanner.nextLine();

            if (heroTurn) {
                damage = monster.getHitWith(hero.attack());

                System.out.println(hero.getName() + " attacks " + monster.getName() + " with " + hero.getWeapon().getName() + " (ATTACKS:" + damage + "| DMG : " + damage + ")");

                heroTurn = false;
            }
            else {
                damage = hero.getHitWith(monster.attack());

                System.out.println(monster.getName() + " attacks " + hero.getName() + " with " + monster.getWeapon().getName() + " (ATTACKS:" + damage + "| DMG : " + damage + ")");

                heroTurn = true;
            }

            refresh();
        }

        if (hero.isAlive()) {
            System.out.println("--- " + hero.getName() + " WINS !!! ---");
        }
        else {
            System.out.println("--- " + hero.getName() + " LOSE... ---");
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


    public static void main(String[] args) {

        LearningSoulsGame game = new LearningSoulsGame();

        game.play_v1();

    }
}