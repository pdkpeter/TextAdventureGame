import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class textAdventureTest {
        
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
        int experienceGained = 25;
        int playerExperience = 0;
        int playerExperienceTotal = 0;
        int playerGold = 0;
        int playerGoldGained = 50;
        int playerGoldTotal = 0;

        boolean running = true;

        System.out.println("Welcome to Peter's Dungeon game");


        GAME:
        while(running){
            System.out.println("----------------------------------------------------");

            int enemyHealth = randGenerator.nextInt(maxEnemyHealth);
            String enemy = enemies[randGenerator.nextInt(enemies.length)];
            System.out.println("\t" + enemy + " has pulled up!\n");
            //i want to implement if statements here to check if enemy.equals("whatever")
            //if so, then we will print a picture of the enemy
            //i will do this using another method probably
            
            //enemy is alive
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

                //xp gaining. works now!
                playerExperience = randGenerator.nextInt(experienceGained);
                playerExperienceTotal += playerExperience;
                System.out.println("You gained " + playerExperience + " XP, you now have " + playerExperienceTotal + " XP.");
                
                //gold gaining. Works now!
                playerGold = randGenerator.nextInt(playerGoldGained);
                playerGoldTotal += playerGold;
                System.out.println("$$$\tYou gained " + playerGold + " gold, you now have " + playerGoldTotal + " gold.");

                if(randGenerator.nextInt(100) < healthPotionDropChance) {
                    numHealthPotions++;
                    System.out.println("The " + enemy + " dropped a health potion!");
                    System.out.println("You now have " + numHealthPotions + " health potion(s).");
                }

                System.out.println("----------------------------------------------------");
                System.out.println("What would you like to do now player?");
                System.out.println("1. Continue fighting");
                System.out.println("2. Exit Peter's dungeon");

                //WORK IN PROGRESS
                System.out.println("3. Enter shop");

                String input = in.nextLine();

                while(!input.equals("1") && !input.equals("2") && !input.equals("3")) {
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

                else if(input.equals("3")){
                    System.out.println("Welcome to the shop! The merchant has items to sell to you");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Bronze sword : Increases maximum damage by 20\t50 gold");
                    System.out.println("Silver sword : Increases maximum damage by 30\t100 gold");
                    System.out.println("Gold sword : Increases maximum damage by 40\t150 gold");
                    System.out.println("The ultimate weapon, galvinized knuckles : Increases maximum damage by 100\t250 gold");
                }
            }
            System.out.println("####################");
            System.out.println("THANKS FOR PLAYING!!");
            System.out.println("####################");
            in.close();
        }

        private void printPig(){
            String pig = "";
            try{
                BufferedReader pigReader = new BufferedReader(new FileReader("art.txt"));
                String line = "";
                while((line = pigReader.readLine()) != null){
                    pig += line + "\n";
                }
                pigReader.close();
            } catch(IOException e){
                System.out.println("Oops I goofed");
            }
            System.out.println(pig);
        }
    }



