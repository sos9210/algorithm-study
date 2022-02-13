package sec08;

import java.util.Scanner;

//섬나라 아일랜드(DFS)
public class Sec08_12 {
                //상, 하, 좌, 우, 대각선 위치 8개 좌표
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int answer;
    public void DFS(int x, int y, int[][] board) {
        for (int i = 0; i < 8; i++) {   //섬의 위치를 중심으로 8개 좌표조회
            int nx = x + dx[i];         // nx ny : 다음 탐색 좌표
            int ny = y + dy[i];
            // 다음 탐색 좌표가 board크기 안에 존재하고 섬인경우
            if(nx >= 0 && ny >= 0 && nx < board.length && ny < board.length && board[nx][ny] == 1){
                board[nx][ny] = 0;  // 조회된 좌표를 0으로 변경
                DFS(nx,ny,board);
            }
        }
    }
    public void solution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 1){       // 지도에서 섬이 발견될 경우
                    answer++;               // 발견된 섬의 개수를 1개 증가
                    board[i][j] = 0;        // 발견된 위치를 0으로 변경
                    DFS(i,j,board);         // DFS실행
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sec08_12 T = new Sec08_12();
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }    
        }
        T.solution(arr);

        System.out.println(answer);
    }
    
}
