package programmers.level1;

public class P12954 {
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = answer[i-1 == -1 ? 0 : i-1] + x;
        }
        return answer;
    }
    public static void main(String[] args) {
        long[] result = solution(2,5);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
