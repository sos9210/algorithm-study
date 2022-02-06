package sec08;

import java.util.Scanner;

public class Sec08_06 {
    static int[][] dy;
    public int DFS(int n, int r){
        if(dy[n][r] > 0){
            return dy[n][r];
        }
        if(n == r || r == 0){
            return 1;
        }else{
            return dy[n][r] = DFS(n-1, r) + DFS(n-1,r-1);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Sec08_06 T = new Sec08_06();
        int n = in.nextInt();
        int r = in.nextInt();
        dy = new int[n+1][r+1];
        System.out.println(T.DFS(n,r));

    }
}
