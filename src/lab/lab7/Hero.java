package lab.lab7;

/*
 * latest edit ~10:00 PM 10/6/16
 * Source code from Prof Nico Enego
 * Created by Loewe Alivio, Michael Pacana and Jace Roldan
 */

public abstract class Hero extends RPGCharacter{
    protected int buffcount1; //for counting buff turns
    protected int buffcount2; //for counting buff turns

    protected boolean isBuffed;

    public boolean isBuffing() {
        return isBuffed;
    }

    public void negateBuff() { isBuffed = false; }

    public Hero(String name) {
        super(name);
    }

    public abstract void skillDisp();
    //overwritten depende sa hero type

    public void plusMana(int points){
        setMana(getMana() + points);
    }
}