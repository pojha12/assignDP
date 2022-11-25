import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    private static Game game = new Game();
    private final ArrayList<Trainer> trainers;
    private Round time;
    private Round day;
    private Round night;
    private FacCodeAMon factory;
    
    /*
     * Constructor
     */
    private Game() {
        factory = new FacCodeAMon();
        trainers = new ArrayList<>();
        trainers.add(new Trainer("Palak Ojha", factory));
        trainers.add(new Trainer("Jake Martin", factory));
        trainers.add(new Trainer("Emma Owen", factory));
        trainers.add(new Trainer("John Adam", factory));
        day = new Round(Round.Time.DAY);
        time = day;
        night = new Round(Round.Time.NIGHT);

    }

    public static Game getGame() {
        return game;
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public FacCodeAMon getFactory() {
        return factory;
    }

    public Round getCurrentRound() {
        return time;
    }
    
    /*
     * game on next day
     */
    public void newDay() {
        for (Trainer t : trainers) {
            for (int i = 0; i < t.getTotalMons(); i++) {
                t.healMons();
                t.evolveMons();
            }
        }
        day = new Round(Round.Time.DAY);
        time = day;
        night = new Round(Round.Time.NIGHT);
    }
    
    /*
     * run game for numRounds
     * @param numRounds
     */
    public void runGameRounds(int numRounds) {
        for (int i = 0; i < numRounds; i++) {
            System.out.println("Round " + (i + 1) + " at day time");
            time.runRound(game.getTrainers());
            time = night;
            System.out.println("Night now");
            night.runRound(game.getTrainers());
            newDay();

        }
        System.out.println("Game Over");

        for (Trainer t : trainers) {
            t.getInfo();
        }
    }

}
