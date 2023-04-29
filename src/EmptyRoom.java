public class EmptyRoom extends MapTile{
    public EmptyRoom(int x, int y){
        super(x,y);
    }
    @Override
    public String intro_text() {
        return "\n This room is empty. Hack to unlock.";
    }
   // public void modify_player(Player player){

   // }
}
