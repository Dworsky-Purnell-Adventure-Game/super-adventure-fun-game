import java.util.Scanner;

public class Adventure {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);

        // play game?
        System.out.println("Would you like to begin your adventure? [Yes/No]");
        String confirmation = s.next();
        s.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Let's begin...");
        } else {
            System.out.println("Adventure another day then.");
        }

        // name
        System.out.println("What is your name, adventurer?");
        String userName = s.nextLine();
        System.out.printf("Welcome, %s.%n", userName);

        // begin in dungeon
        // decide which weapon to pick up
        System.out.println("Having fought your way deep into the dungeon, you trusty sword has shattered. You see 2 rusty weapons - a shortsword and an axe - laying on the floor. Which do you pick up?");

        String weaponChoice = s.nextLine();

        if (weaponChoice.contains("sword")) {
            System.out.println("You pick up the sword.");
        } else if (weaponChoice.contains("axe")) {
            System.out.println("You pick up the axe");
        } else {
            System.out.println("You continue with no weapon.");
        }

        // continue down dungeon - roll dice to advance
        System.out.println("You look ahead - the dungeon is dark. Leaving it to chance, you pull out your trusted 20-sided die to see how far to venture");
        System.out.println("You roll to see how far you go [R]oll");

        int heroDiceSides = s.nextInt();
        double diceRoll = diceRoll(heroDiceSides);

        if (diceRoll >= 5) {

        } else if (diceRoll >= 10) {

        } else if (diceRoll >= 15) {

        } else {

        }
        // 5 different encounters to start - dice roll dictates which encounter happens
        // end of dungeon - boss battle




    }

    public static double diceRoll(int num) {
        double diceRoll = (Math.random() * num) + 1;
        return diceRoll;
    }
//        //Enemy 1 - Goblin
//        public static int Goblin() {
//
//    }
//
//    public static int HeroStats() {
//        int HP = 50;
//        int Potions = 5; // 20 pts of health
//        String Weapon = "";
//
//    }


}
