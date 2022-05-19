package programmers;

public class P12931 {
    public static int solution(int n) {
        int answer = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            answer += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return answer;
        /*  // 이게 더 좋은방법이다.
        int answer = 0;

        while (n != 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
         */
    }
    public static void main(String[] args) {
        System.out.println(solution(123));
    }
}
