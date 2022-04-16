package study;

import java.util.Scanner;

public class B15864_new1 {
    static int N,M,H,answer;
    static int[][] map;
    static boolean isFinish;
    public static void DFS(int row, int col, int count){
        if(isFinish) return;
        if(count == answer){
            if(isCheck()){
                isFinish = true;
            }
            return;
        }

        for (int i = col; i <= H; i++) {
            for (int j = row; j < N; j++){
                if(map[i][j] == 0 && map[i][j+1] == 0){
                    map[i][j] = 1;
                    map[i][j+1] = 2;
                    DFS(1,1,count+1);
                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }
        }

    }
    // 출발지점과 목적지점 라인이 같은지 체크한다.
    private static boolean isCheck(){
        for (int j = 1; j <= N; j++) {
            int nextJ = j;
            int nextI = 1;
            while(nextI <= H){
                if(map[nextI][nextJ] == 1) nextJ++;
                else if(map[nextI][nextJ] == 2) nextJ--;
                nextI++;
            }
            if(j != nextJ) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //가로길이(세로선의 개수)
        M = sc.nextInt();   //가로선 갯수
        H = sc.nextInt();   //세로길이(가로선을 놓을수 있는 위치 개수)
        map = new int[H+1][N+1];
        for (int i = 1; i <= M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;      //가로선이 이어진부분을 체크한다.
            map[a][b+1] = 2;
        }
        for (int i = 0; i <= 3; i++) {
            answer = i;
            DFS(1,1,0);
            if(isFinish) break;
        }
        System.out.println(isFinish ? answer : -1);
    }
}
