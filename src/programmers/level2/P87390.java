package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//n^2배열 자르기
public class P87390 {
    //Max(행,열) 의 idx값이 그 자리의 값
    //우리가 뽑고싶은 숫자가 Left~Right 범위의 숫자니 Left에서 Right까지 순회하면서 Max(행,열)을 반환
    public static int[] solution(int n, long left, long right) {
        List<Long> list = new ArrayList<>();

        for(long i=left;i<right+1;i++){
            list.add(Math.max(i/n,i%n) + 1);
        }
        Long[] arr = list.toArray(new Long[0]);
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i].intValue();
        }
        return answer;
    }
    public static void main(String[] args) {
        Arrays.stream(solution(3, 2, 5)).forEach(v -> System.out.print(v+" "));
        System.out.println();
        Arrays.stream(solution(4, 7, 14)).forEach(v -> System.out.print(v+" "));
    }
}
