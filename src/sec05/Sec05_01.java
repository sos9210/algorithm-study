package sec05;

import java.util.Scanner;
import java.util.Stack;

public class Sec05_01 {
    public String solution(String str){
        /* //내가푼것..
        String answer = "NO";
        int le = 0;
        int re = 0;
        for (char x: str.toCharArray()) {
            if(x == "("){
                ++le;
            }
            if(x == ")"){
                ++re;
            }
            if(re > le){
                return answer;
            }
        }
        if(le == re){
            answer = "YES";
        }
        */
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if( x == '('){
                stack.push(x);
            }else{
                if(stack.isEmpty()){
                    return "NO";
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()){
            return "NO";
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str = in.next();
        Sec05_01 T = new Sec05_01();
        System.out.println(T.solution(str));
        return ;
    }
}
