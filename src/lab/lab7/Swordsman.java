package lab.lab7;

/**
 * Created by Juan Carlos on 12/17/2016.
 */
/*
 * latest edit ~6:02 PM 10/7/16
 * Created by Loewe Alivio, Mike Pacana and Jace Roldan.
 * Source code from Prof Nico Enego
 *
 */
public class Swordsman extends Hero {
    public static final int BASE_ATTACK = 10;
    public static final int BASE_ARMOR = 15; //changed ARMOR to BASE_ARMOR

    public Swordsman(String name) {
        super(name);
        super.setHp(120);
        super.setMana(100);

        stats.attack = BASE_ATTACK;    //call overloaded constructor for stats.java
        stats.armor = BASE_ARMOR;
    }

    public void skillDisp() {
        System.out.println("Skill Set (Swordsman):\n" +
                "1. Attack\n" +
                "2. Bloodlust\n" +
                "3. Guard Stance");
        System.out.print("Choose a skill: ");
        plusMana();
    }

    private void plusMana() {   //regenerate mana before every turn
        if(getMana() + 20 < 100) {
            super.plusMana(20);
        } else {
            super.setMana(100);
        }
    }

    private void buffTurns() {
        if(buffcount1 != 0){
            buffcount1++;       //buffcount1 counts the number of turns for Bloodlust
            if(buffcount1 == 6) {
                buffcount1 = 0;
                stats.attack = BASE_ATTACK; //attack reset to BASE_ATTACK
            }
        }
        if(buffcount2 != 0){
            buffcount2++;       //buffcount2 counts the number of turns for Guard Stance
            if(buffcount2 == 6){    //Guard Stance is erased
                buffcount2 = 0;
                stats.armor = BASE_ARMOR; //armor reset to BASE_ARMOR
            }
        }
    }

    public void attack(int choice, RPGCharacter opponent) { //took out the return type
        buffTurns();
        if(choice == 2) {
            //proceed to attack if insufficient mana for this ability
            if(getMana() - 15 < 0) {
                System.out.println("Mana is too low. Proceed to attack");
                opponent.takeDamage(stats.attack);
                return;
            }
            else if(buffcount1 == 0){
                stats.attack += 5;
            }
            super.minusMana(15);
            buffcount1 = 1;  //even when player calls bloodlust again and again, only the buffcount1 gets reset.
            isBuffed = true;
        }

        else if(choice == 3) {            // buffs for 5 turns + 8 armor
            if(getMana() - 20 < 0) {
                System.out.println("Mana is too low. Proceed to attack");
                opponent.takeDamage(stats.attack);
                return;
            }

            else if(buffcount2 == 0){
                stats.armor += 6;
            }
            super.minusMana(20);
            buffcount2 = 1;
            isBuffed = true;
        }

        else { opponent.takeDamage(stats.attack); }
    }

    public void dispStats(){
        System.out.println("Trained in the great halls of Darumas, the Swordsmen of Kalyos mastered the way of the sword.\n" +
                " They are often found in battlefields to showcase their skills.\n" +
                " Their special skills allow them to enhance their capabilities for a few fold which makes them a terror to soldiers who are encountered by these beasts.\n\n");

        System.out.printf("Class: Swordsman\n\tHP: ******\n\tMana: *****\n\tAttack: **\n\tArmor: ***");//17
        System.out.println("\nSkills: \n\tBloodlust: Damage for 5 turns\n\tGuard Stance: Armor for 5 turns\n");
    }
    public String toString(){
        return super.toString() + "\n\tBase attack = " + stats.attack + " Armor = " + stats.armor;
    }
}