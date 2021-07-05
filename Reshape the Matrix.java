class Solution {
   public int[][] matrixReshape(int[][] mat, int r, int c) {

	int m = mat.length, n = mat[0].length;
	if (m * n != r * c)
		return mat;

	int[][] ans = new int[r][c];
	int x = 0, y = 0;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			ans[x][y] = mat[i][j];
			y++;
			if (y == c) {
				x++;
				y = 0;
			}
		}
	}

	return ans;
}
}