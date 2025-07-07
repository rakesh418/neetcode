package dp;

public class PalindromicSubString {
    public static void findCountBruteForce(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int l = i, r = j, k = j;
                while (l < r && s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                }
                res += (l >= r) ? 1 : 0;
                if (l >= r) {
                    System.out.println(s.substring(i, k + 1));
                }
            }
        }
        System.out.println("Response: " + res);
    }

    public static void findCountTwoPointer(String s){
        int res=0;
        for(int i=0; i<s.length();i++){
            //odd length check   aba
            int l=i, r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                res++;
            }
            //even length check abba
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                res++;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        String s = "abba";
//        findCountBruteForce(s);
        findCountTwoPointer(s);
    }
}
