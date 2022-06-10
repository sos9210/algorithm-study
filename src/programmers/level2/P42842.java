package programmers.level2;

import java.util.*;

public class P42842 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int by = brown+yellow;  //총 격자의 수

        for (int i = 2; i <= by/2; i++) {
            int row = i;        //세로
            int col = by / i;   //가로

            //(가로 - 2) * (세로 - 2 ) 중앙노란색의 크기를 구한다. 테두리를 제외시키기때문에 가로세로 -2씩 빼주고 곱한다.
            if((row-2) * (col-2) == yellow){
                answer[0] = col;
                answer[1] = row;
                return answer;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        //Arrays.stream(solution(10,2)).forEach(v -> System.out.print(v +" "));
        //Arrays.stream(solution(8,1)).forEach(v -> System.out.print(v +" "));
        Arrays.stream(solution(24,24)).forEach(v -> System.out.print(v +" "));
    }
}
