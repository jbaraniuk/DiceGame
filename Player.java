package diceGame;
/**
 * @author Justin Baraniuk 
 * Player object stores name and score.
 */
public class Player {
	private String name;
	private int score;
	
	/**
	 * Constructor
	 * @param name  The player's name.
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * The setScore method sets the player's score.
	 * @param points  To add to player's score.
	 */
	public void setScore(int points) {
		if (score + points > 0)
			this.score += points;
		else if (score + points < 0)
			this.score = 0;
	}
	
	/**
	 * The getScore method returns the player's score.
	 * @return	The player's current score.
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * The getName method returns the player's name.
	 * @return name The player's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * The toString method returns the player's name.
	 * @return name	The player's name and score as a String.
	 */
	public String toString() {
		return name + ": " + score;
	}
}
