package sec07;

import java.util.Scanner;
// 재귀함수는 스택프레임에 계속 쌓여서 무겁다.. 스택오버플로우도 발생할가능성도 있음.
public class Sec07_04_required {
    static int[] fibo;
    public int DFS(int n){
        if(fibo[n] > 0) return fibo[n];
        if(n==1) return fibo[n] = 1;
        else if(n == 2){
            return fibo[n] = 1;
        }else{
            return fibo[n] = DFS(n-2)+DFS(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        fibo = new int[n+1];
        Sec07_04_required T = new Sec07_04_required();
        T.DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
