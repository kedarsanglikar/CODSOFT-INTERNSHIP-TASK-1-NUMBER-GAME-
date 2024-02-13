/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package number.game;

import java.util.Scanner;
import java.util.Random;
//import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class NumberGame {

    /**
     * @param args the command line arguments
     */
    public static int guess;
    public static int randomInteger;
    public static int flag;
    static Scanner sc;
    static Random rd;
    public static int score = 0;

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            mainGame();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            newGame();
        }
    }

    public static void newGame() {
        System.out.println("Do you want to play again? Type (Y/N)");
        sc = new Scanner(System.in);
        char decision = sc.next().charAt(0);

//        System.out.println(decision);
        if (decision == 'Y' || decision == 'y') {
            try {
                mainGame();
            } catch (Exception ex) {
                System.out.println(ex.toString());
                newGame();
            }
        } else if (decision == 'N' || decision == 'n') {
            exitGame();
        } else {
            System.out.println("Wrong Choice. Please enter appropriate and correct option!");
            newGame();
        }
    }

    public static void mainGame() throws Exception {

        System.out.println("-----NUMBER GAME-----");

        System.out.println("Total number of attempts for user is 3");
        sc = new Scanner(System.in);
        rd = new Random();
        flag = 0;

        randomInteger = rd.nextInt(100);

        while (flag < 3) {

            System.out.println("Guess the correct number : ");
            guess = sc.nextInt();

            if (guess == randomInteger) {
                System.out.println("You guessed the correct number");
                System.out.println("Number generated : " + randomInteger);
                score++;
                newGame();
                break;

            } else if (guess > randomInteger) {
                System.out.println("You guessed the number too high");

                flag++;

            } else {
                System.out.println("You guessed the number too low");

                flag++;

            }

        }

        if (flag >= 3) {
            System.out.println("You exceeded the limit of attempts!");
            System.out.println("Number generated : " + randomInteger);
            newGame();
        }

    }

    private static void exitGame() {
        System.out.println("Your score is : " + score);
        System.out.println("The score is based upon the number of successful guesses.");
        System.out.println("Game Exited");
        System.exit(0);
    }
}
