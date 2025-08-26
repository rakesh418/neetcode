package greedy;

public class GasStation {
    public static void main(String[] args) {
        int[] gas={1,2,3,4};
        int[] cost={2,2,4,1};

        int total =0;
        int index=0;
        for(int i=0; i<gas.length; i++){
            total += gas[i]-cost[i];
            if(total<0){
                total =0;
                index=i+1;
            }
        }
        System.out.println(index);
    }
}
