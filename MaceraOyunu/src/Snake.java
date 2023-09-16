public class Snake extends Obstacle{
    private int maxDamage;

    public Snake(int maxDamage) {
        super(0, 12, 4, "Yılan", 0, 12);
        this.maxDamage = maxDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }
}