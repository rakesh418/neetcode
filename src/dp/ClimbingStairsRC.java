package dp;

public class ClimbingStairsRC {
    public static int findNoOfSteps(int n){
        return dfs(0, n);
    }

    public static int dfs(int i, int n){
        if(i==n){
            return 1;
        }
        if(i>n){
            return 0;
        }
        return dfs(i+1,n)+dfs(i+2,n);
    }

    public static void main(String[] args) {
        System.out.println(findNoOfSteps(4));
    }
}
