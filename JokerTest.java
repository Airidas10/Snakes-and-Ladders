

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class JokerTest.
 *
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class JokerTest
{
    /**
     * Default constructor for test class JokerTest
     */
    public JokerTest()
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
    public void testGeneratePosition()
    {
        Joker joker1 = new Joker();
        for (int i = 1; i <= 100; i++)
        {
            joker1.generatePosition();
            int position = joker1.getPosition();
            assertTrue(position >= 21 && position <= 80);
        }
    }

    @Test
    public void testGetPosition()
    {
        Joker joker1 = new Joker();
        for (int i = 1; i <= 100; i++)
        {
            int pos = joker1.getPosition();
            assertTrue(pos > 21 && pos <= 80 && pos != 34 && pos != 51 
                    && pos != 68 && pos != 30 && pos != 42 && pos != 60);
        }
    }

    @Test
    public void testNewPosition()
    {
        Joker joker1 = new Joker();
        int position = joker1.newPosition();
        assertTrue(position >= 21 && position <= 80);
    }
}



