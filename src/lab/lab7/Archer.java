package lab.lab7;

/* latest edit ~6:03 PM 10/7/16
 * Source code from Prof Nico Enego
 * Created by Loewe Alivio, Michael Pacana and Jace Roldan
 *
 */

public class Archer extends Hero {
    //same stats as assassin
    //higher accuracy than assassin but weaker armor
    //need changes and improvements
    public static final int BASE_ATTACK = 15;
    public static final int BASE_ARMOR = 5;

    public Archer(String name){
        super(name);
        super.setHp(120);
        super.setMana(60);

        stats.armor= BASE_ARMOR;
        stats.attack= BASE_ATTACK;
    }

    public void skillDisp() {
        System.out.println("Skill set (Archer):\n" +
                "1.Attack\n" +
                "2.Cobra Shot\n" +
                "3.Paralysing Barrage\n");
        System.out.println("Choose a skill: ");
        plusMana();
    }

    private void plusMana() {   //plus mana in every turn
        if(getMana() + 10 < 60) {
            super.plusMana(10);
        }
        else {
            super.setMana(60);
        }
    }

    private void buffturns(RPGCharacter opponent) {
        if(buffcount1 != 0) {
            buffcount1++;       //buffcount turns
            if(buffcount1 == 5) {
                buffcount1 = 0;
                opponent.restoreNormal(1);
            }
            opponent.damagePerSecond(4); //add these lines to all heroes with poison effect attacks
        }
    }

    public void attack(int choice, RPGCharacter opponent){ //add coin toss variable here
        buffturns(opponent);

        opponent.restoreNormal(2); //before every attack, we restore the paralysis status to false

        if(choice == 2){
            if(getMana() - 20 < 0) {
                System.out.println("Mana is too low. Proceed to attack.");
                opponent.takeDamage(stats.attack);
                return;
            }

            buffcount1 = 1;
            super.minusMana(20);

            opponent.takeEffect(1);
            //in every turn ma damage ang kontra let's say 5 turns
            //poison arrow
            //i add pa nig Damage per Second sa enemy
            opponent.takeDamage(stats.attack + 2);
        }
        else if(choice == 3) {
            //paralysis arrow
            //once in every turn ma paralyse ang enemy... cannot move
            if(getMana() - 20 < 0) {
                System.out.println("Mana is too low. Proceed to attack.");
                opponent.takeDamage(stats.attack);
            }

            super.minusMana(20);
            opponent.takeEffect(2);
            opponent.takeDamage(stats.attack + 4);
        }

        else { opponent.takeDamage(stats.attack); }
    }

    public void dispStats(){
        System.out.println("The skill of the Duhr Hunters is admired and feared by the people living in The Great Alfatrar Forest.\n" +
                " Their poison arrows leave their opponents in a screeching pain, giving them a horrifying death.\n" +
                " Escaping is impossible for their paralysing arrows will leave their opponents in a standstill.\n" +
                " Though, it is not exactly their existence that is feared by their opponents" +
                " but the firing of their arrows which could be liken to a cry of a banshee.\n\n");

        System.out.printf("Class: Archer\n\tHP: ******\n\tMana: ***\n\tAttack: ***\n\tArmor: *");//15
        System.out.println("\nSkills: \n\tCobra Shot: Poison Damage for 5 turns\n\tParalysis Barrage: Opponent is unable to move for 5 turns\n");
    }

    public String toString(){
        return super.toString() + "\n\tBase attack = " + stats.attack + " Armor = " + stats.armor;
    }
}
