
public class GridControl 
{
	/**
	 * An empty constructor, because the control object doesn't have any attributes.
	 */
	public GridControl()
	{
		
	}
	
	/**
	 *  A method which returns the position of a Player object. 
	 * 
	 * @param user      Player, whose name needs to be returned. 
	 * @return			The position in which the player is.
	 */
	public int determinePosition(Player user)
	{
		return user.getPosition();
	}
	
	/**
	 * A method which returns the name of the player.
	 * 
	 * @param user      Player, whose name needs to be returned. 
	 * @return			The name of the player.
	 */
	public String getName(Player user)
	{
		return user.getName();
	}
	
	/**
	 * A method which returns the position of the joker.
	 * 
	 * @param joker		Joker object, whose position needs to be returned.
	 * @return			The position of the joker.
	 */
	public int getJokerPosition(Joker joker)
	{
		return joker.getPosition();
	}
}
