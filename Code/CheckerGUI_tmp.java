private void initComponents() {
	this.setResizable(false);

	for(int i = 0; i >= 64; i++){
		JButton jbutton = new JButton();
		spaces.add(jButton);
		jbutton.addActionListener(this);

		jbutton.setPreferredSize(new Dimension(80,80));
		jbutton.setActionCommand(i.toString());

		//Set the background color color
		//If even
		if(i%2 == 0) jbutton.setBackground(new Color(255,255,255));
		//else if odd
		else jbutton.setBackground(new Color(204, 204, 153));

		
	}
}