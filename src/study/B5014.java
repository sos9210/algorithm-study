package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5014 {
    static int end,Uplus,Dminus,top;
    static int[] visit;
    private static void BFS(int position){
        visit[position] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(position);
        while(!q.isEmpty()){
            int p = q.poll();
            if(p == end){
                System.out.println(visit[p]-1);
                System.exit(0);
            }
            if(p+Uplus <= top && visit[p+Uplus] == 0){
                visit[p+Uplus] = visit[p]+1;
                q.offer(p+Uplus);
            }
            if(p-Dminus >= 1 && visit[p-Dminus] == 0){
                visit[p-Dminus] = visit[p]+1;
                q.offer(p-Dminus);
            }
        }
        System.out.println("use the stairs");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int position = 0;
        for (int i = 0; i < 5; i++) {
            int a =sc.nextInt();
            if(i == 0){
                top = a;
            }
            if(i == 1){
                position = a;
            }
            if(i == 2){
                end = a;
                visit = new int[top+1];
            }
            if(i == 3){
                Uplus=a;
            }
            if(i == 4){
                Dminus=a;
            }
        }
        BFS(position);
    }
}
