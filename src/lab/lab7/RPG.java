package lab.lab7;

/**
 * Created by Juan Carlos on 12/17/2016.
 */
/*
 * latest edit ~06:02 am 10/7/16
 * Created by Loewe Alivio, Michael Pacana and Jace Roldan
 * Source code from Prof Nico Enego
 */

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.*;
import java.io.*;

public class RPG {

    private Random rand;

    // constructor
    public RPG() {
        this.rand = new Random();
    }

    // generate a random monster name..
    public String getRandomMonsterName() {
        String[] adjectives = {"Flame", "Sea", "Nature"};
        String[] monsters = {"Basilisk", "Griffyn", "Dragon"};
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);

        return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    // coin toss
    public boolean coinToss() {
        return randInt(0, 1) == 1 ? true : false;
    }   //coin toss needs to change

    // pause the game for awhile for dramatic effect!
    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public boolean duel(RPGCharacter attacker, RPGCharacter defender,boolean turn,int PVP) {
        int choice;

        if(turn) {
            Hero type = (Hero) attacker;
            type.skillDisp();
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            for(;choice<0 || choice>3;choice = sc.nextInt());
        }
        else {
            if(PVP == 1) {
                Hero type = (Hero) attacker;
                type.skillDisp();
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();
                for(;choice<0 || choice>3;choice = sc.nextInt());
            }
            else {    //monster
                choice = 1;
            }
        }

        sleep(0);

        if(attacker.isParalysed()) {
            System.out.println("\n~ " + attacker.getName() + " is paralyzed." + attacker.getName() + " cannot move.\n");
        } else if(!coinToss() && choice == 1){
            System.out.println(attacker.getName() + "'s attack missed!\n");
        } else {
            attacker.attack(choice,defender);
            if(attacker.isBuffing()){
                System.out.println("\n~ " + attacker.getName() + " activated a buff. "+"\n");
            }
            else{
                System.out.println("\n~ " + attacker.getName() + " attacked " + defender.getName() + "\n");
            }
            sleep(0);

            if (!defender.isAlive()) {
                System.out.printf("\n~ %s killed %s!\n", attacker.getName(), defender.getName());
                return true;
            }
        }
        attacker.negateBuff();
        return false;
    }

    public static RPGCharacter newHero(String name) {
        RPGCharacter hero = new Swordsman(name);
        for(boolean choice=false; choice==false;){
            int ans;
            Scanner sc = new Scanner(System.in);
            clearScreen();//taaas ra kaayu //
            System.out.printf("What is your class?\n\t1.Swordsman\n\t2.Mage\n\t3.Assassin\n\t4.Druid\n\t5.Archer\n\t6.Paladin\nChoose: ");
            for(ans=0 ;ans <= 0 || ans > 6 ;ans = sc.nextInt());
            clearScreen();
            if(ans==2){ hero = new Mage(name); }
            else if(ans==3){ hero = new Assassin(name); }
            else if(ans==4){ hero = new Druid(name); }
            else if(ans==5){ hero = new Archer(name); }
            else if(ans==6){ hero = new Paladin(name); }
            hero.dispStats();
            System.out.printf("Are you sure about this class? Choose the number of your choice \n\t1. Yes\n\t2. No\n");
            int sure;
            for(sure=0; sure!=1 && sure!=2; sure=sc.nextInt());
            if (sure==1){
                choice=true;
            }
        }
        return hero;
    }


    public static void main(String[] args) {
        //to determine if it is the hero turn.. this is so in order for the hero to choose a skill
        boolean heroturn = true;
        RPG rpg = new RPG();
        Scanner sc = new Scanner(System.in);
        for(boolean playagain=true; playagain==true;){
            clearScreen();
            System.out.println("\n\n\t\t\tWelcome to the gladiator arena of Sarumsaas!!\n" +
                    " Warriors all over the world of Exios gathered here to compete and sought the ultimate prize of acquiring the Golden Protator.\n" +
                    " It is said to give whoever acquires it an eternal life and glory.\n" +
                    " Warriors are to compete against ancient and brutal monsters that are said to have ravaged the world during the Age of the Gods.\n" +
                    " Warriors, do not fret in this battle. This may be your last but what awaits you is the glory sought by all. Now, LET THE GAMES BEGIN!\n\n");
            System.out.println("Would you like to play the PVP mode?\n\t1. Yes\n\t2. No");
            int PVP;
            for(PVP = 0; PVP != 1 && PVP != 2; PVP = sc.nextInt());

            System.out.printf("Hello Adventurer! Welcome to the gladiator arena of Sarumsaas!\nWhat is your name? ");
            String name = sc.next();
            RPGCharacter hero = newHero(name);
            RPGCharacter monster;

            clearScreen();
            if(PVP == 1) {
                System.out.printf("Hello Adventurer! Welcome to the gladiator arena of Sarumsaas!\nWhat is your name? ");
                String name2 = sc.next();
                monster = newHero(name2);
            }
            else {
                int ans;
                clearScreen();
                System.out.printf("Please enter the difficulty level:\n\t1-Noob\n\t2-Chill\n\t3-Insane\n ");
                for (ans = -1; ans < 0 || ans > 4; ans = sc.nextInt()) ;
                int hph = 0, hpl = 0, ah = 0, al = 0;
                if (ans == 1) {
                    hph = 130;
                    hpl = 100;
                    ah = 20;
                    al = 15;
                } else if (ans == 2) {
                    hph = 150;
                    hpl = 130;
                    ah = 30;
                    al = 20;
                } else if (ans == 3) {
                    hph = 170;
                    hpl = 150;
                    ah = 40;
                    al = 30;
                }
                monster = new Monster(rpg.getRandomMonsterName(), rpg.randInt(hpl, hph), rpg.randInt(al, ah));
            }

            clearScreen();
            System.out.println("====== GAME START ======");
            System.out.printf("%s\n%s\n", hero, monster);
            // fight! for version 1, hero will always attack first.
            int count = 0;
            while (true) {
                System.out.println("\n  == ROUND " + ++count +"==\n");
                // hero's turn
                boolean monsterIsDead = rpg.duel(hero, monster,heroturn,PVP);
                heroturn = false;
                if (monsterIsDead){System.out.println("\nYou have won. The monsters have lost the battle."); break;}
                // monster's turn
                boolean heroIsDead = rpg.duel(monster, hero,heroturn,PVP);
                heroturn = true;
                if (heroIsDead) {System.out.println("\nYou have lost. The monsters have won.");break;}
                System.out.println("\nPress any key to continue...");
                try
                {
                    System.in.read();
                }
                catch(Exception e){}
                clearScreen();
                System.out.printf("%s\n%s\n", hero, monster);
            }
            clearScreen();
            System.out.printf("%s\n%s\n\n", hero, monster);
            System.out.print("Do you want to play again?\n\t1.Yes\n\t2.No\n");
            int pa;
            for(pa=0;pa!=1 && pa!=2;pa=sc.nextInt());
            if(pa==2){
                playagain=false;
            }
        }
    }
}