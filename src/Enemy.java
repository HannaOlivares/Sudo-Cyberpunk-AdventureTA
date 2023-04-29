import java.util.Random;
public class Enemy {
    protected String name;
    protected static int hp;
    protected int damage;
    private String ability;

    public Enemy(int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        setName("Enemy");
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getName() {
        return name;
    }

    public static boolean is_alive() {
        return (hp > 0);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        int maxHp = 0;
        return maxHp;
    }

    public int getDamage() {
        return damage;
    }
    public void Attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(this.damage) + 1;
        player.takeDamage(damage);
        System.out.printf("%s attacks you for %d damage.%n", name, damage);
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
        System.out.printf("%s takes %d damage.%n", name, damage);
    }

    public boolean isDefeated() {
        return hp <= 0;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    /*public void Fight(Player player) {
        System.out.printf("%s appears!%n", name);
        while (!this.isDefeated() && !player.isDefeated()) {
            this.attack(player);
            if (player.isDefeated()) {
                break;
            }
            System.out.println("Your attack:");
            player.attack(this);
            if (this.isDefeated()) {
                System.out.printf("%s has been defeated!%n", name);
                break;
            }
            System.out.println();
        }
    *///}
    public void modify_player(Player the_player) {
        Enemy enemy = null;
        if (Enemy.is_alive()) {
            the_player.hp = the_player.hp - enemy.damage;
            System.out.printf("Enemy does %d damage. You have %d HP remaining.", enemy.damage, the_player.hp);
            while (enemy.hp > 0) {
                the_player.attackEnemy(enemy);
            }
        }
    }

    public void attack(Player player) {
    }
}
/*class Zombie extends Enemy{
    public Zombie(){
        super("Zombie",20,15);
    }

    @Override
    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(getDamage()) + 1;
        player.takeDamage(damage);
        System.out.printf("%s tail whips you for %d damage.%n", getName(), damage);
    }
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isDefeated()) {
            System.out.printf("%s is still alive and surrounding you .%n", getName());
        }
    }
*///}

class Dog extends Enemy{
    public Dog(){
        super(28,10);
    }
    @Override
    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(getDamage()) + 1;
        player.takeDamage(damage);
        System.out.printf("%s tail whips you for %d damage.%n", getName(), damage);
    }
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isDefeated()) {
            System.out.printf("%s is still alive and surrounding you .%n", getName());
        }
    }
}

class SecurityGuards extends Enemy {
    private SecurityGuards securityGuards;
    public SecurityGuards(SecurityGuards securityGuards){
        super(12,40);
        this.securityGuards = securityGuards;
    }
    @Override
    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(getDamage()) + 1;
        player.takeDamage(damage);
        System.out.printf("%s tail whips you for %d damage.%n", getName(), damage);
    }
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isDefeated()) {
            System.out.printf("%s is still alive and surrounding you .%n", getName());
        }
    }
}





