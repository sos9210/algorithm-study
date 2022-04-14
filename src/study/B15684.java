package study;

import java.util.Scanner;

//일단 가로선 for문으로 깔고 제대로 도착하는지 체크하는듯
public class B15684 {
    static int[][] map;
    static int N,M,H,answer;
    static boolean isFinish = false;
    private static void DFS(int row,int col, int horizon){
        if(isFinish) return;
        if(answer == horizon){  //가로선의 개수가
            if(isCheck()){
                isFinish = true;
            }
            return;
        }
        for (int i = col; i <= H; i++) {
            for (int j = row; j < N; j++) {
                // 가로선 두 개가 연속으로 놓여질 수 없기 때문에 가로선을 추가하기 전에 연결된 가로선이 있는지 확인한다.
                if(map[i][j] == 0 && map[i][j + 1] == 0){
                    //가로선 추가
                    map[i][j] = 1;
                    map[i][j + 1] = 2;

                    DFS(1,1,horizon+1);

                    //가로선 제거
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
        
    }
    //i번으로 출발해서 i번으로 도착했는지 체크
    private static boolean isCheck() {
        for (int i = 1; i <= N; i++) {
            int nx = i;
            int ny = 1;

            while (ny <= H) {
                if (map[ny][nx] == 1) nx++; // 우측으로 이동
                else if (map[ny][nx] == 2) nx--; // 좌측으로 이동
                ny++; // y축+1칸 이동한다. (아래로 이동)
            }

            if (nx != i) return false; // i번으로 출발해서 i번으로 도착하지 않는게 하나라도 있다면 리턴.
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //세로
        M = sc.nextInt();   //가로
        H = sc.nextInt();
        map = new int[H+1][N+1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;      //우측이동
            map[a][b+1] = 2;    //좌측이동
        }

        // 추가할 가로선의 갯수를 미리 정해놔야 탐색 종료 조건으로 걸 수 있다.
        // 아래 반복문에서 i는 추가할 가로선의 수.
        for (int i = 0; i <= 3; i++) {
            answer = i;
            DFS(1,1,0);
            if(isFinish) break;
        }
        System.out.println(isFinish ? answer : -1);
    }
}
