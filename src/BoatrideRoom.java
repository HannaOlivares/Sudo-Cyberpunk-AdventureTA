public class BoatrideRoom extends MapTile{
    public BoatrideRoom(int x, int y){
        super(x,y);
    }
    @Override
    public String intro_text() {
        return "\n You found yourself in the BoatrideRoom! Get on to go see the famous Isla de las muñecas.";
    }
    public void modify_player(Player player){

    }
}

