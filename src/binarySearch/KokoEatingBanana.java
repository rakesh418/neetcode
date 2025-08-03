package binarySearch;

import java.util.Arrays;

public class KokoEatingBanana {
    public static int minEatingSpeed(int[] piles, int hours ){
        int speed = 1;
        while(true) {
            int time=0;
            for (int num : piles) {
                time +=(int)Math.ceil((double)num/speed);
            }
            if(time>hours){
                speed++;
            }else{
                return speed;
            }
        }
    }

    public static int minEatingSpeedBinary(int[] piles, int hours) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while (l<=r) {
            int m = (l+r)/2;
            long totalTime = 0;
            for (int pile : piles) {
                totalTime += (int) Math.ceil((double) pile / m);
            }
            if (totalTime <= hours) {
                res=m;
                r=m-1;
            }else{
                l=m+1;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int [] piles = {6,4,3,2};
        System.out.println(minEatingSpeed(piles, 5));
        System.out.println(minEatingSpeedBinary(piles, 5));
    }
}
