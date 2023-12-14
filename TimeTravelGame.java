import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TimeTravelGame {
    private player player;
    private HomelessMan homelessMan;
    private House house;
    private Scanner scanner;

    public TimeTravelGame(String playerName,List<Child> children) {
        this.player = new player(playerName);
        this.homelessMan = new HomelessMan();
        this.house = new House(children);
        this.scanner = new Scanner(System.in);
    }

    public player getPlayer() {
        return player;
    }

    public HomelessMan getHomelessMan() {
        return homelessMan;
    }

    public House getHouse() {
        return house;
    }

    public void play() {
        System.out.println("Welcome to the Time Travel Game!");
        System.out.println("You find yourself in modern-day Quito.");

        exploreAlley();

        if (!player.isDiscovered()) {
            followHomelessMan();
            if (!player.isDiscovered()) {
                surviveInHouse();
                if (!player.isDiscovered()) {
                    exploreColonialQuito();
                }
            }
        }

        System.out.println("Game over. Thanks for playing!");
        scanner.close();
    }

    private void exploreAlley() {
        System.out.println("You find a homeless man. Do you want to leave a basket of fruit for him?");
        System.out.println("1. Leave a basket of fruit");
        System.out.println("2. Ignore the homeless man");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                homelessMan.wakeUp();
                homelessMan.startWalking();
            
                break;
            case 2:
                System.out.println("You ignore the homeless man and continue your journey.");
                System.out.println("Game over. Thanks for playing!");
                scanner.close();
                System.exit(0);
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private void followHomelessMan() {
        System.out.println("You follow the homeless man through the streets of Quito. It's a festive atmosphere.");
        System.out.println("Do you want to enter the house with him?");
        System.out.println("1. Enter the house");
        System.out.println("2. Stay outside");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                enterHouse();
                break;
            case 2:
                System.out.println("You decide not to enter the house. The homeless man and the children disappear.");
                System.out.println("Game over. Thanks for playing!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private void enterHouse() {
        System.out.println("You enter the house with the homeless man and seven children.");
        System.out.println("Survive for seven days without being noticed...");

        for (int day = 1; day <= 7; day++) {
            System.out.println("\nDay " + day + ":");
            System.out.println("1. Listen to children's conversations");
            System.out.println("2. Search for healing stones");
            System.out.println("3. Do nothing");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    listenToConversations();
                    break;
                case 2:
                    searchForStones();
                    break;
                case 3:
                    System.out.println("You choose to do nothing.");
                    System.out.println("Game over. Thanks for playing!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    day--; // Repeat the current day
            }

            if (player.isDiscovered()) {
                System.out.println("Game over. Thanks for playing!");
                scanner.close();
                System.exit(0);
                break;
            }
        }

        if (!player.isDiscovered() && house.hasHealingStones()) {
            System.out.println("Congratulations! You survived seven days in the house without being noticed.");
        }
    }
    private void surviveInHouse() {
        System.out.println("You enter the house with the homeless man and seven children.");
        System.out.println("Survive for seven days without being noticed...");
    
        for (int day = 1; day <= 7; day++) {
            System.out.println("\nDay " + day + ":");
            System.out.println("1. Listen to children's conversations");
            System.out.println("2. Search for healing stones");
            System.out.println("3. Do nothing");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    listenToConversations();
                    break;
                case 2:
                    searchForStones();
                    break;
                case 3:
                    System.out.println("You choose to do nothing.");
                    System.out.println("Game over. Thanks for playing!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    day--; // Repeat the current day
            }
    
            if (player.isDiscovered()) {
                System.out.println("Game over. Thanks for playing!");
                scanner.close();
                System.exit(0);
                break;
            }
        }
    
        if (!player.isDiscovered() && house.hasHealingStones()) {
            System.out.println("Congratulations! You survived seven days in the house without being noticed.");
        }
    }
    
    private void listenToConversations() {
        System.out.println("You listen to the children's conversations. Try to remember the peculiar name.");
        // TODO: Implement listening to conversations and remembering the peculiar name
    }

    private void searchForStones() {
        System.out.println("You search for the healing stones.");
        List<Child> children = house.getChildren();

        for (Child child : children) {
            if (!child.hasHealingStone()) {
                child.hideHealingStone();
            }
        }

        if (house.hasHealingStones()) {
            System.out.println("You found all the healing stones!");
        }
    }

    private void exploreColonialQuito() {
        System.out.println("You successfully survived in the house. Now, you find yourself in colonial Quito.");

        System.out.println("The streets are different, and people are dressed in Victorian clothes.");
        System.out.println("You have the whole day to explore the city. Be cautious and gather information.");

        for (int i = 0; i < 3; i++) {
            System.out.println("\nExplore options:");
            System.out.println("1. Talk to water carriers");
            System.out.println("2. Examine advertisements on walls");
            System.out.println("3. Speak to locals");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    talkToWaterCarriers();
                    break;
                case 2:
                    examineAdvertisements();
                    break;
                case 3:
                    speakToLocals();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    i--; // Repeat the current iteration
            }

            if (player.isDiscovered()) {
                System.out.println("Game over. Thanks for playing!");
                scanner.close();
                System.exit(0);
                break;
            }
        }

        if (!player.isDiscovered()) {
            System.out.println("As the sun sets, approach one of the water carriers and say in Quechua: \"niukapa sutimi.\"");
            System.out.println("This phrase might help you in this unfamiliar time.");
            System.out.println("The water carrier instructs you to meet in the big square when the sun goes down.");

            System.out.println("\nThe game continues... (You can extend the story from here)");
        }
    }

    private void talkToWaterCarriers() {
        System.out.println("You approach a water carrier and attempt to converse in Quechua: \"niukapa sutimi.\"");
        System.out.println("The water carrier looks at you and replies in Quechua, providing you with valuable information.");
    }

    private void examineAdvertisements() {
        System.out.println("You carefully examine the advertisements on the walls.");
        System.out.println("You notice war propaganda and get a sense that a war is taking place.");
        System.out.println("To find out more, you decide to talk to business owners in the center of Quito.");
    }

    private void speakToLocals() {
        System.out.println("You engage in conversation with locals, trying to gather information about the current situation.");
        System.out.println("They provide insights into the social structures and ongoing events.");
    }

    public static void main(String[] args) {
        // Initialize the game
        TimeTravelGame game = new TimeTravelGame("YourPlayerName", Arrays.asList(
            new Child("Child1", "normal dream"),
            new Child("Child2", "normal dream"),
            new Child("Child3", "normal dream"),
            new Child("Child4", "normal dream"),
            new Child("Child5", "normal dream"),
            new Child("Child6", "normal dream"),
            new Child("Child7", "evil entity") // Only this child has a nightmare about the evil entity
    ));

        // Start the game
        game.play();
    }
}