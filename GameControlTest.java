

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Random;

/**
 * The test class GameControlTest which tests the GameControl class.
 *
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class GameControlTest
{
    /**
     * Default constructor for test class GameControlTest
     */
    public GameControlTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testRollDice()
    {
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Tim");
        Joker joker1 = new Joker();
        GameControl gameCont1 = new GameControl(2, player1, player2, joker1);
        for (int i = 1; i <= 100; i++)
        {
            int result = gameCont1.rollDice();
            assertTrue(result >= 1 && result <= 6);
        }
    }
    
    @Test
    public void testMove2Players()
    {
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Tim");
        Joker joker1 = new Joker();
        GameControl gc1 = new GameControl(2, player1, player2, joker1);
        
        assertEquals(1, player1.getPosition());
        assertEquals(1, player2.getPosition());
        gc1.move(6, 1);
        assertEquals(7, player1.getPosition());
        gc1.move(3, 2);
        assertEquals(4, player2.getPosition());
        gc1.move(1, 1);
        assertEquals(8, player1.getPosition());
        gc1.move(5, 2);
        assertEquals(9, player2.getPosition());
        gc1.move(2, 1);
        assertEquals(10, player1.getPosition());
        gc1.move(4, 2);
        assertEquals(13, player2.getPosition());
    }
    
    @Test
    public void testMove3Players()
    {
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Tim");
        Player player3 = new Player("John");
        Joker joker1 = new Joker();
        GameControl gc1 = new GameControl(2, player1, player2, player3, joker1);
        
        assertEquals(1, player1.getPosition());
        assertEquals(1, player2.getPosition());
        assertEquals(1, player3.getPosition());
        gc1.move(6, 1);
        assertEquals(7, player1.getPosition());
        gc1.move(3, 2);
        assertEquals(4, player2.getPosition());
        gc1.move(5, 3);
        assertEquals(6, player3.getPosition());
        
        gc1.move(1, 1);
        assertEquals(8, player1.getPosition());
        gc1.move(5, 2);
        assertEquals(9, player2.getPosition());
        gc1.move(1, 3);
        assertEquals(7, player3.getPosition());
        
        gc1.move(2, 1);
        assertEquals(10, player1.getPosition());
        gc1.move(4, 2);
        assertEquals(13, player2.getPosition());
        gc1.move(4, 3);
        assertEquals(11, player3.getPosition());
    }
    
    @Test
    public void testDeterminePosition()
    {
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Tim");
        Joker joker1 = new Joker();
        GameControl gc1 = new GameControl(2, player1, player2, joker1);
        
        assertEquals(1, player1.getPosition());
        assertEquals(1, player2.getPosition());
        gc1.move(6, 1);
        assertEquals(7, player1.getPosition());
        gc1.move(3, 2);
        assertEquals(4, player2.getPosition());
        gc1.move(1, 1);
        assertEquals(8, player1.getPosition());
        gc1.move(5, 2);
        assertEquals(9, player2.getPosition());
        gc1.move(2, 1);
        assertEquals(10, player1.getPosition());
        gc1.move(4, 2);
        assertEquals(13, player2.getPosition());
    }

    @Test
    public void testSwitchTurn2Players()
    {
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Tim");
        Joker joker1 = new Joker();
        GameControl gc1 = new GameControl(2, player1, player2, joker1);
        int turn = 1;
        if (turn < 2)
        {
            turn++;
        }
        else
        {
            turn = 1;
        }
        assertTrue(turn >= 1 && turn <= 2);        
    }
    
    @Test
    public void testSwitchTurn3Players()
    {
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Tim");
        Player player3 = new Player("Jim");
        Joker joker1 = new Joker();
        GameControl gc1 = new GameControl(3, player1, player2, player3, joker1);
        int turn = 1;
        if (turn < 3)
        {
            turn++;
        }
        else
        {
            turn = 1;
        }
        assertTrue(turn >= 1 && turn <= 3); 
    }

    @Test
    public void testSnakeCheck()
    {
        ArrayList<Snake> snakes = new ArrayList<Snake>();
        Snake snake1 = new Snake(21, 12);   
        snakes.add(snake1);
        Snake snake2 = new Snake(34, 25);    
        snakes.add(snake2);
        Snake snake3 = new Snake(51, 37);     
        snakes.add(snake3);
        Snake snake4 = new Snake(68, 49);     
        snakes.add(snake4);
        Snake snake5 = new Snake(87, 38);     
        snakes.add(snake5);
        Snake snake6 = new Snake(95, 20);     
        snakes.add(snake6);
        
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Tim");
        Player player3 = new Player("Jim");
        Joker joker1 = new Joker();
        GameControl gc1 = new GameControl(3, player1, player2, player3, joker1);
        int turn = 1;
        
        boolean snakeCheck = false;
        for (int i = 1; i <= 1000; i++)
        {
            Random random = new Random();
            int randomPosition = random.nextInt(100) + 1;
            if (turn < 3)
            {
                turn++;
            }
            else
            {
                turn = 1;
            }
            for(Snake snake:snakes) 
            {
                  if (turn == 1)
                  {
                    if (snake.getStartPosition() == player1.getPosition())
                    {
                        snakeCheck = true;
                        assertTrue(snakeCheck);
                    }   
                  }
                  if (turn == 2)
                  {
                      if (snake.getStartPosition() == player2.getPosition())
                      {
                          snakeCheck = true;
                          assertTrue(snakeCheck);
                      }
                  }
                  if (turn == 3)
                  {
                      if (snake.getStartPosition() == player3.getPosition())
                      {
                          snakeCheck = true;
                          assertTrue(snakeCheck);
                      }
                  }
             }
        }
    }
    
    @Test
    public void testLadderCheck()
    {
        ArrayList<Ladder> ladders = new ArrayList<Ladder>();
        Ladder ladder1 = new Ladder(8, 24);   
        ladders.add(ladder1);
        Ladder ladder2 = new Ladder(17, 39);    
        ladders.add(ladder2);
        Ladder ladder3 = new Ladder(30, 50);     
        ladders.add(ladder3);
        Ladder ladder4 = new Ladder(42, 67);    
        ladders.add(ladder4);
        Ladder ladder5 = new Ladder(60, 77);     
        ladders.add(ladder5);
        Ladder ladder6 = new Ladder(82, 92);     
        ladders.add(ladder6);
        
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Tim");
        Player player3 = new Player("Jim");
        Joker joker1 = new Joker();
        GameControl gc1 = new GameControl(3, player1, player2, player3, joker1);
        int turn = 1;
        
        boolean ladderCheck = false;
        for (int i = 1; i <= 1000; i++)
        {
            Random random = new Random();
            int randomPosition = random.nextInt(100) + 1;
            if (turn < 3)
            {
                turn++;
            }
            else
            {
                turn = 1;
            }
            for(Ladder ladder:ladders) 
            {
                  if (turn == 1)
                  {
                    if (ladder.getStartPosition() == player1.getPosition())
                    {
                        ladderCheck = true;
                        assertTrue(ladderCheck);
                    }   
                  }
                  if (turn == 2)
                  {
                      if (ladder.getStartPosition() == player2.getPosition())
                      {
                          ladderCheck = true;
                          assertTrue(ladderCheck);
                      }
                  }
                  if (turn == 3)
                  {
                      if (ladder.getStartPosition() == player3.getPosition())
                      {
                          ladderCheck = true;
                          assertTrue(ladderCheck);
                      }
                  }
             }
        }
    }
    
    @Test
    public void testCheckWin()
    {
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Tim");
        Player player3 = new Player("Jim");
        Joker joker1 = new Joker();
        GameControl gc1 = new GameControl(3, player1, player2, player3, joker1);
        int turn = 1;
        
        boolean win = false;
        for (int i = 1; i <= 1000; i++)
        {
            Random random = new Random();
            int randomPosition = random.nextInt(100) + 1;
            if (turn < 3)
            {
                turn++;
            }
            else
            {
                turn = 1;
            }
            if (turn == 1)
            {
                    if (100 == player1.getPosition())
                    {
                        win = true;
                        assertTrue(win);
                    }   
            }
            if (turn == 2)
            {
                    if (100 == player2.getPosition())
                    {
                        win = true;
                        assertTrue(win);
                    }
            }
            if (turn == 3)
            {
                    if (100 == player3.getPosition())
                    {
                        win = true;
                        assertTrue(win);
                    }
            }
        }
    }
    
    public void testOnJoker()
    {
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Tim");
        Player player3 = new Player("Jim");
        Joker joker1 = new Joker();
        GameControl gc1 = new GameControl(3, player1, player2, player3, joker1);
        int turn = 1;
        for (int i = 1; i <= 100; i++)
        {
            if (turn <= 3)
            {
                turn++;
            }
            else
            {
                turn = 1;
            }
            boolean onJoker = false;
            if (turn == 1)
            {
                if (player1.getPosition() == joker1.getPosition())
                {
                    onJoker = true;
                    assertTrue(onJoker);
                }
    		}
    		else if (turn == 2)
    		{
    		    if (player2.getPosition() == joker1.getPosition())
    		    {
    		        onJoker = true;
    		        assertTrue(onJoker);
    		      }
    		}
    		else if (turn == 3)
    		{
    		    if (player3.getPosition() == joker1.getPosition())
    		    {
    		        onJoker = true;
    		        assertTrue(onJoker);
    		    }
    		}
        }
    }

    @Test
    public void testGetWildcardNumber()
    {
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Tim");
        Joker joker1 = new Joker();
        GameControl gameCont1 = new GameControl(2, player1, player2, joker1);
        assertEquals(1, gameCont1.getWildcardNumber(player1));
        player1.addWildcard();
        player1.addWildcard();
        assertEquals(3, gameCont1.getWildcardNumber(player1));
        player1.deductWildcard();
        assertEquals(2, gameCont1.getWildcardNumber(player1));
        player1.deductWildcard();
        player1.deductWildcard();
        assertEquals(1, gameCont1.getWildcardNumber(player2));
        assertEquals(0, gameCont1.getWildcardNumber(player1));
    }
    
    @Test
    public void testDeductWildcard()
    {
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Tim");
        Joker joker1 = new Joker();
        GameControl gc1 = new GameControl(2, player1, player2, joker1);
        assertEquals(1, gc1.getWildcardNumber(player1));
        player1.addWildcard();
        player1.addWildcard();
        assertEquals(3, gc1.getWildcardNumber(player1));
        player1.deductWildcard();
        assertEquals(2, gc1.getWildcardNumber(player1));
        player1.deductWildcard();
        player1.deductWildcard();
        assertEquals(0, gc1.getWildcardNumber(player1));
        player1.deductWildcard();
        assertEquals(0, gc1.getWildcardNumber(player1));
        assertEquals(1, gc1.getWildcardNumber(player2));
        player2.deductWildcard();
        assertEquals(0, gc1.getWildcardNumber(player2));
    }
}
