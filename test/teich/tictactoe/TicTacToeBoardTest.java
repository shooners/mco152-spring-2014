package teich.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeBoardTest {

	@Test
	public void testIsFull() {

		TicTacToeBoard b = new TicTacToeBoard();
		boolean full = b.isFull();

		Assert.assertTrue(full);
	}

	@Test
	public void testGetSymbol() {
		TicTacToeBoard b = new TicTacToeBoard();
		Symbol actual = b.getSquare(new Location(0, 0));
		Symbol symbol = Symbol.X;

		Assert.assertSame(symbol, actual);
	}
}
