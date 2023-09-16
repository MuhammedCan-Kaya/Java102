public class Armors {
    private int id;
    private String name;
    private int defence;
    private int price;

    public Armors(int id, int defence, int price ,String name) {
        this.name = name;
        this.id = id;
        this.defence = defence;
        this.price = price;
    }

    public static Armors[] armors(){
        Armors[] armorList = new Armors[3];
        armorList[0] = new Armors(1, 1,15,"Hafif Zırh");
        armorList[1] = new Armors(2, 3,25,"Orta Zırh");
        armorList[2] = new Armors(3, 5,40,"Ağır Zırh");
        return armorList;
    }

    public static Armors getArmorObjByID(int id){
        for(Armors a : Armors.armors()){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
