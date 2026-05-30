class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O'){
                q.offer(new int[]{i,0});
            }
            if(board[i][board[0].length - 1] == 'O')
                q.offer(new int[]{i,board[0].length - 1});
        }
        for(int i = 1; i < board[0].length - 1; i++){
            if(board[0][i] == 'O')
                q.offer(new int[]{0,i});
            if(board[board.length - 1][i] == 'O')
                q.offer(new int[]{board.length - 1,i});
        }

        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] dir : dirs) {
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr < 1 || nr >= board.length - 1 || nc < 1  || nc >= board[0].length - 1 || visited[nr][nc])
                    continue;
                
                if(board[nr][nc] == 'O') {
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }

        for(int i = 1; i < board.length - 1; i++){
            for(int j = 1; j < board[0].length - 1; j++){
                if(board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
        
    }
}