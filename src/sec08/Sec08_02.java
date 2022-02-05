package sec08;

import java.util.Arrays;
import java.util.Scanner;

public class Sec08_02 {
    static int answer = Integer.MIN_VALUE, c, n;

    public void DFS(int L, int sum, int[] arr) {
        if(sum > c){
            return;
        }
        if(L == n){  // L이 바둑이 마릿수가 됐을때
            answer = Math.max(answer,sum);
        }else{
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }
    public static void main(String[] args){
        Sec08_02 T = new Sec08_02();
        Scanner in=new Scanner(System.in);
        c = in.nextInt();
        n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
