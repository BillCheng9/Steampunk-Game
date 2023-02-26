public class Worker implements Enemy{
    String name = "Worker Bot";
    int defense = 5;
    int health = 5;
    int damage = 5;
    public String short_attack(){return "";};

    public String charge_attack(){return "";};

    public String increase_stat(){return "";};

    public boolean healthCheck() {
        if (health <= 0) {
            return false;
        }
        return true;
    }
}
