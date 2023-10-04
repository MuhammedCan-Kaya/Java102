import java.util.Scanner;

public class PatikaStore {
    private String brandName;

    public PatikaStore() {
    }

    public PatikaStore(String name) {
        this.brandName = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public static void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("PatikaStore'ye hoşgeldiniz.");
        System.out.println("Aşağıdaki panelden yapmak istediğiniz işlemi seçebilirsiniz.");
        System.out.println();
        boolean isContinue = true;
        while (isContinue) {
            System.out.println();
            System.out.println("PatikaStore Ürün Yönetim Paneli");
            System.out.println("1- Notebook İşlemleri");
            System.out.println("2- Cep Telefonu İşlemleri");
            System.out.println("3- Marka Listele");
            System.out.println("0- Çıkış Yap");
            System.out.print("Seçiminiz: ");
            int choice = scan.nextInt();
            System.out.println();
            switch (choice) {
                case 0:
                    System.out.println("Çıkış yapıldı. İyi günler dileriz.");
                    isContinue = false;
                    break;
                case 1:
                    System.out.println("Notebook Ürünlerimiz");
                    Products.makeNotebookTable();
                    NoteBooks.showAttributes();
                    System.out.println();
                    System.out.println("Hangi işlemi yapmak istiyorsunuz?");
                    System.out.println("1- Ürün eklemek");
                    System.out.println("2- Ürün çıkarmak");
                    System.out.println("3- Geri dön");
                    int selection = scan.nextInt();
                    boolean isTurnBack = true;
                    while(isTurnBack){
                        switch (selection) {
                            case 1:
                                String empty = scan.nextLine();
                                System.out.print("Ürün ismi giriniz: ");
                                String name = scan.nextLine();
                                System.out.print("Ürün marka ismi giriniz: ");
                                String brandName = scan.next();
                                System.out.print("Ürün ID giriniz: ");
                                int id = scan.nextInt();
                                System.out.print("Ürün IMEI kodu giriniz: ");
                                int imei = scan.nextInt();
                                System.out.print("Ürün fiyat değeri giriniz: ");
                                int price = scan.nextInt();
                                System.out.print("Ürün indirim değeri giriniz: ");
                                int discount = scan.nextInt();
                                System.out.print("Ürün stok miktarı giriniz: ");
                                int stock = scan.nextInt();
                                System.out.print("Ürün depolama miktarı giriniz: ");
                                int storage = scan.nextInt();
                                System.out.print("Ürün ekran boyutunu giriniz: ");
                                double inc = scan.nextDouble();
                                System.out.print("Ürün RAM miktarını giriniz: ");
                                int ram = scan.nextInt();
                                NoteBooks nb = new NoteBooks(brandName, id, name, imei, price, discount, stock, storage, inc, ram);
                                NoteBooks.list.add(nb);
                                isTurnBack = false;
                                break;
                            case 2:
                                NoteBooks.showAttributes();
                                System.out.print("IMEI numarasına göre silmeyi istediğiniz ürünü seçiniz. IMEI: ");
                                int index = scan.nextInt();
                                NoteBooks.removeProductByIMEI(NoteBooks.list,index);
                            case 3:
                                isTurnBack = false;
                                break;
                            default:
                                System.out.println("Hatalı tuşlama yaptınız. Lütfen geçerli bir seçeneği seçin.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Cep Telefonu Ürünlerimiz");
                    Phones.makePhoneTable();
                    Phones.showAttributes();
                    System.out.println();
                    System.out.println("Hangi işlemi yapmak istiyorsunuz?");
                    System.out.println("1- Ürün eklemek");
                    System.out.println("2- Ürün çıkarmak");
                    System.out.println("3- Geri dön");
                    int secim = scan.nextInt();
                    boolean isReturn = true;
                    while(isReturn){
                        switch (secim) {
                            case 1:
                                String empty = scan.nextLine();
                                System.out.print("Ürün ismi giriniz: ");
                                String name = scan.nextLine();
                                System.out.print("Ürün marka ismi giriniz: ");
                                String brandName = scan.next();
                                System.out.print("Ürün ID giriniz: ");
                                int id = scan.nextInt();
                                System.out.print("Ürün IMEI kodu giriniz: ");
                                int imei = scan.nextInt();
                                System.out.print("Ürün fiyat değeri giriniz: ");
                                int price = scan.nextInt();
                                System.out.print("Ürün indirim değeri giriniz: ");
                                int discount = scan.nextInt();
                                System.out.print("Ürün stok miktarı giriniz: ");
                                int stock = scan.nextInt();
                                System.out.print("Ürün depolama miktarı giriniz: ");
                                int storage = scan.nextInt();
                                System.out.print("Ürün ekran boyutu giriniz: ");
                                double inc = scan.nextDouble();
                                System.out.print("Ürün RAM miktarı giriniz: ");
                                int ram = scan.nextInt();
                                System.out.print("Ürün rengi giriniz: ");
                                String color = scan.next();
                                System.out.print("Ürün hafıza miktarını giriniz: ");
                                int memory = scan.nextInt();
                                System.out.print("Ürün batarya sınırı giriniz: ");
                                int battery = scan.nextInt();
                                Phones ph = new Phones(id, brandName, name, imei, price, discount, stock, storage, inc, ram, color,
                                        memory,battery);
                                Phones.list.add(ph);
                                isReturn = false;
                                break;
                            case 2:
                                NoteBooks.showAttributes();
                                System.out.print("IMEI numarasına göre silmeyi istediğiniz ürünü seçiniz. IMEI: ");
                                int index = scan.nextInt();
                                NoteBooks.removeProductByIMEI(NoteBooks.list,index);
                                break;
                            case 3:
                                isReturn = false;
                                break;
                            default:
                                System.out.println("Hatalı tuşlama yaptınız. Lütfen geçerli bir seçeneği seçin.");
                        }
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Markalarımız");
                    System.out.println("-------------");
                    for (PatikaStore i : Main.brands) {
                        System.out.println(i.getBrandName());
                    }
                    break;
                default:
                    System.out.println("Hatalı seçim yaptınız. Lütfen tekrar deneyiniz.");
            }
        }
    }
}
