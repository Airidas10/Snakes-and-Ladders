

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SnakeTest.
 *
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class SnakeTest
{
    /**
     * Default constructor for test class SnakeTest
     */
    public SnakeTest()
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
    public void testGetStartPosition()
    {
        Snake snake1 = new Snake(21, 12);
        Snake snake2 = new Snake(34, 25);
        Snake snake3 = new Snake(51, 37);
        Snake snake4 = new Snake(68, 49);
        Snake snake5 = new Snake(87, 38);
        Snake snake6 = new Snake(95, 20);
        assertEquals(21, snake1.getStartPosition());
        assertEquals(34, snake2.getStartPosition());
        assertEquals(51, snake3.getStartPosition());
        assertEquals(68, snake4.getStartPosition());
        assertEquals(87, snake5.getStartPosition());
        assertEquals(95, snake6.getStartPosition());
    }

    @Test
    public void testGetEndPosition()
    {
        Snake snake1 = new Snake(21, 12);
        Snake snake2 = new Snake(34, 25);
        Snake snake3 = new Snake(51, 37);
        Snake snake4 = new Snake(68, 49);
        Snake snake5 = new Snake(87, 38);
        Snake snake6 = new Snake(95, 20);
        assertEquals(12, snake1.getEndPosition());
        assertEquals(25, snake2.getEndPosition());
        assertEquals(37, snake3.getEndPosition());
        assertEquals(49, snake4.getEndPosition());
        assertEquals(38, snake5.getEndPosition());
        assertEquals(20, snake6.getEndPosition());
    }
}


