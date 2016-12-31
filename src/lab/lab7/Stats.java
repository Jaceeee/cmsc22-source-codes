package lab.lab7;

/**
 * Created by Juan Carlos on 12/17/2016.
 */
//auxiliary class made for composition
public class Stats {
    public String name;

    public int hp;
    public int mana;
    public int attack;
    public int armor;

    public boolean paralysisStatus;
    public boolean poisonStatus;

    public Stats(String name){ //overloaded constructor for composite class Stats
        this.name = name;
        paralysisStatus = poisonStatus = false;
    }
}