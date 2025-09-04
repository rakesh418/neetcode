package greedy;

public class BuyTwoChocolate {
    public static void main(String[] args) {
        int[] prices = {1,1,2};
//        int[] prices = {2,5,0,7,1};
        int money =7;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int p: prices){
            if(p<min1) {
                min2= min1;
                min1 = p;
            }else if(p<min2){
                min2=p;
            }
        }
        System.out.println(money-(min1+min2));
    }
}
