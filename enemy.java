import java.util.Random;

public class enemy {
    private static final int MAX_ENEMY_HEALTH = 60;
    private static final int MAX_ENEMY_DAMAGE = 20;

    private String enemyName;
    private int enemyHealth;
    private int enemyDamage;

    private int healthPotionDropChance;

    private int maxExperienceDropped;

    private int maxGoldDropped;

    private Random randGenerator; //randomizer

    //constructor, setting enemy
    public enemy(String name){
        randGenerator = new Random();
        //enemy name
        enemyName = name;
        //enemy health
        enemyHealth = randGenerator.nextInt(MAX_ENEMY_HEALTH);
        //randomizes damage
        changeDamage();
        
        healthPotionDropChance = 40; //40%
        maxExperienceDropped = 25;
        maxGoldDropped = 50;
    }

    //changing damage method
    public void changeDamage(){
        enemyDamage = randGenerator.nextInt(MAX_ENEMY_DAMAGE);
    }

    //taking damage method
    public void enemyTakeDamage(player p){
        enemyHealth -= p.getDamage();
        if(enemyIsDead()){
            death(p);
        }
    }

    public int getDamage(){
        return enemyDamage;
    }

    //check if enemy is dead or not
    public boolean enemyIsDead(){
        return enemyHealth <= 0;
    }

    //what happens upon defeating an enemy
    public void death(player p){
        p.addXP( randGenerator.nextInt(maxExperienceDropped));
        p.addGold(randGenerator.nextInt(maxGoldDropped));

        if(randGenerator.nextInt(100) < healthPotionDropChance) {
            p.addHealthPotions(1); // 1 health potion added
        }
    }
}
