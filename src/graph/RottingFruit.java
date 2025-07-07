package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingFruit {

    public static void findTimeinMinutes(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> rottingQueue = new LinkedList<>();
        for(int i=0; i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rottingQueue.add(new int[]{i, j});
                }
            }
        }
        int min=0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int size=rottingQueue.size();
        while(!rottingQueue.isEmpty()){
            if(size==0){
                min++;
                size=rottingQueue.size();
            }
            int[] node = rottingQueue.poll();
            int row = node[0];
            int col = node[1];
            for(int[] direction : directions) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 1)
                    continue;
                grid[r][c] =2;
                rottingQueue.offer(new int[]{r,c});
            }
            size--;
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
//        int[][] grid = {{1,1,0},{0,1,1},{0,1,2}};
        int[][] grid = {{1,0,1},{0,2,0},{1,0,1}};
        findTimeinMinutes(grid);
    }
}
