package sec02;

import java.util.Scanner;

public class Sec02_12 {

    public int solution(int[][] arr, int n, int m) {
        int answer=0,cnt=0;
        //i학생 j시험횟수
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cnt=0;
                for (int k = 0; k < m; k++) {
                    int pi=0, pj=0;
                    for (int s = 0; s < n; s++) {
                        if(arr[k][s]==i) pi=s;
                        if(arr[k][s]==j) pj=s;
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt == m){
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=in.nextInt();
            }
        }
        Sec02_12 T = new Sec02_12();
        System.out.println(T.solution(arr,n,m));
    }

}
