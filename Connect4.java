import java.util.Random;
import java.util.Scanner;

/*
 * the main class and use the other classes to play the game
 */
public class Connect4 {
	public static void main(String[] args) {
		String player1, player2;
		boolean change;
		boolean gameOver = false;
		Board board = new Board();
		final String[] color = {"X", "O"};
		int[] record = new int[7];
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please create a name for Player 1:");
		player1 = input.nextLine();
		System.out.print("Please create a name for Player 2:");
		player2 = input.nextLine();
		System.out.println(player1 + ", you should input a number 0 or 1 to decide who go first.");
		int number = input.nextInt();
		input.nextLine();
		
		while (number != 0 && number != 1) {
			System.out.println(player1 + ", you should input a number 0 or 1 to decide who go first.");
			number = input.nextInt();
			input.nextLine();
		}
	
		if (number == new Random().nextInt(2)) {
			change = true;
		} else {
			change = false;
		}
		System.out.println("Game start!Player " + (change ? player1 : player2) + " go first.");
		while (!gameOver) {
			board.print();
			System.out.println((change ? player1 : player2)
					+ ", please input a number range in [1,7] which column to add a piece.");
			int col;

			col = Integer.valueOf(input.nextLine()); 
			while (col < 1 || col > 7 || record[col - 1] >= 6) {
				if (col >= 1 && col <= 7 && record[col - 1] >= 6) {
					System.out.println((change ? player1 : player2) + " that col is already full,please select another column range[1,7].");
					col = Integer.valueOf(input.nextLine()); 
					continue;
				}
				System.out.println((change ? player1 : player2)
						+ ", please input a number range in [1,7] which column to add a piece.");
				col = Integer.valueOf(input.nextLine()); 
			}
			
			Piece piece = new Piece(change ? color[0] : color[1]);
			board.addPiece(piece, col);
			record[col - 1]++;
			
			if(board.win()){
				System.out.println("Game over! Player " + (change ? player1 : player2) + " win.");
				gameOver = true;
				board.print();
			} else if(board.isFull()){
				System.out.println("Game over! Draw.");
				gameOver = true;
				board.print();
			}
			change = !change;
		}
	}
}