
public class FacCodeAMon {

    private int mons;
    
    /*
     * Constructor
     */
    public FacCodeAMon() {
        mons = 0;

    }
    
    /*
     * gets a random CodeAMon
     * @return CodeAMon
     */
    public CodeAMon getRandCodeAMon() {
        CodeAMon rand = getCodeAMon(CodeAMon.Types.values()[mons++ % 4]);
        rand.takeHealing(Statistics.RHEALTH_DEC);
        return rand;
    }

    public CodeAMon getCodeAMon() {
        return getCodeAMon(CodeAMon.Types.values()[mons++ % 4]);
    }

    /*
     * creates CodeAMon based on type
     * @param: type of CodeAMon
     */
    public CodeAMon getCodeAMon(CodeAMon.Types type) {
        switch (type) {
            case SINGLETON:
                return new SingletonCodeAMon();
            case BUILDER:
                return new BuilderCodeAMon();
            case ADAPTER:
                return new AdapterCodeAMon();
            case COMMAND:
                return new CommandCodeAMon();
            default:
                return getRandCodeAMon();
        }

    }
}
