package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Hedgehog {
    int x,y,time;
    public Hedgehog (int x, int y, int time){
        this.x=x;
        this.y=y;
        this.time=time;
    }
}
class Water {
    int x,y;
    public Water (int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class B3055 {
    static int R,C, min = Integer.MAX_VALUE;
    static char[][] map;
    static int[] nx = {0,0,1,-1};
    static int[] ny = {1,-1,0,0};
    static boolean[][] visit;
    static Water water;
    private static void BFS(Hedgehog h){
        Queue<Hedgehog> q = new LinkedList<>();
        q.offer(h);
        while(!q.isEmpty()){
             Hedgehog hh = q.poll();
             if(map[hh.x][hh.y] == 'D'){
                 min = Math.min(min,hh.time);
             }

            for (int i = 0; i < 4; i++) {   //홍수퍼지는거부터 잡자
                int dx = nx[i] + water.x;
                int dy = ny[i] + water.y;
                if (dx >= 0 && dy >= 0 && dx < R && dy < C && map[dx][dy] != 'D' && map[dx][dy] != 'X') {
                    map[dx][dy] = '*';
                }
            }
            for (int i = 0; i < 4; i++) {
                int dx = nx[i] + hh.x;
                int dy = ny[i] + hh.y;
                if(dx >= 0 && dy >= 0 && dx < R && dy < C && map[dx][dy] != 'X' && map[dx][dy] != '*' &&!visit[dx][dy]){
                    visit[dx][dy] = true;
                    q.offer(new Hedgehog(dx,dy,hh.time+1));
                }
            }


        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        visit = new boolean[R][C];
        int x=0,y=0;
        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S') {
                    x = i;
                    y = j;
                }
                if(map[i][j] == '*') water = new Water(i,j);
            }
        }
        BFS(new Hedgehog(x,y,0));
        System.out.println(min);
    }
}
