package arraysProb;

public class BestTimeBuySellStockII {
    public static void main(String[] args) {
//        int[] prices ={7,1,5,3,6,1};
        int[] prices ={1,2,3,4,5};

        int left=0, right=1;
        int sum=0;
        int res=0;
        while(right<prices.length){
            if(prices[right-1]>prices[right]){
                left=right;
                res=res+sum;
                sum=0;
            }else{
                sum=Math.max(sum,prices[right]-prices[left]);
            }
            right++;
        }
        if(left!=right){
            res=res+sum;
        }
        System.out.println(res);
    }
}
