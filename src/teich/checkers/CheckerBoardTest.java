package teich.checkers;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CheckerBoardTest {

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringOnEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		final String expected = "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringAfterNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n"
				+ "--------\n" + "--------\n" + "r-r-r-r-\n" + "-r-r-r-r\n"
				+ "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test that isOnBoard() returns the correct result for different xs and ys
	 */
	public void testIsOnBoard() {
		CheckerBoard board = new CheckerBoard();
		boolean found = board.isOnBoard(1, 6);
		Assert.assertTrue(found);
		boolean square = board.isOnBoard(7, 7);
		Assert.assertTrue(square);
		boolean onBoard = board.isOnBoard(8, 0);
		Assert.assertFalse(onBoard);
	}

	@Test
	/**
	 * Test that isEmptySquare() returns the correct result before and after setPiece() is called
	 */
	public void testIsEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		boolean empty = board.isEmptySquare(1, 2);
		Assert.assertTrue(empty);
		board.setPiece(1, 2, Piece.WHITE_MAN);
		boolean full = board.isEmptySquare(1, 2);
		Assert.assertFalse(full);
	}

	@Test
	/**
	 * Given an board with pieces, test that calling clear() clears the board
	 */
	public void testClear() {
		CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		board.clear();
		boolean empty = board.isEmptySquare(1, 0);
		Assert.assertTrue(empty);
	}

	@Test
	/**
	 * Test that the board is in the correct configuration after
	 * resetNewGame() is called
	 */
	public void testResetNewGame() {
		CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		Assert.assertEquals(board.getPiece(0, 0), null);
		Assert.assertEquals(board.getPiece(0, 1), Piece.WHITE_MAN);
		Assert.assertEquals(board.getPiece(0, 2), null);
		Assert.assertEquals(board.getPiece(0, 3), null);
		Assert.assertEquals(board.getPiece(0, 4), null);
		Assert.assertEquals(board.getPiece(0, 5), Piece.RED_MAN);
		Assert.assertEquals(board.getPiece(0, 6), null);
		Assert.assertEquals(board.getPiece(0, 7), Piece.RED_MAN);
	}

	@Test
	/**
	 * Test execute(Move) moves a piece from one square to the other
	 */
	public void testMove() {
		CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		board.execute(new Move(5, 2, 4, 3));
		Assert.assertTrue(board.isEmptySquare(5, 2));
		Assert.assertFalse(board.isEmptySquare(4, 3));
	}

	@Test
	/**
	 * Test execute(Move) promotes a WHITE_MAN to a WHITE_KING when moving to the 8th row
	 */
	public void testMovePromoteToWhiteKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 6, Piece.WHITE_MAN);
		board.execute(new Move(3, 6, 4, 7));
		Piece p = board.getPiece(4, 7);
		Assert.assertTrue(p.isKing());
	}

	@Test
	/**
	 * Test execute(Move) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testMovePromoteToRedKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 1, Piece.RED_MAN);
		board.execute(new Move(2, 1, 3, 0));
		Piece p = board.getPiece(3, 0);
		Assert.assertTrue(p.isKing());
	}

	@Test
	/**
	 * Test execute(Jump) moves a piece from one square to another AND removes the piece that was jumped
	 */
	public void testJump() {
		CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		board.execute(new Jump(5, 2, 4, 3, 3, 4));
		Assert.assertTrue(board.isEmptySquare(5, 2));
		Assert.assertTrue(board.isEmptySquare(4, 3));
		Assert.assertFalse(board.isEmptySquare(3, 4));
	}

	@Test
	/**
	 * Test execute(Jump) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testJumpPromoteToRedKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 1, Piece.RED_MAN);
		board.execute(new Jump(1, 2, 2, 1, 3, 0));
		Piece p = board.getPiece(3, 0);
		Assert.assertTrue(p.isKing());
	}

	@Test
	/**
	 * Test execute(Jump) promotes a WHITE_MAN to a WHITE_KING when moving to the 1st row
	 */
	public void testJumpPromoteToWhiteKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 6, Piece.WHITE_MAN);
		board.execute(new Jump(2, 5, 3, 6, 4, 7));
		Piece p = board.getPiece(4, 7);
		Assert.assertTrue(p.isKing());
	}

	@Test
	/**
	 * Test that getMoves() returns the correct number of Move objects when called on an empty square
	 */
	public void testGetMovesForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		List<Move> moves = board.getMoves(5, 4);
		Assert.assertEquals(0, moves.size());
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 4, Piece.RED_MAN);
		List<Move> moves = board.getMoves(5, 4);
		Move m1 = new Move(5, 4, 6, 3);
		Assert.assertEquals(m1, moves.get(0));
		Move m2 = new Move(5, 4, 4, 3);
		Assert.assertEquals(m2, moves.get(1));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 4, Piece.RED_KING);
		List<Move> moves = board.getMoves(5, 4);
		Move m1 = new Move(5, 4, 6, 3);
		Assert.assertEquals(m1, moves.get(0));
		Move m2 = new Move(5, 4, 4, 3);
		Assert.assertEquals(m2, moves.get(1));
		Move m3 = new Move(5, 4, 6, 5);
		Assert.assertEquals(m3, moves.get(2));
		Move m4 = new Move(5, 4, 4, 5);
		Assert.assertEquals(m4, moves.get(3));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 2, Piece.WHITE_MAN);
		List<Move> moves = board.getMoves(5, 2);
		Move m1 = new Move(5, 2, 4, 3);
		Assert.assertEquals(m1, moves.get(0));
		Move m2 = new Move(5, 2, 6, 3);
		Assert.assertEquals(m2, moves.get(1));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 2, Piece.WHITE_KING);
		List<Move> moves = board.getMoves(5, 2);
		Move m1 = new Move(5, 2, 4, 3);
		Assert.assertEquals(m1, moves.get(3));
		Move m2 = new Move(5, 2, 6, 3);
		Assert.assertEquals(m2, moves.get(2));
		Move m3 = new Move(5, 2, 4, 1);
		Assert.assertEquals(m3, moves.get(1));
		Move m4 = new Move(5, 2, 6, 1);
		Assert.assertEquals(m4, moves.get(0));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is surrounded in 4 directions and
	 * cannot move.
	 * This should be an empty List
	 */
	public void testGetMovesForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 4, Piece.RED_KING);
		board.setPiece(6, 3, Piece.RED_KING);
		board.setPiece(4, 3, Piece.WHITE_MAN);
		board.setPiece(6, 5, Piece.WHITE_KING);
		board.setPiece(4, 5, Piece.RED_MAN);
		List<Move> moves = board.getMoves(5, 4);
		Assert.assertNotNull(moves);
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (0,7) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt07() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 7, Piece.RED_KING);
		List<Move> moves = board.getMoves(0, 7);
		Move move = new Move(0, 7, 1, 6);
		Assert.assertEquals(move, moves.get(0));
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (7,0) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt70() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(7, 0, Piece.RED_KING);
		Move move = new Move(7, 0, 6, 1);
		List<Move> moves = board.getMoves(7, 0);
		Assert.assertEquals(move, moves.get(0));
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on an empty square
	 */
	public void testGetJumpsForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		List<Jump> jumps = board.getJumps(4, 3);
		Assert.assertEquals(0, jumps.size());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on square that does not have
	 * any possible jumps
	 */
	public void testGetJumpsForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 4, Piece.RED_KING);
		List<Jump> jumps = board.getJumps(5, 4);
		Assert.assertEquals(0, jumps.size());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when a King can jump in 4 directions
	 */
	public void testGetJumpsForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 4, Piece.RED_KING);
		board.setPiece(6, 3, Piece.WHITE_MAN);
		board.setPiece(4, 3, Piece.WHITE_MAN);
		board.setPiece(6, 5, Piece.WHITE_MAN);
		board.setPiece(4, 5, Piece.WHITE_MAN);
		List<Jump> jumps = board.getJumps(5, 4);
		Jump j1 = new Jump(5, 4, 6, 3, 7, 2);
		Assert.assertEquals(j1, jumps.get(0));
		Jump j2 = new Jump(5, 4, 4, 3, 3, 2);
		Assert.assertEquals(j2, jumps.get(1));
		Jump j3 = new Jump(5, 4, 6, 5, 7, 6);
		Assert.assertEquals(j3, jumps.get(2));
		Jump j4 = new Jump(5, 4, 4, 5, 3, 6);
		Assert.assertEquals(j4, jumps.get(3));
	}

	@Test
	/**
	 * Test that getJumps() returns the returns the correct Jump objects when a Piece can jump in 2 directions
	 */
	public void testGetJumpsForRedManWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 4, Piece.RED_MAN);
		board.setPiece(6, 3, Piece.WHITE_MAN);
		board.setPiece(4, 3, Piece.WHITE_MAN);
		List<Jump> jumps = board.getJumps(5, 4);
		Jump j1 = new Jump(5, 4, 6, 3, 7, 2);
		Assert.assertEquals(j1, jumps.get(0));
		Jump j2 = new Jump(5, 4, 4, 3, 3, 2);
		Assert.assertEquals(j2, jumps.get(1));
	}

}
