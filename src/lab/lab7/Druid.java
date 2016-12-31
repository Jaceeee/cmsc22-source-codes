package lab.lab7;

/*latest edit ~6:03 PM 10/7/16
 * Source code fron From Nico Enego
 * Created by Loewe Alivio, Michael Pacana and Jace Roldan
 */
public class Druid extends Hero {
    public static final int BASE_ATTACK = 10;
    public static final int BASE_ARMOR = 5;

    public Druid(String name) {
        super(name);
        super.setHp(120);
        super.setMana(100);

        stats.attack= BASE_ATTACK;
        stats.armor= BASE_ARMOR;
    }

    public void skillDisp() {
        System.out.println("Skill set (Druid):\n" +
                "1.Attack\n" +
                "2.Werwolf Aspect\n" +
                "3.Shocking Touch");
        System.out.print("Choose a skill: ");
        plusMana();
    }

    private void plusMana() {   //plus mana in every turn
        if(getMana() + 10 < 100) {
            super.plusMana(10);
        }
        else {
            super.setMana(100);
        }
    }

    private void buffturns() {
        if(buffcount1 != 0){
            buffcount1++;       //gs ctr increases
            if(buffcount1 == 5){    //gserased
                buffcount1 = 0;
                stats.armor -= 6;
                stats.attack -= 10;
            }
        }
    }

    public void attack(int choice, RPGCharacter opponent) {
        buffturns();

        opponent.restoreNormal(2);
        if(choice == 2) {
            //transformation
            //werewolf for 4 turns;

            if(getMana() - 15 < 0) {
                System.out.println("Mana is too low. Proceed to attack.");
                opponent.takeDamage(stats.attack);
                return;
            }

            if(buffcount1 == 0) {
                stats.armor += 6;
                stats.attack += 10;
            }

            super.minusMana(15);
            buffcount1 = 1;
            isBuffed = true;
        }
        else if(choice == 3) {
            //shocking spell nature power
            //once every turn the enemy will paralyze.. the enemy won't move sa kana nga turn
            if(getMana() - 20 < 0) {
                System.out.println("Mana is too low. Proceed to attack.");
                opponent.takeDamage(stats.attack);
                return;
            }

            super.minusMana(35);
            opponent.takeEffect(2); //it means the enemy is paralyzed
            opponent.takeDamage(stats.attack + 7);
        }

        else { opponent.takeDamage(stats.attack); }
    }

    public void dispStats(){
        System.out.println("The Ra-Ahaya Druids of The Great Alfatrar Forest are among " +
                "the most vicious druids in the world of Exios.\n" +
                " They are feared for their Werewolf Aspect bestowed " +
                "upon by the Cursed Dark God, Vala.\n" +
                " Their vicious and cannibalistic ways make them one of the greatest threats in Exios.\n\n");

        System.out.printf("Class: Druid\n\tHP: ******\n\tMana: *****\n\tAttack: **\n\tArmor: *");//15
        System.out.println("\nSkills: \n\tWerewolf Aspect: Additional Armor for 5 turns\n\tShocking Touch: Opponent is unable to move for 5 turns\n");
    }

    public String toString() {
        return super.toString() + "\n\tBase attack = " + stats.attack + " Armor = " + stats.armor;
    }
}