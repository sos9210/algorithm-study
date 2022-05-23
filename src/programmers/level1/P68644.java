package programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P68644 {
    public static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }
        Integer[] toArray = set.toArray(new Integer[0]);
        int[] answer = new int[toArray.length];
        for (int i = 0; i < toArray.length; i++) {
            answer[i] = toArray[i];
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        int[] result = solution(new int[]{2,1,3,4,1});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
