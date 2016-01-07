

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * The test class GridControlTest.
 *
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class GridControlTest
{
    /**
     * Default constructor for test class GridControlTest
     */
    public GridControlTest()
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
    public void testDeterminePosition()
    {
        Player player1 = new Player("Airidas");
        Player player2 = new Player("Gary");
        Player player3 = new Player("Tony");
        Player player4 = new Player("Peter");
        Player player5 = new Player("John");
        GridControl gridCont1 = new GridControl();
        assertEquals(1, gridCont1.determinePosition(player1));
        player2.setPosition(74);
        assertEquals(74, player2.getPosition());
        player3.setPosition(20);
        assertEquals(20, gridCont1.determinePosition(player3));
        player4.move(6);
        assertEquals(7, gridCont1.determinePosition(player4));
        Ladder ladder1 = new Ladder(8, 24);
        player5.moveUpTheLadder(ladder1);
        assertEquals(24, gridCont1.determinePosition(player5));
    }
    
    @Test
    public void testDeterminePosition2()
    {
        Player player1 = new Player("Airidas");
        GridControl gridCont1 = new GridControl();
        Random random = new Random();
        for (int i = 1; i <= 100; i++)
        {
            int randomNumber = random.nextInt(100) + 1;
            player1.setPosition(randomNumber);
            int position = player1.getPosition();
            assertEquals(position, gridCont1.determinePosition(player1));
        }
    }
}

