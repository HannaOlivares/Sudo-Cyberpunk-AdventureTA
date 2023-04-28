public class EmptyRoom extends MapTile{
    public EmptyRoom(int x, int y){
        super(x,y);
    }
    public String into_text() {
        return "\n This room is empty. Hack to unlock.";
    }
    public void modify_player(Player player){

    }
}
