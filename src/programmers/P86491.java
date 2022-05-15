package programmers;

import java.util.Arrays;

public class P86491 {
    public static int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < sizes.length; i++) {
            maxWidth = Math.max(maxWidth,Math.max(sizes[i][0],sizes[i][1]));
            maxHeight = Math.max(maxHeight,Math.min(sizes[i][0],sizes[i][1]));
        }
        answer = maxWidth * maxHeight;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60,50},{30,70},{60,30},{80,40}}));
    }
}
