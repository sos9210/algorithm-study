package study;

import java.util.*;

class Point1 {
    int x,y;
    public Point1(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class B1987 {
    static String[][] map;
    static int[] mx = {0,-1,0,1};
    static int[] my = {1,0,-1,0};
    static int count = 0;
    static int C,R;
    static int[][] visit;
    public void DFS(int level,Point1 p,String str) {
        count = Math.max(level,count);
        for (int i = 0; i < 4; i++) {
            int nextX = mx[i]+p.x;
            int nextY = my[i]+p.y;
            //map배열에서 벗어나거나 한번 방문한적있으면 다음 좌표탐색
            if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C || visit[nextX][nextY] > 0){
                continue;
            }
            //방문한적없는 알파벳이라면
            if(!str.contains(map[nextX][nextY])){
                visit[nextX][nextY] = 1;
                DFS(level+1,new Point1(nextX,nextY),str + map[nextX][nextY]);
                visit[nextX][nextY] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        B1987 T = new B1987();
        R = sc.nextInt();
        C = sc.nextInt();
        map = new String[R][C];
        visit = new int[R][C];
        for (int i = 0; i < R; i++) {
            String inputstr = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = String.valueOf(inputstr.charAt(j));
            }
        }

        T.DFS(1,new Point1(0,0),map[0][0]);
        System.out.println(count);
    }
}
