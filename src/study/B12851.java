package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Subin {
    int position;
    public Subin (int position) {
        this.position = position;
    }
}
public class B12851 {
    static int N,K,count,minTime = Integer.MAX_VALUE;
    static int[] time = new int[100001];
    public static void BFS(Subin subin) {
        Queue<Subin> q = new LinkedList<>();
        time[N] = 1;
        q.offer(subin);
        while (!q.isEmpty()){
            Subin s = q.poll();
            if(time[s.position] > minTime) return;    //현재걸린시간이 minTime보다 크면 종료시킨다

            for (int i = 0; i < 3; i++) {
                int position;
                if (i == 0)         position = s.position + 1;
                else if (i == 1)    position = s.position - 1;
                else                position = s.position * 2;
                if (position < 0 || position > 100000) continue;

                if(position == K){
                    minTime = time[s.position];
                    count++;
                }
                //다음 위치는 방문한적 없거나 다음 위치는 현재위치 +1일때
                if(time[position] == 0 || time[position] == time[s.position] + 1){
                    q.offer(new Subin(position));
                    time[position] = time[s.position] + 1;
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
        BFS(new Subin(N));
        System.out.println(minTime);
        System.out.println(count);
    }
}
