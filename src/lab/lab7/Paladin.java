package lab.lab7;

/* latest edit ~6:03 PM 10/7/16
 * Source code from Prof Nico Enego
 * Created by Loewe Alivio, Michael Pacana and Jace Roldan
 */

public class Paladin extends Hero{
    public static final int BASE_ATTACK = 15;
    public static final int BASE_ARMOR = 15;

    public Paladin(String name) {
        super(name);
        super.setHp(140);
        super.setMana(60);

        stats.attack = BASE_ATTACK;    //call overloaded constructor for stats.java
        stats.armor = BASE_ARMOR;
    }

    public void skillDisp() {
        System.out.println("Skill set (Paladin):\n" +
                "1. Attack\n"+
                "2. Divine Blessing\n" +
                "3. Righteous Shield");
        System.out.print("Choose a skill: ");
        plusMana();
    }

    private void plusMana() {   //regen mana every turn
        if(getMana() + 5 < 60) {
            super.plusMana(5);
        }
        else {
            super.setMana(60);
        }
    }

    private void buffturns() {
        if(buffcount2 != 0) {
            buffcount2++;
            if(buffcount2 == 5) {
                buffcount2 = 0;
                stats.armor = BASE_ARMOR;
            }
        }
    }

    public void attack(int choice,RPGCharacter opponent) {//attacks & special attacks

        buffturns();

        opponent.restoreNormal(2);

        if(choice == 2) {  //heal
            if(getMana() - 17 < 0) {
                System.out.println("Mana is too low. Proceed to attack.");
                opponent.takeDamage(stats.attack);
            }

            int health = super.getHp();
            if(health + 25 > 140) {
                super.setHp(140);
            }
            else{
                super.setHp(25 + health);
            }

            super.minusMana(17);
        }

        else if(choice == 3){ //armor buff
            if(getMana() - 20 < 0) {
                System.out.println("Mana is too low. Proceed to attack.");
                opponent.takeDamage(stats.attack);
                return;
            }

            else if(buffcount2 == 0) {
                stats.armor += 10;
            }
            super.minusMana(30);
            buffcount2 = 1;
            isBuffed = true;
        }
        else { opponent.takeDamage(stats.attack); }
    }

    public void dispStats(){
        System.out.println("The Kalyos Paladins pledged their oath and loyalty to the God Father, Sindros, as their testament to follow the path of righteousness.\n" +
                " Oftentimes, they are sent by the Kalyos Empire to eradicate monsters that threaten to destroy the country as one of its elite forces.\n" +
                " Their charismatic fervor in the battlefield gave their allies a boost to their morale, and enemies and monsters alike shudder at their inevitable death.\n\n");

        System.out.printf("Class: Paladin\n\tHP: *******\n\tMana: ***\n\tAttack: ***\n\tArmor: ***");//17
        System.out.println("\nSkills: \n\tDivine Blessing: Heal\n\tRighteous shield: Buffs Armor for 5 turns\n");
    }

    public String toString(){
        return super.toString() + "\n\tBase attack = " + stats.attack + " Armor = " + stats.armor;
    }
}