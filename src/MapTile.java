import java.util.*;
public class MapTile {
    int x;
    int y;
    //Constructor Method
    public MapTile(int x, int y){
        //this is an Instance variable
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MapTile other = (MapTile) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
    public String intro_text(){
    throw new UnsupportedOperationException();
    }
    //resolve this to load the rest of the rooms
    public void modify_player(Player player){
        throw new UnsupportedOperationException();
    }
    public ArrayList<Action> adjacent_moves(){
        //Returns all move actions for adjacent tiles.
        ArrayList<Action> moves = new ArrayList<Action>();
        if (World.tile_exists(x , y+1) != null)
            moves.add(new MoveEast());
        if (World.tile_exists(x , y-1) != null)
            moves.add(new MoveWest());
        if (World.tile_exists(x-1, y) != null)
            moves.add(new MoveNorth());
        if (World.tile_exists(x+1, y) != null)
            moves.add(new MoveSouth());
        //String moves[] = new String[1];
        return moves;
    }
    public ArrayList<Action> available_actions(){
        ArrayList<Action> moves = new ArrayList<Action>();
        moves = adjacent_moves();
        moves.add(new ViewInventory());
        //String moves[] = new String[1];
        return moves;
    }
}