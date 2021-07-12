# diceGame
Multiplayer dice game; first to 100 wins!

In this simple turn-based multiplayer game, each player takes a turn rolling a pair of dice. After each roll their score is increased by the result (the score of 2 dice added together) and the next player will have their turn.

If a player’s roll includes a 2, increase the score by double the roll amount
If a player’s roll results in a total of 7, their score is decreased by 7 points
Note that scores do not go below 0
If a player rolls a pair of 6s, their score is reset to 0 and the turn-taking order is reversed
If the player rolls a pair of 1s, they are eliminated from the game.
This will continue until a winner is declared: either someone reaches 100 points or there is only one player left in the game.
