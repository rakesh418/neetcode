package graph;

public class MaxAreaOfIslands {

    public static int count(char[][] grid){
        int area=0; int maxArea=0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++){
                if(grid[i][j]=='1'){
                    area = dfs(grid,i,j);
                    maxArea= Math.max(maxArea,area);
                }
            }
        return maxArea;
    }

    public static int dfs(char[][] grid, int r, int c){
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int row = grid.length;
        int col = grid[0].length;
        if(r<0 || r>=row || c<0 || c>=col || grid[r][c]=='0'){
            return 0;
        }
        grid[r][c]='0';
        int area=1;
        for(int[] direction : directions){
            area= area+ dfs(grid, r+direction[0],c+direction[1]);
        }
        return area;
    }

    public static void main(String[] args) {
        char [][] grid = {{'0','1','0','1','0'}, {'0','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
//        char [][] grid = {{'1','1','0','0','1'}, {'1','1','0','0','1'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println(count(grid));
    }
}
