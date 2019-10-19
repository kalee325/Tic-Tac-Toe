import java.util.Scanner;
public class TicTacToe {

	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Tic Tac Toe - Player is O and AI is X");
		boolean winner = false;
		char [] board = new char [9]; 
		char player = 'O';

		//print out the intial board with positional numbers
		String numbers = "123456789";
		for(int i = 0; i < numbers.length(); i++) {
			if(board[i] != 'O' && board[i] != 'X') {
				board[i] = numbers.charAt(i);	
			}
		}
		printBoard(board);

		do{
			//player's turn
			System.out.print("Enter a position (enter 0 to exit): ");
			int position = input.nextInt();
			if(position == 0) {
				System.exit(0);
			}
			//the input must be a number from 1 to 9
			int i = -1;
			if(i < board.length) {
				if(position > i) {
					position--;
				}
			}
			updateBoard(position, player, board);

			//AI's turn
			int position2;
			if(!isWinner(board)) {
				position2 = nextPosition(board);
				char player2 = updateMark(player);
				updateBoard(position2, player2, board);
			}

			printBoard(board);

			//if you win
			winner = isWinner(board); 
			if(winner == true) {
				System.out.println("You are the winner!");
			}

			//if AI wins
			//horizontal for X
			else if(board[0] == 'X' && board[0] == board[1] && board[1] == board[2]) {
				winner = true;
				System.out.println("You lose...");
			}
			else if(board[3] == 'X' && board[3] == board[4] && board[4] == board[5]) {
				winner = true;
				System.out.println("You lose...");
			}
			else if(board[6] == 'X' && board[6] == board[7] && board[7] == board[8]) {
				winner = true;
				System.out.println("You lose...");
			}
			//vertical for X
			else if(board[0] == 'X' && board[0] == board[3] && board[3] == board[6]) {
				winner = true;
				System.out.println("You lose...");
			}
			else if(board[1] == 'X' && board[1] == board[4] && board[4] == board[7]) {
				winner = true;
				System.out.println("You lose...");
			}
			else if(board[2] == 'X' && board[2] == board[5] && board[5] == board[8]) {
				winner = true;
				System.out.println("You lose...");
			}
			//diagonal for X
			else if(board[0] == 'X' && board[0] == board[4] && board[4] == board[8]) {
				winner = true;
				System.out.println("You lose...");
			}
			else if(board[2] == 'X' && board[2] == board[4] && board[4] == board[6]) {
				winner = true;
				System.out.println("You lose...");
			}
		} while(winner == false); 
	//if winner remains false while the board is all filled, then the game is draw.
	}
	public static void printBoard(char board []) {
		System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
		System.out.println("---+---+---");
		System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
		System.out.println("---+---+---");
		System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
	}
	public static int nextPosition(char board []) {
		//random position of AI
		int positionAI = (int)(Math.random() * 9);
		//AI's position cannot be the same as the player's
		while(board[positionAI] == 'O' && board[positionAI] == 'X'
		 || board[positionAI] == 'O' || board[positionAI] == 'X') {
			positionAI = (int)(Math.random() * 9);
		}

		return positionAI;
	}
	public static char updateMark(char mark) {
		return 'X';
	}
	public static void updateBoard(int pos, char mark, char board []) {
		for(int i = 0; i < board.length; i++) {
			board[pos] = mark;
			//if no position is occupied, it becomes empty
			if(board[i] != 'X' && board[i] != 'O') {
				board[i] = ' ';
			}
		}
	}
	public static boolean isWinner(char board []) {
		//horizontal for O
		if(board[0] == 'O' && board[0] == board[1] && board[1] == board[2]) {
			return true;
		}
		else if(board[3] == 'O' && board[3] == board[4] && board[4] == board[5]) {
			return true;
		}
		else if(board[6] == 'O' && board[6] == board[7] && board[7] == board[8]) {
			return true;
		}
		//vertical for O
		else if(board[0] == 'O' && board[0] == board[3] && board[3] == board[6]) {
			return true;
		}
		else if(board[1] == 'O' && board[1] == board[4] && board[4] == board[7]) {
			return true;
		}
		else if(board[2] == 'O' && board[2] == board[5] && board[5] == board[8]) {
			return true;
		}
		//diagonal for O
		else if(board[0] == 'O' && board[0] == board[4] && board[4] == board[8]) {
			return true;
		}
		else if(board[2] == 'O' && board[2] == board[4] && board[4] == board[6]) {
			return true;
		}
		else {
			return false;
		}		
	}
}
