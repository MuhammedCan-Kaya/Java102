public class Products extends PatikaStore{
    private String name;
    private int imei;
    private int price;
    private int discountRate;
    private int stock;
    private int storage;
    private double inc;
    private int ram;

    public Products(String name, int imei, int price, int discountRate,
                    int stock, int storage, double inc, int ram) {
        this.name = name;
        this.imei = imei;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.storage = storage;
        this.inc = inc;
        this.ram = ram;
    }

    public Products() {}

    public String getName() {
        return name;
    }

    public int getImei() {
        return imei;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public int getStock() {
        return stock;
    }

    public int getStorage() {
        return storage;
    }

    public double getInc() {
        return inc;
    }

    public int getRam() {
        return ram;
    }

    public static void makeNotebookTable(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %s |", "ID");
        System.out.printf("%-30s"," Ürün Adı");
        System.out.printf("| %-11s |","Fiyat");
        System.out.printf(" %-11s |","Marka");
        System.out.printf(" %-11s |","Depolama");
        System.out.printf(" %-11s |","Ekran");
        System.out.printf(" %-11s |","İndirim Oranı");
        System.out.printf(" %-11s |","RAM");
        System.out.printf(" %-11s |%n","Stok Sayısı");
    }

    public static void makePhoneTable(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %s |", "ID");
        System.out.printf("%-30s"," Ürün Adı");
        System.out.printf("| %-11s |","Fiyat");
        System.out.printf(" %-11s |","Marka");
        System.out.printf(" %-11s |","Depolama");
        System.out.printf(" %-11s |","Ekran");
        System.out.printf(" %-11s |","İndirim Oranı");
        System.out.printf(" %-11s |","RAM");
        System.out.printf(" %-11s |","Stok Sayısı");
        System.out.printf(" %-11s |","Renk");
        System.out.printf(" %-11s |","Hafıza");
        System.out.printf(" %-11s |%n","Batarya");
    }
}
