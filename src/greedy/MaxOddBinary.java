package greedy;

import java.sql.SQLOutput;

public class MaxOddBinary {
    public static void main(String[] args) {
        String input = "011010";
        char[] charList = input.toCharArray();
        int left = 0;

        for (int i=0; i<charList.length;i++){
            if(input.charAt(i)=='1'){
                char temp = charList[left];
                charList[left]=charList[i];
                charList[i]=temp;
                left++;
            }
        }
        char temp = charList[left-1];
        charList[left-1]=charList[charList.length-1];
        charList[charList.length-1]=temp;
        System.out.println(new String(charList));


        //2nd solution
        int count = 0;
        for(char ch : input.toCharArray()){
            if(ch=='1'){
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count-1;i++){
            sb.append('1');
        }
        for(int i=0; i<input.length()-count;i++){
            sb.append('0');
        }
        sb.append('1');
        System.out.println(sb.toString());
    }
}
