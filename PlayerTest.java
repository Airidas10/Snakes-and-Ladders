

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerTest.
 *
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class PlayerTest
{
    /**
     * Default constructor for test class PlayerTest
     */
    public PlayerTest()
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
    public void testGetPosition()
    {
        Player player1 = new Player("LAA");
        assertEquals(1, player1.getPosition());
        player1.move(20);
        assertEquals(21, player1.getPosition());
        player1.move(47);
        assertEquals(68, player1.getPosition());
        player1.setPosition(99);
        assertEquals(99, player1.getPosition());
        player1.setPosition(100);
        assertEquals(100, player1.getPosition());
    }

    @Test
    public void testGetName()
    {
        Player player1 = new Player("John");
        Player player2 = new Player("Peter");
        Player player3 = new Player("Airidas");
        Player player4 = new Player("Tony");
        Player player5 = new Player("Gary");
        assertEquals("John", player1.getName());
        assertEquals("Peter", player2.getName());
        assertEquals("Airidas", player3.getName());
        assertEquals("Tony", player4.getName());
        assertEquals("Gary", player5.getName());
    }

    @Test
    public void testGetWildcardNumber()
    {
        Player player1 = new Player("Airidas");
        assertEquals(1, player1.getWildcardNumber());
        player1.addWildcard();
        assertEquals(2, player1.getWildcardNumber());
        player1.deductWildcard();
        assertEquals(1, player1.getWildcardNumber());
        player1.deductWildcard();
        assertEquals(0, player1.getWildcardNumber());
        player1.addWildcard();
        assertEquals(1, player1.getWildcardNumber());
        assertEquals(1, player1.getWildcardNumber());
        player1.deductWildcard();
        assertEquals(0, player1.getWildcardNumber());
        player1.deductWildcard();
        assertEquals(0, player1.getWildcardNumber());
        player1.deductWildcard();
        player1.deductWildcard();
        player1.deductWildcard();
        assertEquals(0, player1.getWildcardNumber());
        player1.addWildcard();
        assertEquals(1, player1.getWildcardNumber());
    }

    @Test
    public void testAddWildcard()
    {
        Player player1 = new Player("Airidas");
        assertEquals(1, player1.getWildcardNumber());
        player1.addWildcard();
        assertEquals(2, player1.getWildcardNumber());
        player1.addWildcard();
        assertEquals(3, player1.getWildcardNumber());
    }
    
    @Test
    public void testAddWildcard2()
    {
        Player player1 = new Player("Airidas");
        int numberBefore = player1.getWildcardNumber();
        player1.addWildcard();
        int numberAfter = player1.getWildcardNumber();
        assertTrue(numberAfter - numberBefore == 1);
    }
    
    @Test
    public void testDeductWildcard()
    {
        Player player1 = new Player("Airidas");
        assertEquals(1, player1.getWildcardNumber());
        player1.deductWildcard();
        assertEquals(0, player1.getWildcardNumber());
        player1.deductWildcard();
        assertEquals(0, player1.getWildcardNumber());
    }
    
    @Test
    public void testDeductWildcard2()
    {
        Player player1 = new Player("Airidas");
        int numberBefore = player1.getWildcardNumber();
        player1.deductWildcard();
        int numberAfter = player1.getWildcardNumber();
        if (numberBefore > 0)
        {
            assertTrue(numberBefore - numberAfter == 1);
        }
        else
        {
            assertEquals(0, player1.getWildcardNumber());
        }
    }
    

    @Test
    public void testSetPosition()
    {
        Player player1 = new Player("Airidas");
        player1.setPosition(10);
        assertEquals(10, player1.getPosition());
        player1.setPosition(20);
        assertEquals(20, player1.getPosition());
        player1.setPosition(90);
        assertEquals(90, player1.getPosition());
        player1.setPosition(99);
        assertEquals(99, player1.getPosition());
    }

    @Test
    public void testMove()
    {
        Player player1 = new Player("Airidas");
        assertEquals(1, player1.getPosition());
        player1.move(6);
        assertEquals(7, player1.getPosition());
        player1.move(5);
        assertEquals(12, player1.getPosition());
        player1.move(4);
        assertEquals(16, player1.getPosition());
        player1.move(3);
        assertEquals(19, player1.getPosition());
        player1.move(2);
        assertEquals(21, player1.getPosition());
        player1.move(1);
        assertEquals(22, player1.getPosition());
        assertEquals(22, player1.getPosition());
    }

    @Test
    public void testMoveDownTheSnakes()
    {
        Player player1 = new Player("Airidas");
        Snake snake1 = new Snake(21, 12);
        Snake snake2 = new Snake(34, 25);
        Snake snake3 = new Snake(51, 37);
        Snake snake4 = new Snake(68, 49);
        Snake snake5 = new Snake(87, 38);
        Snake snake6 = new Snake(95, 20);
        player1.moveDownTheSnake(snake1);
        assertEquals(12, player1.getPosition());
        player1.moveDownTheSnake(snake2);
        assertEquals(25, player1.getPosition());
        player1.moveDownTheSnake(snake3);
        assertEquals(37, player1.getPosition());
        player1.moveDownTheSnake(snake4);
        assertEquals(49, player1.getPosition());
        player1.moveDownTheSnake(snake5);
        assertEquals(38, player1.getPosition());
        player1.moveDownTheSnake(snake6);
        assertEquals(20, player1.getPosition());
    }
    
    @Test
    public void testMoveUpTheLadders()
    {
        Player player1 = new Player("Airidas");
        Ladder ladder1 = new Ladder(8, 24);
        Ladder ladder2 = new Ladder(17, 39);
        Ladder ladder3 = new Ladder(30, 50);
        Ladder ladder4 = new Ladder(42, 67);
        Ladder ladder5 = new Ladder(60, 77);
        Ladder ladder6 = new Ladder(82, 92);
        player1.moveUpTheLadder(ladder1);
        assertEquals(24, player1.getPosition());
        player1.moveUpTheLadder(ladder2);
        assertEquals(39, player1.getPosition());
        player1.moveUpTheLadder(ladder3);
        assertEquals(50, player1.getPosition());
        player1.moveUpTheLadder(ladder4);
        assertEquals(67, player1.getPosition());
        player1.moveUpTheLadder(ladder5);
        assertEquals(77, player1.getPosition());
        player1.moveUpTheLadder(ladder6);
        assertEquals(92, player1.getPosition());
    }
}
