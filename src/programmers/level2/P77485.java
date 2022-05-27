package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

public class P77485 {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        int cnt = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = cnt++;
            }
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < queries.length; i++) {
            if(i == 2){
                System.out.println();
            }
            stack.clear();
            int min = Integer.MAX_VALUE;
            int[] query = queries[i];
            //우측
            for (int j = query[1]-1; j < query[3]; j++) {
                int tmp = board[query[0]-1][j];
                if(!stack.isEmpty()) board[query[0]-1][j] = stack.pop();
                stack.push(tmp);
                min = Math.min(min,tmp);
            }
            //아래
            for (int j = query[0]; j < query[2]; j++) {
                int tmp = board[j][query[3]-1];
                if(!stack.isEmpty()) board[j][query[3]-1] = stack.pop();
                stack.push(tmp);
                min = Math.min(min,tmp);
            }
            //좌측
            for (int j = query[3]-1; j >= query[1]; j--) {
                int tmp = board[query[2]-1][j-1];
                if(!stack.isEmpty()) board[query[2]-1][j-1] = stack.pop();
                stack.push(tmp);
                min = Math.min(min,tmp);
            }
            //상단
            for (int j = query[2]-1; j >= query[0]; j--) {
                int tmp = board[j-1][query[0]-1];
                if(!stack.isEmpty()) board[j-1][query[0]-1] = stack.pop();
                stack.push(tmp);
                min = Math.min(min,tmp);
            }
            answer[i] = min;
        }
        return answer;
    }
    public static void main(String[] args) {
        //Arrays.stream(solution(6,6,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}})).forEach(v -> System.out.print(v + " "));
        Arrays.stream(solution(100,97,new int[][]{{1,1,100,97}})).forEach(v -> System.out.print(v + " "));
    }
}
