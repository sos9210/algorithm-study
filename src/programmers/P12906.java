package programmers;


import java.util.ArrayList;
import java.util.List;

public class P12906 {
    public static int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if((i > 0 && arr[i] != arr[i-1]) || i == 0) list.add(arr[i]);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        for (int a:solution(new int[]{1,1,3,3,0,1,1})) {
            System.out.print(a+" ");
        }
    }
}
