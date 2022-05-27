package programmers.level2;


import java.util.*;

public class P12973 {
    public static int solution(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray())
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);

        return stack.isEmpty() ? 1 : 0;
    }
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
        System.out.println(solution("cdcddd"));
    }
}
