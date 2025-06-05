import java.util.Scanner;
import java.util.Random;

public class guessingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Do you want to play? ");
        String answer = scan.nextLine();

        scan.close();
    }
}
