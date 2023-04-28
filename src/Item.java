public class Item {
    protected String name;
    protected String desc;
    protected int value;

    //protected int damage;

    //constructor method
    public Item(String name, String desc, int value) {
        this.name = name;
        this.desc = desc;
        this.value = value;

    }
    public void setName(String Name) {
        this.name = Name;
    }
    public String getName() {
        return name;
    }
}
class Gold extends Item {
    protected int amt;
    public Gold(int amt) {
        super("Gold", String.format("Big Gold Bar! %d", (amt)), amt);
        this.amt = amt;
    }
}

class Weapon extends Item {
    private int damage; //protect the data/control Weapon can only access damage
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public Weapon(String name, String desc, int value, int damage) {
        super(name, desc, value);
        this.damage = damage;
    }
}
class Mace extends Weapon {
    public Mace() {
        super("Mace", "Use a Mace to Fight like our ancestors", 10, 15);
    }
}
class Sword extends Weapon {
    public Sword(){
        super("Sword", "Use the sword to slash through flesh",10, 15);
    } //super goes the Weapon class
}//this is the end of Sword class
class Flipper extends Weapon {
    public Flipper() {
        super("Flipper","Use Flipper Zero to hack the world", 100,50 );
    }
}//Flipper Zero the multi pen testing tool
class Arrow extends Weapon {
    public Arrow(){
        super("Arrow", "Use the arrow for far reach targets", 9, 20);
    }
}//this is end of Arrow class



