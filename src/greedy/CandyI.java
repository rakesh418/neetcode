package greedy;

import java.util.Arrays;

public class CandyI {
    public static void main(String[] args) {
//        int[] rating = {4,3,5,6,5};
        int[] rating = {1,2,3,4,5,1,4,3,2,1};
        int[] candy = new int[rating.length];
        Arrays.fill(candy,1);
        for(int i=0;i<rating.length-1;i++){
            if(rating[i]<rating[i+1]){
                candy[i+1]=candy[i]+1;
            }
        }

        for(int i = rating.length-2; i>=0;i--){
            if(rating[i]>rating[i+1]){
                candy[i]= Math.max(candy[i+1]+1, candy[i]);
            }
        }
        System.out.println(Arrays.toString(candy));
    }
}
