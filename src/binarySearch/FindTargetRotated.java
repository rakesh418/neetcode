package binarySearch;

public class FindTargetRotated {
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,1,2};
        int[] arr1 = {1,2,3,4,5,6};
        int l=0, r = arr.length-1;
        int target = 9;
        boolean flag = false;
        while(l<r){
            int m = (l+r)/2;
            if(arr[m]==target) {
                flag = true;
                break;
            }else if(arr[m]<arr[r]){
                 if(target<arr[r]){
                     l=m+1;
                 }else{
                     r=m-1;
                 }
            }else{
                if(target<arr[r]){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
        }
        System.out.println(flag);
    }
}
