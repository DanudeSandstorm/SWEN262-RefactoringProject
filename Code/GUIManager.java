package Code;

import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JOptionPane;

public class GUIManager {
	Facade facade;
	int gameType;
	
	public GUIManager(Facade facade){
		this.facade = facade;
		
	}
	
	CheckerGUI playingBoardGUI; //= new CheckerGUI(facade, null, null);
	NetworkingGUI networkGUI; //= new NetworkingGUI(null, this);
	PlayerGUI playerSettingsGUI; //= new PlayerGUI(null, this, 0);
	ReplayGUI replayGUI;
	
	////////////////////////// -CheckerGUI- //////////////////////////
	
	public void instanceBoardGUI(String player1, String player2){
		playingBoardGUI = new CheckerGUI(facade, player1, player2);
		
	}
	
	public void boardGUIShow(){
		playingBoardGUI.show();
	}
	
	public void boardGUIHide(){
		playingBoardGUI.hide();
		
	}
	
	////////////////////////// -NetworkGUI (Firstscreen)- //////////////////////////
	
	public void instanceNetworkGUI(GUIManager manager){
		networkGUI = new NetworkingGUI(manager);
	}
		
	public void networkGUIShow(){
		networkGUI.show();
	}
	
	public void networkGUIHide(){
		networkGUI.hide();
	}
	
	////////////////////////// -PlayerGUI (Secondscreen)- //////////////////////////
	
	
	public void instancePlayersGUI(){
		playerSettingsGUI = new PlayerGUI(this, gameType);
	}
	
	public void playerSettingsGUIShow(){
		playerSettingsGUI.show();
	}
	
	public void playerSettingsGUIHide(){
		playerSettingsGUI.hide();
	}
	
	////////////////////////// -ReplayGUI- //////////////////////////
	
	public void instanceReplayGUI(){
		replayGUI = new ReplayGUI(this);
	}
	
	public void replayGUIShow(){
		replayGUI.show();
	}
	
	public void replayGUIHide(){
		replayGUI.hide();
	}	
	
	////////////////////////// -CheckerGUI- ///////////////////////
	
	public void addActionListener(ActionListener a){
		facade.addActionListener(a);
	}
	
	public void pressQuit() {
		facade.pressQuit();
	}
	
	public void selectSpace(int i) {
		facade.selectSpace(i);
	}
	
	public void pressDraw() {
		facade.pressDraw();
	}

	public int getTimer() {
		return facade.getTimer();
	}
	
	public String getFacadeUpdate(){
		return facade.update;
	}

	public String getPlayerSwitch(){
		return facade.playerSwitch;
	}
	
	public Board getStateOfBoard() {
		return facade.stateOfBoard();
	}
	
	public int getTimerWarning() {
		return facade.getTimerWarning();
	}
	
	public int whosTurn(){
		return facade.whosTurn();
	}
	
	////////////////////////// -Facade- //////////////////////////
	
	public int getGameMode(String mode){
		
		int gameMode = 0;
		
		if(mode == "host"){
			gameMode = facade.HOSTGAME;
		} else if(mode == "join"){
			gameMode = facade.CLIENTGAME;
		} else if(mode == "local"){
			gameMode = facade.LOCALGAME;
		}
		return gameMode;
	}
	
	public void setGameMode(String mode) throws Exception{
		int gameType = getGameMode(mode);
		facade.setGameMode(gameType);
	}
	
	public int getFacadeLocal(){
		return facade.LOCALGAME;
	}
	
	public int getFacadeClient(){
		return facade.CLIENTGAME;
	}
	
	public int getFacadeHost(){
		return facade.HOSTGAME;
	}
	
	public void setHost(URL host){
		facade.setHost(host);
	}
	
	public void createPlayer(int playerID, String mode){
		facade.createPlayer(playerID, this.getGameMode(mode));
	}
	
	public void setPlayerName(int playerID, String name){
		facade.setPlayerName(playerID, name);
	}
	
	public String getPlayerName(int playerID){
		return facade.getPlayerName(playerID);
	}
	
	public void setTimer(int totalLength, int warningLength){
		try {
			facade.setTimer(totalLength, warningLength);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Invalid Timer value(s)", "Error",
					JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void startGame(){
		facade.startGame();
	}


	

	
	
	

}
