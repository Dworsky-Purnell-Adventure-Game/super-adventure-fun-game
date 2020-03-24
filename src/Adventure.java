import java.util.*;

public class Adventure {
    public static void main(String[] args) {
        String heroName = "";
        int heroHP = 50;
        int heroPotions = 5; // 20 pts of health
        String heroWeapon = "";
        int goblinHealth = 10;
        int goblinAttack = 5;


        Scanner s = new Scanner(System.in);

        // START GAME
        System.out.println("Would you like to begin your adventure? [Yes/No]");
        String confirmation = s.next();
        s.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Let's begin...");


            // HERO NAME
            System.out.println("What is your name, adventurer?");
            heroName = s.nextLine();
            System.out.printf("Welcome, %s.%n", heroName);

            // INTRO - WEAPON SELECTION
            System.out.println("You are in a dungeon with no weapon.");
            System.out.println("Ahead of you lies a [S]word and an [A]xe.");
            System.out.println("Which weapon do you pick up?");
            heroWeapon = weaponSelection();
            System.out.print("\n\nYou found: " + heroWeapon + "\n\n");
            playerStatus(heroHP, heroWeapon);


            // GOBLIN ENCOUNTER
            System.out.println("Ahead you encounter a goblin - what would you like to do?");
            do {
                System.out.println("Choose an action.");
                System.out.println("Goblin | HP: " + goblinHealth);
                System.out.printf("%s | HP: %d%n[A]ttack | [P]otion | [R]un%n", heroName, heroHP);
                String goblinEncounter = s.next();

                if (goblinEncounter.equalsIgnoreCase("a")) {
                    int attackValue = attackValue(heroWeapon);
                    goblinHealth -= attackValue;
                    heroHP -= goblinAttack;
                    System.out.printf("You hit for %d%n", attackValue);
                    System.out.printf("The goblin attacks for %d%n", goblinAttack);
                }
//             else if (goblinEncounter.equalsIgnoreCase("p")) {
//                if (heroHP == 50) {
//                    System.out.println("Already at full health! It had no effect!");
//                } else if (heroHP < 30) {
//                    // add 20 to hp
//                } else {
//                    System.out.println("Fully recovered health");
//                    heroHP = 50;
//                }
//            } else if (goblinEncounter.equalsIgnoreCase("r")) {
//
//            } else {
//                System.out.println("Please choose 1 of your options");
//            }
            } while (goblinHealth > 0 && heroHP > 0);
            System.out.println("You defeated the goblin!");

            // 2 ORC ENCOUNTER

            // PEPE BOSS BATTLE
        } else {
            System.out.println("Adventure another day then.");
        }

    }







    // WEAPON SELECTION
    public static String weaponSelection() {
        Scanner s = new Scanner(System.in);
        String weaponChoice = s.next();

        if (weaponChoice.equalsIgnoreCase("s")) {
            return "Sword" + weaponNamer();
        } else if (weaponChoice.equalsIgnoreCase("a")) {
            return "Axe" + weaponNamer();
        } else {
            return "Unarmed";
        }
    }

    // WEAPON NAMER
    public  static String weaponNamer(){
        // Name generator
        // A List to hold all the names
        List<String> namesList = new ArrayList<>();
// Create the full list of names
        String[] names = {" of Gondor", " of Dragon's Breath", " of Kevin", " of Kaleb's Fury", " made of Chicken Bone", " of Corona"};
// Store them into the List
        namesList = new ArrayList(Arrays.asList(names));
// Randomly get the first part of the name
        int randomIndex = new Random().nextInt(names.length - 1);
        String weaponName = namesList.get(randomIndex);
// Randomly shuffle the list
        long seed = System.nanoTime();
        Collections.shuffle(namesList, new Random(seed));
        // System.out.println("\nGenerated name: " + weaponName);
        return weaponName;
    }

    // PLAYER STATUS
    public static void playerStatus(int hp, String wpn) {
        System.out.print( "┌─────────────────────────────────────────────────────────┐ \n");
        System.out.print("│ HP ");
        for (int i = 0; i <= hp; i++) {
            System.out.print("▒");
        }
        System.out.print("\n│ \u2694Equipped: " + wpn + "\n");
        System.out.print("└─────────────────────────────────────────────────────────┘\n");
    }

    // ATTACK VALUE
    public static int attackValue(String weapon) {
        int axeRandom = (int) (Math.floor(Math.random() * 10)) + 1;
        int unarmedRandom = (int) (Math.floor(Math.random() * 5)) + 1;

        if (weapon.equals("sword")) {
            return 5;
        } else if (weapon.equals("axe")) {
            return axeRandom;
        } else {
            return unarmedRandom;
        }
    }

    // GOBLIN FIGHT
//    public static int goblinFight() {
//
//    }
}
