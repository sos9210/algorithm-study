package sec08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//토마토(BFS)
//토마토가 전부 익기까지 걸린시간
public class Sec08_11 {
    static class Point { //큐에 담을 Point좌표 클래스
        public int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //box : 토마토박스의 각 토마토 위치를 좌표를 표현, dis : 토마토박스에서 각 토마토 위치에 익기까지 걸린시간을 표현.
    static int[][] box,dis;
    // dx di : 상 하 좌 우 위치를 표현
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static Queue<Point> q = new LinkedList<>();
    public void BFS() {
        while(!q.isEmpty()){
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i]; // nx ny : 다음으로 탐색할 좌표
                int ny = tmp.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && box[nx][ny] == 0){ // 다음 탐색좌표가 탐색범위이고 익은 토마토가 존재할경우
                    box[nx][ny] = 1; //다음 탐색좌표 토마토는 익은 토마로상태로 변경
                    q.offer(new Point(nx,ny));  //Point객체에 좌표값을 인자로 생성하여 넣는다.
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;    // 토마토가 익기까지 걸린시간을 +1 해준다.
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sec08_11 T = new Sec08_11();
        m = sc.nextInt(); //가로
        n = sc.nextInt(); //세로
        box = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1){
                    q.offer(new Point(i,j));    //BFS탐색을 시작할 위치를 큐에 미리 넣는다.
                }
            }
        }
        T.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(box[i][j] == 0){     // BFS를 전부 탐색했는데 아직 익지 않은 토마토가 존재하면 false
                    flag = false;
                }
            }
        }
        if(flag){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {   //dis 2차원배열을 전부 조회해서 가장 높은 숫자가 최종적으로 익기까지 걸린 시간
                    answer = Math.max(answer,dis[i][j]);
                }
            }
        }else{  //토마토가 전부 익지 않았으므로 -1
            answer = -1;
        }
        System.out.println(answer);
    }
}
