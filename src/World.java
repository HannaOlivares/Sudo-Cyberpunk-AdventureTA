import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                    mt = new ZocaloRoom(x, y);
                    mt = checkRoomExists(mt);
                    break;

                case "BoatrideRoom":
                    mt = new BoatrideRoom(x, y);
                    mt = checkRoomExists(mt);
                    break;

                case "TreasureRoom":
                    mt = new TreasureRoom(x, y, new Gold(200));
                    mt = checkRoomExists(mt);
                    TreasureRoom treasureRoom = (TreasureRoom) mt;
                    if (!treasureRoom.isGoldPickedUp()) {
                        System.out.println("You found a pile of gold!");
                        System.out.println("Do you want to pick it up? (Y/N)");
                        Scanner scanner = new Scanner(System.in);
                        String choice = scanner.next();
                        if (choice.equalsIgnoreCase("Y")) {
                            Player player = new Player();
                            ((TreasureRoom) mt).pickUpGold(player);
                        } else {
                            System.out.println("You already picked up the gold in this room.");
                        }
                    }
                    break;
                case "LeaveRoom":
                    mt = new LeaveRoom(x, y);
                    mt = checkRoomExists(mt);
                    break;

                case "JaguarRoom":
                    mt = new JaguarRoom(x, y);
                    mt = checkRoomExists(mt);
                    break;
            }
        }
        if (mt == null) {
            //System.out.println("You have entered an invalid room. Please choose a new action.");
            // generate a new action for the player to take
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

    /*public static MapTile tile_exists(int x, int y) {
        MapTile mt = null;
        if ((x >= 0 && x < _world.length) && (y >= 0 && y < _world[0].length) && _world[x][y] != null) {
            switch (_world[x][y]) {
                case "StartingRoom":
                    mt = new StartingRoom(x,y);
                    mt = checkRoomExists(mt);
                    break;

                case "EmptyRoom":
                    mt = new EmptyRoom(x,y);
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
                    mt = new TreasureRoom(x,y, new Gold(200));
                    mt = checkRoomExists(mt);
                    TreasureRoom treasureRoom = (TreasureRoom) mt;
                    if (!treasureRoom.isGoldPickedUp()) {
                        System.out.println("You found a pile of gold!");
                        System.out.println("Do you want to pick it up? (Y/N)");
                        Scanner scanner = new Scanner(System.in);
                        String choice = scanner.next();
                        if (choice.equalsIgnoreCase("Y")) {
                            Player player = new Player();
                            ((TreasureRoom) mt).pickUpGold(player);
                        } else {
                            System.out.println("You already picked up the gold in this room.");
                        }
                    }
                    break;

                case "LeaveRoom":
                    mt = new LeaveRoom(1, 3);
                    mt = checkRoomExists(mt);
                    break;

                case "JaguarRoom":
                    mt = new JaguarRoom(2, 3);
                    mt = checkRoomExists(mt);
                    break;
            }
           // if (mt == null) {
                //System.out.println("You have entered an invalid room. Please choose a new action.");
                // generate a new action for the player to take
           // }
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
*///}

