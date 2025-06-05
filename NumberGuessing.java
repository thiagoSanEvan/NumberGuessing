import java.util.Scanner;
import java.util.Random;

public class NumberGuessing{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        boolean playing = true; //true = O usuário está jogando o jogo

        int guesses = 3; //Quantas vezes o usuário pode tentar acertar o número

        while (playing == true) {
            System.out.println("Would you like to play a guessing game?(y/n)"); //Pergunta se vai jogar
            String originalAnswer = scan.nextLine();
            String lowerAnswer = originalAnswer.toLowerCase();//Trata a resposta pra só vir em lower case

            if (lowerAnswer.equals("yes") || lowerAnswer.equals("ye") || lowerAnswer.equals("y")) {
                int magicNumber = random.nextInt(1, 11); //Escolhe um número aleatório em cada rodada

                guesses = 3;

                while (guesses > 0) { 
                    System.out.printf("You have %d guesses. Pick a number between 1 and 10: ", guesses);
                    int guessNumber = scan.nextInt();
                    scan.nextLine(); //nextInt não tem o \n no final, então precisa disso para cosumir o newline

                    if (guessNumber == magicNumber) {
                        System.out.println("Congratulations, you got it!");
                        break; //O loop termina ao acertar o número e pergunta novamente se quer jogar
                    } else {
                        guesses--; //Decrementa o número de tentativas antes de validar quantas faltam
                        if (guesses > 0) {
                            System.out.println("Wrong number, try again."); //Tenta de novo
                        } else {
                            System.out.printf("You lost. The correct number was %d.\n", magicNumber);//O jogo acaba e sai do loop while por guesses ser igual a 0
                        }
                    }
                }
            } else if (lowerAnswer.equals("no") || lowerAnswer.equals("n")) {
                System.out.println("Alrighty. Goodbye.");
                playing = false;//Sai imediatamente do jogo
            } else {
                System.out.printf("That is not a valid answer(%s).\n", originalAnswer);//Acusa se a resposta(answer) não for igual a nenhuma das opções
            }
        }
        scan.close();
    }
}