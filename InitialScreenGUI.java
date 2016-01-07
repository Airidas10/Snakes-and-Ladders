import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class starts up an initial game window,
 * where the players can select a 2-player or a 
 * 3-player game mode.
 * 
 * This GUI has no control class, because there is nothing to control.
 * 
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class InitialScreenGUI extends JFrame 
{
	private JFrame frame;
	private ImageIcon img;
	private JLabel label1;
	private JButton twoPlayers;
	private JButton threePlayers;
	private JOptionPane move;
	private JOptionPane name;

	/**
	 * Constructor for the objects of class InitialScreenGUI.
	 */
	public InitialScreenGUI()
	{
		frame = new JFrame();
		move = new JOptionPane();
		name = new JOptionPane();
		createView();
	}

	// A method which creates the GUI visible for the users.
	public void createView()
	{
		// Creating and modifying a JPanel for a pop-up window.
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.WHITE);

		// Adding a main picture onto a JPanel.
		img = new ImageIcon(getClass().getResource("snake-ladder.jpg"));
		label1 = new JLabel(img);

		// Getting resources for the pictures to be used on the buttons.
		ImageIcon twoPl = new ImageIcon(getClass().getResource("2players.png"));
		ImageIcon threePl = new ImageIcon(getClass().getResource("3players.png"));

		// Modifying the JFrame.
		frame.add(panel);
		frame.setSize(1280, 720);
		frame.setLocation(50, 10);
		frame.setTitle("Snakes And Ladders");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Adding 2 buttons and displaying a picture on top.
		twoPlayers = new JButton(twoPl);
		twoPlayers.setPreferredSize(new Dimension(230, 116));
		threePlayers = new JButton(threePl);
		threePlayers.setPreferredSize(new Dimension(230, 116));

		// Labels displaying text on the initial screen.
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 100;
		gbc.weighty = 100;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(-10, 0, 0, 0);
		panel.add(label1, gbc); 
		gbc.insets = new Insets(-50, 0, 0, 0);
		gbc.gridy++;
		panel.add(new JLabel("WELCOME TO THE SNAKES AND LADDERS GAME! "), gbc);
		gbc.gridy++;
		gbc.insets = new Insets(-50, 0, 0, 0);
		panel.add(new JLabel("Select the number of players to start the game: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(0, 0, 0, -700);
		panel.add(twoPlayers, gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.insets = new Insets(0, -700, 0, 0);
		panel.add(threePlayers, gbc);

		/* 
		 * Action listener for a "Two players" button.
		 * When the button is pressed a pop up window is displayed.
		 */
		twoPlayers.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// Start the loop to make sure all the entered values are checked. 
				int tempTest = -1;
				while (tempTest < 0)
				{
					JPanel popUp = new JPanel(new GridBagLayout());
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridx = 1;
					gbc.gridy = 1;
					gbc.insets = new Insets(0, 5, 0, 0);
					popUp.add(new JLabel("Type in a nickname for player1: "), gbc);
					gbc.gridx = 2;
					JTextField field1 = new JTextField(10);
					popUp.add(field1, gbc);
					gbc.gridx = 1;
					gbc.gridy = 2;
					popUp.add(new JLabel("Type in a nickname for player2: "), gbc);
					gbc.gridx = 2;
					JTextField field2 = new JTextField(10);
					popUp.add(field2, gbc);
					int result = name.showConfirmDialog(null, popUp, "Enter player nicknames", JOptionPane.CANCEL_OPTION);
					String player1 = field1.getText();
					String player2 = field2.getText();

					//If "Cancel" or "X" is pressed.
					if (result == -1 || result == 2)
					{
						// Stop the loop and do nothing, so that the pop up dialog closes. 
						break;
					}
					else if (player1.length() == 0 || player2.length() == 0)
					{
						move.showMessageDialog(null, "Nicknames can't be blank!", "Nickname error", JOptionPane.PLAIN_MESSAGE);
					}
					else if (player1.length() > 10 || player2.length() > 10)
					{
						move.showMessageDialog(null, "Nicknames can't exceed 10 symbols!", "Nickname error", JOptionPane.PLAIN_MESSAGE);
					}
					else if(player1.equals(player2))
					{
						JOptionPane.showMessageDialog(null, "Please enter different nicknames", "Nickname error", JOptionPane.PLAIN_MESSAGE);
					}
					else
					{
						// To stop the loop and let people progress onto the game.
						tempTest++;
						GameGUI startGame = new GameGUI(2, player1, player2);
						// Make the "initial screen" not displayable.
						frame.dispose();
					}
				}


			}
		});

		/* 
		 * Action listener for a "Three players" button.
		 * When the button is pressed a pop up window is displayed.
		 */
		threePlayers.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int tempTest = -1;
				while (tempTest < 0)
				{
					JPanel popUp = new JPanel(new GridBagLayout());
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridx = 1;
					gbc.gridy = 1;
					gbc.insets = new Insets(0, 5, 0, 0);
					popUp.add(new JLabel("Type in a nickname for player1: "), gbc);
					gbc.gridx = 2;
					JTextField field1 = new JTextField(10);
					popUp.add(field1, gbc);
					gbc.gridx = 1;
					gbc.gridy = 2;
					popUp.add(new JLabel("Type in a nickname for player2: "), gbc);
					gbc.gridx = 2;
					JTextField field2 = new JTextField(10);
					popUp.add(field2, gbc);

					gbc.gridx = 1;
					gbc.gridy = 3;
					popUp.add(new JLabel("Type in a nickname for player3: "), gbc);
					gbc.gridx = 2;
					JTextField field3 = new JTextField(10);
					popUp.add(field3, gbc);
					int result = name.showConfirmDialog(null, popUp, "Enter player nicknames", JOptionPane.CANCEL_OPTION);
					String player1 = field1.getText();
					String player2 = field2.getText();
					String player3 = field3.getText();

					//If "Cancel" or "X" is pressed.
					if (result == -1 || result == 2)
					{
						// Stop the loop and do nothing, so that the pop up dialog closes. 
						break;
					}
					else if (player1.length() == 0 || player2.length() == 0 || player3.length() == 0)
					{
						move.showMessageDialog(null, "Nicknames can't be blank!", "Nickname error", JOptionPane.PLAIN_MESSAGE);
					}
					else if (player1.length() > 10 || player2.length() > 10 || player3.length() > 10)
					{
						move.showMessageDialog(null, "Nicknames can't exceed 10 symbols!", "Nickname error", JOptionPane.PLAIN_MESSAGE);
					}
					else if(player1.equals(player2) || player1.equals(player3) || player2.equals(player3))
					{
						JOptionPane.showMessageDialog(null, "Please enter different nicknames", "Nickname error", JOptionPane.PLAIN_MESSAGE);
					}
					else
					{
						// To stop the loop and let people progress onto the game.
						tempTest++;
						GameGUI startGame = new GameGUI(3, player1, player2, player3);
						// Make the "initial screen" not displayable.
						frame.dispose();
					}
				}
			}
		});


		frame.setVisible(true); 
	}
	// A main method.
	public static void main(String[] args) 
	{
		InitialScreenGUI game = new InitialScreenGUI();
	}
}
