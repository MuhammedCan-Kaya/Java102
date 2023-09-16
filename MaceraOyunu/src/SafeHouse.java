public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }
    @Override
    public boolean onLocation() {
        if(isWinGame()){
            System.out.println("Bütün ödülleri toplayıp eve geldiniz ve oyunu kazandınız. Tebrikler.");
            return false;
        }
        System.out.println("Güvenli Evdesiniz.");
        System.out.println("Canınız Yenilendi.");
        this.getPlayer().setHealth(this.getPlayer().getBasicHealth());
        return true;
    }

    public boolean isWinGame(){
        return this.getPlayer().getInventory().isFirewood() && this.getPlayer().getInventory().isFood() && this.getPlayer().getInventory().isWater()
                && this.getPlayer().getInventory().isMineRibbon();
    }
}
