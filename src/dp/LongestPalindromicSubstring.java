package dp;

public class LongestPalindromicSubstring {

    public static void findCountBruteForce(String s){
        int resLength=0;
        for(int i=0; i<s.length();i++){
            for(int j=i;j<s.length();j++){
                int l=i, r=j;
                while(l<r && s.charAt(l)==s.charAt(r)){
                    l++;
                    r--;
                }
                if(l>=r && resLength<(j-i+1)) {
                    resLength = j-i+1;
                }
            }
        }
        System.out.println(resLength);
    }

    public static void findCountTwoPointer(String s){
        int resLength=0;
        int resIdx=0;
        for(int i=0; i<s.length();i++){
            //odd length check   aba
            int l=i, r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(resLength<(r-l+1)){
                    resLength=r-l+1;
                    resIdx=l;
                }
                l--;
                r++;
            }
            //even length check abba
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(resLength<(r-l+1)){
                    resLength=r-l+1;
                    resIdx=l;
                }
                l--;
                r++;
            }
        }
        System.out.println(s.substring(resIdx,resIdx+resLength));
    }

    public static void main(String[] args) {
        String s = "abbaabbaba";
//        findCountBruteForce(s);
        findCountTwoPointer(s);
    }
}
