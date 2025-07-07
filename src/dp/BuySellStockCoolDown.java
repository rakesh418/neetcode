package dp;

public class BuySellStockCoolDown {

    public static void solution(int[] prices){
        System.out.println(getMaxProfit(prices,0, true));
    }

    public static int getMaxProfit(int[] prices, int i, boolean buyflag){
        int profit;
        if(i>=prices.length){
            return 0;
        }
        int cooldownProfit = getMaxProfit(prices, i+1, buyflag);
        if(buyflag){
            int buyProfit = getMaxProfit(prices, i+1, !buyflag) - prices[i];
            profit =Math.max(cooldownProfit, buyProfit);
        }else{
            int sellProfit = getMaxProfit(prices, i+2, !buyflag) + prices[i];
            profit= Math.max(sellProfit,cooldownProfit);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices={1,1,9,0,4};
        solution(prices);
    }
}
