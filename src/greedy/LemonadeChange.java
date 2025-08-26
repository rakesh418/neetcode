package greedy;

public class LemonadeChange {

    public static boolean isChangePossible(int[] bills){
        int five=0, ten=0;
        for(int bill : bills){
            if(bill==5){
                five++;
            }else if(bill==10){
                if(five>0){
                    ten++;
                    five--;
                }else{
                    return false;
                }
            }else{
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }else if(five>2) {
                    five=five-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bill = {5,10,5,5,20};
        System.out.println(isChangePossible(bill));
    }
}
