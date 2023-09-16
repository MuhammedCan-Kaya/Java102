public class Inventory {
    private Weapons weapon;
    private Armors armor;
    private boolean food;
    private boolean water;
    private boolean firewood;
    private boolean mineRibbon;

    public Inventory() {
        this.weapon = new Weapons(-1,0,0,"Yumruk");
        this.armor = new Armors(-1,0,0, "Paçavra");
        this.food = false;
        this.firewood = false;
        this.water = false;
        this.mineRibbon = false;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Armors getArmor() {
        return armor;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }

    public boolean isFood() { // bu ödüller kazanıldıkça set ile false değerler true olacak.
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean isMineRibbon() {
        return mineRibbon;
    }

    public void setMineRibbon(boolean mineRibbon) {
        this.mineRibbon = mineRibbon;
    }
}
