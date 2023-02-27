
public interface Enemy {

    public String getName();
    public int short_attack() throws InterruptedException;

    public int charge_attack() throws InterruptedException;

    public void increase_stat();

    public boolean healthCheck();
}
