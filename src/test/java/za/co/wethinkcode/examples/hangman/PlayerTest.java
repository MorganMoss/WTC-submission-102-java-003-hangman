package za.co.wethinkcode.examples.hangman;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {
    @Test
    public void testGetChances() {                                                             
        Player player = new Player();                                                                   
        assertEquals(5, player.getChances());                                                           
    }

    
    @Test
    public void testLoseChance() {
        Player player = new Player();
        int chances = player.getChances();
        player.lostChance();                                                                            
        assertEquals(chances - 1, player.getChances());     
        player.lostChance();                                                                            
        assertEquals(chances - 2, player.getChances());                                              
    }

    
    @Test
    public void testHasNoChances() {
        Player player = new Player();
        int chances = player.getChances();
        for (int i = 0; i < chances; i++) {                                                             
            assertFalse(player.hasNoChances());                                                         
            player.lostChance();
        }
        assertTrue(player.hasNoChances());                                                              
    }

    
    @Test
    public void testLoseChanceHasNoChances() {
        Player player = new Player();
        int chances = player.getChances();
        for (int i = 0; i < chances + 1; i++) {                                                         
            player.lostChance();
        }
        assertEquals(0, player.getChances());                                                           
    }


    @Test
    public void testGetWordsFile() {
        byte[] inputStreamData = "pain.txt\n".getBytes();                                            
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);                            
        Player player = new Player(inputStream);                                                        
        assertEquals("pain.txt", player.getWordsFile());                                             
    }

    
    @Test
    public void testGetWordsFileNoInput() {
        byte[] inputStreamData = "\n".getBytes();                                                       
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);
        Player player = new Player(inputStream);
        assertEquals("short_words.txt", player.getWordsFile());                                         
    }

    
    @Test
    public void testGetGuess() {
        byte[] inputStreamData = "f\n".getBytes();                                                      
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);
        Player player = new Player(inputStream);
        assertEquals("f", player.getGuess());                                                           
    }

    
    @Test
    public void testWantsToQuit() {
        byte[] inputStreamData = "quit\n".getBytes();                                                   
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);
        Player player = new Player(inputStream);
        assertEquals("quit", player.getGuess());                                                        
        assertTrue(player.wantsToQuit());                                                               
    }

    
    @Test
    public void testWantsToExit() {
        byte[] inputStreamData = "exit\n".getBytes();                                                   
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);
        Player player = new Player(inputStream);
        assertEquals("exit", player.getGuess());                                                        
        assertTrue(player.wantsToQuit());                                                               
    }
    @Test
    public void testWantsToQuitCapitalized() {
        byte[] inputStreamData = "Quit\n".getBytes();                                                   
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);
        Player player = new Player(inputStream);
        assertEquals("Quit", player.getGuess());                                                        
        assertTrue(player.wantsToQuit());                                                               
    }

    
    @Test
    public void testWantsToExitAllCaps() {
        byte[] inputStreamData = "EXIT\n".getBytes();                                                   
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);
        Player player = new Player(inputStream);
        assertEquals("EXIT", player.getGuess());                                                        
        assertTrue(player.wantsToQuit());                                                               
    }


    @Test
    public void testWantsToQuitCamel() {
        byte[] inputStreamData = "quIt\n".getBytes();                                                   
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);
        Player player = new Player(inputStream);
        assertEquals("quIt", player.getGuess());                                                        
        assertTrue(player.wantsToQuit());                                                               
    }                                                              
}
