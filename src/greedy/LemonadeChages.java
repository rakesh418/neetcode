package greedy;

public class LemonadeChages {
    public static void main(String[] args) {
        int[] bills = {5,10,5,5,10};
        int five=0, ten=0;
        boolean flag=true;
        for(int bill : bills){
            if(bill==5){
                five++;
            }else if(bill==10){
                ten++;
                five--;
            }else if(ten>0){
                ten--;
                five--;
            }else{
                five-=3;
            }
            if(five<0){
                flag=false;
                break;
            }
        }
        System.out.println(flag);
    }
}
