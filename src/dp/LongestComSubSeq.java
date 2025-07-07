package dp;

public class LongestComSubSeq {

    public static void solution(String text1,String text2){
        int length = findCommonSeq(text1,text2,0,0);
        System.out.println("length: "+length);
    }

    public static int findCommonSeq(String text1, String text2, int i, int j){
        if(i>=text1.length() || j>= text2.length())
            return 0;
        if(i<text1.length() && j<text2.length() && text1.charAt(i)==text2.charAt(j)){
            return 1 + findCommonSeq(text1,text2,i+1,j+1);
        }

        return  Math.max(findCommonSeq(text1,text2,i+1,j), findCommonSeq(text1,text2,i,j+1));

    }

    public static void main(String[] args) {
        String text1 = "cabt", text2 = "crabt";
        solution(text1,text2);
    }
}
