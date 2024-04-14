package org.problems;

public class MaximumRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] columns = new int[R + 1][C + 1];
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                columns[x + 1][y] = columns[x][y] + (matrix[x][y] - '0');
            }
        }
        int best = 0;
        for (int top = 0; top < R; top++) {
            for (int bot = top; bot < R; bot++) {
                int current = 0;
                for (int y = 0; y < C; y++) {
                    if (all_ones(top, bot, y, columns)) {
                        current += 1;
                    } else {
                        current = 0;
                    }
                    best = Math.max(best, current * (bot - top + 1));
                }
            }
        }
        return best;
    }
    public boolean all_ones(int top, int bot, int y, int[][] columns) {
        return columns[bot + 1][y] - columns[top][y] == bot - top + 1;
    }
}
