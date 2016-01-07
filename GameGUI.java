import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is responsible for the main interface of the game. 
 * The frame consists of 2 panels. This interface gets updated as the game progresses.
 * 
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class GameGUI extends JFrame 
{
	GameControl gc;

	private int playersNumber;
	private String player1;
	private String player2;
	private String player3;
	private int turn;
	private int diceRoll;

	private JFrame frame;
	private JPanel container;
	private Grid grid;
	private JPanel panel2;
	private JButton rollButton;
	private JButton moveButton;
	private JButton wildcardButton;
	private JButton endButton;
	private JTextField result;
	private JLabel playerName;
	private JTextField position;
	private JTextField wildcards;
	private JOptionPane move;
	private JOptionPane name;
	private JOptionPane usedWildcard;
	private JOptionPane winner;
	private JOptionPane reallyRestart;
	private JOptionPane snakeExplained;
	private JOptionPane ladderExplained;
	private JOptionPane wildcardExplained;
	private JOptionPane jokerExplained;
	private JOptionPane rulesExplained;

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenu menu2;
	private JMenu menu3;
	private JMenuItem restart;
	private JMenuItem snakeMenu;
	private JMenuItem ladderMenu;
	private JMenuItem wildcardMenu;
	private JMenuItem jokerMenu;
	private JMenuItem rulesMenu;
	private JMenuItem contact;

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
	private ArrayList<Snake> snakes;

	private Ladder ladder1;
	private Ladder ladder2;
	private Ladder ladder3;
	private Ladder ladder4;
	private Ladder ladder5;
	private Ladder ladder6;
	private ArrayList<Ladder> ladders;

	
	/**
     * The first constructor for objects of class GameGUI (for 2 players).
     * 
     * @param players    The number of players.
     * @param gamer1     The first player.
     * @param gamer2     The second player.
     */
	public GameGUI(int players, String gamer1, String gamer2)
	{
		playersNumber = players;
		turn = 1;

		user1 = new Player(gamer1);
		user2 = new Player(gamer2);

		joker = new Joker();

		gc = new GameControl(players, user1, user2, joker);

		frame = new JFrame();
		container = new JPanel();
		grid = new Grid(players, user1, user2, joker);
		panel2 = new JPanel();
		result = new JTextField();
		playerName = new JLabel();
		position = new JTextField();
		wildcards = new JTextField();
		move = new JOptionPane();
		name = new JOptionPane();
		usedWildcard = new JOptionPane();
		winner = new JOptionPane();
		reallyRestart = new JOptionPane();
		snakeExplained = new JOptionPane();
		ladderExplained = new JOptionPane();
		wildcardExplained = new JOptionPane();
		jokerExplained = new JOptionPane();
		rulesExplained = new JOptionPane();

		menuBar = new JMenuBar();
		menu = new JMenu("Game");
		menu2 = new JMenu("Explanations");
		menu3 = new JMenu("Contact the developers");
		restart = new JMenuItem("Restart game");
		snakeMenu = new JMenuItem("Snakes");
		ladderMenu = new JMenuItem("Ladders");
		wildcardMenu = new JMenuItem("Wildcard");
		jokerMenu = new JMenuItem("Joker");
		rulesMenu = new JMenuItem("Game Rules");
		contact = new JMenuItem("Write us an e-mail!");

		menu.add(restart);
		menu2.add(snakeMenu);
		menu2.add(ladderMenu);
		menu2.add(wildcardMenu);
		menu2.add(jokerMenu);
		menu2.add(rulesMenu);
		menu3.add(contact);
		menuBar.add(menu);
		menuBar.add(menu2);
		menuBar.add(menu3);
		frame.setJMenuBar(menuBar);

		player1 = user1.getName();
		player2 = user2.getName();

		snakes = new ArrayList<Snake>();
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


		ladders = new ArrayList<Ladder>();
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

		createView();
	}
	
	/**
     * The second constructor for objects of class GameGUI (for 3 players).
     * 
     * @param players    The number of players.
     * @param gamer1     The first player.
     * @param gamer2     The second player.
     * @param gamer3     The third player.
     */
	public GameGUI(int players, String gamer1, String gamer2, String gamer3)
	{
		playersNumber = players;
		turn = 1;

		user1 = new Player(gamer1);
		user2 = new Player(gamer2);
		user3 = new Player(gamer3);

		joker = new Joker();

		gc = new GameControl(players, user1, user2, user3, joker);

		frame = new JFrame();
		container = new JPanel();
		grid = new Grid(players, user1, user2, user3, joker);
		panel2 = new JPanel();
		result = new JTextField();
		playerName = new JLabel();
		position = new JTextField();
		wildcards = new JTextField();
		move = new JOptionPane();
		name = new JOptionPane();
		usedWildcard = new JOptionPane();
		winner = new JOptionPane();
		reallyRestart = new JOptionPane();
		snakeExplained = new JOptionPane();
		ladderExplained = new JOptionPane();
		wildcardExplained = new JOptionPane();
		jokerExplained = new JOptionPane();
		rulesExplained = new JOptionPane();

		menuBar = new JMenuBar();
		menu = new JMenu("Game");
		menu2 = new JMenu("Explanations");
		menu3 = new JMenu("Contact the developers");
		restart = new JMenuItem("Restart game");
		snakeMenu = new JMenuItem("Snakes");
		ladderMenu = new JMenuItem("Ladders");
		wildcardMenu = new JMenuItem("Wildcard");
		jokerMenu = new JMenuItem("Joker");
		rulesMenu = new JMenuItem("Game Rules");
		contact = new JMenuItem("Write us an e-mail!");

		menu.add(restart);
		menu2.add(snakeMenu);
		menu2.add(ladderMenu);
		menu2.add(wildcardMenu);
		menu2.add(jokerMenu);
		menu2.add(rulesMenu);
		menu3.add(contact);
		menuBar.add(menu);
		menuBar.add(menu2);
		menuBar.add(menu3);
		frame.setJMenuBar(menuBar);

		player1 = user1.getName();
		player2 = user2.getName();
		player3 = user3.getName();

		snakes = new ArrayList<Snake>();
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


		ladders = new ArrayList<Ladder>();
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

		createView();
	}

	/**
	 *  A method which creates the GUI visible for the users.
	 */
	public void createView()
	{
		// Modification of a JFrame
		frame.setSize(1280, 720);
		frame.setLocation(50, 10);
		frame.setTitle("Snakes And Ladders");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creation of a container JPanel, that later gets split up into 2 smaller JPanels
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

		// A call to another class, which creates the bigger JPanel and draws a 10x10 grid.
		grid.setPreferredSize(new Dimension(905, 720));

		// Creation and modification of a second JPanel.
		panel2.setLayout(new GridBagLayout());
		panel2.setPreferredSize(new Dimension(370, 720));

		// Addition of both smaller JPanels to the container JPanel.
		container.add(grid);
		container.add(panel2);

		// Creating a "roll dice" button with an image
		ImageIcon rollDice = new ImageIcon(getClass().getResource("dice.jpg"));
		rollButton = new JButton(rollDice);

		// Modification of a "Roll dice" button and it's addition on JPanel2.
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 100;
		gbc.weighty = 100;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(20, 0, 0, 0);
		rollButton.setPreferredSize(new Dimension(296, 140));
		panel2.add(rollButton, gbc);

		//Modifications of a text field, where the result of a thrown dice will be shown.
		result.setPreferredSize(new Dimension(296, 30));
		result.setEditable(false);
		result.setHorizontalAlignment(JTextField.CENTER);
		gbc.insets = new Insets(200, 0, 0, 0);
		panel2.add(result, gbc);

		//Modifications of a label, where the player's name will be shown.
		playerName.setText(player1);
		playerName.setForeground(Color.RED);
		playerName.setFont(new Font("Georgia", Font.BOLD + Font.ITALIC, 30));
		playerName.setHorizontalAlignment(JTextField.CENTER);
		gbc.insets = new Insets(250, 0, 0, 0);
		panel2.add(playerName, gbc);

		//Modifications of a text field, where the position of a player will be shown.
		position.setPreferredSize(new Dimension(296, 30));
		position.setEditable(false);
		position.setText("Your current position is:  1");
		position.setHorizontalAlignment(JTextField.CENTER);
		gbc.insets = new Insets(300, 0, 0, 0);
		panel2.add(position, gbc);


		// Creating a "Move figures" button with an image
		ImageIcon moveFigures = new ImageIcon(getClass().getResource("move.png"));
		moveButton = new JButton(moveFigures);

		// Modification of a "Move figures" button and it's addition on JPanel2.
		gbc.insets = new Insets(370, -125, 0, 0);
		moveButton.setPreferredSize(new Dimension(117, 154));
		panel2.add(moveButton, gbc);
		moveButton.setEnabled(false);

		// Creating a "Use wildcard" button with an image
		ImageIcon wildcardImg = new ImageIcon(getClass().getResource("wildcard.png"));
		wildcardButton = new JButton(wildcardImg);

		// Modification of a "Use wildcard" button and it's addition on JPanel2.
		gbc.insets = new Insets(370, 125, 0, 0);
		wildcardButton.setPreferredSize(new Dimension(117, 154));
		panel2.add(wildcardButton, gbc);
		wildcardButton.setEnabled(false);

		// Creating an "end turn" button with an image
		ImageIcon endTurn = new ImageIcon(getClass().getResource("endTurn.png"));
		endButton = new JButton(endTurn);

		// Modification of an "end turn" button and it's addition on JPanel2.
		gbc.insets = new Insets(570, 0, 0, 0);
		endButton.setPreferredSize(new Dimension(200, 80));
		endButton.setEnabled(false);
		panel2.add(endButton, gbc);

		//Modifications of a text field, where the number of remaining wildcards will be shown.
		wildcards.setPreferredSize(new Dimension(296, 30));
		wildcards.setEditable(false);
		wildcards.setText("Wildcards left: 1");
		wildcards.setHorizontalAlignment(JTextField.CENTER);
		gbc.insets = new Insets(535, 0, 0, 0);
		panel2.add(wildcards, gbc);


		// Action listener, which gets activated after the "roll dice" button is pressed.
		rollButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// Simulate the roll of a die.
				diceRoll = gc.rollDice();
				result.setText("You rolled " + diceRoll);

				// Enable the right buttons.
				rollButton.setEnabled(false);
				moveButton.setEnabled(true);
				
				// Checks for each player to see, if they have any remaining wildcards.
				if (turn == 1)
				{
					int wildcardNumber = gc.getWildcardNumber(user1);
					if (wildcardNumber > 0)
					{
						wildcardButton.setEnabled(true);
					}
				}
				if (turn == 2)
				{
					int wildcardNumber = gc.getWildcardNumber(user2);
					if (wildcardNumber > 0)
					{
						wildcardButton.setEnabled(true);
					}
				}
				if (turn == 3)
				{
					int wildcardNumber = gc.getWildcardNumber(user3);
					if (wildcardNumber > 0)
					{
						wildcardButton.setEnabled(true);
					}
				}

			}
		});

		// Action listener, which gets activated after the "roll dice" button is pressed.
		moveButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// Update the player's position
				gc.move(diceRoll, turn);
							
				// Check if the player is on the snake.
				boolean onSnake = gc.snakeCheck(snakes, turn);

				// Check if the player is on the ladder.
				boolean onLadder = gc.ladderCheck(ladders, turn);
				
				// Check if the player has won.
				boolean isWinner = gc.checkWin(turn);
				
				// Actions to do, if the player happens to be on a snake.
				if (onSnake == true)
				{
					// Update the GUI.
					grid.repaint();
					// Determine which snake has "caught" the player.
					Snake snake = gc.whichSnake(snakes, turn);
					// Display a pop-up window to the player.
					JOptionPane.showMessageDialog(null, "You stepped on a snake!" + 
							"\n You move to a position " + snake.getEndPosition(), 
							"Snake!", JOptionPane.PLAIN_MESSAGE);
					// Move the players down the snake.
					gc.snakeMovement(turn, snake);
				}
				
				// Actions to do, if the player happens to be on a ladder.
				if (onLadder == true)
				{
					// Update the GUI.
					grid.repaint();
					// Determine which ladder was "found" by the player.
					Ladder ladder = gc.whichLadder(ladders, turn);
					// Display a pop-up window to the player.
					JOptionPane.showMessageDialog(null, "You stepped on a ladder!" + 
							"\n You move to a position " + ladder.getEndPosition(), 
							"Ladder!", JOptionPane.PLAIN_MESSAGE);
					// Move the players up the ladder.
					gc.ladderMovement(turn, ladder);
				}
				
				// Check if the player is on the Joker.
				boolean onJoker = gc.onJoker(turn);
				if (onJoker == true)
				{
					// Determine where the players are.
					int player1Pos = gc.determinePosition(turn);
					int player2Pos = gc.determinePosition(turn);
					int player3Pos = gc.determinePosition(turn);
					
					// Announce the player's, whose turn it is, position.
					if (turn == 1)
					{
						position.setText("Your current position is: " + player1Pos);
					}
					if (turn == 2)
					{
						position.setText("Your current position is: " + player2Pos);
					}
					if (turn == 3)
					{
						position.setText("Your current position is: " + player3Pos);
					}
					// Update the GUI.
					grid.repaint();
					// Generate a Joker number.	
					Random random = new Random();
					int jokerNumber = random.nextInt(6) + 1;
					// Determine which player is on the joker.
					Player user = gc.whoOnJoker(turn);
					// Display a pop-up window to the player.
					JOptionPane.showMessageDialog(null, "You stepped on a joker!" + 
							"\n He gives you a random number! " + jokerNumber, 
							"Joker!", JOptionPane.PLAIN_MESSAGE);
					// Trigger a joker action.
					gc.jokerAction(jokerNumber, user);
					// Determine the amount of wildcards the player has left and update the display. 
					int amountOfWildcards = gc.getWildcardNumber(user);
					wildcards.setText("Wildcards left: " + amountOfWildcards);
					// Update the GUI.
					grid.repaint();
					
					// Enable the right buttons.
					rollButton.setEnabled(false);
					moveButton.setEnabled(false);
					wildcardButton.setEnabled(false);
					endButton.setEnabled(true);
				}
				// Actions to do if the player is not on the joker.
				if (onJoker == false)
				{
					// Update the GUI.
					grid.repaint();

					// Enable the right buttons.
					rollButton.setEnabled(false);
					moveButton.setEnabled(false);
					wildcardButton.setEnabled(false);
					endButton.setEnabled(true);
				}
				
				// Determine where players are.
				int player1Pos = gc.determinePosition(turn);
				int player2Pos = gc.determinePosition(turn);
				int player3Pos = gc.determinePosition(turn);
				
				// Announce the player's, whose turn it is, position.
				if (turn == 1)
				{
					position.setText("Your current position is: " + player1Pos);
				}
				if (turn == 2)
				{
					position.setText("Your current position is: " + player2Pos);
				}
				if (turn == 3)
				{
					position.setText("Your current position is: " + player3Pos);
				}
				
				// Actions to do, if somebody has reached the 100th position.
				if (isWinner == true)
				{
					// Determine who won the game and display a pop-up window.
					String champion = gc.whoWon();
					winner.showMessageDialog(null, champion + " has won the game!", 
							"We have a winner!", JOptionPane.PLAIN_MESSAGE);
					// Disable  all buttons.
					endButton.setEnabled(false);
				}
			}
		});

		// Action listener, which gets activated after the "Use a wildcard" button is pressed.
		wildcardButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				/*
				 * Determine the amount of remaining wildcards for a player and display it.
				 */
				if (turn == 1)
				{
					gc.deductWildcard(turn);
					int wildcardsNumber = gc.getWildcardNumber(user1);
					wildcards.setText("Wildcards left: " + wildcardsNumber);
					usedWildcard.showMessageDialog(null, "You used a wildcard!" + 
							"\nYou stay in the same position for this turn" + "\nYour remaining wildcards: " +
							wildcardsNumber, "Used a wildcard", JOptionPane.PLAIN_MESSAGE);
				}
				if (turn == 2)
				{
					gc.deductWildcard(turn);
					int wildcardsNumber = gc.getWildcardNumber(user2);
					wildcards.setText("Wildcards left: " + wildcardsNumber);
					usedWildcard.showMessageDialog(null, "You used a wildcard!" + 
							"\nYou stay in the same position for this turn" + "\nYour remaining wildcards: " +
							wildcardsNumber, "Used a wildcard", JOptionPane.PLAIN_MESSAGE);
				}
				if (turn == 3)
				{
					gc.deductWildcard(turn);
					int wildcardsNumber = gc.getWildcardNumber(user3);
					wildcards.setText("Wildcards left: " + wildcardsNumber);
					usedWildcard.showMessageDialog(null, "You used a wildcard!" + 
							"\nYou stay in the same position for this turn" + "\nYour remaining wildcards: " +
							wildcardsNumber, "Used a wildcard", JOptionPane.PLAIN_MESSAGE);
				}

				// Enable the right buttons.
				moveButton.setEnabled(false);
				wildcardButton.setEnabled(false);
				endButton.setEnabled(true);				
			}
		});

		// Action listener, which gets activated after the "end turn" button is pressed.
		endButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// Update the GUI.
				result.setText("");
				
				// Pass the turn to another player.
				turn = gc.switchTurns();

				// Determine where players are.
				int player1Pos = gc.determinePosition(turn);
				int player2Pos = gc.determinePosition(turn);
				int player3Pos = gc.determinePosition(turn);

				// Announce which player's turn it is, update the JPanel and announce position.
				if (turn == 1)
				{
					JOptionPane.showMessageDialog(null, player1 + "'s turn!", "Game Announcment", JOptionPane.PLAIN_MESSAGE);
					playerName.setText(player1);	
					position.setText("Your current position is: " + player1Pos);
					wildcards.setText("Wildcards left: " + user1.getWildcardNumber());
				}
				if (turn == 2)
				{
					JOptionPane.showMessageDialog(null, player2 + "'s turn!", "Game Announcment", JOptionPane.PLAIN_MESSAGE);
					playerName.setText(player2);
					position.setText("Your current position is: " + player2Pos);
					wildcards.setText("Wildcards left: " + user2.getWildcardNumber());
				}
				if (turn == 3)
				{
					JOptionPane.showMessageDialog(null, player3 + "'s turn!", "Game Announcment", JOptionPane.PLAIN_MESSAGE);
					playerName.setText(player3);
					position.setText("Your current position is: " + player3Pos);
					wildcards.setText("Wildcards left: " + user3.getWildcardNumber());
				}

				// Enable the right buttons.
				rollButton.setEnabled(true);
				endButton.setEnabled(false);
			}
		});

		//  Action listeners for a "Game restart" option from the menu bar.
		restart.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent evt) 
			{   
				// Pop-up window to make sure the players want to restart the game.
				if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Restart the game?",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
				{
					frame.dispose();
					InitialScreenGUI game = new InitialScreenGUI();
				} 
			}
		});
		
		// Explanation of the Snakes role.
		snakeMenu.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent evt) 
			{    
				snakeExplained.showMessageDialog(null, "Snakes are represented as green arrows " +
						"on the grid.\n\n" + "When a player steps on a snake his position decreases " +
						"depending on the length of a snake.", "Explanation of snakes", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		// Explanation of the Ladders role.
		ladderMenu.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent evt) 
			{    
				ladderExplained.showMessageDialog(null, "Ladders are represented as orange arrows " +
						"on the grid.\n\n" + "When a player steps on a ladder his position increases " +
						"depending on the length of a ladder.", "Explanation of ladders", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		// Explanation of the Wildcards role.
		wildcardMenu.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent evt) 
			{    
				wildcardExplained.showMessageDialog(null, "Every player gets 1 wildcard to start the game " +
						"\n\nWildcards may be used to prevent a player from moving after rolling the die. \n" 
						+ "The most common strategy is to use a wildcard, when moving would mean stepping on a snake.\n\n " 
						+ "More wildcards may be earned with the help of a Joker.", "Explanation of wildcards", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		// Explanation of the Jokers role.
		jokerMenu.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent evt) 
			{    
				jokerExplained.showMessageDialog(null, "Joker is a mystical, mythological creature.\n"
						+ "He locates at a random position between 21 and 80 " 
						+ "(the position is random and different every time) and waits for his prey.\n"
						+ "If a player is brave enough to visit the joker, the joker gives the player a " 
						+ "random number between 1 and 6.\n Joker's actions depend on that number:\n\n"
						+ "If a player gets 1: \n" 
						+ "The joker teleports this player to a position number 10.\n\n"
						+ "If a player gets 2: \n" 
						+ "The joker teleports this player to a position number 20.\n\n"
						+ "If a player gets 3: \n" 
						+ "The joker takes away a player's wildcard.\n"
						+ "If the player doesn't have it, the joker teleports the player to a "
						+ "position number 1.\n\n"
						+ "If a player gets 4: \n" 
						+ "The joker gives this player 1 wildcard to use in the future adventures.\n\n"
						+ "If a player gets 5: \n" 
						+ "The joker teleports this player to a position number 90.\n\n"
						+ "If a player gets 6: \n" 
						+ "The joker teleports this player to a position number 99.\n\n"
						, "Explanation of Joker", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		// Explanation of the game rules.
		rulesMenu.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent evt) 
			{    
				rulesExplained.showMessageDialog(null, "The game 'Snakes and ladders' is played on a 10x10 board \n" 
						+ "The die is rolled and a player, who rolled it, moves by the rolled number. \n" 
						+ "Players who first gets to the position 100 wins the game.\n" 
						+ "Various objects placed on the board also interfere with the player movement.\n"
						+ "You can read about these objects from the 'Explanations' menu", 
						"Rules of the game", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		// Menu item to contact the game developers.
		contact.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent evt) 
			{    
				Desktop desktop = Desktop.getDesktop(); 
				try 
				{
					desktop.mail(new URI("mailto:airidas.darbas@gmail.com?subject=Snakes%20and%20ladders"));
				} 
				catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				catch (URISyntaxException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		// Addition of a container JPanel onto a JFrame
		frame.add(container);
		// Modifying a JFrame, so that it's visible.
		frame.setVisible(true); 
		// Modifying JOptionPane, so that it displays whose move it is initially
		JOptionPane.showMessageDialog(null, player1 + "'s turn!", "Game Announcment", JOptionPane.PLAIN_MESSAGE);
	}
}