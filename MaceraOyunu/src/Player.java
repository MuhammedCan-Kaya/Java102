import java.util.Scanner;

public class Player extends Game{
    private int health;
    private int basicHealth;
    private int damage;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){

        GameChar[] charList = {new Samurai(), new Archer(), new Chevalier()};
        System.out.println("********************");
        for (GameChar gameChar : charList){
            System.out.println(gameChar.getId() + " - " + gameChar.getName() + " " +
                    "\tDamage: " + gameChar.getDamage() +
                    "\tHealth: " + gameChar.getHealth() +
                    "\tMoney: " + gameChar.getMoney());
        }
        System.out.println("---------------------");
        System.out.print("Lütfen bir karakter seçiniz: ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Chevalier());
                break;
            default:
                initPlayer(new Samurai());
        }
    }
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setName(gameChar.getName());
        this.setMoney(gameChar.getMoney());
        this.setBasicHealth(gameChar.getHealth());
    }

    public void printInfo(){
        System.out.println();
        System.out.println(
                "Silah: " + this.getInventory().getWeapon().getName() +
                "\nZırh: " + this.getInventory().getArmor().getName() +
                "\nSavunma: " + this.getInventory().getArmor().getDefence() +
                "\nHasar: " + this.getTotalDamage() +
                "\nSağlık: " + this.getHealth() +
                "\nPara: " + this.getMoney());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health <= 0){
            health = 0;
        }
        this.health = health;
    }

    public int getBasicHealth() {
        return basicHealth;
    }

    public void setBasicHealth(int basicHealth) {
        this.basicHealth = basicHealth;
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
}
