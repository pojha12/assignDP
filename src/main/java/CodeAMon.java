import java.util.concurrent.ThreadLocalRandom;

/*
 * CodeAMon.java
 */
public class CodeAMon implements Statistics {
    public int level;
    public boolean battled;
    public int experiencePoints;
    public int healingPoints;
    public Types type;
    public boolean posOfAttack;
    public Types incType; // db
    public Types decType; // b
    public int initialDamage;
    public double initialDefense;
    public boolean usePotion;
    public double typeInc;

    public enum Types {
        ADAPTER, COMMAND, SINGLETON, BUILDER,
    }

    /*
     * Constructor
     */
    public CodeAMon() {
        healingPoints = MAX_HEALING;
        experiencePoints = 0;
        level = 0;
        battled = false;
    }

    /*
     * damage after attack is done
     * 
     * @return double
     */
    public double getAttack() {
        int attacks = ThreadLocalRandom.current().nextInt(0, 4);
        if (attacks == 1) {
            if (posOfAttack) {
                return (initialDamage + (level * LEVEL_JUMP))
                            * BONUS_ATTACK * typeInc * BOOSTER_ATTACK;
            }
            return (initialDamage + (level * LEVEL_JUMP)) * BONUS_ATTACK * typeInc;
        }

        if (usePotion) {
            return (initialDamage + (level * LEVEL_JUMP)) * typeInc * BOOSTER_ATTACK;
        }
        return (initialDamage + (level * LEVEL_JUMP)) * typeInc;
    }

    public double getDefense() {
        return (initialDamage + (level * LEVEL_JUMP)) * typeInc;
    }

    public Types getType() {
        return type;
    }

    /*
     * 
     */
    public void gainExperiencePoints(int oppLevel) {
        level = level + (oppLevel + 1);
    }

    public void monBattled() {
        battled = false;
    }

    /*
     * Heal CodeAMon
     */

    public void healCodeAMon() {
        healingPoints = healingPoints + (int) (HEAL + (level * LEVEL_JUMP));
        if (healingPoints > (int) (HEAL + (level * LEVEL_JUMP))) {
            healingPoints = (int) (HEAL + (level * LEVEL_JUMP));
        }
    }

    public void takeHealing(double change) {
        healingPoints = (int) (healingPoints - change);
    }

    public int getExpPoints() {
        return experiencePoints;
    }

    public int getLevel() {
        return level;
    }

    public int getHealPoints() {
        return healingPoints;
    }

    public void usePotion() {
        usePotion = true;
    }

    /*
     * after game is over at night
     * 
     * @return
     */
    public void endGameForDay() {
        evolveMon();
        if (battled == false) {
            healCodeAMon();
        }
        battled = false;
    }

    /*
     * CodeAMon can evolve if enough experience points
     */

    public void evolveMon() {
        if (level < MAX_LEVEL && experiencePoints > level) {
            level++;
            healingPoints = (int) (healingPoints * LEVEL_JUMP);
            experiencePoints = 0;
        }
    }

    public void setBonus(CodeAMon opponent) {
        if (opponent.getType().equals(incType)) {
            typeInc = LOST;
        } else if (opponent.getType().equals(decType)) {
            typeInc = BONUS;
        } else {
            typeInc = 1;
        }

    }

    public void setValues() {
        typeInc = 0.0;
        usePotion = false;
    }

    /*
     * reset
     */
    public void bonusReset() {
        typeInc = 0.0;
        usePotion = false;
    }

    /*
     * prints info on players when called
     */

    public void getInfo() {
        System.out.println(type.toString() + " is on level " + this.level);
        System.out.println("Level= " + this.level);
        System.out.println(type.toString() + " : ");

    }

}
