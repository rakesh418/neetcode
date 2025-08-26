package greedy;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
//        int[] rating = {4,3,5};
        int[] rating = {1,2,5,4};

        int[] res = new int[rating.length];
        Arrays.fill(res,1);

        for(int i=1; i<rating.length; i++){
            if(rating[i-1]<rating[i]){
                res[i]=res[i-1]+1;
            }
        }

        for(int i=rating.length-2; i>=0; i--){
            if(rating[i]>rating[i+1]){
                res[i]=Math.max(res[i], res[i+1]+1);
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
