public class Enemy {
    protected String name;
    protected int hp;
    protected int damage;

    public Enemy(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
    public void setName(String Name) {
        this.name = Name;
    }
    public String getName() {
        return name;
    }
    public boolean is_alive() {
        return (this.hp > 0);

    }
}
  /* class Ogre extends Enemy{
    public Ogre(){
        super("Ogre", 20,30);


    }
*///}

class Zombie extends Enemy{
    public Zombie(){
        super("Zombie",20,15);
    }
}
class Dog extends Enemy{
    public Dog(){
        super("Stay Dog", 28,10);
    }
}
class Jaguar extends Enemy{
    public Jaguar(){
        super("Giant Jaguar", 10,45);
    }

}
class SecurityGuards extends Enemy {
    private SecurityGuards securityGuards;
    public SecurityGuards(SecurityGuards securityGuards){
        super("Tough SecurityGuard", 12,40);
        this.securityGuards = securityGuards;
    }
}




