
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rbowlen
 */
public class Game {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner to read file input
        Scanner scan = new Scanner(new File("questions.txt"));
        ArrayList<Question> questions = new ArrayList<>();
        int playerOnePoints = 0;
        int playerTwoPoints = 0;
        //Scanner to scan keyboard input
        Scanner kb = new Scanner(System.in);
        
        /**
         * Create object instances of each question and pass them into an 
         * ArrayList
         */
        int numQuestions = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < numQuestions; i++) {
           questions.add(new Question(scan.nextLine(), scan.nextLine(),
                   scan.nextLine(), scan.nextLine(), scan.nextLine(),
                   scan.nextLine())); 
        }
        
        /**
         * Alternate questions to each player, starting with player one. 
         * Notify the players if they guessed correctly or not and track 
         * their points.
         */
        for(int i = 0; i < questions.size(); i ++) {
            //Give every other question to player one
            if(i % 2 == 0) {
                System.out.println("Player One, please answer the following"
                        + " question:\n");
                printQuestion(questions.get(i));
                String answer = kb.next();
                if(answer.equalsIgnoreCase(questions.get(i).correctAnswer)) {
                    playerOnePoints++;
                    System.out.println("You got it right! You have "
                            + playerOnePoints + " points.\n");
                } else {
                    System.out.println("Sorry, that was incorrect! You have "
                            + playerOnePoints + " points.\n");
                }
            } else{ //Give every other question to player two
                System.out.println("Player Two, please answer the following"
                        + " question:\n");
                printQuestion(questions.get(i));
                String answer = kb.next();
                if(answer.equalsIgnoreCase(questions.get(i).correctAnswer)) {
                    playerTwoPoints++;
                    System.out.println("You got it right! You have "
                            + playerTwoPoints + " points.\n");
                } else {
                    System.out.println("Sorry, that was incorrect! You have "
                            + playerTwoPoints + " points.\n");
                }
            }
        }
        
        //Decide who wins
        if(playerOnePoints > playerTwoPoints) {
            System.out.print("Player one wins!");
        } else {
            System.out.print("Player two wins!");
        }
        
        
    }
    
    public static void printQuestion(Question question) {
        System.out.println(question.question);
        System.out.println(question.answerOne);
        System.out.println(question.answerTwo);
        System.out.println(question.answerThree);
        System.out.println(question.answerFour);
    }
}
