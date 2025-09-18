package twoPointer;

public class MaxOne {
    public static void main(String[] args) {
        String  input = "100100110001";
//        String  input = "100000111110000000";
        char[] chars = input.toCharArray();
        int l=0; int r=0;
        int sum =0;
        int maxsum=-1;
        int left=0, right=0;
        while(r<chars.length){
            if(chars[r]=='0'){
                sum++;
            }else{
                sum--;
            }
            if(sum>0){
                if(sum>maxsum) {
                    maxsum = Math.max(sum,maxsum);
                    left = l;
                    right = r;
                }
                r++;
            }else{
                sum=0;
                r++;
                l=r;
            }
        }

        System.out.println(left + ":"+ right);
    }
}
