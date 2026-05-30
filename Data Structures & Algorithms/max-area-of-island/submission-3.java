class Solution {

    private int currentCount = 0;

    private void searchAround(int[][] grid, int rowIndex, int columnIndex) {

        // Right
        if (columnIndex + 1 < grid[0].length && grid[rowIndex][columnIndex + 1] == 1) {
            grid[rowIndex][columnIndex + 1] = 0;
            currentCount ++;
            searchAround(grid, rowIndex, columnIndex + 1);

        }

        // Left
        if (columnIndex - 1 >= 0 && grid[rowIndex][columnIndex - 1] == 1) {
            grid[rowIndex][columnIndex - 1] = 0;
            currentCount ++;
            searchAround(grid, rowIndex, columnIndex - 1);
        }

        // Down
        if (rowIndex + 1 < grid.length && grid[rowIndex + 1][columnIndex] == 1) {
            grid[rowIndex + 1][columnIndex] = 0;
                currentCount ++;
                searchAround(grid, rowIndex + 1, columnIndex);
        }

        // Up
        if (rowIndex - 1 >= 0 && grid[rowIndex - 1][columnIndex] == 1) {
            grid[rowIndex - 1][columnIndex] = 0;
                currentCount ++;
                searchAround(grid, rowIndex - 1, columnIndex);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {

        int maxCount = 0;

        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < grid[0].length; columnIndex++) {

                if (grid[rowIndex][columnIndex] == 1) {
                        grid[rowIndex][columnIndex] = 0;
                        currentCount = 1;
                        searchAround(grid, rowIndex, columnIndex);
                        if(currentCount > maxCount)
                            maxCount = currentCount;
                }
            }
        }

        return maxCount;
    }
}