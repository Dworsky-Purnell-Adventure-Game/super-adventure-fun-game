import java.util.*;

public class Adventure {
    public static void main(String[] args) throws InterruptedException {

        Scanner s = new Scanner(System.in);

        // Hero Stats
        String heroName = "";
        int heroHP = 50;
        int heroPotions = 5; // 20 pts of health
        String heroWeapon = "";


        // START GAME
        System.out.println("Would you like to begin your adventure? [Y/N]");
        String confirmation = s.next();
        s.nextLine();

        if (confirmation.equalsIgnoreCase("y")) {
            System.out.println("Let's begin...");

            // HERO NAME
            System.out.println("What is your name, adventurer?");
            heroName = s.nextLine();
            System.out.printf("Welcome, %s.%n%n", heroName);

            // WEAPON SELECTION
            System.out.println("You are in a dungeon with no weapon.");
            System.out.println("Ahead of you lies a [S]word and an [A]xe.");
            System.out.println("\nWhich weapon do you pick up?");
            heroWeapon = weaponSelection();
            System.out.printf("You found: %s%n%n%n%n", heroWeapon);
            Thread.sleep(2000);

            // LOW-LEVEL ENCOUNTER
            System.out.print("As you begin your journey you are ambushed by some small goblin creature!\n");
            heroHP = lowLevelBattle(heroHP, heroWeapon, heroName, 10, "Stick", "Urzal the Scared");
            Thread.sleep(2000);

            // TIMER FOR AMBIANCE
            System.out.print("\n.");
            Thread.sleep(1500);
            System.out.print(".");
            Thread.sleep(1500);
            System.out.print(".");
            Thread.sleep(1500);


            // BOSS-LEVEL ENCOUNTER
            System.out.print("\nHOW DARE YOU!\n");
            Thread.sleep(1500);
            System.out.print("           ▗▖▌▌▌▌▙▗▖    ▗▗▗▄▗▖▖        \n" +
                    "         ▖▛▞▞▞▟▐▞▞▞▞▌▌▞▞▌▙▚▞▞▞▞▄       \n" +
                    "        ▞▞▞▞▟▐▐▐▐▐▞▞▞▞▛▟▐▐▐▐▞▞▞▞▄      \n" +
                    "       ▟▐▞▟▐▐▐▚▚▌▌▌▛▞▙▜▞▛▌▙▚▚▜▜▐▚▄▗    \n" +
                    "      ▞▞▞▞▞▞▌▙▚▌▛▜▐▚▜▐▐▐▞▟▞▌▛▞▞▌▌▌▌▙   \n" +
                    "    ▖▄▚▜▐▞▟▐▐▐▞▞▞▌▌▌▌▌▙▚▚▚▚▌▙▚▚▚▜▐▞▞▄  \n" +
                    "   ▟▐▞▌▌▌▌▙▙▛▟▞▞▌▛▜▜▀▛▙▜▐▞▟▟▐▞▙▜▐▞▞▟▞▌ \n" +
                    "  ▌▌▌▙▚▜▐▞▄▚▜▐▝▝▖▝▀ ▗   ▖▀▝▐▝▝▗   ▝▘▘▚ \n" +
                    " ▞▟▐▚▚▚▚▚▚▚▚▚▚▜▜▐▟▞▞▄▖▌▙▚▜▜▚▜▜▄▙▙▙▜▀▛▘ \n" +
                    "▗▜▐▐▐▐▞▌▙▚▚▌▙▜▐▞▌▞▞▞▄▚▜▐▐▚▚▚▚▚▚▄▐▗▌▀   \n" +
                    "▌▌▌▙▚▌▌▌▌▙▚▚▚▚▚▚▚▜▐▚▙▚▜▐▞▞▌▛▌▙▙▐▀▌▄    \n" +
                    "▞▞▌▌▌▌▌▙▚▚▚▚▌▙▚▚▜▐▐▐▐▐▞▚▚▚▚▚▜▐▐▐▚▚▚▚   \n" +
                    "▚▚▚▚▌▙▜▐▐▞▌▙▚▚▌▛▟▐▚▌▙▚▚▌▙▚▜▐▐▐▐▐▐▞▌▌▌  \n" +
                    "▌▛▞▌▌▌▌▌▌▙▜▐▙▌▌▀▟▞▌▙▚▜▞▟▐▞▟▞▙▚▌▙▙▚▚▌▙  \n" +
                    "▞▞▞▞▞▞▞▟▐▞▞█▛█▛▙▙▄  ▘▘▀▝▟▟▐▐▐▚▚▚▞▞▌▛▞▘ \n" +
                    "▜▞▌▛▞▌▛▞▞▞▛▛▛█▜██▟▛▜▞▌▝    BAAAAA!!!!        \n" +
                    "▙▙▜▞▞▞▞▞▞▙▚▜▜▟▜▟▟▜█▙▌▙▖                \n" +
                    "▙▙▛▟▜▞▙▜▐▐▐▚▚▚▜▐▐▜▐▞▟▐▝                \n" +
                    "▙▙▜▙▛▟▙▙▛▙▜▐▚▛▟▚▛▟▚▜▟▚▌                \n" +
                    "▙▙▛▟▜▚▙▙▜▟▜▜▜▟▜▜▟▜▜▜▟▜▟▛▖              \n" +
                    "▙▚▛▙▛█▟▞█▞▛▛▙▜▜▚▛▛▛▙▜▚▙▛█▖             \n" +
                    "▙██▟█▟▟▟▙███▟███▟██▟██▟█▟▙  ");

            Thread.sleep(2000);
            System.out.println("\n\nPrepare for a boss fight.\n");
            Thread.sleep(2000);

            bossFight(heroHP, heroWeapon, heroName, 100, "Mace of Justice", "Pepe the Nasty");
        } else {
            System.out.println("Another day then.");
        }

    }


    // BOSS FIGHT!
    public  static void bossFight(int hHP, String hWpn, String hName, int eHP, String eWpn, String eName){
        Scanner s = new Scanner(System.in);
        enemyStatus(eHP, eWpn, eName);
        playerStatus(hHP, hWpn, hName);

        // Loop through fight until one of the fighter's HP is 0
        do {
            System.out.println("[A]ttack | [P]otion | [R]un");
            String encounter = s.next();

            // Begin attack choice
            if (encounter.equalsIgnoreCase("a")) {

                int attackValue = attackValue(hWpn);

                eHP -= attackValue;
                System.out.printf("%nYou damage him by %d!%n", attackValue);
                enemyStatus(eHP, eWpn, eName); // enemy status bar

                hHP -= 3;
                System.out.printf("%n%s damages you by %d!%n", eName, 8);
                playerStatus(hHP, hWpn, hName); // player status bar

            }

            // Begin potion choice
            else if (encounter.equalsIgnoreCase("p")) {
                if (hHP == 50) {
                    System.out.println("\nAlready at full health! It had no effect!");
                } else {
                    int currentHP = hHP;

                    if (hHP >= 30) {
                        hHP = 50;
                    } else {
                        hHP += 20;
                    }

                    int recoveredHP = hHP - currentHP;

                    System.out.printf("%nYou recovered %d health!%n", recoveredHP);
                }

                hHP -= 3;
                enemyStatus(eHP, eWpn, eName);
                System.out.printf("%n%s damages you by %d!%n", eName, 3);
                playerStatus(hHP, hWpn, hName);

            }

            // Begin run choice
            else if (encounter.equalsIgnoreCase("r")) {

                if (randomNum() > 5) {
                    System.out.println("You successfully ran away, coward.");
                    break;
                } else {
                    System.out.println("\nCan't escape! You must fight or die!");

                    enemyStatus(eHP, eWpn, eName);
                    System.out.printf("%n%s damages you by %d!%n", eName, 3);
                    hHP -= 3;
                    playerStatus(hHP, hWpn, hName);
                }

            }
            // User didn't enter valid choice
            else {
                System.out.println("Please enter a correct action!");
            }
        } while (eHP > 0 && hHP > 0);
        // Upon death, display message
        if (eHP <= 0) {
            System.out.printf("%nYou defeated %s%n!", eName);
        }
        if (hHP <= 0) {
            System.out.println("Game Over! Adventure another day.");
        }
    }

    // GOBLIN ENCOUNTER
    public  static int lowLevelBattle(int hHP, String hWpn, String hName, int eHP, String eWpn, String eName){
        Scanner s = new Scanner(System.in);
        enemyStatus(eHP, eWpn, eName);
        playerStatus(hHP, hWpn, hName);

        // Loop through fight until one of the fighter's HP is 0
        do {
            System.out.println("[A]ttack | [P]otion | [R]un");
            String goblinEncounter = s.next();

            // Begin attack choice
            if (goblinEncounter.equalsIgnoreCase("a")) {

                int attackValue = attackValue(hWpn);

                eHP -= attackValue;
                System.out.printf("%nYou damage him by %d!%n", attackValue);
                enemyStatus(eHP, eWpn, eName); // enemy status bar

                hHP -= 3;
                System.out.printf("%nThe goblin damages you by %d!%n", 3);
                playerStatus(hHP, hWpn, hName); // player status bar

            }

            // Begin potion choice
            else if (goblinEncounter.equalsIgnoreCase("p")) {
                if (hHP == 50) {
                    System.out.println("\nAlready at full health! It had no effect!");
                } else {
                    int currentHP = hHP;

                    if (hHP >= 30) {
                        hHP = 50;
                    } else {
                        hHP += 20;
                    }

                    int recoveredHP = hHP - currentHP;

                    System.out.printf("%nYou recovered %d health!%n", recoveredHP);
                }

                hHP -= 3;
                enemyStatus(eHP, eWpn, eName);
                System.out.printf("%nThe goblin damages you by %d!%n", 3);
                playerStatus(hHP, hWpn, hName);

            }

            // Begin run choice
            else if (goblinEncounter.equalsIgnoreCase("r")) {

                if (randomNum() > 5) {
                    System.out.println("You successfully ran away, coward.");
                    break;
                } else {
                    System.out.println("\nCan't escape! You must fight or die!");

                    enemyStatus(eHP, eWpn, eName);
                    System.out.printf("%nThe goblin damages you by %d!%n", 3);
                    hHP -= 3;
                    playerStatus(hHP, hWpn, hName);
                }

            }
            // User didn't enter valid choice
            else {
                System.out.println("Please enter a correct action!");
            }
        } while (eHP > 0 && hHP > 0);
        // Upon death, display message
        if (eHP <= 0) {
            System.out.println("You defeated the goblin!");
        }
        if (hHP <= 0) {
            System.out.println("Game Over! Adventure another day.");
        }
        return hHP;
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
    public static String weaponNamer() {
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
        int attackValue = 0;
        int randomEight = (int) (Math.floor(Math.random() * 8)) + 1;
        int randomThree = (int) (Math.floor(Math.random() * 3)) + 1;

        if (weapon.contains("Sword")) {
            attackValue = 5;
        } else if (weapon.contains("Axe")) {
            attackValue = randomEight;
        } else {
            attackValue = randomThree;
        }
        return attackValue;
    }

    // ENEMY STATUS
    public static void enemyStatus(int hp, String wpn, String name) {
        System.out.print("┌─────────────────────────────────────────────────────────────┐ \n");
        System.out.print("| " + name + "\n");
        System.out.print("│ HP ");
        for (int i = 0; i <= hp; i++) {
            System.out.print("▒");
        }
        System.out.print(" " + hp);
        System.out.print("\n│ \u2694Weapon: " + wpn + "\n");
        System.out.print("└─────────────────────────────────────────────────────────────┘\n");
    }

    // PLAYER STATUS
    public static void playerStatus(int hp, String wpn, String name) {
        System.out.print("┌─────────────────────────────────────────────────────────────┐ \n");
        System.out.print("| " + name + "\n");
        System.out.print("│ HP ");
        for (int i = 0; i <= hp; i++) {
            System.out.print("▒");
        }
        System.out.print(" " + hp);
        System.out.print("\n│ \u2694Weapon: " + wpn + "\n");
        System.out.print("└─────────────────────────────────────────────────────────────┘\n");

    }
    
}


