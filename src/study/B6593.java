package study;

import java.util.*;
class PointB6593 {
    int h, x, y, second;
    public PointB6593(int h, int x, int y,int second){
        this.h = h;
        this.x = x;
        this.y = y;
        this.second =second;
    }
}
public class B6593 {
    static int L,R,C;
    static int[] nx = {1,-1,0,0,0,0};
    static int[] ny = {0,0,1,-1,0,0};
    static int[] nh = {0,0,0,0,1,-1};
    static char[][][] map;
    static boolean[][][] visit;
    static int second = 0;
    public static void BFS(PointB6593 pointB6593){
        Queue<PointB6593> q = new LinkedList<>();
        visit[pointB6593.h][pointB6593.x][pointB6593.y] = true;
        q.offer(pointB6593);
        while(!q.isEmpty()){
            PointB6593 point = q.poll();
            int h = point.h; int x = point.x; int y = point.y;

            if(map[h][x][y] == 'E'){
                System.out.println("Escaped in "+point.second+" minute(s).");
                System.exit(0);
            }
            for (int k = 0; k < 6; k++) {
                int nextX = x + nx[k];
                int nextY = y + ny[k];
                int nextH = h + nh[k];
                if (nextH < L && nextX < R && nextY < C && nextH >= 0 && nextX >= 0 && nextY >= 0
                        && map[nextH][nextX][nextY] != '#' && !visit[nextH][nextX][nextY]) {

                    visit[nextH][nextX][nextY] = true;
                    q.offer(new PointB6593(nextH,nextX,nextY, point.second+1));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();
        if(L == 0 && R == 0 && C == 0) System.exit(0);
        map = new char[L][R][C];
        visit = new boolean[L][R][C];
        int x = 0,y = 0, h = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                String a = sc.next();
                for (int k = 0; k < C; k++) {
                    if(String.valueOf(a.charAt(k)).equals("S")){
                        h = i;
                        x = j;
                        y = k;
                    }
                    map[i][j][k] = a.charAt(k);
                }
            }
        }
        BFS(new PointB6593(h,x,y,second));
        if(second == 0) System.out.println("Trapped!");
    }
}
