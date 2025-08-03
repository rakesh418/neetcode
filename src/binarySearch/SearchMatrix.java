package binarySearch;

public class SearchMatrix {
    public static boolean searchStairCase(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        int r=0, c=col-1;
        while(r<row && c>=0){
            if(matrix[r][c] == target){
                return true;
            }
            else if(matrix[r][c] < target){
                r++;
            }else{
                c--;
            }
        }
        return false;
    }

    public static boolean searchBinaray(int[][] matrix, int target){
        int top=0, bot = matrix.length-1;
        while(top<=bot){
            int row = (top+bot)/2;
            if(target<matrix[row][0]){
                bot=row-1;
            }else if (target >matrix[row][matrix[0].length-1]) {
                top=row+1;
            }else{
                break;
            }
        }
        System.out.println(top);
        System.out.println(bot);
        int l =0 , r=matrix[0].length-1;
        int row = (top+bot)/2;
        while(l<=r){
            int m = (l+r)/2;
            if(target==matrix[row][m]){
                return true;
            }else if (target< matrix[row][m]){
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
        int target =10;
        System.out.println(searchStairCase(matrix, target));
        System.out.println(searchBinaray(matrix, target));
    }
}
