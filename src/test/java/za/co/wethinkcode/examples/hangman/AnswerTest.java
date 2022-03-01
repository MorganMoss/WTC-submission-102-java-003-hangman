package za.co.wethinkcode.examples.hangman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AnswerTest {
    @Test
    public void testToString() {
        Answer answer = new Answer("why");                                                             
        assertEquals("why", answer.toString());                                                        
    }


    @Test
    public void testEqualsFalseCase() {
        Answer a = new Answer("am");
        Answer b = new Answer("i");
        assertFalse(a.equals(b));                                                                               
    }


    @Test
    public void testEqualsTrueCase() {
        Answer a = new Answer("doing");
        Answer b = new Answer("doing");
        assertTrue(a.equals(b));                                                                               
        assertTrue(a.equals(a));  
        assertTrue(b.equals(b));                                                                               
                                                                                     
    }


    @Test
    public void testGetHintSingle() {
        Answer solution = new Answer("these");                                                           
        Answer lastAnswer = new Answer("_____");                                                         
        Answer hint = solution.getHint(lastAnswer, 's');                                                
        assertEquals(new Answer("___s_"), hint);
    }


    @Test
    public void testGetHintDouble() {
        Answer solution = new Answer("tests");                                                           
        Answer lastAnswer = new Answer("_____");                                                         
        Answer hint = solution.getHint(lastAnswer, 's');                                                
        assertEquals(new Answer("__s_s"), hint);
    }


    @Test
    public void testHasLetter() {
        Answer answer = new Answer("all");
        assertTrue(answer.hasLetter('a'));
        assertFalse(answer.hasLetter('x'));
    }

    
    @Test
    public void testGenerateRandomHint() {
        Answer wordToGuess = new Answer("over");
        Answer hint = wordToGuess.generateRandomHint();                                                 

        for (int i = 0; i < hint.toString().length(); i++) {                                            
            char hintLetter = hint.toString().charAt(i);
            char expectedLetter = wordToGuess.toString().charAt(i);
            if (hintLetter != '_') {
                assertEquals(expectedLetter, hintLetter);
            }
        }
    }


    @Test
    public void testIsGoodGuess() {
        Answer wordToGuess = new Answer("again");
        Answer currentAnswer = new Answer("a_a__");
        assertTrue(currentAnswer.isGoodGuess(wordToGuess,'g'));                                         
        assertFalse(currentAnswer.isGoodGuess(wordToGuess,'x'));                                        
        assertFalse(currentAnswer.isGoodGuess(wordToGuess,'a'));                                        
    }
}
