package sec05;

import java.util.Scanner;
import java.util.Stack;

public class Sec05_05 {
    public int solution(String str){
        int answer=0;

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }else if(str.charAt(i-1) == '(' && str.charAt(i) == ')'){
                stack.pop();
                answer += stack.size();
            }else{
                stack.pop();
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.next();
        Sec05_05 T = new Sec05_05();
        System.out.println(T.solution(str));
        return ;
    }
}
