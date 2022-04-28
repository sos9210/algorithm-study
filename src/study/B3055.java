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
    static Queue<Water> w = new LinkedList<>();
    private static void BFS(Hedgehog h){
        Queue<Hedgehog> q = new LinkedList<>();
        q.offer(h);
        int beforeTime = 0;
        while(!q.isEmpty()){
             Hedgehog hh = q.poll();
             if(map[hh.x][hh.y] == 'D'){    //위치가 D면 목표점 도달
                 min = Math.min(min,hh.time);
             }
             int waterSize = w.size();  //홍수 사이즈
            //홍수가 퍼진다.
             while (waterSize > 0 && beforeTime < hh.time){ //홍수 사이즈만큼 돌고 현재 고슴도치 큐의 시간이 전에 돌았던 고슴도치 큐보다 크면실행
                 Water water = w.poll();
                 for (int i = 0; i < 4; i++) {
                     int dx = nx[i] + water.x;
                     int dy = ny[i] + water.y;
                     //지도의 경계를 벗어나면 안되고 비버굴,홍수,돌이 아닌곳으로 홍수가 퍼져나갈 수 있다.
                     if (dx >= 0 && dy >= 0 && dx < R && dy < C && map[dx][dy] != 'D' && map[dx][dy] != '*' && map[dx][dy] != 'X') {
                         map[dx][dy] = '*';
                         w.offer(new Water(dx,dy));
                     }
                 }
                 --waterSize;
             }
             //홍수를 다 돌고나면 현재시간 체크해준다.
             beforeTime = hh.time;

             //현재위치가 홍수면 다음 큐를 실행한다.
            if(map[hh.x][hh.y] == '*'){
                continue;
            }

            //고슴도치가 이동한다.
            for (int i = 0; i < 4; i++) {
                int dx = nx[i] + hh.x;
                int dy = ny[i] + hh.y;
                //지도 경계를 벗어나면 안되고 벽,홍수,방문한적 있는 위치는 이동할 수 없다.
                if(dx >= 0 && dy >= 0 && dx < R && dy < C && map[dx][dy] != 'X' && map[dx][dy] != '*' && !visit[dx][dy]){
                    //방문위치 체크
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
        map = new char[R][C];       //지도
        visit = new boolean[R][C];  //방문체크
        int x=0,y=0;
        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S') {  //시작위치
                    x = i;
                    y = j;
                }
                if(map[i][j] == '*') w.offer(new Water(i,j));   //홍수 위치를 큐에 담는다.
            }
        }
        BFS(new Hedgehog(x,y,0));
        if(min == Integer.MAX_VALUE) System.out.println("KAKTUS");  //한번도 도달하지 못했으므로 실패
        else System.out.println(min);
    }
}
