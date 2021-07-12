package diceGame;
/**
 * @author Justin Baraniuk
 * Driver for Dice game.
 */
public class DiceGameDriver {

	public static void main(String[] args) {
		Game game = new Game();	
		Player player1 = new Player("Justin");
		Player player2 = new Player("Tiffany");
		Player player3 = new Player("Tom");
		Player player4 = new Player("Viola");
		game.addPlayer(player1);
		game.addPlayer(player2);
		game.addPlayer(player3);
		game.addPlayer(player4);		
		game.startGame();
	}
}
