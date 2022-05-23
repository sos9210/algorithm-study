package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P12935 {
    public static int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(min > arr[i]) min = arr[i];
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != min) list.add(arr[i]);
        }
        if(list.size() == 0) return new int[]{-1};

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] result = solution(new int[]{2,4,3,1});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
