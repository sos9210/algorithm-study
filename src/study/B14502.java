package study;

import java.util.*;

class Point14502 {
    int x,y;
    public Point14502(int x, int y){
        this.x = x;
        this.y = y;
    }
}
//bfs + dfs 조합문제
public class B14502 {
    static int N,M,result;
    static int[][] map,copyMap;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<Point14502> q = new LinkedList<>();

    public static int countSafe() {
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(copyMap[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void copy() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                copyMap[i][j] = map[i][j];
                if(copyMap[i][j] == 2) q.offer(new Point14502(i,j));
            }
        }
    }
    private static void DFS(int start,int wallCnt){
        if(wallCnt == 3){
            copy();
            BFS();  // 바이러스 뿌리기
            result = Math.max(result,countSafe());
            return;
        }
        //모든 맵 탐색
        for (int i = start; i < M*N; i++) {
            int nx = i / M;
            int ny = i % M;
            if(map[nx][ny] == 2 || map[nx][ny] == 1) continue; //벽이나 바이러스는 건너뛴다.

            map[nx][ny] = 1;
            DFS(i+1,wallCnt+1); //벽 세우기
            map[nx][ny] = 0;
        }
    }
    private static void BFS(){
        while (!q.isEmpty()){
            Point14502 point = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
                    if(copyMap[nextX][nextY] == 0){
                        copyMap[nextX][nextY] = 2;
                        q.offer(new Point14502(nextX,nextY));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        DFS(0,0);

        System.out.println(result);
    }

}
