
public class CommandCodeAMon extends CodeAMon {
    
    /*
     * Constructor
     */
    public CommandCodeAMon() {
        super();
        type = Types.COMMAND;
        incType = Types.ADAPTER;
        decType = Types.SINGLETON;
        initialDamage = 30;
        initialDefense = 0.1;
    }

}
