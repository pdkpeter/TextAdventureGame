import java.util.Random;

public class player {

    //Player variables
    private int playerHealth;
    private int maxPlayerDamage;
    private int playerDamage;

    private int healthPotionHeal;
    private int numHealthPotions;
    
    private int playerExperienceTotal; 
    

    private int playerGoldTotal;


    private Random randGenerator; //randomizer

    //player constructor
    public player(){
        //damage and health
        randGenerator = new Random();
        playerHealth = 100;
        maxPlayerDamage = 40;
        changeDamage();
        
        //health potions
        numHealthPotions = 3;
        healthPotionHeal = 30;

        //experience
        playerExperienceTotal = 0;

        //gold
        playerGoldTotal = 0;
    }

    //changing damage method
    public void changeDamage(){
        playerDamage = randGenerator.nextInt(maxPlayerDamage); 
    }

    //accesor damage method
    public int getDamage(){
        return playerDamage;
    }

    //setter to add xp
    public void addXP(int experienceGained){
        playerExperienceTotal += experienceGained;
    }

    //setter to add gold
    public void addGold(int goldGained){
        playerGoldTotal += goldGained;
    }

    //setter to add health potions
    public void addHealthPotions(int healthPotionGained){
        numHealthPotions += healthPotionGained;
    }

    public void playerTakeDamage(enemy e){
        playerHealth -= e.getDamage();
        
        if(playerHealth < 1){
            //make another method to check if players dead then break after
        }
    }
}
