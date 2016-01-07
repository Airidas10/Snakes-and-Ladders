import java.util.Random;

/**
 * This class is for a die object.
 * This die is used, when a user rolls it to get a random value between 1 and 6.
 * 
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class Joker 
{
	private int position;
	
	/**
     * The constructor for objects of class Joker.
     * The method is called to generate a random, yet correct position
     * for the joker to be in. 
     */
	public Joker()
	{
		generatePosition();
	}
	
	/**
     * The method which generates a random number between 21 and 80 and assigns it to the Joker.
     */
	public void generatePosition()
	{
		Random randomPosition = new Random();
		int position = randomPosition.nextInt(60) + 21;
		this.position = position;
	}
	
	/**
     * The method which calls a method to re-generate a position of a Joker 
     * (knowing that the previous one wasn't correct) and returns it.
     * 
     * @return    Newly generated position
     */
	public int newPosition()
	{
		generatePosition();
		return position;
	}
	
	/**
     * The method which checks if the position is correct and then returns it if it is.
     * If it's not, it re-generates the position and repeats the process. 
     * 
     * @return    A correct position of the Joker.
     */
	public int getPosition()
	{
		int pos = position;
		while (pos == 21 || pos == 34 || pos == 51 || pos == 68 || pos == 8 || pos == 17 || 
			   pos == 30 || pos == 42 || pos == 60)
		{
			pos = newPosition();
		}
		return pos;	
	}	
}
