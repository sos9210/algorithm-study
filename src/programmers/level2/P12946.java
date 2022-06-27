package programmers.level2;

import java.util.Arrays;

public class P12946 {
    public static int[][] solution(int n) {
        int[][] answer = {};
        return answer;
    }
    public static void main(String[] args) {
        Arrays.stream(solution(2)).forEach(v -> {
            Arrays.stream(v).forEach(s -> System.out.println(s+" "));
            System.out.println();
        } );
    }
}
