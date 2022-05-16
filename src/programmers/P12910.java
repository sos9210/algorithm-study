package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P12910 {
    public static int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0){
                list.add(arr[i]);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        if(answer.length == 0){
            return new int[]{-1};
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        for (int i:solution(new int[]{5, 9, 7, 10},5)) {
            System.out.println(i + " ");
        }
    }
}
