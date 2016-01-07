import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

/**
 * This class is a control class. 
 * The GUI interacts with this class and this class then 
 * interacts with the entity objects.  
 * 
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class GameControl 
{
	private Die die;
	private int playersNumber;
    private int turn;
	private Player user1;
	private Player user2;
	private Player user3;
	
	private Joker joker;
	
	private Snake snake1;
	private Snake snake2;
	private Snake snake3;
	private Snake snake4;
	private Snake snake5;
	private Snake snake6;
	
	private Ladder ladder1;
	private Ladder ladder2;
	private Ladder ladder3;
	private Ladder ladder4;
	private Ladder ladder5;
	private Ladder ladder6;
	
	private JOptionPane jokerMessage;
	
	/**
     * The first constructor for objects of class GameControl (for 2 players).
     * 
     * @param players    The number of players.
     * @param p1     The first player.
     * @param p2     The second player.
     * @param joker      The joker object.
     */
	public GameControl(int players, Player p1, Player p2, Joker joker)
	{
		playersNumber = players;
		die = new Die();
		turn = 1;
		user1 = p1;
		user2 = p2;
		this.joker = joker;
		
		ArrayList<Snake> snakes = new ArrayList<Snake>();
		snake1 = new Snake(21, 12);   
		snakes.add(snake1);
		snake2 = new Snake(34, 25);    
		snakes.add(snake2);
		snake3 = new Snake(51, 37);     
		snakes.add(snake3);
		snake4 = new Snake(68, 49);     
		snakes.add(snake4);
		snake5 = new Snake(87, 38);     
		snakes.add(snake5);
		snake6 = new Snake(95, 20);     
		snakes.add(snake6);
		
		ArrayList<Ladder> ladders = new ArrayList<Ladder>();
		ladder1 = new Ladder(8, 24);   
		ladders.add(ladder1);
		ladder2 = new Ladder(17, 39);    
		ladders.add(ladder2);
		ladder3 = new Ladder(30, 50);     
		ladders.add(ladder3);
		ladder4 = new Ladder(42, 67);    
		ladders.add(ladder4);
		ladder5 = new Ladder(60, 77);     
		ladders.add(ladder5);
		ladder6 = new Ladder(82, 92);     
		ladders.add(ladder6);
		
		jokerMessage = new JOptionPane();
	}
	
	/**
     * The second constructor for objects of class GameGUI (for 3 players).
     * 
     * @param players    The number of players.
     * @param p1     The first player.
     * @param p2     The second player.
     * @param p3     The third player.
     * @param joker      The joker object.
     */
	public GameControl(int players, Player p1, Player p2, Player p3, Joker joker)
	{
		playersNumber = players;
		die = new Die();
		turn = 1;
		user1 = p1;
		user2 = p2;
		user3 = p3;
		this.joker = joker;
		
		ArrayList<Snake> snakes = new ArrayList<Snake>();
		snake1 = new Snake(21, 12);   
		snakes.add(snake1);
		snake2 = new Snake(34, 25);    
		snakes.add(snake2);
		snake3 = new Snake(51, 37);     
		snakes.add(snake3);
		snake4 = new Snake(68, 49);     
		snakes.add(snake4);
		snake5 = new Snake(87, 38);     
		snakes.add(snake5);
		snake6 = new Snake(95, 20);     
		snakes.add(snake6);
		
		ArrayList<Ladder> ladders = new ArrayList<Ladder>();
		ladder1 = new Ladder(8, 24);   
		ladders.add(ladder1);
		ladder2 = new Ladder(17, 39);    
		ladders.add(ladder2);
		ladder3 = new Ladder(30, 50);     
		ladders.add(ladder3);
		ladder4 = new Ladder(42, 67);   
		ladders.add(ladder4);
		ladder5 = new Ladder(60, 77);     
		ladders.add(ladder5);
		ladder6 = new Ladder(82, 92);    
		ladders.add(ladder6);
		
		jokerMessage = new JOptionPane();
		
	}
	
	/**
	 *  A method which tells the Die object to roll the die.
	 * 
	 *  @return      The number rolled.
	 */
	public int rollDice()
	{
		int dieRoll = die.rollDice();
		return dieRoll;
	}
	
	/**
	 *  A method which tells the Player objects to move.
	 *  @param dieRoll
	 *  @param turn
	 */
	public void move(int dieRoll, int turn)
	{
		if (turn == 1)
		{
			user1.move(dieRoll);
		}
		if (turn == 2)
		{
			user2.move(dieRoll);
		}
		if (turn == 3)
		{
			user3.move(dieRoll);
		}
	}
	
	/**
	 *  A method which returns the position of a Player object. 
	 * 
	 * @param turn      Whose turn it is.
	 * @return			The position in which the player is.
	 */
	public int determinePosition(int turn)
	{
		if (turn == 1)
		{
			int position = user1.getPosition();
			return position;
			
		}
		if (turn == 2)
		{
			int position = user2.getPosition();
			return position;
		}
		if (turn == 3)
		{
			int position = user3.getPosition();
			return position;
		}
		// Will never get returned
		else
		{
			int position = 0;
			return position;
		}
	}
	
	/**
	 *  A method which switches the turn and tells which player's turn it is to go. 
	 * 
	 *  @return       A variable, which describes whose turn it is.
	 */
	public int switchTurns()
	{
		if (turn < playersNumber)
		{
			turn++;
			return turn;
		}
		else
		{
			turn = 1;
			return turn;
		}
	}
	
	/**
	 *  A method which checks if any player is on the snake. 
	 * 
	 *  @param snakes      All game snakes in an arraylist
	 *  @param turn		   Whose turn it is.	
	 *  @return			   If a player is on the snake. 
	 */
	public boolean snakeCheck(ArrayList<Snake> snakes, int turn)
	{
		boolean test = false;
		Iterator<Snake> it = snakes.iterator();
		while(it.hasNext()) 
		{
			Snake snake = it.next();
			if (turn == 1)
			{
				if (snake.getStartPosition() == user1.getPosition())
				{
					test = true;
				}
			}
			if (turn == 2)
			{
				if (snake.getStartPosition() == user2.getPosition())
				{
					test = true;
				}
			}
			if (turn == 3)
			{
				if (snake.getStartPosition() == user3.getPosition())
				{
					test = true;
				}
			}
		}
		if (test != true)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 *  A method which determines which player is on the snake (only called after the snakeCheck method returns true).
	 * 
	 *  @param snakes      All game snakes in an arraylist
	 *  @param turn		   Whose turn it is.	
	 *  @return			   On which snake the player is. 
	 */
	public Snake whichSnake(ArrayList<Snake> snakes, int turn)
	{
		for(Snake snake:snakes) 
		{
			if (turn == 1)
			{
				if (snake.getStartPosition() == user1.getPosition())
				{
					return snake;
				}
			}
			if (turn == 2)
			{
				if (snake.getStartPosition() == user2.getPosition())
				{
					return snake;
				}
			}
			if (turn == 3)
			{
				if (snake.getStartPosition() == user3.getPosition())
				{
					return snake;
				}
			}
		}
		// This will never be returned.
		return snake1;
	}
	
	/**
	 *  A method which checks if any player is on the ladder.
	 * 
	 * @param ladders	   All game ladder in an arraylist
	 * @param turn		   Whose turn it is.	
	 * @return			   If a player is on the Ladder. 
	 */
	public boolean ladderCheck(ArrayList<Ladder> ladders, int turn)
	{
		boolean test = false;
		Iterator<Ladder> it = ladders.iterator();
		while(it.hasNext()) 
		{
			Ladder ladder = it.next();
			if (turn == 1)
			{
				if (ladder.getStartPosition() == user1.getPosition())
				{
					test = true;
				}
			}
			if (turn == 2)
			{
				if (ladder.getStartPosition() == user2.getPosition())
				{
					test = true;
				}
			}
			if (turn == 3)
			{
				if (ladder.getStartPosition() == user3.getPosition())
				{
					test = true;
				}
			}
		}
		if (test != true)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 *  A method which determines which player is on the ladder (only called after the ladderCheck method returns true)
	 * 
	 * @param ladders	   All game ladder in an arraylist
	 * @param turn		   Whose turn it is.	
	 * @return			   On which ladder the player is. 
	 */
	public Ladder whichLadder(ArrayList<Ladder> ladders, int turn)
	{
		for(Ladder ladder:ladders) 
		{
			if (turn == 1)
			{
				if (ladder.getStartPosition() == user1.getPosition())
				{
					return ladder;
				}
			}
			if (turn == 2)
			{
				if (ladder.getStartPosition() == user2.getPosition())
				{
					return ladder;
				}
			}
			if (turn == 3)
			{
				if (ladder.getStartPosition() == user3.getPosition())
				{
					return ladder;
				}
			}
		}
		// This will never be returned.
		return ladder1;
	}
	
	/**
	 *  A method which determines if any player managed to reach the 100th position.
	 * 
	 * @param turn        Whose turn it is
	 * @return			  If any player won the game.
	 */
	public boolean checkWin(int turn)
	{
		int position = 0;
		if (turn == 1)
		{
			position = user1.getPosition();
		}
		if (turn == 2)
		{
			position = user2.getPosition();
		}
		if (turn == 3)
		{
			position = user3.getPosition();
		}
		if (position == 100)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 *  A method which determines which player won (only called after the checkWin method returns true).
	 * 
	 * @return		Which player won the game
	 */
	public String whoWon()
	{
		int pos1 = user1.getPosition();
		int pos2 = user2.getPosition();
		if (pos1 == 100)
		{
			return user1.getName();
		}
		else if (pos2 == 100)
		{
			return user2.getName();
		}
		else
		{
			return user3.getName();
		}
	}
	
	/**
	 *  A method which determines if any player is on the Joker.
	 * 
	 * @param turn		Whose turn it is.
	 * @return			If any player stepped on the Joker.
	 */
	public boolean onJoker(int turn)
	{
		boolean onJoker = false;
		if (turn == 1)
		{
			if (user1.getPosition() == joker.getPosition())
			{
				onJoker = true;
			}
		}
		else if (turn == 2)
		{
			if (user2.getPosition() == joker.getPosition())
			{
				onJoker = true;
			}
		}
		else if (turn == 3)
		{
			if (user3.getPosition() == joker.getPosition())
			{
				onJoker = true;
			}
		}
		return onJoker;
	}
	
	/**
	 * A method which determines which player is on the joker (only called after the onJoker method returns true).
	 * 
	 * @param turn       Whose turn it is.		
	 * @return			 Which player is on the joker.
	 */
	public Player whoOnJoker(int turn)
	{
		if (turn == 1)
		{
			return user1;
		}
		else if (turn == 2)
		{
			return user2;
		}
		else
		{
			return user3;
		}
	}
	
	/**
	 *  A method which performs the function of a Joker.
	 * 
	 * @param result		The random number, which will determine the actions of the joker.
	 * @param user			The player who will be the recipient of these actions 
	 * 						(the one, who was determined to be on the joker).
	 */
	public void jokerAction(int result, Player user)
	{
		if (result == 1)
		{
			user.setPosition(10);
			jokerMessage.showMessageDialog(null, "Unlucky! The joker moved you to a position 10!", 
					"Joker!", JOptionPane.PLAIN_MESSAGE);
		}
		else if (result == 2)
		{
			user.setPosition(20);
			jokerMessage.showMessageDialog(null, "Unlucky! The joker moved you to a position 20!", 
					"Joker!", JOptionPane.PLAIN_MESSAGE);
		}
		else if (result == 3)
		{
			int numberOfWildcards = user.getWildcardNumber();
			if (numberOfWildcards > 0)
			{
				user.deductWildcard();
				jokerMessage.showMessageDialog(null, "The joker decided to take your wildcard away!", 
						"Joker!", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				jokerMessage.showMessageDialog(null, "The joker wanted to take your wildcard away! " 
						+ "but you didn't have any! \n" 
						+ "He is now furious and moved you back to the start!", 
						"Joker!", JOptionPane.PLAIN_MESSAGE);
				user.setPosition(1);
			}
		}
		else if (result == 4)
		{
			user.addWildcard();
			jokerMessage.showMessageDialog(null, "The joker gave you a wildcard! \n" +
			"Use it wisely!", "Joker!", JOptionPane.PLAIN_MESSAGE);
		}
		else if (result == 5)
		{
			user.setPosition(90);
			jokerMessage.showMessageDialog(null, "Congratulations! The joker moved you to a position 90!", 
					"Joker!", JOptionPane.PLAIN_MESSAGE);
		}
		else if (result == 6)
		{
			user.setPosition(99);
			jokerMessage.showMessageDialog(null, "Congratulations! The joker moved you to a position 99!", 
			"Joker!", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	/**
	 *  A method which returns a "wildcardNumber" attribute of a Player object. 
	 * 
	 * @param user    The Player, whose wildcard number is determined.
	 * @return		  The number of wildcards the said player has.		
	 */
	public int getWildcardNumber(Player user)
	{
		return user.getWildcardNumber();
	}
	
	/**
	 *  A method which makes the Player go down the snake.
	 * 
	 * @param turn 		Whose turn it is.
	 * @param snake		The snake which has "caught" the player.
	 */
	public void snakeMovement(int turn, Snake snake)
	{
		if (turn == 1)
		{
			user1.moveDownTheSnake(snake);
		}
		if (turn == 2)
		{
			user2.moveDownTheSnake(snake);
		}
		if (turn == 3)
		{
			user3.moveDownTheSnake(snake);
		}
	}
	
	/**
	 *  A method which makes the Player go up the ladder.
	 * 
	 * @param turn		Whose turn it is
	 * @param ladder	A ladder which the player will use.
	 */
	public void ladderMovement(int turn, Ladder ladder)
	{
		if (turn == 1)
		{
			user1.moveUpTheLadder(ladder);
		}
		if (turn == 2)
		{
			user2.moveUpTheLadder(ladder);
		}
		if (turn == 3)
		{
			user3.moveUpTheLadder(ladder);
		}
	}
	
	/**
	 *  A method which takes away a wildcard from the player.
	 * 
	 * @param turn		Whose turn it is.
	 */
	public void deductWildcard(int turn)
	{
		if (turn == 1)
		{
			user1.deductWildcard();
		}
		if (turn == 2)
		{
			user2.deductWildcard();
		}
		if (turn == 3)
		{
			user3.deductWildcard();
		}
	}
}
