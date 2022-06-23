package programmers.level2;

//올바른 괄호
//보통 괄호문제는 Stack을 쓴다.
public class P12909 {
    public static boolean solution(String s) {
        boolean answer = true;
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                open++;
            }else if(s.charAt(i) == ')'){
                close++;
            }
            //열린 괄호가 닫는 괄호보다 많아지는 순간 틀린 괄호가 된다.
            if(open < close){
                answer = false;
                break;
            }
        }
        //열린괄호와 닫는괄호 개수가 같지않으면 틀린 괄호 이므로 false
        if(open != close) answer = false;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
}
