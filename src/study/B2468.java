package study;

import java.util.Scanner;

public class B2468 {
    static int N;
    static int[][] map;
    static int[] nx = {1,-1,0,0};
    static int[] ny = {0,0,-1,1};
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;
    static int count = 0;
    public static void DFS(int x, int y,int height){
        for (int k = 0; k < 4; k++) {   //상하좌우 탐색
            int nextX = x + nx[k];
            int nextY = y + ny[k];
            // 다음좌표가 map크기를 벗어나지 않고 방문한적이 없고 비높이보다 클때
            if (nextX < N && nextY < N && nextX >= 0 && nextY >= 0 && !visit[nextX][nextY] && map[nextX][nextY] > height) {
                visit[nextX][nextY] = true; //방문 체크
                DFS(nextX, nextY,height);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        int height = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int a = sc.nextInt();
                map[i][j] = a;
                height = Math.max(height,a);    //비 최대 높이를 구한다
            }
        }
        for (int s = 0; s <= height; s++) { // 0부터 비 최대 높이만큼 돌린다
            count = 0;                      //각 비높이를 한바퀴 돌때마다 count와 방문체크여부를 초기화한다.
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {       //map 탐색시작
                for (int j = 0; j < N; j++) {
                    if(map[i][j] > s && !visit[i][j]){  //해당 위치가 비 높이보다 높고 방문한적이 없을때
                        count++;                        //영역갯수 +1
                        DFS(i, j,s);
                        max = Math.max(count, max);     //각 비 높이마다 가장 많은 안전영역을 가지는 숫자를 구한다.
                    }
                }
            }
        }
        System.out.println(max);
    }
}
