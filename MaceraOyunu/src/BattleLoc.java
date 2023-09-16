import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.award = award;
        this.obstacle = obstacle;
        this.maxObstacle = maxObstacle;
    }

    @Override
    boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız: " + this.getName());
        System.out.println("Burada dikkatli olmalısın. " + this.getName() + "'da "+ obsNumber + " tane " + this.getObstacle().getName()
                + " bulunmaktadır.");
        System.out.println("Savaşacak mısın yoksa kaçacak mısın? Savaşmak istiyorsan S'ye, kaçmak istiyorsan K'ye bas.");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S")){
            if (combat(obsNumber)){
                System.out.println("*************");
                System.out.println(this.getName() + "daki " + "tüm düşmanları yendiniz.");
                System.out.println("Ödülünüz: " + this.getAward());
                System.out.println("*************");
                if(this.getAward().equals("Food")){
                    this.getPlayer().getInventory().setFood(true);
                }
                if(this.getAward().equals("Water")){
                    this.getPlayer().getInventory().setWater(true);
                }
                if(this.getAward().equals("Firewood")){
                    this.getPlayer().getInventory().setFirewood(true);
                }
                if(this.getAward().equals("Miner Ribbon")){
                    this.getPlayer().getInventory().setMineRibbon(true);
                    Random a = new Random();
                    int percent = a.nextInt(99) + 1;
                    if(percent < 25){
                        int possibility = a.nextInt(99) + 1;
                        if(possibility < 20){
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                        }else if(possibility > 20 && possibility < 50){
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                        }else{
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                        }
                    }else{
                        System.out.println("Para elde edilmedi.");
                    }
                }
                if(isWinGame()){
                    System.out.println();
                    System.out.println("BÜTÜN ÖDÜLLER TOPLANDI, GÜVENLİ EVE DÖNEREK OYUNU KAZANABİLİRSİNİZ.");
                }
                return true;
            }
        }
        if(this.getPlayer().getHealth() == 0){
            System.out.println("Öldünüz. Oyun bitti.");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber){
        for(int i = 1; i <= obsNumber; i++){
            if(this.getObstacle().getName().equals("Yılan")){
                this.getObstacle().setDamage(randomObstacleDamage());
            }
            this.getObstacle().setHealth(this.getObstacle().getBasicHealth());
            playerStats();
            obstacleStats(i);
            if(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0)
            System.out.println("İlk vuruş %50 olasılıkla senindir. Hala kaçabilirsin, bu riske rağmen ilk vuruşu denemek istiyor musun? Vuruş için V, " +
                    "kaçış için K'ye bas.");
            String selectCombat = input.nextLine().toUpperCase();
            Random b = new Random();
            int firstHit = b.nextInt(99) + 1;
            if (selectCombat.equals("V") && firstHit < 50){
                System.out.println("Canavara vuruldu.");
                this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamage());
                afterHit();
            }else if(this.getObstacle().getHealth() > 0 && firstHit > 50){
                System.out.println();
                System.out.println("Canavar size vurdu.");
                int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefence();
                if(obstacleDamage < 0){
                    obstacleDamage = 0;
                }
                this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                afterHit();
            }
            else{
                return false;
            }
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.print("Vur ya da kaç. Vurmak için V, kaçmak için K'ye bas: ");
                selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                    System.out.println("Canavara vuruldu.");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamage());
                    afterHit();
                    if(this.getObstacle().getHealth() > 0){
                        System.out.println();
                        System.out.println("Canavar size vurdu.");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefence();
                        if(obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }else{
                    return false;
                }
            }
            if(this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz.");
                System.out.println(this.getObstacle().getAward() + " altın kazandınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
                if(this.getObstacle().getName().equals("Yılan")){
                    Snake snakeDrop = new Snake(4);
                    Random a = new Random();
                    int percent = a.nextInt(99) + 1;
                    if(percent < 15){
                        int rate = a.nextInt(99) + 1;
                        if(rate < 20){
                            this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjByID(3));
                            System.out.println("Tüfek elde edildi.");
                        }else if(rate > 20 && rate < 50){
                            this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjByID(2));
                            System.out.println("Kılıç elde edildi.");
                        }else if(rate > 50){
                            this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjByID(1));
                            System.out.println("Tabanca elde edildi.");
                        }
                    }else if(percent > 15 && percent < 30){
                        int odds = a.nextInt(99) + 1;
                        if(odds < 20){
                            this.getPlayer().getInventory().setArmor(Armors.getArmorObjByID(3));
                            System.out.println("Ağır zırh elde edildi.");
                        }else if(odds > 20 && odds < 50){
                            this.getPlayer().getInventory().setArmor(Armors.getArmorObjByID(2));
                            System.out.println("Orta zırh elde edildi.");
                        }else if(odds > 50){
                            this.getPlayer().getInventory().setArmor(Armors.getArmorObjByID(1));
                            System.out.println("Hafif zırh elde edildi.");
                        }
                    }else {
                        System.out.println("Silah ya da zırh elde edilmedi.");
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println("Canavarın Canı: " + this.getObstacle().getHealth());
        System.out.println("-----------------");
    }

    public void playerStats(){
        System.out.println("Oyuncu değerleri");
        System.out.println("-----------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Savunma: " + this.getPlayer().getInventory().getArmor().getDefence());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Para: " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStats(int i){
        System.out.println(i + "." + this.getObstacle().getName() + " değerleri");
        System.out.println("-----------------------");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getAward());
    }

    public boolean isWinGame(){
        return this.getPlayer().getInventory().isFirewood() && this.getPlayer().getInventory().isFood() && this.getPlayer().getInventory().isWater()
                && this.getPlayer().getInventory().isMineRibbon();
    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public int randomObstacleDamage(){
        Random x = new Random();
        Snake snakeObject = new Snake(4);
        return x.nextInt(snakeObject.getMaxDamage()) + 3;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
