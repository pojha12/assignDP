
public class BuilderCodeAMon extends CodeAMon {

    /*
     * Constructor
     */
    public BuilderCodeAMon() {
        super();
        type = Types.BUILDER;
        incType = Types.ADAPTER;
        decType = Types.SINGLETON;
        initialDamage = 30;
        initialDefense = 0.2;

    }

}
