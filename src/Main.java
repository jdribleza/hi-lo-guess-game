import java.util.Scanner;

public class Main {

    private static int randomNumber;

    static {
        generateRandomNumber();
    }

    private static void generateRandomNumber() {
        double generatedRandomNumber = (Math.random() * 9) + 1; // Generate random number from 1 - 10
        randomNumber = (int) Math.floor(generatedRandomNumber); // Round randomNumber to the lowest decimal value
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        play(scanner);
    }

    private static void play(Scanner scanner){
        int attempt = 3;
        do{
            System.out.println("\nHI-LO Game \t Attempts left: " + attempt);
            System.out.println("Enter number from 1 to 10 to guess:");
            int guess = scanner.nextInt();
            if (guess == randomNumber){
                String successMessage = """
                        *******************************************
                        ***** You Won! You guessed the number *****
                        *******************************************
                        """;
                System.out.println("\n"+ successMessage);
                break;
            }

            System.out.println((guess > randomNumber)?"Too High!":"Too Low!");

            // decrease attempt
            attempt--;

            if (attempt == 0){
                String attemptMessage = """
                        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        !!!!!!!! You Lost! Out of attempts !!!!!!!!
                        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        """;
                System.out.println("\n"+ attemptMessage);
            }
        }while (attempt > 0);

        playAgain(scanner);
    }

    private static void playAgain(Scanner scanner){
        System.out.println("Would you like to continue playing? [Y][N]");
        scanner.nextLine(); // clear buffer
        String selectedOption = scanner.nextLine();
        if (selectedOption.equalsIgnoreCase("Y")){
            generateRandomNumber();
            play(scanner);
        }
    }

}
