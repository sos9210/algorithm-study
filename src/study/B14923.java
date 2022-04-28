package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Hongik {
    int x,y,time;
    int magic = 1;
    public Hongik(int x, int y,int time, int magic){
        this.x = x;
        this.y = y;
        this.time = time;
        this.magic = magic;
    }
}
public class B14923 {
    static int N,M;
    static int[][] map;
    static int[] nx = {0,0,1,-1};
    static int[] ny = {1,-1,0,0};
    static boolean[][] visit;
    static int min = Integer.MAX_VALUE;
    private static void BFS(Hongik hhhh){
        Queue<Hongik> h = new LinkedList<>();
        h.offer(hhhh);
        visit[hhhh.x][hhhh.y] = true;

        while (!h.isEmpty()){
            Hongik hongik = h.poll();
            if(map[hongik.x][hongik.y] == 2){
                min = Math.min(min, hongik.time);
            }
            for (int i = 0; i < 4; i++) {
                int dx = hongik.x + nx[i];
                int dy = hongik.y + ny[i];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visit[dx][dy]){
                    if(map[dx][dy] == 1 && hongik.magic == 1) {                 //벽인경우 마법사용하여 이동
                        h.offer(new Hongik(dx,dy,hongik.time+1,hongik.magic-1));
                    }
                    if(map[dx][dy] == 0 || map[dx][dy] == 2 && map[dx][dy] != 1) {//벽이 아닌경우이고 출구거나 빈공간일 경우
                        h.offer(new Hongik(dx,dy, hongik.time+1, hongik.magic));
                    }
                    visit[dx][dy] = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Hongik hongik = new Hongik(sc.nextInt()-1,sc.nextInt()-1,0,1);
        map = new int[N][M];
        visit = new boolean[N][M];
        map[sc.nextInt()-1][sc.nextInt()-1] = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 2) map[i][j] = sc.nextInt();
            }
        }

        BFS(hongik);
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}
