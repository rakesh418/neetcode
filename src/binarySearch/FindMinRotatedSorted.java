package binarySearch;

public class FindMinRotatedSorted {
    public static void main(String[] args) {
//        int[] nums = {3,4,5,6,1,2};
//        int[] nums = {6,1,2,3,4,5};
            int[] nums = {6,1,2};
        int l = 0 , r=nums.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]>nums[r]) {
                l = mid + 1;
            }else{
                r=mid;
            }

        }
        System.out.println(nums[l]);
    }
}
