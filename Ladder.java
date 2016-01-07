
/**
 * This class is for a ladder object.
 * The ladders are placed on the board with their end position
 * bigger than their start position. 
 * 
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class Ladder 
{
	private int startPos;
	private int endPos;
	
	/**
     * The constructor for objects of class Ladder.
     * 
     * @param start      The "start" of the ladder.
     * @param end        The "end" of the ladder.
     */
	public Ladder(int start, int end)
	{
		startPos = start;
		endPos = end;
	}
	
	/**
     * The method which returns where the "start" of the ladder is.
     * 
     * @param return      The "start" of the ladder.
     */
	public int getStartPosition()
	{
		return startPos;
	}
	
	/**
     * The method which returns where the "end" of the ladder is.
     * 
     * @param return      The "end" of the ladder.
     */
	public int getEndPosition()
	{
		return endPos;
	}
}
