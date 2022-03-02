package za.co.wethinkcode.examples.hangman;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Player --- Object signifying a player of hangman
 * @author Morgan Moss
 */
public class Player {
    /**
     * The amount of chances this player has before game over
     */
    private int chances;
    /**
     * The scanner used to traverse input
     */
    private Scanner inputScanner;
    /**
     * Default Textfile
     */
    private String defaultTextFile = "short_words.txt";
    /**
     * The last input given
     */
    private String in = "";


    /**
     * Default Constructor, makes a new player with 5 chances
     * and uses system.in as the input stream
     */
    public Player(){chances = 5; inputScanner= new Scanner(System.in);}


    /**
     * Overloaded Constructor, makes a new player with 5 chances, but
     * has a custom input stream
     * @param in : The input stream the player is using to give input
     */
    public Player(InputStream input){chances = 5; inputScanner = new Scanner(input);}


    /**
     * Getter for chances
     * @return (int) The amount of chances this player has left
     */
    public int getChances(){return chances;}


    /**
     * Checks if the player has no chances left
     * @return (boolean) : True if this player has no chances, otherwise False
     */
    public boolean hasNoChances(){return chances <= 0;}


    /**
     * De-increments this players chances by one
     */
    public void lostChance(){if (!(this.hasNoChances())) chances--;}

    
    /**
     * Gets next line of input
     * @return (String) the next line
     */
    public String getGuess(){
        in = inputScanner.nextLine();
        return in;
    }


    /**
     * Gets the path to pick random words from
     * @return (String) : The path for this players words list file
     */
    public String getWordsFile(){
        System.out.println("Words file? [leave empty to use short_words.txt]");
        String result = getGuess();
        return result.isBlank() ? defaultTextFile : result;
    }
    

    /**
     * Checks if the user has asked to quit
     * @return (boolean) : True if the user's input is "quit" or "exit"
     */
    public boolean wantsToQuit(){ 
        return in.toLowerCase().equals("quit")||in.toLowerCase().equals("exit");
    }


}
