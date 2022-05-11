package study;

import java.util.Arrays;

public class P12982 {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        int i=0;
        //부서의 길이(d.length)와 카운트(answer)가 같으면 false (같은경우는 모든 부서에 예산지원이 가능한경우)
        //현재까지 합한 신청금액과 다음 부서의 신청금액을 더한 금액보다 예산이 더 많아야 실행한다.
        while (answer != d.length&& i + d[answer] <= budget) {
            i = i + d[answer];
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1,3,2,5,4}, 9));
        System.out.println(solution(new int[]{2,2,3,3}, 10));
    }
}
