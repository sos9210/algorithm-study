package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Hongik {
    int x,y,time,magic;
    public Hongik(int x, int y,int time, int magic){
        this.x = x;
        this.y = y;
        this.time = time;
        this.magic = magic;
    }
}
public class B14923 {
    static int N,M,endN,endM;
    static int[][] map;
    static int[] nx = {0,0,1,-1};
    static int[] ny = {1,-1,0,0};
    static boolean[][][] visit;
    private static void BFS(Hongik hhhh){
        Queue<Hongik> h = new LinkedList<>();
        h.offer(hhhh);
        visit[1][hhhh.x][hhhh.y] = true;
        visit[2][hhhh.x][hhhh.y] = true;

        while (!h.isEmpty()){
            Hongik hongik = h.poll();
            if(hongik.x == endN && hongik.y == endM){
                System.out.println(hongik.time);
                System.exit(0);
            }
            for (int i = 0; i < 4; i++) {
                int dx = hongik.x + nx[i];
                int dy = hongik.y + ny[i];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visit[hongik.magic][dx][dy]){
                    if(map[dx][dy] == 1 && hongik.magic == 0) {                 //벽인경우 마법사용하여 이동
                        h.offer(new Hongik(dx,dy,hongik.time+1,hongik.magic+1));
                        visit[hongik.magic+1][dx][dy] = true;
                    }
                    if(map[dx][dy] == 0 && map[dx][dy] != 1) {//벽이 아닌경우이고 빈공간일 경우
                        h.offer(new Hongik(dx,dy, hongik.time+1, hongik.magic));
                        visit[hongik.magic][dx][dy] = true;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Hongik hongik = new Hongik(sc.nextInt()-1,sc.nextInt()-1,0,0);
        map = new int[N][M];
        visit = new boolean[3][N][M];
        endN = sc.nextInt()-1;
        endM = sc.nextInt()-1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        BFS(hongik);
        System.out.println(-1);
    }
}
