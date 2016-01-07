

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LadderTest.
 *
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class LadderTest
{
    /**
     * Default constructor for test class LadderTest
     */
    public LadderTest()
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
        Ladder ladder1 = new Ladder(8, 24);
        Ladder ladder2 = new Ladder(17, 39);
        Ladder ladder3 = new Ladder(30, 50);
        Ladder ladder4 = new Ladder(42, 67);
        Ladder ladder5 = new Ladder(60, 77);
        Ladder ladder6 = new Ladder(82, 92);
        assertEquals(8, ladder1.getStartPosition());
        assertEquals(17, ladder2.getStartPosition());
        assertEquals(30, ladder3.getStartPosition());
        assertEquals(42, ladder4.getStartPosition());
        assertEquals(60, ladder5.getStartPosition());
        assertEquals(82, ladder6.getStartPosition());
    }

    @Test
    public void testGetEndPosition()
    {
        Ladder ladder1 = new Ladder(8, 24);
        Ladder ladder2 = new Ladder(17, 39);
        Ladder ladder3 = new Ladder(30, 50);
        Ladder ladder4 = new Ladder(42, 67);
        Ladder ladder5 = new Ladder(60, 77);
        Ladder ladder6 = new Ladder(82, 92);
        assertEquals(24, ladder1.getEndPosition());
        assertEquals(39, ladder2.getEndPosition());
        assertEquals(50, ladder3.getEndPosition());
        assertEquals(67, ladder4.getEndPosition());
        assertEquals(77, ladder5.getEndPosition());
        assertEquals(92, ladder6.getEndPosition());
    }
}


