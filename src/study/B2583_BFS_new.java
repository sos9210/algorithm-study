package study;

import java.util.*;
class Position{
    int x,y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}
//BFS
public class B2583_BFS_new {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int m,n,k;
    static int[][] map;
    static int count;
    static boolean[][] visit;
    static List<Integer> size = new ArrayList<>();
    public int solution(Position position){
        Queue<Position> q = new LinkedList<>();
        q.offer(position);
        int thisSize = 1;
        while(!q.isEmpty()){
            Position poll = q.poll();
            int px = poll.x;
            int py = poll.y;
            visit[px][py] = true;       //방문체크를 꼭 해줘야한다.
            for (int i = 0; i < 4; i++) { //현재 포지션기준 상하좌우 탐색을실행
                int nextPx = px+dx[i];
                int nextPy = py+dy[i];
                // 다음좌표위치가 map크기를 벗어나거나 방문한적 있는 좌표가 아닐경우 실행
                if(nextPx >= 0 && nextPy >= 0 && nextPx < n && nextPy < m  && map[nextPx][nextPy] == 0 && visit[nextPx][nextPy]==false){
                    map[nextPx][nextPy] = 1;
                    q.offer(new Position(nextPx,nextPy));
                    thisSize++;
                }
            }
        }
        return thisSize;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        B2583_BFS_new T = new B2583_BFS_new();
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        visit = new boolean[n][m];
        map = new int[n][m];
        for (int i = 0; i < k; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int j = x1; j < x2; j++) {
                for (int l = y1; l < y2; l++) {
                    map[j][l] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    size.add(T.solution(new Position(i,j)));
                    ++count;
                }
            }
        }
        System.out.println(count);
        Collections.sort(size);
        size.stream().forEach(v -> System.out.print(v + " "));

    }
}
