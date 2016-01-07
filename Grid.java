import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

/**
 * This class is responsible for the bigger panel of the game GUI.
 * This class draws a 10x10 game grid and everything that is displayed on that grid.
 * 
 * @author Airidas Jaraminas
 * @date March 2015
 */
public class Grid extends JComponent
{
	private Rectangle[] rectangle = new Rectangle[100];
	
	private final int RECTANGLE_WIDTH = 88;
	private final int RECTANGLE_HEIGTH = 65;
	private int numberOfPlayers;
	private Player user1;
	private Player user2;
	private Player user3;
	private Joker joker;
	private GridControl gc;
	
		
	/**
     * The first constructor for objects of class Grid (for 2 players).
     * 
     * @param number    The number of players.
     * @param p1     The first player.
     * @param p2     The second player.
     * @param joker		The joker object.
     */
	public Grid(int number, Player p1, Player p2, Joker joker)
	{
		setLayout(null);
		numberOfPlayers = number;
		user1 = p1;
		user2 = p2;
		this.joker = joker;
		gc = new GridControl();
	}
	
	/**
     * The second constructor for objects of class Grid (for 3 players).
     * 
     * @param number    The number of players.
     * @param p1     The first player.
     * @param p2     The second player.
     * @param p3     The third player.
     * @param joker		The joker object.
     */
	public Grid(int number, Player p1, Player p2, Player p3, Joker joker)
	{
		setLayout(null);
		numberOfPlayers = number;
		user1 = p1;
		user2 = p2;
		user3 = p3;
		this.joker = joker;
		gc = new GridControl();
	}
	
	/**
	* A method which generates the rectangles. Later on, they will be assembled into a single 10x10 
	* grid.
	*/ 
	public void createRectangle()
	{
		int x = 5;
		int y = 600;
		int counter = 0;
		for (int i = 0; i < 100; i++)
		{
			Rectangle rect = new Rectangle(x, y, RECTANGLE_WIDTH, RECTANGLE_HEIGTH);
			rectangle[i] = rect;
			if (counter < 9)
			{	
				x = x + 88;
				counter++;
			}
			else
			{
				x = 5;
				counter = 0;
				y = y - 65;
			}
			
		}
	}
	
	/**
	* Built in, overridden method called to display the graphical objects on the screen.
	*/ 
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int buttonNr = 1;
		int numberX = 68;
		int numberY = 625;
		int counter = 0;
		Graphics2D g2 = (Graphics2D) g;
		createRectangle();
		
		// Draw the rectangles, which will represent the grid.
		for (int index = 0; index < 100; index++)
		{
			g2.draw(rectangle[index]);
		}
		
		// Number rectangles 1-99.
		Color numberColor = new Color(0, 0, 0);
		g2.setFont(new Font("Serif", Font.BOLD, 24));
		g2.setColor(numberColor);
		for (int index = 0; index < 99; index++)
		{
			g2.drawString(String.valueOf(buttonNr), numberX, numberY);
			if (counter < 9)
			{	
				numberX = numberX + 88;
				counter++;
			}
			else
			{
				numberX = 67;
				counter = 0;
				numberY = numberY - 65;
			}
			buttonNr++;
			
		}
		
		// Give a number to a rectangle number 100.
		Color winColor = new Color(5, 13, 240);
		g2.setFont(new Font("Serif", Font.BOLD, 35));
		g2.setColor(winColor);
		g2.drawString("" + 100, 820, 55);
		
		// Define how should the ladders be displayed.
		Color ladderColor = new Color(252, 182, 3);
		g2.setColor(ladderColor);
		g2.setStroke(new BasicStroke(3));
		
		// Draw ladder1
		g2.drawLine(657, 625, 300, 495);
		g2.drawLine(300, 495, 317, 495);
		g2.drawLine(300, 495, 308, 506);
		
		// Draw ladder2
		g2.drawLine(569, 560, 740, 430);
		g2.drawLine(740, 430, 737, 440);
		g2.drawLine(740, 430, 733, 427);
		
		// Draw ladder3
		g2.drawLine(822, 495, 822, 365);
		g2.drawLine(822, 365, 815, 372);
		g2.drawLine(822, 365, 829, 372);
		
		// Draw ladder4
		g2.drawLine(118, 365, 564, 238);
		g2.drawLine(564, 238, 560, 247);
		g2.drawLine(564, 238, 555, 232);
		
		// Draw ladder5
		g2.drawLine(822, 300, 558, 170);
		g2.drawLine(558, 170, 568, 170);
		g2.drawLine(558, 170, 563, 178);
		
		// Draw ladder6
		g2.drawLine(129, 105, 129, 40);
		g2.drawLine(129, 40, 122, 47);
		g2.drawLine(129, 40, 136, 47);
		
		// Define how snakes should be displayed.
		Color snakeColor = new Color(0, 255, 0);
		g2.setColor(snakeColor);
		g2.setStroke(new BasicStroke(3));
		
		// Draw snake1
		g2.drawLine(41, 495, 124, 560);
		g2.drawLine(124, 560, 126, 554);
		g2.drawLine(124, 560, 110, 560);
		
		// Draw snake2
		g2.drawLine(300, 430, 393, 495);
		g2.drawLine(393, 495, 395, 489);
		g2.drawLine(393, 495, 379, 495);
		
		// Draw snake3
		g2.drawLine(41, 305, 564, 430);
		g2.drawLine(564, 430, 563, 424);
		g2.drawLine(564, 430, 550, 433);
		
		// Draw snake4
		g2.drawLine(657, 240, 740, 370);
		g2.drawLine(740, 370, 742, 364);
		g2.drawLine(740, 370, 732, 369);
		
		// Draw snake5
		g2.drawLine(569, 110, 652, 430);
		g2.drawLine(652, 430, 655, 422);
		g2.drawLine(652, 430, 643, 424);
		
		// Draw snake6
		g2.drawLine(393, 55, 828, 560);
		g2.drawLine(828, 560, 827, 550);
		g2.drawLine(828, 560, 820, 559);
		
		// Define the position of the Joker.
		int jokerPosition = gc.getJokerPosition(joker);
		int jokerX = 44;
		int jokerY = 618;
		if (jokerPosition >= 21 && jokerPosition <= 30)
		{
			int jokerPlace = 88 * (jokerPosition - 21);
			jokerX = jokerX + jokerPlace;
			jokerY = jokerY - 98;
		}
		else if (jokerPosition >= 31 && jokerPosition <= 40)
		{
			int jokerPlace = 88 * (jokerPosition - 31);
			jokerX = jokerX + jokerPlace;
			jokerY = jokerY - 163;
		}
		else if (jokerPosition >= 41 && jokerPosition <= 50)
		{
			int jokerPlace = 88 * (jokerPosition - 41);
			jokerX = jokerX + jokerPlace;
			jokerY = jokerY - 228;
		}
		else if (jokerPosition >= 51 && jokerPosition <= 60)
		{
			int jokerPlace = 88 * (jokerPosition - 51);
			jokerX = jokerX + jokerPlace;
			jokerY = jokerY - 293;
		}
		else if (jokerPosition >= 61 && jokerPosition <= 70)
		{
			int jokerPlace = 88 * (jokerPosition - 61);
			jokerX = jokerX + jokerPlace;
			jokerY = jokerY - 358;
		}
		else if (jokerPosition >= 71 && jokerPosition <= 80)
		{
			int jokerPlace = 88 * (jokerPosition - 71);
			jokerX = jokerX + jokerPlace;
			jokerY = jokerY - 423;
		}
		
		// Define how to display the joker.
		Color jokerColor = new Color(222, 35, 57);
		g2.setFont(new Font("Serif", Font.BOLD, 48));
		g2.setColor(jokerColor);
		g2.drawString("J", jokerX, jokerY);
		
		// Define the position of player1.		
		int player1Pos = gc.determinePosition(user1);
		int xCoordinate = 10;
		int yCoordinate = 625;
		
		if (player1Pos > 1 && player1Pos <= 10)
		{
			int moveBy = 88 * (player1Pos - 1);
			xCoordinate = xCoordinate + moveBy;
		}
		else if (player1Pos >= 11 && player1Pos <= 20)
		{
			int moveBy = 88 * (player1Pos - 11);
			xCoordinate = xCoordinate + moveBy;
			yCoordinate = yCoordinate - 65;
		}
		else if (player1Pos >= 21 && player1Pos <= 30)
		{
			int moveBy = 88 * (player1Pos - 21);
			xCoordinate = xCoordinate + moveBy;
			yCoordinate = yCoordinate - 130;
		}
		else if (player1Pos >= 31 && player1Pos <= 40)
		{
			int moveBy = 88 * (player1Pos - 31);
			xCoordinate = xCoordinate + moveBy;
			yCoordinate = yCoordinate - 195;
		}
		else if (player1Pos >= 41 && player1Pos <= 50)
		{
			int moveBy = 88 * (player1Pos - 41);
			xCoordinate = xCoordinate + moveBy;
			yCoordinate = yCoordinate - 260;
		}
		else if (player1Pos >= 51 && player1Pos <= 60)
		{
			int moveBy = 88 * (player1Pos - 51);
			xCoordinate = xCoordinate + moveBy;
			yCoordinate = yCoordinate - 325;
		}
		else if (player1Pos >= 61 && player1Pos <= 70)
		{
			int moveBy = 88 * (player1Pos - 61);
			xCoordinate = xCoordinate + moveBy;
			yCoordinate = yCoordinate - 390;
		}
		else if (player1Pos >= 71 && player1Pos <= 80)
		{
			int moveBy = 88 * (player1Pos - 71);
			xCoordinate = xCoordinate + moveBy;
			yCoordinate = yCoordinate - 455;
		}
		else if (player1Pos >= 81 && player1Pos <= 90)
		{
			int moveBy = 88 * (player1Pos - 81);
			xCoordinate = xCoordinate + moveBy;
			yCoordinate = yCoordinate - 520;
		}
		else if (player1Pos >= 91 && player1Pos <= 100)
		{
			int moveBy = 88 * (player1Pos - 91);
			xCoordinate = xCoordinate + moveBy;
			yCoordinate = yCoordinate - 585;
		}
		
		// Define how to display player1.
		Color p1Color = new Color(7, 2, 94);
		g2.setFont(new Font("Serif", Font.BOLD, 24));
		g2.setColor(p1Color);
		String name1 = gc.getName(user1);
		if (name1.length() >= 4)
		{
			String figure1 = name1.substring(0, 3);
			g2.drawString(figure1, xCoordinate, yCoordinate);
		}
		else
		{
			g2.drawString(name1, xCoordinate, yCoordinate);
		}
		
		// Define the position of player2.	
		int player2Pos = gc.determinePosition(user2);
		int xCoordinate2 = 10;
		int yCoordinate2 = 645;
		
		if (player2Pos > 1 && player2Pos <= 10)
		{
			int moveBy = 88 * (player2Pos - 1);
			xCoordinate2 = xCoordinate2 + moveBy;
		}
		else if (player2Pos >= 11 && player2Pos <= 20)
		{
			int moveBy = 88 * (player2Pos - 11);
			xCoordinate2 = xCoordinate2 + moveBy;
			yCoordinate2 = yCoordinate2 - 65;
		}
		else if (player2Pos >= 21 && player2Pos <= 30)
		{
			int moveBy = 88 * (player2Pos - 21);
			xCoordinate2 = xCoordinate2 + moveBy;
			yCoordinate2 = yCoordinate2 - 130;
		}
		else if (player2Pos >= 31 && player2Pos <= 40)
		{
			int moveBy = 88 * (player2Pos - 31);
			xCoordinate2 = xCoordinate2 + moveBy;
			yCoordinate2 = yCoordinate2 - 195;
		}
		else if (player2Pos >= 41 && player2Pos <= 50)
		{
			int moveBy = 88 * (player2Pos - 41);
			xCoordinate2 = xCoordinate2 + moveBy;
			yCoordinate2 = yCoordinate2 - 260;
		}
		else if (player2Pos >= 51 && player2Pos <= 60)
		{
			int moveBy = 88 * (player2Pos - 51);
			xCoordinate2 = xCoordinate2 + moveBy;
			yCoordinate2 = yCoordinate2 - 325;
		}
		else if (player2Pos >= 61 && player2Pos <= 70)
		{
			int moveBy = 88 * (player2Pos - 61);
			xCoordinate2 = xCoordinate2 + moveBy;
			yCoordinate2 = yCoordinate2 - 390;
		}
		else if (player2Pos >= 71 && player2Pos <= 80)
		{
			int moveBy = 88 * (player2Pos - 71);
			xCoordinate2 = xCoordinate2 + moveBy;
			yCoordinate2 = yCoordinate2 - 455;
		}
		else if (player2Pos >= 81 && player2Pos <= 90)
		{
			int moveBy = 88 * (player2Pos - 81);
			xCoordinate2 = xCoordinate2 + moveBy;
			yCoordinate2 = yCoordinate2 - 520;
		}
		else if (player2Pos >= 91 && player2Pos <= 100)
		{
			int moveBy = 88 * (player2Pos - 91);
			xCoordinate2 = xCoordinate2 + moveBy;
			yCoordinate2 = yCoordinate2 - 585;
		}
		
		// Define how to display player2.
		Color p2Color = new Color(204, 0, 0);
		g2.setFont(new Font("Serif", Font.BOLD, 24));
		g2.setColor(p2Color);
		String name2 = gc.getName(user2);
		if (name2.length() >= 4)
		{
			String figure2 = name2.substring(0, 3);
			g2.drawString(figure2, xCoordinate2, yCoordinate2);
		}
		else
		{
			g2.drawString(name2, xCoordinate2, yCoordinate2);
		}
		
		if (numberOfPlayers == 3)
		{
			// Define the position of player3.
			int player3Pos = gc.determinePosition(user3);
			int xCoordinate3 = 10;
			int yCoordinate3 = 665;
			
			if (player3Pos > 1 && player3Pos <= 10)
			{
				int moveBy = 88 * (player3Pos - 1);
				xCoordinate3 = xCoordinate3 + moveBy;
			}
			else if (player3Pos >= 11 && player3Pos <= 20)
			{
				int moveBy = 88 * (player3Pos - 11);
				xCoordinate3 = xCoordinate3 + moveBy;
				yCoordinate3 = yCoordinate3 - 65;
			}
			else if (player3Pos >= 21 && player3Pos <= 30)
			{
				int moveBy = 88 * (player3Pos - 21);
				xCoordinate3 = xCoordinate3 + moveBy;
				yCoordinate3 = yCoordinate3 - 130;
			}
			else if (player3Pos >= 31 && player3Pos <= 40)
			{
				int moveBy = 88 * (player3Pos - 31);
				xCoordinate3 = xCoordinate3 + moveBy;
				yCoordinate3 = yCoordinate3 - 195;
			}
			else if (player3Pos >= 41 && player3Pos <= 50)
			{
				int moveBy = 88 * (player3Pos - 41);
				xCoordinate3 = xCoordinate3 + moveBy;
				yCoordinate3 = yCoordinate3 - 260;
			}
			else if (player3Pos >= 51 && player3Pos <= 60)
			{
				int moveBy = 88 * (player3Pos - 51);
				xCoordinate3 = xCoordinate3 + moveBy;
				yCoordinate3 = yCoordinate3 - 325;
			}
			else if (player3Pos >= 61 && player3Pos <= 70)
			{
				int moveBy = 88 * (player3Pos - 61);
				xCoordinate3 = xCoordinate3 + moveBy;
				yCoordinate3 = yCoordinate3 - 390;
			}
			else if (player3Pos >= 71 && player3Pos <= 80)
			{
				int moveBy = 88 * (player3Pos - 71);
				xCoordinate3 = xCoordinate3 + moveBy;
				yCoordinate3 = yCoordinate3 - 455;
			}
			else if (player3Pos >= 81 && player3Pos <= 90)
			{
				int moveBy = 88 * (player3Pos - 81);
				xCoordinate3 = xCoordinate3 + moveBy;
				yCoordinate3 = yCoordinate3 - 520;
			}
			else if (player3Pos >= 91 && player3Pos <= 100)
			{
				int moveBy = 88 * (player3Pos - 91);
				xCoordinate3 = xCoordinate3 + moveBy;
				yCoordinate3 = yCoordinate3 - 585;
			}
			
			// Define how to display player3.
			Color p3Color = new Color(0, 0, 0);
			g2.setFont(new Font("Serif", Font.BOLD, 24));
			g2.setColor(p3Color);
			String name3 = gc.getName(user3);
			if (name3.length() >= 4)
			{
				String figure3 = name3.substring(0, 3);
				g2.drawString(figure3, xCoordinate3, yCoordinate3);
			}
			else
			{
				g2.drawString(name3, xCoordinate3, yCoordinate3);
			}
		}
		
		
	}
	
	
}
