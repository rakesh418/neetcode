package graph;

public class NumberOfIslands {

    public static int count(char[][] grid){
        int count=0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        return count;
    }

    public static void dfs(char[][] grid, int r, int c){
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int row = grid.length;
        int col = grid[0].length;
        if(r<0 || r>=row || c<0 || c>=col || grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        for(int[] direction : directions){
            dfs(grid, r+direction[0],c+direction[1]);
        }
    }

    public static void main(String[] args) {
        char [][] grid = {{'0','1','1','1','0'}, {'0','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
//        char [][] grid = {{'1','1','0','0','1'}, {'1','1','0','0','1'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println(count(grid));
    }
}
