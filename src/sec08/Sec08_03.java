package sec08;

import java.util.Scanner;

public class Sec08_03 {
    static int n,m,L,answer = Integer.MIN_VALUE;
    static int[][] arr;
    public void DFS(int L, int t, int sum ,int[][] arr) {
        if(t > m){
            return ;
        }
        if(L == n){
            answer = Math.max(answer, sum);
        }else{
            DFS(L+1,t+arr[L][1],sum+arr[L][0],arr);
            DFS(L+1,t,sum,arr);
        }
    }
    public static void main(String[] args){
        Sec08_03 T = new Sec08_03();
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        T.DFS(0,0,0,arr);
        System.out.println(answer);
    }
}
