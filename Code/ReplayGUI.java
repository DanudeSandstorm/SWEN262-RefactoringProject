package Code;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;

public class ReplayGUI extends JFrame implements ActionListener, 
	ChangeListener {

	// Variables
	private JButton rematchButton;
	private JButton menuButton;
	private GUIManager manager;
	
	public ReplayGUI(GUIManager manager) {
		super("Replay");
		this.manager = manager;
		initComponents();
	}
	
	private void initComponents() {
		setSize(300, 150);
		rematchButton = new JButton();
		menuButton = new JButton();
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gridBagConstraints1;
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm(evt);
			}
		});

		rematchButton.setText("Rematch");
		//rematchButton.setName("button1");
		rematchButton.setBackground(new Color(212, 208, 200));
		rematchButton.setForeground(Color.black);
		rematchButton.setActionCommand("rematch");
		rematchButton.addActionListener(this);

		gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 11;
		gridBagConstraints1.insets = new Insets(20, 0, 10, 12);
		gridBagConstraints1.anchor = GridBagConstraints.EAST;
		getContentPane().add(rematchButton, gridBagConstraints1);

		menuButton.setText("Menu");
		//menuButton.setName("button2");
		menuButton.setBackground(new Color(212, 208, 200));
		menuButton.setForeground(Color.black);
		menuButton.setActionCommand("menu");
		menuButton.addActionListener(this);
		
		gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 11;
		gridBagConstraints1.insets = new Insets(20, 0, 10, 0);
		gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
		getContentPane().add(menuButton, gridBagConstraints1);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ((e.getActionCommand()).equals("rematch")) {
			// Go through the mediator to get back to CheckersGUI with the previous settings.
			String playerOne = manager.getPlayerName(1);
			String playerTwo = manager.getPlayerName(2);
			manager.instanceBoardGUI(playerOne, playerTwo);
			manager.boardGUIShow();
			this.hide();
		} else if ((e.getActionCommand()).equals("menu")) {
			// Go through the mediator to get to the MainMenuGUI.
			manager.instanceNetworkGUI(manager);
			manager.networkGUIShow();
			this.hide();
		}
	}
	
	private void exitForm(java.awt.event.WindowEvent evt) {
		System.exit(0);
	}
}
