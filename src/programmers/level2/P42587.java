package programmers.level2;

import java.util.*;

public class P42587 {
    public static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            q.offer(priorities[i]);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == q.peek()) {
                    answer++;
                    if (i == location) {
                        return answer;
                    }
                    q.poll();
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //System.out.println(solution(new int[]{2, 1, 3, 2},2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1},0));
    }
}
