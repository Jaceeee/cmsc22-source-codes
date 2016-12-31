package lab.lab14;

/**
 * Created by Juan Carlos on 11/25/2016.
 */
public abstract class Character {
    WeaponBehavior weapon;

    public abstract void fight();

    public void setWeapon(WeaponBehavior wb){
        weapon = wb;
    }
}
