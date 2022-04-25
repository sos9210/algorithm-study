package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point17141 {
    int x, y,count;
    public Point17141 (int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
public class B17141 {
    static int N,M;
    static int[][] map;
    static String[][] copyMap;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<Point17141> q = new LinkedList<>();
    static int min = Integer.MAX_VALUE;
    private static void copy(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(copyMap[i][j] == null) copyMap[i][j] = "";
                if(map[i][j] == 1)
                    copyMap[i][j] = "-";
                else if(!copyMap[i][j].equals("0"))copyMap[i][j] = "";

                if(copyMap[i][j].equals("0")){
                    q.offer(new Point17141(i,j,0));
                }
            }
        }
    }
    private static int BFS(){
        int count = 0;
        while (!q.isEmpty()){
            Point17141 p = q.poll();
            count = p.count;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && copyMap[nx][ny].equals("")){
                    q.offer(new Point17141(nx,ny,p.count+1));
                    copyMap[nx][ny] = String.valueOf(p.count+1);
                }
            }
        }
        return count;
    }
    private static void DFS(int x, int count){
        if(count == M){
            copy();
            min = Math.min(BFS(),min);
            return;
        }

        for (int i = x; i < N*N; i++) {
            int nx = i / N;
            int ny = i % N;
            if(map[nx][ny] == 1) continue;
            if(map[nx][ny] == 2){
                copyMap[nx][ny] = "0";
                DFS(x+1,count+1);
                copyMap[nx][ny] = "";
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        copyMap = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        DFS(0,0);

        System.out.println(min);
    }
}
