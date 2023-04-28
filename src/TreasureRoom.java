public class TreasureRoom extends MapTile{
    public TreasureRoom(int x, int y, Gold gold){
        super(x,y);
    }

    public String into_text() {
        return "\n You found the Montezuma's treasure!";
    }

    //public void modify_player(Player player){

    // }
}
