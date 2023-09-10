package union_find;

public class CountIslands {
    int islandsCounter = 0;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        } else {
            int rowNumber = grid.length;
            int colNumber = grid[0].length;

            for (int row = 0; row < rowNumber; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] != '0' && grid[row][col] != 'v') {
                        islandsCounter += 1;
                        markIslands(row, col, grid, rowNumber, colNumber);
                    }
                }
            }

            return islandsCounter;
        }
    }

    private void markIslands(int row, int col, char[][] grid, int rowNumber, int colNumber) {
        if (grid[row][col] != '0' && grid[row][col] != 'v') {
            grid[row][col] = 'v';

            if (row > 0) {
                markIslands(row - 1, col, grid, rowNumber, colNumber);
            }
            if (row < rowNumber - 1) {
                markIslands(row + 1, col, grid, rowNumber, colNumber);
            }
            if (col > 0) {
                markIslands(row, col - 1, grid, rowNumber, colNumber);
            }
            if (col < colNumber - 1) {
                markIslands(row, col + 1, grid, rowNumber, colNumber);
            }
        }
    }
}
