package lab.lab7;

/* latest edit ~6:03 PM 10/7/16
 * Source code from Prof Nico Enego
 * Created by Loewe Alivio, Michael Pacana and Jace Roldan
 */
public class Mage extends Hero {
    public static final int BASE_ATTACK = 5;
    public static final int BASE_ARMOR = 5;

    public Mage(String name){
        super(name);
        super.setHp(100);
        super.setMana(140);

        stats.attack= BASE_ATTACK;
        stats.armor= BASE_ARMOR;
    }

    public void skillDisp() {
        System.out.println("Skill set (Mage):\n" +
                "1.Attack\n" +
                "2.Fireball\n" +
                "3.Curse of Madness");
        System.out.print("Choose a skill: ");
        plusMana();
    }

    private void plusMana() {   //plus mana in every turn
        if(getMana() + 7 < 140) {
            super.plusMana(7);
        }
        else {
            super.setMana(140);
        }
    }

    private void buffturns(RPGCharacter opponent) {
        if(buffcount2 != 0) {
            buffcount2++;       //buffcount turns
            opponent.damagePerSecond(8);
            if(buffcount2 == 4) {
                buffcount2 = 0;
                opponent.restoreNormal(1);
            }
        }

    }


    //special attacks more or less mao ni ilang special moves
    public void attack(int choice,RPGCharacter opponent) {
        buffturns(opponent);

        opponent.restoreNormal(2);

        if(choice == 2) {
            if(getMana() - 35 < 0 ) {
                System.out.println("Mana is too low. Proceed to attack.");
                opponent.takeDamage(stats.attack);
                return;
            }

            super.minusMana(35);
            opponent.takeDamage(stats.attack + 12);
        }
        else if(choice == 3) {
            if(getMana() - 20 < 0) {
                System.out.println("Mana is too low. Proceed to attack.");
                opponent.takeDamage(stats.attack);
                return;
            }

            super.minusMana(20);
            buffcount2 = 1;
            opponent.takeEffect(1);

            opponent.takeDamage(stats.attack + 5);
        }

        else { opponent.takeDamage(stats.attack); }
    }

    public void dispStats(){
        System.out.println("The Mages of the Daran studied the ways of the Arcane.\n" +
                " Their mastery over magic is constantly sought by the countries of Exios for it is a strong asset in the battlefield.\n" +
                " But, these mages are often secluded in the outside world in order for them to continue pursue the secrets of the Arcane.\n\n");

        System.out.printf("Class: Mage\n\tHP: *****\n\tMana: *******\n\tAttack: *\n\tArmor: *");//15
        System.out.println("\nSkills: \n\tFireball: Flame Damage Attack \n\tCurse of Madness: Curse Damage for 4 turns\n");
    }
    public String toString() {
        return super.toString() + "\n\tBase attack = " + stats.attack + " Armor = " + stats.armor;
    }
}