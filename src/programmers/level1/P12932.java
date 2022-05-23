package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class P12932 {
    public static int[] solution(long n) {
        List<Integer> list = new ArrayList<>();
        while(n != 0){
            list.add((int) (n % 10));
            n = n / 10;
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(12345));
    }
}
