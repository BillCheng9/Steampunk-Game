
public interface Enemy {

    public String getName();
    public int getHealth();
    public int attacked(int value);
    public int short_attack() throws InterruptedException;

    public int charge_attack() throws InterruptedException;

    public void increase_stat() throws InterruptedException;

    public boolean healthCheck();
}
