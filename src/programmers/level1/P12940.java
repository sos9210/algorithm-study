package programmers.level1;

import java.util.Arrays;

public class P12940 {
    //https://jisunshine.tistory.com/134
    public static int[] solution(int n, int m) {
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        while (min != 0) {
            int tmp = max % min;
            max = min;
            min = tmp;
        }
        // 최대 공배수 = 두 수의 곱 / 최대공약수
        return new int[] {max,n * m / max };//최대공약수, 최소공배수
    }
    public static void main(String[] args) {
        Arrays.stream(solution(3,5)).forEach(v -> System.out.print(v+" "));
    }
}
