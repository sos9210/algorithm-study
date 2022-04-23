/*package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Subin1 {
    String str;
    int position;
    public Subin1(int position, String str){
        this.position = position;
        this.str = str;
    }

}
public class B13913 {
    static int N,K, min = Integer.MAX_VALUE;
    static String way;
    static int[] time = new int[100001];
    //static StringBuilder result = new StringBuilder();
    static Stack<String> stack = new Stack<>();
    private static void BFS() {
        time[N] = 1;
        Queue<Subin1> q = new LinkedList<>();
        q.offer(new Subin1(N,N+" "));
        while (!q.isEmpty()){
            Subin1 subin = q.poll();
            int position = subin.position;

            if(time[position] > min) return;

            for (int i = 0; i < 3; i++) {
                int nextPosition = 0;
                if(i == 0) nextPosition = position + 1;
                if(i == 1) nextPosition = position - 1;
                if(i == 2) nextPosition = position * 2;

                if(nextPosition < 0 || nextPosition > 100000) continue;
                if(nextPosition == K){
                    min = time[position];
                    way = subin.str+nextPosition;
                    return;
                }

                if(time[nextPosition] == 0 || time[nextPosition] == time[position] + 1){
                    q.offer(new Subin1(nextPosition,  subin.str+nextPosition+" "));
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
            System.out.println(N);
            System.exit(0);
        }
        BFS();
        System.out.println(min);
        System.out.print(way);
    }
}*/
package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Subin1 {
    int position;
    public Subin1(int position){
        this.position = position;
    }

}
public class B13913 {
    static int N,K, min = Integer.MAX_VALUE;
    static int[] time = new int[100001];
    static int[] way = new int[100001];
    static Stack<Integer> stack = new Stack<>();
    private static void BFS() {
        time[N] = 1;
        Queue<Subin1> q = new LinkedList<>();
        q.offer(new Subin1(N));
        stack.push(K);
        while (!q.isEmpty()){
            Subin1 subin = q.poll();
            int position = subin.position;

            if(time[position] > min) return;

            for (int i = 0; i < 3; i++) {
                int nextPosition = 0;
                if(i == 0) nextPosition = position + 1;
                if(i == 1) nextPosition = position - 1;
                if(i == 2) nextPosition = position * 2;

                if(nextPosition < 0 || nextPosition > 100000) continue;
                if(nextPosition == K){
                    min = time[position];
                    while(position!=N){
                        stack.push(position);
                        position = way[position];
                    }
                    stack.push(N);
                    return;
                }

                if(time[nextPosition] == 0 || time[nextPosition] == time[position] + 1){
                    q.offer(new Subin1(nextPosition));
                    time[nextPosition] = time[position] + 1;
                    way[nextPosition] = position;
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
            System.out.println(N);
            System.exit(0);
        }
        BFS();
        System.out.println(min);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
