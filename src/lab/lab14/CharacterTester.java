package lab.lab14;

/**
 * Created by Juan Carlos on 11/25/2016.
 */
public class CharacterTester {
    public static void main(String[] args){
        WeaponBehavior wb = new KnifeBehavior();
        Character c = new King(wb);
        c.fight();

        wb = new BowAndArrowBehavior();
        c = new Queen(wb);
        c.fight();

        wb = new SwordBehavior();
        c = new Knight(wb);
        c.fight();

        wb = new AxeBehavior();
        c = new Troll(wb);
        c.fight();

        wb = new KnifeBehavior();
        c = new Troll(wb);
        c.fight();

        wb = new BowAndArrowBehavior();
        c = new Knight(wb);
        c.fight();

        wb = new SwordBehavior();
        c = new Queen(wb);
        c.fight();

        wb = new AxeBehavior();
        c = new King(wb);
        c.fight();
    }
}
