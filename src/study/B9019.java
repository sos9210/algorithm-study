package study;

import java.util.*;

class Calculator{
    int num;
    String method;
    public Calculator(int num, String method){
        this.num = num;
        this.method = method;
    }
    int D() {
        return (num * 2) % 10000;
    }

    int S() {
        return num == 0 ? 9999 : num - 1;
    }

    int L() {
        return num % 1000 * 10 + num / 1000;
    }

    int R() {
        return num % 10 * 1000 + num / 10;
    }
}
public class B9019 {
    static boolean[] visit; //방문 숫자 체크

    public void BFS(Calculator cal, int right){
        Queue<Calculator> q = new LinkedList<>();
        q.offer(cal);
        while(!q.isEmpty()){
            Calculator c = q.poll();
            if(c.num == right){     //찾으면 break
                System.out.println(c.method);
                break;
            }
            if(!visit[c.D()]){  //계산방법 사용여부가 아닌 숫자가 계산결과로 나온적있는지 여부
                q.offer(new Calculator(c.D(),c.method+"D"));
                visit[c.D()] = true;
            }
            if(!visit[c.S()]){
                q.offer(new Calculator(c.S(),c.method+"S"));
                visit[c.S()] = true;
            }
            if(!visit[c.L()]){
                q.offer(new Calculator(c.L(),c.method+"L"));
                visit[c.L()] = true;
            }
            if(!visit[c.R()]){
                q.offer(new Calculator(c.R(),c.method+"R"));
                visit[c.R()] = true;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        B9019 T = new B9019();
        for (int i = 0; i < count; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            visit = new boolean[10000];
            visit[left] = true;

            T.BFS(new Calculator(left, ""),right);
        }
    }
}
