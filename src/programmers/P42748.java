package programmers;

import java.util.Arrays;

public class P42748 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] com = commands[i];
            int[] slice = Arrays.copyOfRange(array, com[0]-1, com[1]);
            Arrays.sort(slice);
            answer[i] = slice[com[2]-1];
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
