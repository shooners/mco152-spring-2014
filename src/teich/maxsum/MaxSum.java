package teich.maxsum;

public class MaxSum {

	private int[][] numbers;
	private int max;

	public MaxSum(int max) {
		this.max = max;
		numbers = new int[max][max];
	}

	public int getMaxSum() {
		int x = 0;
		int y = 0;
		int sum1 = numbers[x][y];
		for (int row = x; row < max; row++) {
			for (int column = y; column < max; column++) {
				int temp = numbers[row][column];
				if (temp > sum1) {
					sum1 = temp;
				}
				if (column < max - 1) {
					int temp2 = numbers[row][column] + numbers[row][column + 1];
					if (temp2 > sum1) {
						sum1 = temp2;
					}
					if (column < max - 2) {
						int temp3 = temp2 + numbers[row][column + 2];
						if (temp3 > sum1) {
							sum1 = temp3;
						}

						if (column == 0) {
							int temp4 = temp3 + numbers[row][column + 3];
							if (temp4 > sum1) {
								sum1 = temp4;
							}
						}
					}
				}
			}
		}

		for (int r = x; r < max; r++) {
			for (int c = y; c < 4; c++) {
				if (r < max - 1) {
					int temp2 = numbers[r][c] + numbers[r + 1][c];
					if (temp2 > sum1) {
						sum1 = temp2;
					}
					if (r < max - 2) {
						int temp3 = temp2 + numbers[r + 2][c];
						if (temp3 > sum1) {
							sum1 = temp3;
						}
						if (r == 0) {
							int temp4 = temp3 + numbers[r + 3][c];
							if (temp4 > sum1) {
								sum1 = temp4;
							}
						}
					}
				}
			}
		}

		for (int r = x; r < max; r++) {
			for (int c = y; c < max; c++) {
				if (r < max - 1 && c < max - 1) {
					int temp2 = numbers[r][c] + numbers[r][c + 1]
							+ numbers[r + 1][c] + numbers[r + 1][c + 1];// 2*2
					if (temp2 > sum1) {
						sum1 = temp2;
					}
					if (r < max - 2 && c < max - 2) {
						int temp3 = temp2 + numbers[r][c + 2]
								+ numbers[r + 1][c + 2];// 3*2
						if (temp3 > sum1) {
							sum1 = temp3;
						}
						if (c == 0) {
							int temp4 = temp3 + numbers[r][c + 3]
									+ numbers[r + 1][c + 3];// 4*2
							if (temp4 > sum1) {
								sum1 = temp4;
							}

							int temp5 = temp2 + numbers[r + 2][c]
									+ numbers[r + 2][c + 1];// 2*3
							if (temp5 > sum1) {
								sum1 = temp5;
							}
							int temp6 = temp3 + numbers[r + 2][c]
									+ numbers[r + 2][c + 1]
									+ numbers[r + 2][c + 2];// 3*3
							if (temp6 > sum1) {
								sum1 = temp6;
							}
							int temp7 = temp6 + numbers[r][c + 3]
									+ numbers[r + 1][c + 3]
									+ numbers[r + 2][c + 3];// 4*3
							if (temp7 > sum1) {
								sum1 = temp7;
							}
							if (r == 0) {
								int temp8 = temp5 + numbers[r + 3][c]
										+ numbers[r + 3][c + 1];// 2*4
								if (temp8 > sum1) {
									sum1 = temp8;
								}
								int temp9 = temp6 + numbers[r + 3][c]
										+ numbers[r + 3][c + 1]
										+ numbers[r + 3][c + 2];// 3*4
								if (temp9 > sum1) {
									sum1 = temp9;
								}
								int temp10 = temp9 + numbers[r][c + 3]
										+ numbers[r + 1][c + 3]
										+ numbers[r + 2][c + 3]
										+ numbers[r + 3][c + 3];// 4*4
								if (temp10 > sum1) {
									sum1 = temp10;
								}
							}
						}
					}
				}
			}
		}
		return sum1;
	}

	public static void main(String[] args) {
		MaxSum rec = new MaxSum(5);
		System.out.println(rec.getMaxSum());
	}
}
