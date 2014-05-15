package teich.checkers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard() {
		this.board = new Piece[HEIGHT][WIDTH];
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y) {
		return (x < 8 && x > -1 && y < 8 && y > -1);
	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y) {
		return board[y][x] == null;
	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				removePiece(i, j);
			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame() {
		int h = 1;
		int w = 0;
		do {
			setPiece(h, w, Piece.WHITE_MAN);
			h += 2;
		} while (h < 8);

		h = 0;
		w = 1;
		do {
			setPiece(h, w, Piece.WHITE_MAN);
			h += 2;
		} while (h < 8);
		h = 1;
		w = 2;
		do {
			setPiece(h, w, Piece.WHITE_MAN);
			h += 2;
		} while (h < 8);
		h = 0;
		w = 5;
		do {
			setPiece(h, w, Piece.RED_MAN);
			h += 2;
		} while (h < 8);

		h = 1;
		w = 6;
		do {
			setPiece(h, w, Piece.RED_MAN);
			h += 2;
		} while (h < 8);
		h = 0;
		w = 7;
		do {
			setPiece(h, w, Piece.RED_MAN);
			h += 2;
		} while (h < 8);
	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (board[i][j] == null) {
					builder.append("-");
				} else {
					builder.append(board[i][j].toString());
				}
				if (j == WIDTH - 1) {
					builder.append("\n");
				}
			}
		}
		return builder.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move) {
		if (isOnBoard(move.getX1(), move.getY1())
				&& isOnBoard(move.getX2(), move.getY2())) {
			Piece p = getPiece(move.getX1(), move.getY1());
			removePiece(move.getX1(), move.getY1());
			if (move.getY2() == 0) {
				setPiece(move.getX2(), move.getY2(), Piece.RED_KING);
			} else if (move.getY2() == 7) {
				setPiece(move.getX2(), move.getY2(), Piece.WHITE_KING);
			} else {
				setPiece(move.getX2(), move.getY2(), p);
			}
		}
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump) {
		Piece piece = getPiece(jump.getX1(), jump.getY1());
		removePiece(jump.getX1(), jump.getY1());
		removePiece(jump.getCaptureX(), jump.getCaptureY());
		if (jump.getY2() == 0) {
			setPiece(jump.getX2(), jump.getY2(), Piece.RED_KING);
		} else if (jump.getY2() == 7) {
			setPiece(jump.getX2(), jump.getY2(), Piece.WHITE_KING);
		} else {
			setPiece(jump.getX2(), jump.getY2(), piece);
		}
	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {
		List<Move> moves = new ArrayList<Move>();
		if (!isEmptySquare(x, y)) {
			Piece p = getPiece(x, y);
			if (!p.isKing()) {
				if (p.isColor(Color.RED)) {
					if (isOnBoard(x - 1, y + 1) && isEmptySquare(x - 1, y + 1)) {
						moves.add(new Move(x, y, x + 1, y - 1));
					}
					if (isOnBoard(x + 1, y + 1) && isEmptySquare(x + 1, y + 1)) {
						moves.add(new Move(x, y, x - 1, y - 1));
					}
				} else {
					if (isOnBoard(x + 1, y - 1) && isEmptySquare(x + 1, y - 1)) {
						moves.add(new Move(x, y, x - 1, y + 1));
					}
					if (isOnBoard(x - 1, y - 1) && isEmptySquare(x - 1, y - 1)) {
						moves.add(new Move(x, y, x + 1, y + 1));
					}
				}
			} else {
				if (isOnBoard(x + 1, y - 1) && isEmptySquare(x + 1, y - 1)) {
					moves.add(new Move(x, y, x + 1, y - 1));
				}
				if (isOnBoard(x - 1, y - 1) && isEmptySquare(x - 1, y - 1)) {
					moves.add(new Move(x, y, x - 1, y - 1));
				}
				if (isOnBoard(x + 1, y + 1) && isEmptySquare(x + 1, y + 1)) {
					moves.add(new Move(x, y, x + 1, y + 1));
				}
				if (isOnBoard(x - 1, y + 1) && isEmptySquare(x - 1, y + 1)) {
					moves.add(new Move(x, y, x - 1, y + 1));
				}
			}
		}
		return moves;
	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y) {
		List<Jump> jumps = new ArrayList<Jump>();
		if (!isEmptySquare(x, y)) {
			Piece p = getPiece(x, y);
			if (!p.isKing()) {
				if (p.isColor(Color.RED)) {
					if (!isEmptySquare(x + 1, y - 1)) {
						if (isOnBoard(x + 2, y - 2)
								&& isEmptySquare(x + 2, y - 2)
								&& getPiece(x + 1, y - 1).isEnemyColor(
										Color.RED)) {
							jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
						}
					}
					if (!isEmptySquare(x - 1, y - 1)) {
						if (isOnBoard(x - 2, y - 2)
								&& isEmptySquare(x - 2, y - 2)
								&& getPiece(x - 1, y - 1).isEnemyColor(
										Color.RED)) {
							jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
						}
					}
				} else {
					if (!isEmptySquare(x + 1, y - 1)) {
						if (isOnBoard(x + 2, y - 2)
								&& isEmptySquare(x + 2, y - 2)
								&& getPiece(x + 1, y - 1).isEnemyColor(
										Color.WHITE)) {
							jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
						}
					}
					if (!isEmptySquare(x - 1, y - 1)) {
						if (isOnBoard(x - 2, y - 2)
								&& isEmptySquare(x - 2, y - 2)
								&& getPiece(x - 1, y - 1).isEnemyColor(
										Color.WHITE)) {
							jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
						}
					}
				}
			} else {
				Color color = (p.isColor(Color.RED) ? Color.RED : Color.WHITE);
				if (!isEmptySquare(x + 1, y - 1)) {
					if (isOnBoard(x + 2, y - 2) && isEmptySquare(x + 2, y - 2)
							&& getPiece(x + 1, y - 1).isEnemyColor(color)) {
						jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
					}
				}
				if (!isEmptySquare(x - 1, y - 1)) {
					if (isOnBoard(x - 2, y - 2) && isEmptySquare(x - 2, y - 2)
							&& getPiece(x - 1, y - 1).isEnemyColor(color)) {
						jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
					}
				}
				if (!isEmptySquare(x + 1, y + 1)) {
					if (isOnBoard(x + 2, y + 2) && isEmptySquare(x + 2, y + 2)
							&& getPiece(x + 1, y + 1).isEnemyColor(color)) {
						jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
					}
				}
				if (!isEmptySquare(x - 1, y + 1)) {
					if (isOnBoard(x - 2, y + 2) && isEmptySquare(x + 2, y + 2)
							&& getPiece(x - 1, y + 1).isEnemyColor(color)) {
						jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
					}
				}
			}
		}
		return jumps;
	}

}
