package lab.lab7;

/* latest edit ~6:03 PM 10/7/16
 * Source code from Prof Nico Enego
 * Created by Loewe Alivio, Michael Pacana and Jace Roldan
 *
 */

public class Assassin extends Hero {
    public static final int BASE_ATTACK = 15;
    public static final int BASE_ARMOR = 10;

    public Assassin(String name){
        super(name);
        super.setHp(100);
        super.setMana(80);

        stats.attack= BASE_ATTACK;
        stats.armor= BASE_ARMOR;
    }

    public void skillDisp() {
        System.out.println("Skill set (Assassin):\n" +
                "1.Attack\n" +
                "2.Deadly Poison\n" +
                "3.Slice and Dice\nChoose a skill:");  //subject to change
        plusMana();
    }

    private void plusMana() {
        if(getMana() + 8 < 80) {   //plus mana
            super.plusMana(8);
        }
        else {
            super.setMana(80);
        }
    }

    private void buffturns(RPGCharacter opponent) {
        if(buffcount1 != 0) {
            buffcount1++;       //buffcount turns
            opponent.damagePerSecond(5);
            if(buffcount1 == 5) {
                buffcount1 = 0;
                opponent.restoreNormal(1);
            }
        }
    }

    //special attacks more or less mao ni ilang special moves
    public void attack(int choice, RPGCharacter opponent){
        buffturns(opponent);

        opponent.restoreNormal(2); //restores paralysisStatus to false

        if(choice == 2) {
            if(getMana() - 25 < 0 ) {
                System.out.println("Mana is too low. Proceed to attack.");
                opponent.takeDamage(stats.attack);
                return;
            }
            buffcount1 = 1;
            opponent.takeEffect(1);
            super.minusMana(25);
            opponent.takeDamage(stats.attack + 7);
        }

        else if(choice == 3) {
            //highest physical damage among hero types
            if(getMana() - 35 < 0 ) {
                System.out.println("Mana is too low. Proceed to attack.");
                opponent.takeDamage(stats.attack);
            }
            else{
                super.minusMana(35);
                opponent.takeDamage(stats.attack + 9);
            }
        }
        else { opponent.takeDamage(stats.attack); }
    }

    public void dispStats(){
        System.out.println("The Elite Assassins of the Black Heart Syndicate are among the dangerous of their kind.\n" +
                " These highly trained assassins perform their duties in a swift and silent manner leaving them no trace to follow.\n" +
                " In the underground world, they are often hired to assassinate shady individuals.\n" +
                " More often than not, they are successful in their operations.\n" +
                " Usually, the corpses of their targets are testified to be in a zombified state.\n\n");

        System.out.printf("Class: Assassin\n\tHP: *****\n\tMana: ****\n\tAttack: ***\n\tArmor: **");//15
        System.out.println("\nSkills: \n\tDeadly Poison DPS damage  for 4 turns\n\tSlice and Dice: Physical Damage\n");
    }
    public String toString() {
        return super.toString() + "\n\tBase attack = " + stats.attack + " Armor = " + stats.armor;
    }
}