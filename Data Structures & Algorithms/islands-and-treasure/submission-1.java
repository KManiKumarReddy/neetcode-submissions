
class Solution {

    
    public void islandsAndTreasure(int[][] grid) {
        Queue<Integer> q = new LinkedList<>();
        int currentDistance = 1;

        for(int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 0)
                    q.offer(i*100+j);
        }
        q.offer(-1);
        while(!q.isEmpty()) {
            int currentIndex = q.poll();
            if(currentIndex == -1) {
                currentDistance ++;
                if(!q.isEmpty())
                    q.offer(-1);
                continue;
            }
            int i = currentIndex / 100;
            int j = currentIndex % 100;
            if( i +1 < grid.length){
                int current = grid[i+1][j];
                if(current == 2147483647){
                    q.offer((i+1)*100 + j);
                    grid[i+1][j] = currentDistance ;
                }
            }
            if( i > 0){
                int current = grid[i-1][j];
                if(current == 2147483647){
                    q.offer((i-1)*100 + j);
                    grid[i-1][j] = currentDistance ;
                }
            }
            if( j +1 < grid[0].length){
                int current = grid[i][j+1];
                if(current == 2147483647){
                    q.offer(i*100 + j+1);
                    grid[i][j+1] = currentDistance ;
                }
            }
            if( j > 0){
                int current = grid[i][j - 1];
                if(current == 2147483647){
                    q.offer(i*100 + j - 1);
                    grid[i][j-1] = currentDistance ;
                }
            }
            
        }
        
    }
}
