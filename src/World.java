import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class World {
    public static String[][] _world;
    static Point Starting_Position = new Point(0, 0);
    public static ArrayList<MapTile> history = new ArrayList<MapTile>();

    private static Point available_actions = new Point(0, 0);

    public static MapTile tile_exists(int x, int y) {
        MapTile mt = null;
        if ((x >= 0 && x < _world.length) && (y >= 0 && y < _world[0].length) && _world[x][y] != null) {
            switch (_world[x][y]) {
                case "StartingRoom":
                    mt = new StartingRoom(x, y);
                    mt = checkRoomExists(mt);
                    break;
                case "EmptyRoom":
                    mt = new EmptyRoom(x, y);
                    mt = checkRoomExists(mt);
                    break;
                case "ZocaloRoom":
                    mt = new ZocaloRoom(x,y);
                    mt = checkRoomExists(mt);
                    break;
                case "BoatrideRoom":
                    mt = new BoatrideRoom(x,y);
                    mt = checkRoomExists(mt);
                  break;
                case "TreasureRoom":
                    mt = new TreasureRoom(x, y, new Gold(200));
                    mt = checkRoomExists(mt);

                case "JaguarRoom":
                mt = new JaguarRoom(x, y);
                    mt = checkRoomExists(mt);
                break;

                /*case "GiantSpiderRoom":
                    mt = new GiantSpiderRoom(x,y, new GiantSpider());
                    mt = checkRoomExists(mt);
//                default:
//                   */// throw new IllegalStateException("Unexpected value: " + _world[x][y]);
            }
        }
        return mt;
    }

    private static MapTile checkRoomExists(MapTile mt) {
        if (history.indexOf(mt) != -1) {
            mt = history.get(history.indexOf(mt));
        } else {
            history.add(mt);
        }
        return mt;
    }

  public void load_tiles() {
        // Parses a file that describes the world space into the _world object
        List<String> rows = new ArrayList<String>();
        try {
            BufferedReader f = new BufferedReader(new FileReader("src/SudoMap.txt"));
            String row;
            while ((row = f.readLine()) != null) {
                rows.add(row);
            }
            f.close();
            int x_max = rows.get(0).split("\t").length;
            _world = new String[rows.size()][x_max];
            String[] cols;
            String tile_name;
            for (int y = 0; y < rows.size(); y++) {
                cols = rows.get(y).split("\t");
                for (int x = 0; x < x_max; x++) {
                    tile_name = cols[x];
                    if (tile_name.equals("StartingRoom")) {
                        Starting_Position.x = y;
                        Starting_Position.y = x;
                    }
                    _world[y][x] = tile_name.equals(" ") ? null : tile_name;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    /*public void load_tiles() {
        // Parses a file that describes the world space into the _world object
        List<String> rows = new ArrayList<String>();
        try {
            BufferedReader f = new BufferedReader(new FileReader("src/SudoMap.txt"));
            String row;
            while ((row = f.readLine()) != null) {
               // rows.add(row);
                System.out.println(row);
        }
            f.close();
            int x_max = rows.get(0).split("\t").length;
            _world = new String[rows.size()][x_max];
            String[] cols;
            String tile_name;
            for (int y = 0; y < rows.size(); y++) {
                cols = rows.get(y).split("\t");
                for (int x = 0; x < x_max; x++) {
                    tile_name = cols[x];
                    if (tile_name.equals("StartingRoom")) {
                        Starting_Position.x = y;
                        Starting_Position.y = x;
                    }
                    _world[y][x] = tile_name.equals(" ") ? null : tile_name;
                }
            }
        } // Closing try code block
        catch (Exception e) {
            // System.err.format("Exception occurred trying to read '%s'.",
            // filename);
            e.printStackTrace();
        }
    } // Closing block for Load_Tiles Method
*///}