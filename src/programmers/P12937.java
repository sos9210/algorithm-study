package programmers;

public class P12937 {
    public static String solution(int num) {
        if(num == 0 || num % 2 == 0){
            return "Even";
        }
        return "Odd";
    }
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }
}
