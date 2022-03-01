package za.co.wethinkcode.examples.hangman;

import java.util.Random;


/**
 * Answer --- Object signifying an answer from a game of hangman
 * @author Morgan Moss
 */
public class Answer {
    /**
     * The word stored in this answer
     */
    private String word;


    /**
     * Constructor for Answer
     * Creates answer with word given
     * @param word : Answer word
     */
    public Answer(String word){
        this.word = word;
    }


    /**
     * Checks if 2 answer objects are equal
     * @param answer : the other answer object being compared to this one
     * @return (boolean) : True if they're equal, otherwise False
     */
    @Override
    public boolean equals(Object answer){
        if (answer == this){return true;}
        if (!(answer instanceof Answer)){return false;}
        return word.equals(answer.toString());
    }

    
    /**
     * Getter for word
     * @return (String) : The word held by this Answer
     */
    public String toString(){return word;}


    /**
     * Makes a new answer with the hint given
     * @param lastAnswer : The last answer given
     * @param letter : The letter to be added to the new answer (as a hint)
     * @return (Answer) : The new Answer Object with hint included
     */
    public Answer getHint(Answer lastAnswer, char letter){
        String newAnswer = "";
        for(int i = 0; i < lastAnswer.toString().length(); i++){
            if (letter == word.toUpperCase().charAt(i) 
               || letter == word.toLowerCase().charAt(i) ){newAnswer += letter;}
            else {newAnswer += lastAnswer.toString().charAt(i);}
        }
        return new Answer(newAnswer.toLowerCase());
    }

    
    /**
     * Checks if this Answer Object contains a specific letter
     * @param letter : The letter you are looking for in answer
     * @return (boolean) : True if letter is in this Answer, otherwise False
     */
    public boolean hasLetter(char letter){
        return word.toUpperCase().indexOf(letter) 
             + word.toLowerCase().indexOf(letter) != -2;
    }


    /**
     * Checks if the letter is in the solution, 
     * and that it has not been guessed yet
     * @param solution : The Answer that contains the solution
     * @param letter : The letter guessed
     * @return (Boolean) : True if its a good guess, otherwise False
     */
    public boolean isGoodGuess(Answer solution, char letter){
        return !this.hasLetter(letter) && solution.hasLetter(letter);
    }


    /**
     * Creates a new answer with blanks and one hint
     * @return (Answer) : Blank Answer with at least one letter filled in
     */
    public Answer generateRandomHint(){
        int randomIndex = new Random().nextInt(word.length() - 1);
        String noLetters = "_".repeat(word.length());
        return this.getHint(new Answer(noLetters), word.charAt(randomIndex));
    }
}
