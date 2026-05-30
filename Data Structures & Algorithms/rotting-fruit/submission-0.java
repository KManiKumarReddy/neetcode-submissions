class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();

        int freshCount = 0;
        int minutes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1)
                    freshCount ++;
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty() && freshCount > 0) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= grid.length ||
                    nc < 0 || nc >= grid[0].length) {
                    continue;
                }

                if (grid[nr][nc] == 1) {
                    grid[nr][nc] = grid[r][c] + 1;
                    minutes = Math.max(minutes, grid[nr][nc]);
                    freshCount --;
                    q.offer(new int[]{nr, nc});
                }
            }

        }
        return freshCount > 0 ? -1 : (minutes > 2 ? minutes - 2 : 0);
    }
}