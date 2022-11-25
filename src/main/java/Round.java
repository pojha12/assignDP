import java.util.ArrayList;

public class Round {
    public enum Time {
        DAY, NIGHT
    }

    private Time time;

    /*
     * Constructor
     */
    public Round(Time time) {
        this.time = time;
    }
    
    /*
     * runs game for each trainer
     * @param trainers (ArrayList)
     */
    public void runRound(ArrayList<Trainer> trainers) {
        for (int i = 0; i < trainers.size() - 1; i++) {
            new Attack(trainers.get(i), time);
        }
    }

    public Time getTime() {
        return time;
    }

}
