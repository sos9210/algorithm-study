package programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P42626 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        //PriorityQueue 사용하여 자동정렬
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            q.offer(scoville[i]);
        }
        //큐의 사이즈가 1보다 크고 다음 큐가 K보다 작을경우 반복실행
        while(q.size() > 1 && q.peek() < K){
            int min1 = q.poll();
            int min2 = q.poll();
            int scov = min1 + (min2 * 2);
            q.offer(scov);
            answer++;   //횟수증가
        }
        //최종스코빌지수가 K보다 작으면 return -1
        if(q.peek() < K) return -1;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2},5));
    }
}
