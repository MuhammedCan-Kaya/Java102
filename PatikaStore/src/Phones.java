import java.util.ArrayList;
public class Phones extends Products{
    private String color;
    private int memory;
    private int battery;
    private int id;
    private String brandname;

    public Phones(int id, String brandname,String name, int imei, int price, int discountRate,
                  int stock, int storage, double inc, int ram, String color,
                  int memory, int battery) {
        super(name, imei, price, discountRate, stock, storage, inc, ram);
        this.color = color;
        this.battery = battery;
        this.memory = memory;
        this.id = id;
        this.brandname = brandname;
    }

    public static ArrayList<Phones> list = new ArrayList<>();

    public String getColor() {
        return color;
    }

    public int getMemory() {
        return memory;
    }

    public int getBattery() {
        return battery;
    }

    public int getIdd() {
        return id;
    }

    public String getBrrandname() {
        return brandname;
    }

    public static void showAttributes(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Phones i : list) {
            System.out.printf("| %d  |", i.getIdd());
            System.out.printf("%-30s|", " " + i.getName());
            System.out.printf("%-13s|", " " + i.getPrice());
            System.out.printf("%-13s|", " " + i.getBrrandname());
            System.out.printf("%-13s|", " " + i.getStorage());
            System.out.printf("%-13s|", " " + i.getInc());
            System.out.printf("%-15s|", " " + i.getDiscountRate());
            System.out.printf("%-13s|", " " + i.getRam());
            System.out.printf("%-13s|", " " + i.getStock());
            System.out.printf("%-13s|", " " + i.getColor());
            System.out.printf("%-13s|", " " + i.getMemory());
            System.out.printf("%-13s|", " " + i.getBattery());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
