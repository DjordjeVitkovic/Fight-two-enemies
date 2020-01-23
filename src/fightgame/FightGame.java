package fightgame;

import java.util.Random;
import java.util.Scanner;

public class FightGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        //Varijable za igru
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int maxEnemyHealt = 75;
        int enemyAttackDamage = 25;

        int healt = 100;
        int attackDamage = 50;
        int numHealtPotions = 3;
        int healtPotionHealtAmount = 30;
        int healtPotionDropChance = 50; //procenti

        boolean running = true;

        System.out.println("Wellcome to the Dungeon!");

        GAME:
        while (running) {

            System.out.println("------------------------------------------------");

            int enemyHealt = rand.nextInt(maxEnemyHealt);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while (enemyHealt > 0) {

                System.out.println("\tYour HP: " + healt);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealt);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink healt potion");
                System.out.println("\t3. Run!");

                String input = sc.nextLine();

                if (input.equals("1")) {

                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealt -= damageDealt;
                    healt -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt);
                    System.out.println("\t> You recive " + damageTaken + " in retaliation!");

                    if (healt < 1) {
                        System.out.println("\t You have too much damage, you are too weak to go on! ");
                        break;
                    }

                } else if (input.equals("2")) {

                    if (numHealtPotions > 0) {

                        healt += healtPotionHealtAmount;
                        numHealtPotions--;
                        System.out.println("\t You drink a healt potion, healin yourself for " + healtPotionHealtAmount
                                + "\n\t You now have " + healt + " HP."
                                + "\n\t You have " + numHealtPotions + " healt points left.\n");

                    } else {

                        System.out.println("\t> You have no healt potions left! Defeat enemies for a chance to get one!\n");

                    }

                } else if (input.equals("3")) {

                    System.out.println("\t Your run away from the " + enemy + "!");
                    continue GAME;

                } else {
                    System.out.println("\t Invalid command!");

                }

            }

            if (healt < 1) {
                System.out.println("Tou limp out of dungeon, weak from battle.");
                break;
            }

            System.out.println("------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" #  You have " + healt + " HP left. #");
            if (rand.nextInt(100) < healtPotionDropChance) {
                numHealtPotions++;
                System.out.println(" # The " + enemy + " drop a healt potion! #");
                System.out.println(" # You now have " + numHealtPotions + " healt potions(s). #");

            }
            System.out.println("------------------------------------------------");
            System.out.println("What would you like to do now? ");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = sc.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = sc.nextLine();
            }

            if (input.equals("1")) {

                System.out.println("You continue your adventure!");

            } else if (input.equals("2")) {

                System.out.println("You exit the dungeon, successful from your adventure!");
                break;
            }
        }
        System.out.println("# THANK FOR PLAYING # ");
    }

}
