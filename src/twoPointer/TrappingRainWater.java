package twoPointer;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,2,0,3,1,0,1,3,2,1};

        int l =0, r=height.length-1;
        int leftMax = height[l];
        int rightMax = height[r];
        int res=0;
        while(l<r){
            if(leftMax<rightMax){
                l++;
                leftMax=Math.max(leftMax,height[l]);
                res+=leftMax-height[l];
            }else{
                r--;
                rightMax=Math.max(rightMax,height[r]);
                res+=rightMax-height[r];
            }
        }
        System.out.println(res);
    }
}
