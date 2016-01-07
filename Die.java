import java.util.Random;

/**
 * This class is for a die object.
 * This die is used, when a user rolls it to get a random value between 1 and 6.
 * 
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class Die 
{
	private Random dieRoll;
	
	/**
     * The constructor for objects of class Die.
     */
	public Die()
	{
		dieRoll = new Random();
	}
	
	/**
	* A method, which generates a random number, which is a simulation of a rolled die.
	*/ 
	public int rollDice()
	{
		int result = dieRoll.nextInt(6) + 1; 
		return result;		
	}
}
