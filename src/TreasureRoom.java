public class TreasureRoom extends MapTile{
    private Gold gold;
    private boolean goldPickedUp;

    public TreasureRoom(int x, int y, Gold gold){
        super(x,y);
        this.gold = gold;
        this.goldPickedUp = false;
    }

    @Override
    public String intro_text() {
        return "You found the Montezuma's treasure!";
    }

    public void modify_player(Player player){
        // Do nothing
    }

    public void pickUpGold(Player player) {
        int amt = gold.getAmt();
        player.addGold(amt);
        System.out.println("You picked up " + amt + " gold!");
        goldPickedUp = true;
    }

    public boolean isGoldPickedUp() {
        return goldPickedUp;
    }
}








/*public class TreasureRoom extends MapTile {
    private Gold gold;

    public TreasureRoom(int x, int y, Gold gold) {
        super(x, y);
        this.gold = gold;
    }
    @Override
    public String intro_text() {
        return "You found the Montezuma's treasure!";
    }
    public void modify_player(Player player) {

    }
    public void pickUpGold(Player player) {
        int amt = gold.getAmt();
        player.addGold(amt);
        System.out.println("You picked up " + amt + " gold!");
        gold = null;
    }
    public Gold getGold() {
        return gold;
    }
*///}
