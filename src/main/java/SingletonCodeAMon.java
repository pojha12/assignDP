
public class SingletonCodeAMon extends CodeAMon {
    
    /*
     * Constructor
     */
    public SingletonCodeAMon() {
        super();
        type = Types.SINGLETON;
        incType = Types.COMMAND;
        decType = Types.BUILDER;
        initialDamage = 50;
        initialDefense = 0.5;

    }

}
