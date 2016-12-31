package lab.lab7;

/*
* latest edit ~9:00 AM 10/6/16 by Jace
* Source code from Prof Nico Enego
* Created by Loewe Alivio, Michael Pacana and Jace Roldan
*
*/

public class Monster extends RPGCharacter{
    //need changes and improvements

    private int attackDamage;

    public Monster(String name, int hp, int attackDamage) {
        super(name);
        setHp(hp);
        this.attackDamage = attackDamage;
    }

    public void attack(int choice, RPGCharacter opponent){
        opponent.takeDamage(attackDamage);
    }

    public void takeDamage(int damage) {
        stats.hp -= damage;
    }

    public void negateBuff() { }

    public void dispStats() { }

    public boolean isBuffing(){ return false; }

    public String toString() {
        return super.toString() + "\n\tBase Damage = " + attackDamage;
    }
}