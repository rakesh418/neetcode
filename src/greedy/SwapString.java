package greedy;

public class SwapString {
    public static void main(String[] args) {
       String  s1 = "bank", s2 = "kanb";
       int i=-1, j=-1, cnt=0;

       for(int k=0; k<s2.length();k++){
           if(s1.charAt(k)!=s2.charAt(k)){
               cnt++;
               if(i==-1){
                   i=k;
               }else if (j==-1){
                   j=k;
               }
           }
       }

       if(cnt==0){
           System.out.println(true);
       }else if(cnt==2 && s1.charAt(i)==s2.charAt(j) && s1.charAt(j)==s2.charAt(i)){
           System.out.println(true);
       }else{
           System.out.println(false);
       }
    }
}
