package lab.lab14;

/**
 * Created by Juan Carlos on 11/25/2016.
 */
public class Queen extends Character{
    public Queen(WeaponBehavior wb){
        setWeapon(wb);
    }

    public void fight(){
        System.out.print("I am a queen... ");
        weapon.useWeapon();
    }

}
