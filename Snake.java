
/**
 * This class is for a snake object.
 * The snakes are placed on the board with their start position
 * bigger than their end position. 
 * 
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class Snake 
{
	private int startPos;
	private int endPos;
	
	/**
     * The constructor for objects of class Snake.
     * 
     * @param start      The "tail" of the snake.
     * @param end        The "head" of the snake.
     */
	public Snake(int start, int end)
	{
		startPos = start;
		endPos = end;
	}
	
	/**
     * The method which returns where the "tail" is.
     * 
     * @param return      The "tail" of the snake.
     */
	public int getStartPosition()
	{
		return startPos;
	}
	
	/**
     * The method which returns where the "head" is.
     * 
     * @param return      The "head" of the snake.
     */
	public int getEndPosition()
	{
		return endPos;
	}
}
