package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Calculator1{
    int left;
    String way;
    public Calculator1(int left, String way){
        this.left= left;
        this.way = way;
    }

    public int D(){
        return left*2 > 9999 ? (left*2)%10000 : left*2;
    }
    public int S(){
        return left == 0 ? 9999 : left-1;
    }
    public int L(){
        return left % 1000 * 10 + left / 1000;
    }
    public int R(){
        return left % 10 * 1000 + left / 10;
    }
}
public class B9019_new {
    private static boolean[] visit;
    private static int left,right;
    public static void BFS(int left){
        Queue<Calculator1> cal = new LinkedList<>();
        cal.offer(new Calculator1(left,""));
        while(!cal.isEmpty()){
            Calculator1 c = cal.poll();
            if(c.left == right){
                System.out.println(c.way);
                break;
            }
            if(!visit[c.D()]){
                cal.offer(new Calculator1(c.D(),c.way+"D"));
                visit[c.D()] = true;
            }
            if(!visit[c.S()]){
                cal.offer(new Calculator1(c.S(),c.way+"S"));
                visit[c.S()] = true;
            }
            if(!visit[c.L()]){
                cal.offer(new Calculator1(c.L(),c.way+"L"));
                visit[c.L()] = true;
            }
            if(!visit[c.R()]){
                cal.offer(new Calculator1(c.R(),c.way+"R"));
                visit[c.R()] = true;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            visit = new boolean[10000];
            left = sc.nextInt();
            right = sc.nextInt();
            visit[left] = true;
            BFS(left);
        }
    }
}
