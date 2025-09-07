package slidingWindow;

public class MinSizeSum {
    public static void main(String[] args) {
        int[] nums={2,1,5,1,5,3};
        int target =10;
        int l=0;
        int r=0;
        int minLength =Integer.MAX_VALUE;
        int sum = 0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>=target){
                minLength=Math.min(minLength,r-l+1);
                System.out.println(l+":"+r);
                sum-=nums[l];
                l++;
            }
            r++;
        }
        System.out.println(minLength);
    }
}
