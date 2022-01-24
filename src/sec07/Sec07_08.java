package sec07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sec07_08 {
    public int solution(int s, int e){
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        while(!queue.isEmpty()){

        }


        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();
        Sec07_08 T = new Sec07_08();
        System.out.println(T.solution(s,e));
        return ;
    }
}
