package teich.tictactoe;


public class TicTacToeBoard {

	private Symbol[][] board;

	public TicTacToeBoard() {
		board = new Symbol[3][3];
		board[0][0] = Symbol.valueOf("X");
		board[0][1] = Symbol.valueOf("X");
		board[0][2] = Symbol.valueOf("X");
		board[1][0] = Symbol.valueOf("X");
		board[1][1] = Symbol.valueOf("O");
		board[1][2] = Symbol.valueOf("O");
		board[2][0] = Symbol.valueOf("O");
		board[2][1] = Symbol.valueOf("X");
		board[2][2] = Symbol.valueOf("O");

	}

	public void reset() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = null;
			}
		}
	}

	public boolean isFull() {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != null) {
					count++;
				}
			}
		}
		return count == 9;

	}

	public void setSquare(Location l, Symbol s) {
		board[l.getX()][l.getY()] = s;
	}

	public Symbol getSquare(Location loc) {
		return board[loc.getX()][loc.getY()];
	}
}
