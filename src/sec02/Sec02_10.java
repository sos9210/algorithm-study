package sec02;

import java.util.Scanner;

public class Sec02_10 {
    /*//내가한것
                            // 좌          우        상         하
    private int findPeak(int left, int right, int top, int bottom){
        int answer = 0;
        int max = Integer.max(left, right);
        max = Integer.max(max, top);
        max = Integer.max(max, bottom);
        return max;
    }
    public int solution(int[][] arr){
        int answer = 0;
        for (int i = 1; i < arr.length-1; i++) {
            for (int j = 1; j < arr.length-1; j++) {
                int x = arr[i][j];
                if(findPeak(arr[i][j-1],arr[i][j+1],arr[i-1][j],arr[i+1][j]) < x){
                    answer++;
                }
            }
        }
        return answer;
    }
     */
    public int solution(int[][] arr,int n) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] >= arr[i][j]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
/*        //내가한것
        int n = in.nextInt();
        int[][] arr = new int[n+2][n+2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; j++) {
                arr[i+1][j+1] = in.nextInt();
            }
        }
        Sec02_10 T = new Sec02_10();
        System.out.println(T.solution(arr));
        */
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=in.nextInt();
            }
        }
        Sec02_10 T = new Sec02_10();
        System.out.print(T.solution(arr,n));
        return ;
    }
}
