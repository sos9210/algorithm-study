package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list= new ArrayList<>();
        int[] check = new int[progresses.length];
        int i = 0;
        int count = 0;
        while (i < progresses.length) {
            progresses[i] += speeds[i];
            ++count;
            if(progresses[i] >= 100){
                check[i] = count;
                count = 0;
                ++i;
            }
        }
        int j = 0;
        while (j < check.length) {
            j++;
            int functionCount = 1;
            int front = check[j-1];
            while(j < check.length && front > check[j]){  //현재기능보다 뒤에기능이 더 빨리 끝났다면?
                functionCount++;
                j++;
            }
            list.add(functionCount);
        }
        int[] answer = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            answer[k] = list.get(k);
        }
        return answer;
    }
    public static void main(String[] args) {
       // Arrays.stream(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})).forEach( v -> System.out.print(v + " "));
       Arrays.stream(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})).forEach( v -> System.out.print(v + " "));
    }
}
