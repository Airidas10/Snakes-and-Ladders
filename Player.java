import javax.swing.JOptionPane;

/**
 * This class is for a player object.
 * Player objects represent all the actions the players take while playing
 * and reflect on their state. 
 * 
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class Player 
{
	private String name;
	private int positionPlayer;
	private int wildcardNumber;
	private JOptionPane bounce;
	
	/**
     * The constructor for objects of class Player.
     * 
     * @param gamer      The name of the player.
     */
	public Player(String gamer)
	{
		name = gamer;
		positionPlayer = 1;	
		wildcardNumber = 1;
		bounce = new JOptionPane();
	}
	
	/** 
	*	A move method to make the player move by the number rolled by rolling the die. 
	*   If that would mean going to a position bigger than 100, the player "bounces" and goes back.
	*	
	*	@param result       The number by which the player should move.
	*/
	public void move(int result)
	{
		if (positionPlayer + result <= 100)
		{
			positionPlayer = positionPlayer + result;
		}
		else
		{
			bounce.showMessageDialog(null, "Bounce!", "Bounce", JOptionPane.PLAIN_MESSAGE);
			int distance = 100 - positionPlayer;
			int bounce = result - distance;
			positionPlayer = 100 - bounce;
		}
	}
	
	/** 
	*	A method which returns the position of the player.
	*	
	*	@return    The position of a player.
	*/
	public int getPosition()
	{
		return positionPlayer;
	}
	
	/** 
	*	A method which returns the name of the player.
	*	
	*	@return    The name of a player.
	*/
	public String getName()
	{
		return name;
	}
	
	/** 
	*	A method which makes the player move down the snake.
	*
	*	@param snake      The snake on which the player is.
	*/
	public void moveDownTheSnake(Snake snake)
	{
		positionPlayer = snake.getEndPosition();
	}
	
	/** 
	*	A method which makes the player move up the ladder.
	*
	*	@param ladder      The ladder on which the player is.
	*/
	public void moveUpTheLadder(Ladder ladder)
	{
		positionPlayer = ladder.getEndPosition();
	}
	
	/** 
	*	A method which returns the number of wildcards that the player has.
	*	
	*	@return    The number of wildcards.
	*/
	public int getWildcardNumber()
	{
		return wildcardNumber;
	}
	
	/** 
	*	A method which takes away 1 wildcard, if the player has any left.
	*/
	public void deductWildcard()
	{
		if (wildcardNumber > 0)
		{
			wildcardNumber--;
		}
	}
	
	/** 
	*	A method which adds 1 wildcard for the player.
	*/
	public void addWildcard()
	{
		wildcardNumber++;
	}
	
	/** 
	*	A method which sets a position for the player.
	*/
	public void setPosition(int newPos)
	{
		positionPlayer = newPos;
	}
}
