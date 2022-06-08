package programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//괄호 회전하기
public class P76502 {
    static int count = 0;
//    static char[] left = {'{','[','(',};
//    static char[] right = {'}',']',')'};
    public static int solution(String s) {
        int answer = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            correct(s);
            s = s.substring(1)+s.substring(0,1);
        }
        return count;
    }
    public static void correct(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()) {
                stack.push(c);
            }else {
                //문자열의 현재 인덱스가 닫힌 괄호인지 체크
                if(c == ']'){   //문자열의 현재 인덱스가 해당하는 닫힌 괄호인 경우
                    if(stack.peek() == '['){    //다음 스택 순서와 짝이 맞으면 pop(), 아니면 push한다.
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }else if(c == ')'){
                    if(stack.peek() == '('){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }else if(c == '}'){
                    if(stack.peek() == '{'){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }else{  //열린 괄호면 push한다.
                    stack.push(c);
                }
/*  //더 짧지만 가독성떨어져서 주석처리
                int cnt = 0;
                for (int j = 0; j < 3; j++) {
                    if(c != right[j]) continue;
                    if (stack.peek() == left[j]) {
                        stack.pop();
                        ++cnt;
                    }else{
                        stack.push(c);
                    }
                }
                if (cnt == 0) stack.push(c);
*/
            }
        }
        //스택이 비어있으면 count를 올린다.
        if(stack.isEmpty()) ++count;
    }
    public static void main(String[] args) {
        System.out.println(solution("[](){}")); //3
        //System.out.println(solution("[[{{((}}]]))"));
    }
}
