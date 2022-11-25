import java.util.concurrent.ThreadLocalRandom;

public class Attack implements Statistics {
    
    /*
     * does attack based on case for trainer and CodeAMon
     * @param trainer
     * @param time
     */
    public Attack(Trainer trainer, Round.Time time) {
        int choice = ThreadLocalRandom.current().nextInt(0, 2);
        if (time.toString().compareTo("DAY") == 0) {
            switch (choice) {
                case BUY:
                    int pickedItem = ThreadLocalRandom.current().nextInt(1, 3);
                    Items.ItemTypes boughtItem = Items.ItemTypes.values()[pickedItem];
                    System.out.println(trainer.getName() + " bought " + boughtItem);
                    if (trainer.getItem(boughtItem) && trainer.getCredits() > COST_OF_ITEM) {
                        System.out.println(trainer.getName() + " bought " + boughtItem);
                    } else {
                        System.out.println(trainer.getName() + " bought nothing");
                    }
                    break;
    
                case BATTLE:
                    System.out.println(trainer.getName() + " ready to battle");
                    Trainer rand = new Trainer();
                    CodeAMon attack = trainer.useMon();
                    CodeAMon randCodeAMon = Game.getGame().getFactory().getRandCodeAMon();
                    Battle b = new Battle(trainer, attack, rand, randCodeAMon);
                    System.out.println(trainer.getName() + " got " 
                                    + randCodeAMon.getType().toString() + " using "
                                    + attack.getType().toString());
    
                    CodeAMon winner = null;
    
                    while (winner == null) {
                        winner = b.fight(attack, randCodeAMon);
                    }
                    if (winner.equals(attack)) {
                        randCodeAMon.healCodeAMon();
                        trainer.catchMon(randCodeAMon);
    
                        attack.gainExperiencePoints(randCodeAMon.getLevel());
    
                        System.out.println(randCodeAMon.getType().toString() 
                                    + " was caught by" + trainer.getName());
                    } else {
                        System.out.println(randCodeAMon.getType().toString() 
                                    + " was not caught by" + trainer.getName());
                    }
                    break;
    
                default:
                    System.out.println("Error");
            }
        }
        else {
            if (choice == ACTION) {
                CodeAMon attack = trainer.useMon();
                if (attack.getHealPoints() < HPATTACK) {
                    System.out.println(trainer.getName() + " is done for now");
                    return;
                }
                System.out.println(trainer.getName() + " is ready for new battle");

                int randOpponent = ThreadLocalRandom.current()
                                    .nextInt(0, Game.getGame().getTrainers().size());
                Trainer topponent = Game.getGame().getTrainers().get(randOpponent);
                CodeAMon opp = topponent.useMon();
                int count = 0;

                while (opp.getHealPoints() < HPATTACK || topponent.equals(trainer)) {
                    count++;
                    if (count == Game.getGame().getTrainers().size()) {
                        System.out.println("no opponent for " + trainer.getName());
                        break;
                    }
                    topponent = Game.getGame().getTrainers()
                            .get((randOpponent + count) % Game.getGame().getTrainers().size());
                    opp = topponent.useMon();

                }

                System.out.println(trainer.getName() + "vs" + topponent.getName());
                System.out.println(trainer.getName() + " uses " + attack.getType().toString());
                System.out.println(topponent.getName() + " uses " + opp.getType().toString());

                CodeAMon winner = null;
                Battle b = new Battle(trainer, attack, topponent, opp);

                while (winner == null) {
                    winner = b.fight(attack, opp);
                }

                if (winner.equals(attack)) {
                    System.out.println("The winnier is " 
                                + trainer.getName() + " and gets 2 credits");
                    trainer.calcCredit();
                    trainer.incWin();
                    topponent.incLoss();
                } else {
                    System.out.println("The winner is " 
                            + topponent.getName() + " and gets 2 credits");
                    topponent.calcCredit();
                    topponent.incWin();
                    trainer.incLoss();
                }
                return;
            }
        }
        System.out.println(trainer.getName() + " is done for now");
    }
}
