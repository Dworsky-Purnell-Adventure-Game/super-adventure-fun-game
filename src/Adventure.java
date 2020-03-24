import java.util.*;
import java.util.concurrent.TimeUnit;

public class Adventure {
    public static void main(String[] args) throws InterruptedException {

        // Hero Stats
        String heroName = "";
        int heroHP = 50;
        int heroPotions = 5; // 20 pts of health
        String heroWeapon = "";

        // Goblin Stats
        int goblinHealth = 10;
        int goblinAttack = 5;
        String goblinWeapon = "Stick";
        String goblinName = "Urzal the Scared";

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
            System.out.printf("Welcome, %s.%n%n", heroName);

            // INTRO - WEAPON SELECTION
            System.out.println("You are in a dungeon with no weapon.");
            System.out.println("Ahead of you lies a [S]word and an [A]xe.\n");
            System.out.println("Which weapon do you pick up?");
            heroWeapon = weaponSelection();
            System.out.print("You found: " + heroWeapon + "\n\n\n\n");


            // GOBLIN ENCOUNTER
            Thread.sleep(2000);
            System.out.println("Ahead you encounter a goblin - what would you like to do?\n");
            enemyStatus(goblinHealth, goblinWeapon, goblinName);
            playerStatus(heroHP, heroWeapon, heroName);
            do {
                System.out.printf("[A]ttack | [P]otion | [R]un%n");

                String goblinEncounter = s.next();

                if (goblinEncounter.equalsIgnoreCase("a")) {
                    int attackValue = attackValue(heroWeapon);
                    // ENEMY STATS BAR
                    System.out.printf("%nYou damage him by %d!%n", attackValue);
                    goblinHealth -= attackValue;
                    enemyStatus(goblinHealth, goblinWeapon, goblinName);
                    // PLAYER STATS BAR
                    System.out.printf("%nThe goblin damages you by %d!%n", goblinAttack);
                    heroHP -= goblinAttack;
                    playerStatus(heroHP, heroWeapon, heroName);
                } else if (goblinEncounter.equalsIgnoreCase("p")) {
                    // path if hero HP is at maximum
                    if (heroHP == 50) {
                        //
                        System.out.println("\nAlready at full health! It had no effect!");
                        enemyStatus(goblinHealth, goblinWeapon, goblinName);
                        //
                        System.out.printf("%nThe goblin damages you by %d!%n", goblinAttack);
                        heroHP -= goblinAttack;
                        playerStatus(heroHP, heroWeapon, heroName);
                    // path if hero recovered HP
                    } else {
                        // grab current hp value
                        int currentHP = heroHP;
                        int recoveredHP = 0;

                        // if adding 20 hp puts it above 50, reset heroHP to 50
                        heroHP += 20;
                        if (heroHP > 50) {
                            heroHP = 50;
                        }
                        // calculating correct display for recoveredHP
                        if (heroHP - currentHP > 20) {
                            recoveredHP = 20;
                        } else {
                            recoveredHP = heroHP - currentHP;
                        }
                        System.out.printf("%nYou recovered %d health!%n", recoveredHP);
                        enemyStatus(goblinHealth, goblinWeapon, goblinName);

                        System.out.printf("%nThe goblin damages you by %d!%n", goblinAttack);
                        heroHP -= goblinAttack;
                        playerStatus(heroHP, heroWeapon, heroName);
                    }
                } else if (goblinEncounter.equalsIgnoreCase("r")) {

                    if (randomNum() > 5) {
                        System.out.println("You successfully ran away.");
                        break;
                    } else {
                        System.out.println("\nCan't escape!");

                        enemyStatus(goblinHealth, goblinWeapon, goblinName);
                        System.out.printf("%nThe goblin damages you by %d!%n", goblinAttack);
                        heroHP -= goblinAttack;
                        playerStatus(heroHP, heroWeapon, heroName);
                    }

                } else {
                    System.out.println("Please enter a correct action!");
                }
            } while (goblinHealth > 0 && heroHP > 0);

            // IF GOBLIN WAS KILLED, DISPLAY MESSAGE
            if (goblinHealth == 0) {
                System.out.println("You defeated the goblin!");
            }
            if (heroHP == 0) {
                System.out.println("Game Over! Adventure another day.");
            }

            // 2 ORC ENCOUNTER

            // PEPE BOSS BATTLE
        } else {
            System.out.println("Adventure another day then.");
        }

    }
    // RANDOM NUMBER GENERATOR: 1-10
    public static int randomNum() {
       return (int) Math.floor(Math.random() * 10) + 1;
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
            return "nothing but your cold, bare hands";
        }
    }

    // WEAPON NAMER
    public  static String weaponNamer(){
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

    // WEAPON ATTACK VALUE
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

    // ENEMY STATUS
    public static void enemyStatus(int hp, String wpn, String name) {
        System.out.print( "┌─────────────────────────────────────────────────────────┐ \n");
        System.out.print("| " + name + "\n");
        System.out.print("│ HP ");
        for (int i = 0; i <= hp; i++) {
            System.out.print("▒");
        }
        System.out.print(" " + hp + "/10");
        System.out.print("\n│ \u2694Weapon: " + wpn + "\n");
        System.out.print("└─────────────────────────────────────────────────────────┘\n");
    }

    // PLAYER STATUS
    public static void playerStatus(int hp, String wpn, String name) {
        System.out.print( "┌─────────────────────────────────────────────────────────┐ \n");
        System.out.print("| " + name + "\n");
        System.out.print("│ HP ");
        for (int i = 0; i <= hp; i++) {
            System.out.print("▒");
        }
        System.out.println(" " + hp + "/50");
        System.out.print("\n│ \u2694Weapon: " + wpn + "\n");
        System.out.print("└─────────────────────────────────────────────────────────┘\n");
    }
}
