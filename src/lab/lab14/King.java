package lab.lab14;

import java.lang.*;

/**
 * Created by Juan Carlos on 11/25/2016.
 */
public class King extends Character {
    public King(WeaponBehavior wb){
        setWeapon(wb);
    }

    public void fight() {
        System.out.print("I am a king... ");
        weapon.useWeapon();
    }
}
