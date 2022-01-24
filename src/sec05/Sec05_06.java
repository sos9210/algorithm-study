package sec05;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sec05_06 {
    public int solution(int n, int k){
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()){
            for(int i=1; i<k; i++){
                queue.offer(queue.poll());
            }
            queue.poll();
            if(queue.size() == 1){
                answer = queue.poll();
            }
        }

        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Sec05_06 T = new Sec05_06();
        System.out.println(T.solution(n,k));
        return ;
    }
}
