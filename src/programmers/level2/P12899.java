package programmers.level2;

public class P12899 {
    public static String solution(int n) {
        String[] num = {"4", "1", "2"};
        String answer = "";
        while (n > 0) {
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
        System.out.println(solution(8));
        System.out.println(solution(9));
        System.out.println(solution(10));
    }
}
