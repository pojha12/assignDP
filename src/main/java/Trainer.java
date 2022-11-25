
public class Trainer implements Statistics {
    private CodeAMon[] mons;
    private int wins;
    private int loss;
    private String name;
    private int credits;
    private Items[] items;
    private int numberOfMons;

    public Trainer() {
        name = "rand";
    }
    
    /*
     * Constructor
     * @param name
     * @param monAction
     */
    public Trainer(String name, FacCodeAMon monAction) {
        this.name = name;
        mons = new CodeAMon[6];
        mons[0] = monAction.getCodeAMon();
        numberOfMons = 1;
        credits = CREDITS;
        items = new Items[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            items[i] = new Items(Items.ItemTypes.EMPTY);
        }
        wins = 0;
        loss = 0;

    }
    
    /*
     * trainer buys item
     * @param type
     * @return boolean
     */
    public boolean getItem(Items.ItemTypes type) {
        credits = credits - COST_OF_ITEM;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getType().toString().compareTo(Items.ItemTypes.EMPTY.toString()) == 0) {
                items[i] = new Items(type);
                return true;
            }
        }
        return false;
    }

    /*
     * 
     * @return void
     */
    public void healMons() {
        for (int i = 0; i < numberOfMons; i++) {
            mons[i].endGameForDay();
        }
    }

    public int getLoss() {
        return loss;
    }

    public int getCredits() {
        return credits;
    }

    public int getWins() {
        return wins;
    }

    public String getName() {
        return name;
    }

    public void catchMon(CodeAMon mon) {
        mons[numberOfMons] = mon;
        numberOfMons++;
    }

    public void calcCredit() {
        this.credits = this.credits + REWARDS;
    }

    public void incWin() {
        wins++;
    }

    public void incLoss() {
        loss++;
    }

    public int getTotalMons() {
        return numberOfMons;
    }

    /*
     * check if trainer use healing potion
     * @return boolean
     */
    public boolean healingPotion() {
        for (Items i : items) {
            if (i.toString().compareTo("POTION") == 0) {
                i = new Items(Items.ItemTypes.EMPTY);
                return true;
            }
        }
        return false;
    }

    /*
     * check if trainer use booster
     * @return boolean
     */
    public boolean booster() {
        for (Items i : items) {
            if (i.toString().compareTo("BOOSTER") == 0) {
                i = new Items(Items.ItemTypes.EMPTY);
                return true;
            }
        }
        return false;
    }

    /*
     * evolve CodeAMon
     */
    public void evolveMons() {
        for (int i = 0; i < numberOfMons; i++) {
            mons[i].evolveMon();
        }
    }

    /*
     * picks CodeAMon with most health for game
     * @return CodeAMon
     */
    public CodeAMon useMon() {
        CodeAMon useMon = mons[0];
        for (int i = 0; i < numberOfMons; i++) {
            if (mons[i].getHealPoints() > useMon.getHealPoints()) {
                useMon = mons[i];
            }
        }
        return useMon;
    }

    /*
     * print info of players
     */
    public void getInfo() {
        for (int i = 0; i < numberOfMons; i++) {
            mons[i].getInfo();
        }
        System.out.println("Wins= " + wins);
        System.out.println("Loss= " + loss);
    }
}
