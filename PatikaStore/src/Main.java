import java.util.TreeSet;

public class Main {

    public static TreeSet<PatikaStore> brands = new TreeSet<>(new SortByNameComparator());
    static {
        brands.add(new PatikaStore("Samsung"));
        brands.add(new PatikaStore("Lenovo"));
        brands.add(new PatikaStore("Apple"));
        brands.add(new PatikaStore("Huawei"));
        brands.add(new PatikaStore("Casper"));
        brands.add(new PatikaStore("Asus"));
        brands.add(new PatikaStore("HP"));
        brands.add(new PatikaStore("Xiaomi"));
        brands.add(new PatikaStore("Monster"));
    }
    public static void main(String[] args) {
        PatikaStore.run();
    }
}