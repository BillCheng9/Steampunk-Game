public class Rock implements Enemy{
    String name = "LITERAL ROCK";
    int defense = 1;
    int health = 23;
    int damage = 0;
    Combat_Dialogue d = new Combat_Dialogue(this);

    public int short_attack() throws InterruptedException {
        d.print("rock_move");
        return 0;
    }

    public int charge_attack() throws InterruptedException {
        return short_attack();
    }

    public void increase_stat() throws InterruptedException {
        d.print("rock_special");
        health += 5;
    }

    public int getHealth() { return health; }

    public boolean healthCheck() {
        if (health <= 0) {
            return false;
        }
        return true;
    }

    public int attacked(int value){
        if (value > 0) {
            int dmgValue = value - defense;
            if (dmgValue <= 1) {
                health--;
                return 1;
            } else {
                health -= dmgValue;
                return dmgValue;
            }
        }
        else return 0;
    }

    public String getName() {
        return name;
    }
}
