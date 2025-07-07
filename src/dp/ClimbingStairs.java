package dp;

public class ClimbingStairs {
    public static void  climbStairs(int n ){
        System.out.println(dfs(n));
    }

    public static int dfs(int n){
        if(n<=2)
            return n<=0?0:n;
        return dfs(n-1)+dfs(n-2);
    }

    public static void main(String[] args) {
        climbStairs(5);
    }
}
