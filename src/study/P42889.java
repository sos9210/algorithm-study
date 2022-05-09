package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P42889 {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] count = new int[N];
        double[] r = new double[N];
        Arrays.sort(stages);
        for (int i = 0; i < stages.length-1; i++) {
            count[stages[i]-1] = count[stages[i]-1]+1;
        }
        int total=stages.length;

        for (int i = 0; i < N; i++) {
            r[i] = (double) count[i] / total;
            total -= count[i];
        }
        
        return answer;
    }
    public static void main(String[] args) {
        int[] result = solution(5,new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
