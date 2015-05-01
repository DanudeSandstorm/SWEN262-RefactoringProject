package Code;

import java.net.URL;

public class GUIManager {
	Facade facade;
	
	public GUIManager(Facade facade){
		this.facade = facade;
		
	}
	
	CheckerGUI playingBoardGUI; //= new CheckerGUI(facade, null, null);
	NetworkingGUI networkGUI; //= new NetworkingGUI(null, this);
	PlayerGUI playerSettingsGUI; //= new PlayerGUI(null, this, 0);
	
	////////////////////////////////////////////////////
	
	public void instanceBoardGUI(String player1, String player2){
		playingBoardGUI = new CheckerGUI(facade, player1, player2);
		
	}
	
	public void boardGUIShow(){
		playingBoardGUI.show();
	}
	
	public void boardGUIHide(){
		playingBoardGUI.hide();
		
	}
	
	////////////////////////////////////////////////////
	
	public void instanceNetworkGUI(Facade facade, GUIManager manager){
		networkGUI = new NetworkingGUI(facade, manager);
	}
		
	public void networkGUIShow(){
		networkGUI.show();
	}
	
	public void networkGUIHide(){
		networkGUI.hide();
	}
	
	////////////////////////////////////////////////////
	
	
	public void instancePlayersGUI(){
		playerSettingsGUI = new PlayerGUI(facade, this, facade.CLIENTGAME);
	}
	
	public void playerSettingsGUIShow(){
		playerSettingsGUI.show();
	}
	
	public void playerSettingsGUIHide(){
		playerSettingsGUI.hide();
	}
	
	////////////////////////////////////////////////////
	
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
		int gameMode = getGameMode(mode);
		facade.setGameMode(gameMode);
	}
	
	public void setHost(URL host){
		facade.setHost(host);
	}
	
	public void createPlayer(int playerID, String mode){
		facade.createPlayer(playerID, this.getGameMode(mode));
	}
	

}
