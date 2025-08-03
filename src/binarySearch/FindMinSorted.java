package binarySearch;

public class FindMinSorted {
    public static void main(String[] args) {
//        int[] arr  = {3,4,5,6,1,2};
//        int[] arr  = {3,4,5,6,1,2};
        int[] arr  = {6,7,2,3,4,5};
        int l = 0, r = arr.length-1;
        while(l<r){
            int m = (l+r)/2;
            if(arr[m]<arr[r]){
                r=m;
            }else{
                l=m+1;
            }
        }
        System.out.println(arr[l]);
    }
}
