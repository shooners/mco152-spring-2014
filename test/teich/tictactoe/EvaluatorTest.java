package teich.tictactoe;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {

	@Test
	public void testGetWinner() {
		TicTacToeBoard b = new TicTacToeBoard();
		Evaluator evaluate = new Evaluator(b);

		Symbol s = Symbol.X;
		Symbol actual = evaluate.getWinner();

		Assert.assertSame(s, actual);
	}

	@Test
	public void testGetWinningSquares() {
		TicTacToeBoard b = new TicTacToeBoard();
		Evaluator e = new Evaluator(b);

		List<Location> expected = new ArrayList<Location>();
		expected = null;
		List<Location> squares = new ArrayList<Location>();
		squares = e.getWinningSquares();

		Assert.assertSame(expected, squares);
	}

}
