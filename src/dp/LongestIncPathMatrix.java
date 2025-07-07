package dp;

public class LongestIncPathMatrix {

    public static void solution(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int LIS=0;
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++){
                LIS = Math.max(LIS, dfs(matrix, i,j, Integer.MIN_VALUE));
            }
        System.out.println(LIS);
    }

    public static int dfs(int[][] matrix, int r, int c, int prevValue){
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int ROW = matrix.length;
        int COL = matrix[0].length;
        if(r<0 || r>=ROW || c>= COL || c<0 || matrix[r][c]<=prevValue)
            return 0;
        int LIS =1;
        for(int[] dir: directions){
            LIS = Math.max(LIS, 1+dfs(matrix, r+dir[0],c+dir[1], matrix[r][c]));
        }
        return LIS;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {2,1,4},{7,6,5}};
        solution(matrix);
    }
}
