package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5014_new {
    static int visit[];
    static int F,S,G,U,D;
    private static void BFS(int position){
        Queue<Integer> q = new LinkedList<>();
        q.offer(position);
        visit[position] = 1;
        while(!q.isEmpty()){
            int p = q.poll();
            if(p == G){
                System.out.println(visit[p]-1);
                System.exit(0);
            }
            if(p+U <= F && visit[p+U] == 0 ){    //p+U먼저 연산한후 visit체크하여 예외를 미리 방지
                visit[p+U] = visit[p]+1;
                q.offer(p + U);
            }
            if(p-D > 0 && visit[p-D] == 0 ){
                visit[p-D] = visit[p]+1;
                q.offer(p - D);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();
        visit = new int[F+1];
        BFS(S);
        System.out.println("use the stairs");
    }
}
