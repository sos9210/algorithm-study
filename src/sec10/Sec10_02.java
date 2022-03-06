package sec10;

import java.util.Scanner;

public class Sec10_02 {
    static int[] dy;
    public int solution(int n){
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i-2]+dy[i-1];
        }
        return dy[n];
    }
    public static void main(String[] args) {
        Sec10_02 T = new Sec10_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt()+1;
        dy = new int[n+1];
        System.out.println(T.solution(n));
    }
}
