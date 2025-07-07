package dp;

public class UniquePaths {

    public static int findUniquePath(int m, int n){
        return dfs(0,0,m,n);
    }

    public static int dfs(int i,int j,int m, int n){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        return dfs(i+1,j,m,n)+dfs(i,j+1,m,n);
    }

    public static void main(String[] args) {
        System.out.println(findUniquePath(3,3));
    }
}
