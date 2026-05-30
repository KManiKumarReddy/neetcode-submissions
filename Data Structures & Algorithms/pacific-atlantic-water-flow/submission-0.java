class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] grid) {

        HashSet<List<Integer>> pacificVisited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            q.offer(new int[]{i, 0});
            pacificVisited.add(Arrays.asList(i,0));
        }
        for (int j = 1; j < grid[0].length; j++) {
            q.offer(new int[]{0, j});
            pacificVisited.add(Arrays.asList(0,j));
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr <= 0 || nr >= grid.length ||
                    nc <= 0 || nc >= grid[0].length || pacificVisited.contains(Arrays.asList(nr,nc))) {
                    continue;
                }

                if (grid[nr][nc] >= grid[r][c]) {
                    pacificVisited.add(Arrays.asList(nr,nc));
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        System.out.println(pacificVisited);



        HashSet<List<Integer>> atlanticVisited = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            q.offer(new int[]{i, grid[0].length - 1});
            atlanticVisited.add(Arrays.asList(i,grid[0].length -1));
        }
        for (int j = 0; j < grid[0].length - 1; j++) {
            q.offer(new int[]{grid.length -1, j});
            atlanticVisited.add(Arrays.asList(grid.length -1,j));
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= grid.length - 1 ||
                    nc < 0 || nc >= grid[0].length - 1 || atlanticVisited.contains(Arrays.asList(nr,nc))) {
                    continue;
                }

                if (grid[nr][nc] >= grid[r][c]) {
                    atlanticVisited.add(Arrays.asList(nr,nc));
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        atlanticVisited.retainAll(pacificVisited);

        return new ArrayList(atlanticVisited);
    }
}