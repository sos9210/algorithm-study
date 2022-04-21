package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B12851_new {
    static int N,K,count, min = Integer.MAX_VALUE;
    static int[] time = new int[100001];
    private static void BFS() {
        time[N] = 1;
        Queue<Integer> q =new LinkedList<>();
        q.offer(N);
        while(!q.isEmpty()){
            int position = q.poll();
            if(time[position] > min) return;    //현재걸린시간이 minTime보다 크면 종료시킨다
            for (int i = 0; i < 3; i++) {
                int nextPosition = 0;
                if(i == 0)  nextPosition = position+1;
                if(i == 1)  nextPosition = position-1;
                if(i == 2)  nextPosition = position*2;
                if(nextPosition < 0 || nextPosition > 100000) continue;

                if(nextPosition == K){
                    min = time[position];
                    ++count;
                }
                if(time[nextPosition] == 0 || time[nextPosition] == time[position] + 1){
                    q.offer(nextPosition);
                    time[nextPosition] = time[position] + 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        if(N == K){
            System.out.println(0);
            System.out.println(1);
            System.exit(0);
        }
        BFS();
        System.out.println(min);
        System.out.println(count);
    }
}
