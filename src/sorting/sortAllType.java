package sorting;

import java.util.Arrays;

public class sortAllType {

    public static void bubbleSort(int[] nums){
        for(int i=0; i<nums.length-1;i++) {
            for (int j = 0; j < nums.length-1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println("bubbleSort: " + Arrays.toString(nums));
    }

    public static void insertionSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            int key=nums[i];
            int j=i-1;
            while(j>=0 && nums[j] > key){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=key;
        }
        System.out.println("InsertionSort: " + Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(nums, low,mid);
            mergeSort(nums, mid+1,high);
            merge(nums, low, mid, high);
        }else
            return;

    }

    public static void merge(int[] nums, int low, int mid, int high){
        int[] A = new int[mid-low+1];
        int[] B = new int[high-mid];
        for(int i=0;i<A.length;i++){
            A[i]=nums[i+low];
        }
        for(int i=0;i<B.length;i++){
            B[i]=nums[i+mid+1];
        }
        int i=0, j=0;
        int k=low;
        while(i<A.length && j<B.length){
            if(A[i]<B[j]){
                nums[k]=A[i];
                i++;
            }else{
                nums[k]=B[j];
                j++;
            }
            k++;
        }
        while(i<A.length){
            nums[k]=A[i];
            i++;
            k++;
        }
        while(j<B.length){
            nums[k]=B[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
//        int[] nums={10,9,1,1,1,2,3,1};
        int[] nums={10,9,7,11,12,2,3,1};
//        bubbleSort(nums);
//        insertionSort(nums);
        mergeSort(nums, 0, nums.length-1);
        System.out.println("MergeSort: " + Arrays.toString(nums));

    }
}
