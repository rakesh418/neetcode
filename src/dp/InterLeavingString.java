package dp;

public class InterLeavingString {

    public static boolean solution(String s1,String s2, String s3){
        if(s3.length()!=s1.length()+s2.length())
            return false;
        return interleaving(s1,s2,s3,0,0,0);
    }

    public static boolean interleaving(String s1, String s2, String s3, int i,int j, int k){
        if(s1.length()==i && s2.length()==j && s3.length()==k)
            return true;
        if(s1.charAt(i)==s3.charAt(k)){
            return interleaving(s1,s2,s3,i+1,j,k+1);
        }else if (s2.charAt(i)==s3.charAt(k)){
            return interleaving(s1,s2,s3,i,j+1,k+1);
        }else {
            return false;
        }


    }

    public static void main(String[] args) {
        String s1 = "aaaaa" ,  s2 = "bbbbb", s3 = "abaaabbbba";
        System.out.println(solution(s1,s2,s3));
    }
}
