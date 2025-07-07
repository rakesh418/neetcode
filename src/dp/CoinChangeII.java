package dp;

import java.util.Arrays;

public class CoinChangeII {

    public static void solution(int[] coins, int amount){
        Arrays.sort(coins);
        System.out.println(dfs(coins, 0, amount));
    }

    public static int dfs(int[] coins, int index, int amount){
        if(amount==0){
            return 1;
        }
        if(index>= coins.length){
            return 0;
        }
        int res =0;
        if(amount>=coins[index]){
            res = dfs(coins, index, amount-coins[index]);
            res+= dfs(coins, index+1, amount);
        }
        return res;
    }

    public static void main(String[] args) {
        int amount = 6;
        int[] coins = {1,2,3};
        solution(coins,amount);
    }
}
