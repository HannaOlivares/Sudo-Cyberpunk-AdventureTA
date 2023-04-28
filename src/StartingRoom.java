
public class StartingRoom extends MapTile{
    public StartingRoom(int x, int y){
        super(x,y);
    }

    public String intro_text() {
        return "\n Hola Sudo! Would you like to go on an adventure?" ;
    }
    public void modify_player(Player player){
    }
}
