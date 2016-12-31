package lab.lab7;

/*
 * latest edit ~6:02 PM 10/7/16
 * Source code from Prof Nico Enego
 * Created by Loewe Alivio, Michael Pacana and Jace Roldan
 */

public abstract class RPGCharacter {
    protected Stats stats;

    public RPGCharacter(String name) {
        stats = new Stats(name);
    }

    public abstract void negateBuff();
    // implement in subclass
    public abstract void attack(int choice, RPGCharacter opponent);
    //
    public abstract boolean isBuffing();
    // checks to see if character is still alive
    public abstract void dispStats();
    public boolean isAlive() {
        return stats.hp > 0 ? true : false;
    }

    //changed the takeDamage into void type
    public void takeDamage(int damage) {
        damage -= stats.armor;

        if(damage < 0){ //if damage is less than 0, i don't want to increase health! Ha-ha.
            damage = 0;
        }
        stats.hp -= damage;
    }

    //for poison and paralysis effects
    public void takeEffect(int condition) {
        if(condition == 1) {
            stats.poisonStatus = true;
        } else if(condition == 2) {
            stats.paralysisStatus = true;
        }
    }

    //for restoring to normal..
    public void restoreNormal(int condition) {
        if(condition == 1){
            stats.poisonStatus = false;
        } else if(condition == 2) {
            stats.paralysisStatus = false;
        }
    }

    public void damagePerSecond(int dps) {
        if(stats.poisonStatus) { stats.hp -= dps; }
    }

    //changed the minusMana to void
    public void minusMana(int special){
        stats.mana -= special;
    }

    // getters setters
    public String getName() {
        return stats.name;
    }

    public void setName(String name) {
        stats.name = name;
    }

    public int getHp() {
        return stats.hp;
    }

    public void setHp(int hp) {
        stats.hp = hp;
    }

    //use this function in the main to determine whether turn is not affected
    public boolean isParalysed() { return stats.paralysisStatus; }

    public int getMana() { return stats.mana; }

    public void setMana(int mana) { stats.mana = mana; }

    @Override
    public String toString() {
        String life = "", mn = "";
        if(stats.hp < 0) {
            stats.hp = 0;
        }
        for(int i=0; i < stats.hp; i += 4) {
            life = String.format(life + "|");
        }
        for(int i=0; i < stats.mana; i += 4) {
            mn = String.format(mn + "|");
        }
        if(stats.mana!=0) {
            return "Name of Hero: " + stats.name + "\n\tHP:\t[" + stats.hp + "]\t(" + life + ")" + "\n\tMP:\t[" + stats.mana + "]\t(" + mn + ")";
        }
        else {
            return "Opponent: " + stats.name + "\n\tHP:\t[" + stats.hp + "]\t(" + life + ")";
        }
    }
}