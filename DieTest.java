import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DieTest.
 *
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class DieTest
{
    /**
     * Default constructor for test class DieTest
     */
    public DieTest()
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
        Die die1 = new Die();
        for (int i = 1; i <= 100; i++)
        {
            int result = die1.rollDice();
            assertTrue(result >= 1 && result <= 6);
        }
    }
}

