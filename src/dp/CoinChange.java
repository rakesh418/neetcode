package dp;

public class CoinChange {
    public static void solution(int[] coins, int target){
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
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] coins={1,5,10};
        int target = 17;
        solution(coins, target );
    }
}
