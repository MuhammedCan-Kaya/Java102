public class Obstacle {
    private int damage;
    private int health;
    private int id;
    private String name;
    private int award;
    private int basicHealth;

    public Obstacle(int damage, int health, int id, String name, int award, int basicHealth) {
        this.damage = damage;
        this.health = health;
        this.id = id;
        this.name = name;
        this.award = award;
        this.basicHealth = basicHealth;
    }

    public int getBasicHealth() {
        return basicHealth;
    }

    public void setBasicHealth(int basicHealth) {
        this.basicHealth = basicHealth;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
