package study;

import java.util.*;

class Point {
    int x1,y1;
    public Point(int x1, int y1){
        this.x1 = x1;
        this.y1 = y1;
    }
}

public class B2583_BFS {
    static int[][] map;
    static int m,n;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visit;
    public int solution(Point root){
        Queue<Point> q = new LinkedList<>();
        q.offer(root);
        int cnt = 1;
        while (!q.isEmpty()){
            Point poll = q.poll();
            int x = poll.x1;
            int y = poll.y1;
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < m && nextY < n){
                    if(visit[nextX][nextY] == false && map[nextX][nextY] == 0){
                        visit[nextX][nextY] = true;
                        q.offer(new Point(nextX,nextY));
                        ++cnt;
                    }
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        B2583_BFS T = new B2583_BFS();
        m = sc.nextInt();
        n = sc.nextInt();
        int k = sc.nextInt();
        map = new int[m][n];
        visit = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            for (int j = a; j < c; j++) {
                for (int l = b; l < d; l++) {
                    map[l][j] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visit[i][j] == false && map[i][j] == 0){
                    list.add(T.solution(new Point(i,j)));
                    ++count;
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
