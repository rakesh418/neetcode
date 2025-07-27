package dp;

public class MaxProdSubArr {
    public static void main(String[] args) {
        int[] arr = {1,2,-3,4,-1};
        int currMax = 1;
        int currMin = 1;
        int res=Integer.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            int temp= currMax*arr[i];
            currMax = Math.max(Math.max(currMax*arr[i],currMin*arr[i]), arr[i]);
            currMin = Math.min(Math.min(temp,currMin*arr[i]), arr[i]);
            if(res<currMax){
                res=currMax;
            }
        }
        System.out.println(res);
    }
}
