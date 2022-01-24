package sec05;

import java.util.Scanner;
import java.util.Stack;

public class Sec05_03 {
    public int solution(int n, int[][] wv, int move, int[] mv){
        /*  //내가푼것.
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < move; i++){
            for (int j = 0; j < n; j++) {
                if(wv[j][mv[i]-1] != 0){
                    int tmp = stack.push(wv[j][mv[i]-1]);
                    wv[j][mv[i]-1] = 0;
                    if(stack.size() > 1 && tmp == stack.get(stack.size()-2)){
                        stack.pop();
                        stack.pop();
                        answer += 2;
                    }
                    break;
                }
            }
        }

        return answer;
        */
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pos : mv){
            for (int i = 0; i < wv.length; i++) {
                if(wv[i][pos-1] != 0){
                    int tmp=wv[i][pos-1];
                    wv[i][pos-1] = 0;
                    if(!stack.isEmpty() && tmp == stack.peek()){
                        answer += 2;
                        stack.pop();
                    }else{
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] wv = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                wv[i][j] = in.nextInt();
            }
        }
        int move = in.nextInt();
        int[] mv = new int[move];
        for (int i = 0; i < move; i++) {
            mv[i] = in.nextInt();
        }
        Sec05_03 T = new Sec05_03();
        System.out.println(T.solution(n,wv,move,mv));
        return;
    }
}
