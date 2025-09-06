package arraysProb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ValidSudoku {

    public static boolean isValid(char[][] board){
        boolean isValid = true;

        Map<String, HashSet<Character>> map = new HashMap<>();
        for(int i=0; i <board.length;i++){
            for(int j=0; j <board[0].length;j++){
                if(board[i][j]!='.'){
                    String row = "r"+i;
                    String col = "c"+j;
                    String box = "b"+i/3+j/3;
                    map.putIfAbsent(row,new HashSet<>());
                    map.putIfAbsent(col,new HashSet<>());
                    map.putIfAbsent(box,new HashSet<>());
                    if(map.get(row).contains(board[i][j]) ||
                            map.get(col).contains(board[i][j]) ||
                                    map.get(box).contains(board[i][j])){
                                return false;
                    }else{
                        map.get(row).add(board[i][j]);
                        map.get(col).add(board[i][j]);
                        map.get(box).add(board[i][j]);
                    }
                }
            }
        }

        return isValid;
    }

    public static void main(String[] args) {
        char[][] board = {{'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','8','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValid(board));
    }
}
