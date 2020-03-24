import java.util.Scanner;

public class Adventure {
    public static void main (String[] args) {
        int hp = 50;
        int potions = 5; // 20 pts of health
        String weapon = "";


        Scanner s = new Scanner(System.in);

        // START GAME
        System.out.println("Would you like to begin your adventure? [Yes/No]");
        String confirmation = s.next();
        s.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Let's begin...");
        } else {
            System.out.println("Adventure another day then.");
        }

        // HERO NAME
        System.out.println("What is your name, adventurer?");
        String userName = s.nextLine();
        System.out.printf("Welcome, %s.%n", userName);

        // WEAPON SELECTION
        System.out.println("You are in a dungeon with a broken weapon.");
        System.out.println("Ahead of you lies a [S]hortsword and an [A]xe.");
        System.out.println("Which weapon do you pick up?");
        weapon = weaponSelection();


        // GOBLIN ENCOUNTER
        System.out.println("Ahead you encounter a goblin - what would you like to do?");
        System.out.println("[A]ttack | [P]otion | [R]un");

        String goblinEncounter = s.next();

        if (goblinEncounter.equalsIgnoreCase("a")) {
            System.out.println("Goblin | HP: 10");
            System.out.println(userName + " | HP: 50");

        }

        // 2 ORC ENCOUNTER

        // PEPE BOSS BATTLE

    }

    public static String weaponSelection() {
        Scanner s = new Scanner(System.in);
        String weaponChoice = s.next();

        if (weaponChoice.equalsIgnoreCase("s")) {
            System.out.println("You pick up the sword.");
            return "sword";

        } else if (weaponChoice.equalsIgnoreCase("a")) {
            System.out.println("You pick up the axe");
            return "axe";
        } else {
            System.out.println("You continue with no weapon.");
            return "none";
        }
    }
}
