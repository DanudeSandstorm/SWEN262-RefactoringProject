package Code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckerGUI_temp extends JFrame implements ActionListener {
	

	private GUIManager guiManager;
	
	private ArrayList<JButton> spaces = new ArrayList<JButton>();
	
	private int timeRemaining;
	private JLabel timeRemainingLabel, secondsLeftLabel;
	
	private JLabel playerOneLabel;
	private JLabel playerTwoLabel;
	private JLabel whosTurnLabel;
	
	private JLabel warningLabel;
	
	private JButton resignButton, drawButton, replayButton;
	
	// the names and time left
	private static String playerOnesName, playerTwosName, timeLeft;
	
	/**
	 * Constructor, creates the GUI and all its components
	 * @param manager The GUI Manager to interact with
	 * @param name1 player 1 name
	 * @param name2 player 2 name
	 */
	public CheckerGUI_temp(GUIManager manager, String name1, String name2) {
		super("Checkers");
		
		// Long names mess up the way the GUI displays
		// this code shortens the name if it is too long
		if (name1.length() > 7) {
			playerOnesName = name1.substring(0, 7);
		} 
		else playerOnesName = name1;

		if (name2.length() > 7) {
			playerTwosName = name2.substring(0, 7);
		} 
		else playerTwosName = name2;
		
		register();

		initComponents();
		pack();
		update();
		// updateTime();
		
		guiManager = manager;
	}
	
	private void register() {
		
		try {
			guiManager.addActionListener(this);
		} 
		catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * It initializes the components adds the buttons to the ArrayList of squares
	 * and adds an action listener to the components
	 */
	private void initComponents() {
		this.setResizable(false);
		
		playerOneLabel = new JLabel();
		playerTwoLabel = new JLabel();
		whosTurnLabel = new JLabel();
	
		warningLabel = new JLabel();
		timeRemainingLabel = new JLabel();
		secondsLeftLabel = new JLabel();
	
		resignButton = new JButton();
		resignButton.addActionListener(this);
	
		drawButton = new JButton();
		drawButton.addActionListener(this);
		
		// sets the layout and adds listener for closing window
		getContentPane().setLayout(new GridBagLayout());
		
		// add window listener
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm(evt);
			}
		});
		
		//Generate board of buttons
		for(int i = 0; i < 64; i++){
			final JButton jButton = new JButton();
			spaces.add(jButton);
			jButton.addActionListener(this);
	
			jButton.setPreferredSize(new Dimension(80,80));
			jButton.setActionCommand(String.valueOf(i));
	
			//Set the background color
			//If even
			if(i%2 == 0) jButton.setBackground(new Color(255,255,255));
			//else if odd
			else jButton.setBackground(new Color(204, 204, 153));
			
			getContentPane().add(jButton, new gridBagConstraints(i%8, i/8));
		}
		
		//Generate Lables
		playerOneLabel.setText("Player 1:     " + playerOnesName);
		playerOneLabel.setForeground(Color.black);
		getContentPane().add(playerOneLabel, new gridBagConstraints(2, 0, 4));

		playerTwoLabel.setText("Player 2:     " + playerTwosName);
		playerTwoLabel.setForeground(Color.black);
		getContentPane().add(playerTwoLabel, new gridBagConstraints(2,9,4));

		whosTurnLabel.setText("");
		whosTurnLabel.setForeground(new Color(0, 100, 0));
		getContentPane().add(whosTurnLabel, new gridBagConstraints(8,1));

		warningLabel.setText("");
		warningLabel.setForeground(Color.red);
		getContentPane().add(warningLabel, new gridBagConstraints(8,2));

		timeRemainingLabel.setText("Time Remaining:");
		timeRemainingLabel.setForeground(Color.black);
		getContentPane().add(timeRemainingLabel, new gridBagConstraints(8,3));

		secondsLeftLabel.setText(timeLeft + " sec.");
		secondsLeftLabel.setForeground(Color.black);
		getContentPane().add(secondsLeftLabel, new gridBagConstraints(8,4));

		resignButton.setActionCommand("resign");
		resignButton.setText("Resign");
		getContentPane().add(resignButton, new gridBagConstraints(8,7));

		drawButton.setActionCommand("draw");
		drawButton.setText("Draw");
		getContentPane().add(drawButton, new gridBagConstraints(8,6));
	}

	/**
	 * Exit the Application
	 * @param evt
	 */
	protected void exitForm(WindowEvent evt) {
		guiManager.pressQuit();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// if a square gets clicked
			if (		e.getActionCommand().equals("1")
					|| e.getActionCommand().equals("3")
					|| e.getActionCommand().equals("5")
					|| e.getActionCommand().equals("7")
					|| e.getActionCommand().equals("8")
					|| e.getActionCommand().equals("10")
					|| e.getActionCommand().equals("12")
					|| e.getActionCommand().equals("14")
					|| e.getActionCommand().equals("17")
					|| e.getActionCommand().equals("19")
					|| e.getActionCommand().equals("21")
					|| e.getActionCommand().equals("23")
					|| e.getActionCommand().equals("24")
					|| e.getActionCommand().equals("26")
					|| e.getActionCommand().equals("28")
					|| e.getActionCommand().equals("30")
					|| e.getActionCommand().equals("33")
					|| e.getActionCommand().equals("35")
					|| e.getActionCommand().equals("37")
					|| e.getActionCommand().equals("39")
					|| e.getActionCommand().equals("40")
					|| e.getActionCommand().equals("42")
					|| e.getActionCommand().equals("44")
					|| e.getActionCommand().equals("46")
					|| e.getActionCommand().equals("49")
					|| e.getActionCommand().equals("51")
					|| e.getActionCommand().equals("53")
					|| e.getActionCommand().equals("55")
					|| e.getActionCommand().equals("56")
					|| e.getActionCommand().equals("58")
					|| e.getActionCommand().equals("60")
					|| e.getActionCommand().equals("62")) 
			{

				// call selectSpace with the button pressed
				guiManager.selectSpace(Integer.parseInt(e.getActionCommand()));
				
			} 
			// if draw is pressed
			else if (e.getActionCommand().equals("draw")) {
				guiManager.pressDraw();
				guiManager.instanceReplayGUI();
				guiManager.replayGUIShow();
				this.hide();
			}
			// if resign is pressed
			else if (e.getActionCommand().equals("resign")) {
				// does sequence of events for a resign
				//theFacade.pressQuit();
				
				guiManager.instanceReplayGUI();
				guiManager.replayGUIShow();
				this.hide();
			}
			// if the Code came from the facade
			else if (e.getSource().equals(guiManager)) {
				// if its a player switch event
				if ((e.getActionCommand()).equals(guiManager.getPlayerSwitch())) {
					timeRemaining = guiManager.getTimer(); 
				} 
				// if it is an update event
				else if ((e.getActionCommand()).equals(guiManager.getFacadeUpdate())) update();
				else throw new Exception("unknown message from gui manager");
			}
			
		}
		// catch various Exceptions
		catch (NumberFormatException excep) {
			System.err.println("GUI exception: Error converting a string to a number");
		} 
		catch (NullPointerException exception) {
			System.err.println("GUI exception: Null pointerException "
					+ exception.getMessage());
			exception.printStackTrace();
		} 
		catch (Exception except) {
			System.err.println("GUI exception: other: " + except.getMessage());
			except.printStackTrace();
		}
	}
	
	/**
	 * Updates the GUI reading the pieces in the board Puts pieces in correct
	 * spaces, updates whose turn it is
	 */
	private void update() {
		if (checkEndConditions()) {
			
			guiManager.instanceReplayGUI();
			guiManager.replayGUIShow();
		}
		
		Board board = guiManager.getStateOfBoard();
		
		for (int i = 1; i < board.sizeOf(); i++) {
			
			Icon pieceImage = null;
			if (board.occupied(i)) {
				
				String colorName = "";
				String pieceType = "";
				
				if (Color.blue.equals(board.colorAt(i))) {
					colorName = "Blue";
				}
				else if (Color.white.equals(board.colorAt(i))) {
					colorName = "White";
				}
				
				if ((board.getPieceAt(i)).getType() == board.SINGLE){
					pieceType = "Single";
				}
				else if ((board.getPieceAt(i)).getType() == board.KING){
					pieceType = "King";
				}
				
				//Take the corresponding image
				pieceImage = new ImageIcon(CheckerGUI_temp.class
						.getResource("Images/" + colorName + pieceType + ".gif"));
			}
			
			//Set the piece at the space
			JButton space = (JButton) spaces.get(i);
			try{
				space.setIcon(pieceImage);
			}
			catch (Exception e) {}
			
		}
		
		// this code updates whos turn it is
		if (guiManager.whosTurn() == 2) {
			playerTwoLabel.setForeground(Color.red);
			playerOneLabel.setForeground(Color.black);
			whosTurnLabel.setText(playerTwosName + "'s turn ");
		} else if (guiManager.whosTurn() == 1) {
			playerOneLabel.setForeground(Color.red);
			playerTwoLabel.setForeground(Color.black);
			whosTurnLabel.setText(playerOnesName + "'s turn");
		}
	}
	
	/**
	 * Updates the timer
	 */
	private void updateTime() {
		
		if (guiManager.getTimer() > 0){
			// if the time has run out but not in warning time yet
			// display warning and count warning time
			if (timeRemaining <= 0 && (warningLabel.getText()).equals("")) {
				timeRemaining = guiManager.getTimerWarning();
				warningLabel.setText("Time is running out!!!");	
			} 
			// if the time has run out and it was in warning time quit game
			else if (timeRemaining <= 0 && !(warningLabel.getText()).equals("")) {
				guiManager.pressQuit();
			} 
			else timeRemaining--;
			secondsLeftLabel.setText(timeRemaining + " sec.");
		}
		else secondsLeftLabel.setText("*****");
	}
	
	/**
	 * 	Checks the ending conditions for the game see if there a no pieces left
	 * 
	 * @return the return value for the method true if the game should end false
	 *         if game needs to continue
	 */
	private boolean checkEndConditions() {
		
		try {
			// the number of each piece left
			int whitesGone = 0, bluesGone = 0;
			
			// the board to work with
			Board board = guiManager.getStateOfBoard();
			
			// go through all the spots on the board
			for (int i = 1; i < board.sizeOf(); i++) {
				// if there is a piece there
				if (board.occupied(i)) {
					// if its a blue piece there
					if ((board.getPieceAt(i)).getColor() == Color.blue) {
						bluesGone++;	
					} 
					// if the piece is white
					else if ((board.getPieceAt(i)).getColor() == Color.white) {
						whitesGone++;
					}
				}
			}
			
			// if either of the number are 0
			if (whitesGone == 0 || bluesGone == 0) {
				return true;
			}
						
		}
		catch (Exception e) {

			System.err.println(e.getMessage());
		}
		
		return false; //If the game has not ended
	}
	
	
	/**
	 * Reduces amount of parameters needed to construct GridBagConstraints
	 */
	class gridBagConstraints extends GridBagConstraints {

		/**
		 * @param gridx gridx
		 * @param gridy gridy
		 */
		public gridBagConstraints(int gridx, int gridy){
			super();
			this.gridx = gridx;
			this.gridy = gridy;
		}
		
		/**
		 * @param gridx gridx
		 * @param gridy gridy
		 * @param gridwidth
		 */
		public gridBagConstraints(int gridx, int gridy, int gridwidth){
			super();
			this.gridx = gridx;
			this.gridy = gridy;
			this.gridwidth = gridwidth;
		}
	}
}