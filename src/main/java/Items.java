
public class Items {

    public enum ItemTypes {
        EMPTY, POTION, BOOSTER
    }

    private ItemTypes item;

    /*
     * Constructor
     */
    public Items(ItemTypes item) {
        switch (item) {
            case POTION:
                this.item = ItemTypes.POTION;
                break;
            case BOOSTER:
                this.item = ItemTypes.BOOSTER;
                break;
            case EMPTY:
                this.item = ItemTypes.EMPTY;
                break;
            default:
                this.item = ItemTypes.EMPTY;

        }
    }

    public ItemTypes getType() {
        return item;
    }

}
