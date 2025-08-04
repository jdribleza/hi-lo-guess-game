import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static int randomNumber;

    private static final String successMessage = """
                        *******************************************
                        ***** You Won! You guessed the number *****
                        *******************************************
                        """;

    private static final String attemptMessage = """
                        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        !!!!!!!! You Lost! Out of attempts !!!!!!!!
                        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        """;

    // static block
    static { generateRandomNumber(); }

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
        int guess = 0;
        do{
            System.out.println("\nHI-LO Game \t Attempts left: " + attempt);
            System.out.println("Enter number from 1 to 10 to guess:");

            try{
                guess = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("\n!!!!! Invalid input !!!!!");
                playAgain(scanner);
            }

            if (guess == randomNumber){
                System.out.println("\n"+ successMessage);
                break;
            }

            System.out.println((guess > randomNumber)?"Too High!":"Too Low!");

            // decrease attempt
            attempt--;

            if (attempt == 0)
                System.out.println("\n"+ attemptMessage);
        }while (attempt > 0);

        // ask user if he wants to play again
        playAgain(scanner);
    }

    private static void playAgain(Scanner scanner){
        System.out.println("Would you like to continue playing? [Y][N]");
<<<<<<< HEAD

        // clear buffer
        scanner.nextLine();

=======
        scanner.nextLine(); // clear buffer
>>>>>>> 0a60ca60be974025f297b1bdd74bc412b5f2d77d
        String selectedOption = scanner.nextLine();
        if (selectedOption.equalsIgnoreCase("Y")){
            generateRandomNumber();
            play(scanner);
        } else {
            scanner.close();
            System.exit(0);
        }
    }
<<<<<<< HEAD
}
=======

}
>>>>>>> 0a60ca60be974025f297b1bdd74bc412b5f2d77d
