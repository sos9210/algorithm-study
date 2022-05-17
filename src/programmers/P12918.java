package programmers;

public class P12918 {
    public static boolean solution(String s) {
        if(s.matches("[0-9]{4}") || s.matches("[0-9]{6}")){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(solution("12345"));
    }
}
