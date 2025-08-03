package dp;

public class CoinChange {
    public static void wrongSolution(int[] coins, int target){
        int count=0;
        for(int i= coins.length-1;i>=0;i--){
            while(target>= coins[i]){
                target=target-coins[i];
                count++;
            }
            if(target==0){
                break;
            }
        }
        System.out.println(target==0?count:-1);
    }

    public static void rightSolution(int[] coins, int target){
        int res = dfs(coins,target);
        System.out.println(res);
    }

    public static int dfs(int[] coins, int target){
        if(target==0){
            return 0;
        }
        int res =  (int)1e9;
        for(int num: coins){
            if(target>=num){
                res = Math.min(res, 1+dfs(coins,target-num));
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] coins={1,5,10};
//        int target = 17;
        int[] coins={2,3,4,15};
        int target = 20;

        wrongSolution(coins, target );
        rightSolution(coins, target );

    }
}
