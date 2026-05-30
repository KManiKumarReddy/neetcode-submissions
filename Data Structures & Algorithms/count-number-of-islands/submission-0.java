class Solution {

    private boolean[][] visited;

    private void searchAround(char[][] grid, int rowIndex, int columnIndex) {

        // Right
        if (columnIndex + 1 < grid[0].length && !visited[rowIndex][columnIndex + 1]) {
            visited[rowIndex][columnIndex + 1] = true;
            if (grid[rowIndex][columnIndex + 1] == '1') {
                searchAround(grid, rowIndex, columnIndex + 1);
            }
        }

        // Left
        if (columnIndex - 1 >= 0 && !visited[rowIndex][columnIndex - 1]) {
            visited[rowIndex][columnIndex - 1] = true;
            if (grid[rowIndex][columnIndex - 1] == '1') {
                searchAround(grid, rowIndex, columnIndex - 1);
            }
        }

        // Down
        if (rowIndex + 1 < grid.length && !visited[rowIndex + 1][columnIndex]) {
            visited[rowIndex + 1][columnIndex] = true;
            if (grid[rowIndex + 1][columnIndex] == '1') {
                searchAround(grid, rowIndex + 1, columnIndex);
            }
        }

        // Up
        if (rowIndex - 1 >= 0 && !visited[rowIndex - 1][columnIndex]) {
            visited[rowIndex - 1][columnIndex] = true;
            if (grid[rowIndex - 1][columnIndex] == '1') {
                searchAround(grid, rowIndex - 1, columnIndex);
            }
        }
    }

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];

        int count = 0;

        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < grid[0].length; columnIndex++) {

                if (!visited[rowIndex][columnIndex]) {
                    visited[rowIndex][columnIndex] = true;

                    if (grid[rowIndex][columnIndex] == '1') {
                        searchAround(grid, rowIndex, columnIndex);
                        count++;
                    }
                }
            }
        }

        return count;
    }
}