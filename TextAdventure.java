import java.util.Random;
import java.util.Scanner;

public class TextAdventure {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Random randGenerator = new Random();

        //Game variables
        String[] enemies = {"Giant skeleton", "Goblin", "Zombie", "Wizard", "Wild suckling pig"};
        int maxEnemyHealth = 60;
        int enemyAttackDamage = 20;
        
        //Player variables
        int playerHealth = 100;
        int playerDamage = 40;
        int healthPotionHeal = 30;
        int numHealthPotions = 3;
        int healthPotionDropChance = 40; //Percentage

        boolean running = true;

        System.out.println("Welcome to Peter's Dungeaon game");


        GAME:
        while(running){
            System.out.println("----------------------------------------------------");

            int enemyHealth = randGenerator.nextInt(maxEnemyHealth);
            String enemy = enemies[randGenerator.nextInt(enemies.length)];
            System.out.println("\t" + enemy + " has pulled up!\n");

            while(enemyHealth > 0){
                System.out.println("\tYour HP: " + playerHealth);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();

                if(input.equals("1")){
                    int damageDealt = randGenerator.nextInt(playerDamage);
                    int damageTaken = randGenerator.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    playerHealth -= damageTaken;
                    
                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You recieve " + damageTaken + " damage from the " + enemy);

                    if(playerHealth < 1){
                        System.out.println(">t You're all beat up, its over for you");
                        break;
                    }
                } else if(input.equals("2")) {
                    if(numHealthPotions > 0){
                        playerHealth += healthPotionHeal;
                        numHealthPotions--;
                        System.out.println(">t You chug a health potion, healing you for " + healthPotionHeal + "."
                         + "\n\t> You now have " + playerHealth + " HP."
                         + "\n\t> You have " + numHealthPotions + " health potions left.\n");
                    } else{
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance for more to drop");
                    }
                } else if(input.equals("3")){
                    System.out.println("\t> You run away from the " + enemy + "!");
                    continue GAME;
                } 
                else{
                    System.out.println("Invalid command");
                }

                }
                if(playerHealth < 1){
                    System.out.println("You leave the dungeon, you are too weak");
                    break;
                }
                
                System.out.println("----------------------------------------------------");
                System.out.println(enemy + " was defeated!");
                System.out.println("You have " + playerHealth + " HP left.");
                if(randGenerator.nextInt(100) < healthPotionDropChance) {
                    numHealthPotions++;
                    System.out.println("The " + enemy + " dropped a health potion!");
                    System.out.println("You now have " + numHealthPotions + " health potion(s).");
                }

                System.out.println("----------------------------------------------------");
                System.out.println("What would you like to do now player?");
                System.out.println("1. Continue fighting");
                System.out.println("2. Exit Peter's dungeon");

                String input = in.nextLine();

                while(!input.equals("1") && !input.equals("2")) {
                    System.out.println("Invalid command.");
                    input = in.nextLine();
                }

                if(input.equals("1")){
                    System.out.println("You continue on your adventure");
                }

                else if(input.equals("2")){
                    System.out.println("You exit the dungeon, you are lucky to be alive");
                    break;
                }
            }
            System.out.println("####################");
            System.out.println("THANKS FOR PLAYING!!");
            System.out.println("####################");
        }
    }




