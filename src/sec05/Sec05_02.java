package sec05;

import java.util.Scanner;
import java.util.Stack;

public class Sec05_02 {
    public String solution(String str){

        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x:str.toCharArray()) {
            if(x == ')'){
                while(stack.pop() != '(');
            }else{
                stack.push(x);
            }
        }
        for (char x: stack) {
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        Sec05_02 T = new Sec05_02();
        System.out.println(T.solution(input1));
        return ;
    }

}
