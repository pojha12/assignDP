
public class Battle implements Statistics {
    private CodeAMon attacker;
    private CodeAMon defender;
    private Trainer attackTrainer;
    private Trainer defendTrainer;

    /*
     * Constructor
     * @param: trainer
     * @param: attack
     * @param: topponent
     * @param: opp
     */
    public Battle(Trainer trainer, CodeAMon attack, Trainer topponent, CodeAMon opp) {
        attacker = attack;
        defender = opp;
        attackTrainer = trainer;
        defendTrainer = topponent;
        attacker.setBonus(defender);
        defender.setBonus(attacker);
    }

    /*
     * attacker and defender fight
     * 
     * @param: att
     * 
     * @param: def
     */
    public CodeAMon fight(CodeAMon att, CodeAMon def) {
        if (attackTrainer.booster()) {
            att.usePotion();
            System.out.println(att.getType().toString() + "used booster");

        }
        double damage = att.getAttack() * def.getDefense();
        def.takeHealing(damage);
        System.out.println(def.getType().toString() + " has " + damage + " damage");
        if (def.getHealPoints() <= 0.0) {
            System.out.println(def.getType().toString() 
                            + " gained " + def.getLevel() + " experience");
            endGame();
            att.gainExperiencePoints(def.getLevel());
            return att;
        } else if (def.getHealPoints() < HEALING_INC  
                    && (defendTrainer.getName().compareTo("palak") == 0)) {
            if (defendTrainer.healingPotion()) {
                def.healCodeAMon();
                System.out.println(def.getType().toString() + " used healing potion ");
            }

        }
        damage = def.getAttack() * att.getDefense();
        att.takeHealing(damage);
        System.out.println(att.getType().toString() + " took " + damage + " damage");
        if (att.getHealPoints() <= 0.0) {
            System.out.println(att.getType().toString() 
                        + " died and " + def.getType().toString() + " gained "
                    + att.getLevel() + "experience points");

            endGame();
            def.gainExperiencePoints(att.getLevel());
            return def;
        } else {
            return null;
        }
    }

    /*
     * end the game
     */
    public void endGame() {
        attacker.bonusReset();
        defender.bonusReset();
    }

}
