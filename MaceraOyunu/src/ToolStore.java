public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Eşya dükkanı");
    }
    @Override
    public boolean onLocation() {
        System.out.println("Eşya dükkanına hoşgeldiniz.");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("Burada eşya satın alabilirsiniz.");
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış Yap");
            System.out.print("Seçiminiz: ");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3){
                System.out.println("Yanlış seçim yaptınız. Tekrar giriniz: ");
                selectCase = input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Çıkış yapıldı.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }
    public void printWeapon(){
        System.out.println("------Silahlar------");
        for(Weapons weaponList : Weapons.weapons()){
            System.out.println("Id: " + weaponList.getId() +
                    " Silah ismi: " + weaponList.getName() + " //" +
                    " Silah hasarı: " + weaponList.getDamage() + " //" +
                    " Silah fiyatı: " + weaponList.getPrice());
        }
        System.out.println("0 - Menüden Çıkış Yap");
    }

    public void buyWeapon(){
        System.out.print("Bir silah ID'si seçiniz: ");
        int selectWeaponID = input.nextInt();
        while(selectWeaponID < 0 || selectWeaponID > Weapons.weapons().length){
            System.out.println("Geçerli bir değer giriniz.");
            selectWeaponID = input.nextInt();
        }
        if(selectWeaponID != 0) {
            Weapons selectedWeapon = Weapons.getWeaponObjByID(selectWeaponID);
            if(selectedWeapon != null){
                if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız yok.");
                }else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().setMoney(balance);
                    System.out.println("Güncel Paranız: " + this.getPlayer().getMoney());
                }
            }
        }
    }

    public void printArmor(){
        System.out.println("------Zırhlar------");
        for(Armors armorList : Armors.armors()){
            System.out.println("Id: " + armorList.getId() +
                    " Zırh ismi: " + armorList.getName() + " //" +
                    " Zırh savunma değeri: " + armorList.getDefence() + " //" +
                    " Zırh fiyatı: " + armorList.getPrice());
        }
        System.out.println("0 - Menüden Çıkış Yap");
    }

    public void buyArmor(){
        System.out.print("Bir zırh ID'si seçiniz: ");
        int selectArmorID = input.nextInt();
        while(selectArmorID < 0 || selectArmorID > Weapons.weapons().length){
            System.out.println("Geçerli bir değer giriniz.");
            selectArmorID = input.nextInt();
        }
        if(selectArmorID != 0){
            Armors selectedArmor = Armors.getArmorObjByID(selectArmorID);
            if(selectedArmor != null){
                if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız yok.");
                }else {
                    System.out.println(selectedArmor.getName() + " satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    System.out.println("Önceki zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().setMoney(balance);
                    System.out.println("Güncel Paranız: " + this.getPlayer().getMoney());
                }
            }
        }
    }
}
