
public class StartingRoom extends MapTile{
    public StartingRoom(int x, int y){
        super(x,y);
    }
    @Override
    public String intro_text() {
        return "\n Hola Sudo! Would you like to go on an adventure?" ;
    }
    public void modify_player(Player player){
    }
}
