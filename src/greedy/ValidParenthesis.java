package greedy;

public class ValidParenthesis {

    public static void main(String[] args) {
//        checkValidString("((*)");
        checkValidString("**()");
    }

    private static void checkValidString(String input) {
        boolean isValid =dfs(0,0,input);
        System.out.println(isValid);
    }

    private static boolean dfs(int i, int open, String input){
        if(i==input.length())
            return open==0;
        if(open<0)
            return false;
        if(input.charAt(i)=='('){
            return dfs(i+1, open+1,input);
        }else if(input.charAt(i)==')'){
            return dfs(i+1, open-1,input);
        }else{
            return dfs(i+1, open+1,input) ||
                    dfs(i+1, open-1,input)||
                    dfs(i+1, open,input);
        }
    }
}
