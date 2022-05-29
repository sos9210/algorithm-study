package programmers.level2;

import java.util.Stack;

public class P60058 {
    static int position;
    public static String solution(String p) {
        if(p.isEmpty()) return p;
        boolean correct = isCorrect(p);

        String u = p.substring(0,position);
        String v = p.substring(position);

        if(correct){    //u가 올바른 괄호 문자열이면 true 아니면 false
            return u + solution(v);
        }

        String answer = "(" + solution(v) + ")";
        for (int i = 1; i < u.length()-1; i++) {
            if(u.charAt(i) == '('){
                answer += ")";
            }else{
                answer += "(";
            }
        }
        return answer;
    }

    //올바른 괄호 문자열인가?
    public static boolean isCorrect(String str){
        boolean ret = true;
        int left = 0, right = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '('){//열린괄호인경우
                left++;
                stack.push('(');
            }else{                   //닫힌괄호인경우
                right++;
                if(stack.isEmpty()){ //stack이 비어있는가?
                    ret = false;    //열린괄호인데 stack이 비어있으면 짝이 안맞으므로 false
                }else{
                    stack.pop();    //열린괄호인데 stack이 비어있지 않으면 pop()
                }
            }
            if(left == right){      //열린괄호와 닫힌괄호 개수가 같다면?(균형잡힌 괄호 문자열)
                position = i+1;     //균형잡힌 괄호 문자열의 위치를 체크한다.
                return ret;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }
}
