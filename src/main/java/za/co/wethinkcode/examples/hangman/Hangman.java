package za.co.wethinkcode.examples.hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

/**
 * Hangman --- Object signifying a gmae of hangman
 * @author Morgan Moss
 */
public class Hangman {
    /**
     * This program is run from this main function. 
     * It allows you to play hangman
     * @param args : The system arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Player player = new Player();
        String fileName = player.getWordsFile();

        List<String> words = Files.readAllLines(Path.of(fileName));   
                                  
        Answer solution = new Answer(words.get(new Random().nextInt(words.size())).trim());

        Answer answer = solution.generateRandomHint();

        System.out.println("Guess the word: " + answer);

        while (!answer.equals(solution)) {  
            String in = player.getGuess();
            if (in.length() < 1){continue;}
            
            if (player.wantsToQuit()) {System.out.println("Bye!"); break;}

            char guess = in.charAt(0);
            if (answer.isGoodGuess(solution, guess)){
                answer = solution.getHint(answer, guess);
                System.out.println(answer.toString());
                if (answer.equals(solution)) {                                             
                    System.out.println("That is correct! You escaped the noose .. this time.");
                    break;
                }
                continue;
            }

            player.lostChance();

            if (player.hasNoChances()){
                System.out.println("Sorry, you are out of guesses. The word was: " + solution.toString());
                break;
            }

            System.out.println("Wrong! Number of guesses left: " + player.getChances());
        }
    }
}