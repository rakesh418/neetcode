package dp;

public class MinCostStairs {
    public static void calculateMinCost(int[] cost){
        System.out.println(Math.min(minCost(0,cost), minCost(1,cost)));
    }

    public static int minCost(int index,int[] cost){
        if(index>=cost.length){
            return 0;
        }
        return cost[index]+ Math.min(minCost(index+1, cost), minCost(index+2, cost));
    }

    public static void main(String[] args) {
        int[] cost ={1,2,3};
        calculateMinCost(cost);
    }
}
