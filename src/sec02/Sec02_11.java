package sec02;

import java.util.Scanner;

public class Sec02_11 {
    public int solution(int[][] arr, int n) {
        int answer = 0, max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if(arr[i][k] == arr[j][k]){
                        cnt++;
                        break;
                    }
                }
                if(cnt > max){
                    max=cnt;
                    answer=i;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n+1][6];
        for (int i=1; i <= n; ++i) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        Sec02_11 T = new Sec02_11();
        System.out.println(T.solution(arr,n));
        return ;
    }
}
