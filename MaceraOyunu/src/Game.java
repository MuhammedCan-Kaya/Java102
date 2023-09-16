import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start() {
        System.out.println("Macera oyununa hoş geldiniz.");
        System.out.print("Lütfen bir karakter ismi giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın" + " " + player.getName() + ", " + "oyuna hoşgeldiniz.");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("******** Bölgeler ********");
            System.out.println();
            System.out.println("1 - Güvenli Ev: Burada canınız yenilenir.");
            System.out.println("2 - Eşya dükkanı: Silah ve zırh satın alabilirsiniz.");
            System.out.println("3 - Orman: Vampirlerle karşılaşabilirsin. Ödül: Odun");
            System.out.println("4 - Nehir: Ayılarla karşılaşabilirsin. Ödül: Su");
            System.out.println("5 - Mağara: Zombilerle karşılaşabilirsin. Ödül: Yemek");
            System.out.println("6 - Maden : Yılanlarla karşılaşabilirsin. Ödül: Yılanlardan düşen para, silah veya zırh");
            System.out.println("0 - Çıkış yap: Oyunu sonlandırır.");
            System.out.println();
            System.out.print("Lütfen gitmek istediğiniz yeri seçiniz: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if(player.getInventory().isFirewood()){
                        System.out.println("Ödül aldığınız bölgeye tekrar girmeye çalıştığınız için güvenli eve döndünüz.");
                        location = new SafeHouse(player);
                    }else{
                        location = new Forest(player);
                    }
                    break;
                case 4:
                    if(player.getInventory().isWater()){
                        System.out.println("Ödül aldığınız bölgeye tekrar girmeye çalıştığınız için güvenli eve döndünüz.");
                        location = new SafeHouse(player);
                    }else{
                        location = new River(player);
                    }
                    break;
                case 5:
                    if(player.getInventory().isFood()){
                        System.out.println("Ödül aldığınız bölgeye tekrar girmeye çalıştığınız için güvenli eve döndünüz.");
                        location = new SafeHouse(player);
                    }else{
                        location = new Cave(player);
                    }
                    break;
                case 6:
                    if(player.getInventory().isMineRibbon()){
                        System.out.println("Ödül aldığınız bölgeye tekrar girmeye çalıştığınız için güvenli eve döndünüz.");
                        location = new SafeHouse(player);
                    }else{
                        location = new Mine(player);
                    }
                    break;
                default:
                    System.out.println("Seçim yapmadığınız için güvenli eve döndünüz.");
                    location = new SafeHouse(player);
            }

            if(location == null){
                System.out.println("Oyundan çıkış yapıldı.");
                break;
            }
            if(!location.onLocation()){
                break;
            }
        }
    }
}
