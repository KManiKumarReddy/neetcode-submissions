
class Solution {

    
    public void islandsAndTreasure(int[][] grid) {
        Queue<Integer> q = new LinkedList<>();
        int currentDistance = 0;

        for(int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 0)
                    q.offer(i*100+j);
        }
        q.offer(-1);
        while(!q.isEmpty()) {
            System.out.println(q+" "+ currentDistance);
            int currentIndex = q.poll();
            if(currentIndex == -1) {
                currentDistance ++;
                if(!q.isEmpty())
                    q.offer(-1);
                continue;
            }
            int i = currentIndex / 100;
            int j = currentIndex % 100;
            if(grid[i][j] == 2147483647){
                grid[i][j] = currentDistance;
            }
            if( i +1 < grid.length){
                int current = grid[i+1][j];
                if(current > 0 && current == 2147483647){
                    q.offer((i+1)*100 + j);
                }
            }
            if( i > 0){
                int current = grid[i-1][j];
                if(current > 0 && current == 2147483647){
                    q.offer((i-1)*100 + j);
                }
            }
            if( j +1 < grid[0].length){
                int current = grid[i][j+1];
                if(current > 0 && current == 2147483647){
                    q.offer(i*100 + j+1);
                }
            }
            if( j > 0){
                int current = grid[i][j - 1];
                if(current > 0 && current == 2147483647){
                    q.offer(i*100 + j - 1);
                }
            }
            
        }
        
    }
}
