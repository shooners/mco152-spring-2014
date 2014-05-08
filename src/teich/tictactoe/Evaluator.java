package teich.tictactoe;


import java.util.ArrayList;
import java.util.List;

public class Evaluator {

	private TicTacToeBoard board;
	private Symbol s;
	private List<Location> squareX, squareO;

	public Evaluator(TicTacToeBoard board) {
		this.board = board;
		s = null;
	}

	public void evaluate() {
		int countX = 0;
		int countO = 0;

		for (int i = 0; i < 3; i++) {
			if (countX == 3) {
				s = Symbol.X;
				return;
			} else if (countO == 3) {
				s = Symbol.O;
				return;
			}
			squareX = new ArrayList<Location>();
			squareO = new ArrayList<Location>();
			for (int j = 0; j < 3; j++) {
				Location loc = new Location(i, j);
				s = board.getSquare(loc);
				if (s.compareTo(Symbol.X) == 0) {
					countX++;
					squareX.add(loc);
				} else {
					countO++;
					squareO.add(loc);
				}
			}
		}
		countX = 0;
		countO = 0;
		for (int k = 0; k < 3; k++) {
			if (countX == 3) {
				s = Symbol.X;
				return;
			} else if (countO == 3) {
				s = Symbol.O;
				return;
			}
			squareX = new ArrayList<Location>();
			squareO = new ArrayList<Location>();
			for (int h = 0; h < 3; h++) {
				Location loc = new Location(h, k);
				s = board.getSquare(loc);
				if (s.compareTo(Symbol.X) == 0) {
					countX++;
				} else {
					countO++;
				}
			}
		}
		countX = 0;
		countO = 0;
		int g = 0;
		do {
			squareX = new ArrayList<Location>();
			squareO = new ArrayList<Location>();
			for (int f = 0; f < 3; f++) {
				Location loc = new Location(g, f);
				s = board.getSquare(loc);
				if (s.compareTo(Symbol.X) == 0) {
					countX++;
					squareX.add(loc);
				} else {
					countO++;
					squareO.add(loc);
				}
				g++;
			}
		} while (g < 3);
		if (countX == 3) {
			s = Symbol.X;
			return;
		} else if (countO == 3) {
			s = Symbol.O;
			return;
		}
		countX = 0;
		countO = 0;
		g = 2;
		do {
			squareX = new ArrayList<Location>();
			squareO = new ArrayList<Location>();
			for (int d = 0; d < 3; d++) {
				Location loc = new Location(g, d);
				s = board.getSquare(loc);
				if (s.compareTo(Symbol.X) == 0) {
					countX++;
					squareX.add(loc);
				} else {
					countO++;
					squareO.add(loc);
				}
				g--;
			}
		} while (g > -1);
		if (countX == 3) {
			s = Symbol.X;
			return;
		} else if (countO == 3) {
			s = Symbol.O;
			return;
		}
	}

	public Symbol getWinner() {
		Symbol winner = null;
		evaluate();
		winner = s;
		return winner;
	}

	public List<Location> getWinningSquares() {
		evaluate();
		if (Symbol.X.equals(s)) {
			return squareX;
		} else if (Symbol.O.equals(s)) {
			return squareO;
		} else {
			return null;
		}
	}
}
