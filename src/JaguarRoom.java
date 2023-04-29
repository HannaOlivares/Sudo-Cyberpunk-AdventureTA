public class JaguarRoom extends MapTile{
    public JaguarRoom(int x, int y){
        super(x,y);
    }
    @Override
    public String intro_text(){
        return "\n Careful in this room the legendary vicious Jaguar lives here.";
    }

    public void modify_player(Player player){

    }
}

