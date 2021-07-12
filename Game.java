package diceGame;
/**
 * @author Justin Baraniuk
 * Game object class.
 */

import java.util.Random;
import java.util.ArrayList;

public class Game {
	private CircularlyDoublyLinkedList<Player> list;

	public Game(){
		list = new CircularlyDoublyLinkedList<>();
	}
	
	public void addPlayer(Player player) {
			list.addFirst(player);
	}
	
	public void startGame() {
		Random roll = new Random();
		ArrayList<String> eliminated = new ArrayList<>();
		Player player;
		boolean reverse = false;
		
		do {	
			// Get player
			player = list.first();
			
			// Roll dice
			int die1 = roll.nextInt(6) + 1;
			int die2 = roll.nextInt(6) + 1;
			
			// Display roll result
			System.out.print(player.getName() + " rolled " + 
					die1 + " and " + die2);
			
			// Calculate score
			if ((die1 == 2 || die2 == 2) && die1 + die2 != 7) {
				player.setScore(2 * (die1 + die2));
				System.out.println(". Lucky 2, score is now " + player.getScore());
			} else if (die1 + die2 == 7) {
					player.setScore(-7);
				System.out.println(". Unlucky 7, score is now " + player.getScore());
			} else if (die1 == 6 && die2 == 6) {
				player.setScore(0);
				System.out.println(", score is now " + player.getScore());
			} else if (die1 == 1 && die2 == 1) {
				eliminated.add(player.getName());
				System.out.println(". Snake eyes! Player eliminated :(");
				reverse = !reverse;
				list.removeFirst();
			} else {
				player.setScore(die1 + die2);
				System.out.println(", score is now " + player.getScore());
			}			
				
			// Rotate list
			if (!reverse) {
				list.rotate();
				
			} else {
				list.rotateReverse();
			}
			
		} while (player.getScore() < 100 && list.size() != 1);
		
		// Display winner and final score
		System.out.println(player.getName() + " has won the game :)");
		System.out.println();
		System.out.println("Final scores are: ");	
		
		for (int i = 1; i <= list.size(); i++) {
			if (i != list.size()) {
				System.out.print(list.first() + ", ");
			} else {
				System.out.print(list.first());
			}
			list.rotate();
		}
		
		// Display any eliminated players
		if (eliminated.size() > 0) {
			
			System.out.print("\n (Eliminated: ");
			for (int i = 0; i < eliminated.size(); i++) {
				if (i != eliminated.size() - 1)
					System.out.print(eliminated.get(i) + ", ");
				else
					System.out.println(eliminated.get(i) + ")");
			}
		}
	}
}
