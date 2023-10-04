import java.util.ArrayList;
import java.util.Iterator;

public class NoteBooks extends Products {

    public static ArrayList<NoteBooks> list = new ArrayList<>();
    int id;
    String brandName;

    public NoteBooks() {
        super();
    }

    public NoteBooks(String brandName, int id, String name, int imei, int price, int discountRate,
                     int stock, int storage, double inc, int ram) {
        super(name, imei, price, discountRate, stock, storage, inc, ram);
        this.id = id;
        this.brandName = brandName;
    }

    public int getIdd() {
        return id;
    }

    public String getBrrandName() {
        return brandName;
    }

    public static void removeProductByIMEI(ArrayList<NoteBooks> productList, int imei) {
        Iterator<NoteBooks> iterator = productList.iterator();
        while (iterator.hasNext()) {
            NoteBooks product = iterator.next();
            if (product.getImei() == imei) {
                iterator.remove();
            }
        }
    }

    public static void showAttributes() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        for (NoteBooks i : list) {
            System.out.printf("| %d  |", i.getIdd());
            System.out.printf("%-30s|", " " + i.getName());
            System.out.printf("%-13s|", " " + i.getPrice());
            System.out.printf("%-13s|", " " + i.getBrrandName());
            System.out.printf("%-13s|", " " + i.getStorage());
            System.out.printf("%-13s|", " " + i.getInc());
            System.out.printf("%-15s|", " " + i.getDiscountRate());
            System.out.printf("%-13s|", " " + i.getRam());
            System.out.printf("%-13s|", " " + i.getStock());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    }
}