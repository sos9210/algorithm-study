package programmers.level2;

import java.util.Arrays;

public class P81302 {
    public static int[] solution(String[][] places) {
        int[] answer = {};

        return answer;
    }
    public static void main(String[] args) {
        Arrays.stream(solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        })).forEach(v -> System.out.print(v +" "));
    }
}
