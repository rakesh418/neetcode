package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IslandAndTreasure {

    public static void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if(queue.size()==0) return ;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            for(int[] direction : directions){
                int r = row +direction[0];
                int c = col +direction[1];
                if(r<0 || r>=m || c<0 || c>=n || grid[r][c]!=Integer.MAX_VALUE)
                    continue;
                queue.add(new int[]{r,c});
                grid[r][c] = grid[row][col]+1;
            }
        }
        System.out.println(Arrays.deepToString(grid));
        System.out.println(Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        int[][] grid = {{2147483647,-1,0,2147483647},
            {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                    {0,-1,2147483647,2147483647}};

        islandsAndTreasure(grid);
    }
}
