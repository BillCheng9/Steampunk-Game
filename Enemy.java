
public interface Enemy {

    String name = "enemy.TYPE";
    int defense = -1;
    int health = -1;
    int damage = -1;
    public int short_attack() throws InterruptedException;

    public int charge_attack() throws InterruptedException;

    public void increase_stat();

    public boolean healthCheck();
}
