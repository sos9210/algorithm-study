package study;

import java.util.Scanner;

public class B15684_new {
    static int N,M,H,count;
    static int[][] map;
    static boolean isFinish;
    static void DFS(int horizon, int row, int col){
        if(isFinish) return;
        if(count == horizon){
            if(isCheck()){
                isFinish = true;
            }
            return;
        }
        for (int i = col; i <= H; i++) {
            for (int j = row; j < N; j++) {
                if(map[i][j] == 0 && map[i][j+1] == 0) {    //점선 연결여부 확인
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    DFS(horizon + 1, 1,1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }
    private static boolean isCheck(){
        for (int i = 1; i <= N; i++) { //모든 라인에서 시작위치부터 끝위치가 같은지여부 체크한다.
            int ncol = i;
            int nrow = 1;
            while(nrow <= H){           //사다라타기 시작
                if(map[nrow][ncol] == 1) ncol++;    //오른쪽이동
                else if(map[nrow][ncol] == 2) ncol--;//왼쪽이동
                nrow++;                             //밑으로 이동
            }
            if(ncol != i) return false;             //시작과 끝이 같은라인이 아니면 false
        }
        return true; //모든라인이 같으므로 true반환
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //세로선의 갯수(가로 길이)
        M = sc.nextInt();   //가로선 갯수
        H = sc.nextInt();   //가로선을 놓을수 있는 위치 갯수(세로길이)
        map = new int[H+1][N+1];
        for (int j = 0; j < M; j++) {
            int a = sc.nextInt();   //a,b .. 점선이 연결된 위치
            int b = sc.nextInt();
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }
        for (int i = 0; i <=3; i++) {
            count = i;
            DFS(0,1,1);
            if(isFinish) break;
        }

        System.out.println(isFinish ? count : -1);
    }

}
