
public class LeaveRoom extends MapTile{
    public LeaveRoom(int x, int y){
        super(x,y);
    }

    public String into_text() {
        return "\n You have left Mexico City.";
    }

    public void modify_player(Player player){
        player.victory = true;

    }
}

