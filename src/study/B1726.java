package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Robot{
    int x,y,dir,order;
    public Robot(int x, int y, int dir, int order){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.order = order;
    }
}
public class B1726 {
    static int M,N,endX,endY,endDir,min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][][] visit;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    private static void BFS(Robot robot) {
        Queue<Robot> q = new LinkedList<>();
        q.offer(robot);
        visit[robot.dir][robot.x][robot.y] = true;
        while(!q.isEmpty()){
            Robot r = q.poll();
            if(r.x == endX && r.y == endY && r.dir == endDir){
                min = Math.min(r.order,min);
                continue;
            }

            for (int i = 1; i <= 3; i++) {
                int nx = r.x + dx[r.dir] * i;
                int ny = r.y + dy[r.dir] * i;
                //1.
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(map[nx][ny] == 1) break;
                if(visit[r.dir][nx][ny]) continue;
                else { visit[r.dir][nx][ny] = true;
                    q.offer(new Robot(nx,ny,r.dir,r.order+1));
                }
                /*
                //2.왜 이코드는 메모리 초과가 뜰까? 알수없다.. 1번이랑 똑같은데
                if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visit[r.dir][nx][ny]){
                    if(map[nx][ny] == 1) {
                        break;
                    }
                    q.offer(new Robot(nx,ny,r.dir,r.order+1));
                }
                 */
            }

            int left = 0, right = 0;
            switch (r.dir){
                case 0: left = 3; right = 2; break;
                case 1: left = 2; right = 3; break;
                case 2: left = 0; right = 1;break;
                case 3: left = 1; right = 0;break;
            }
            if(!visit[left][r.x][r.y]){
                visit[left][r.x][r.y] = true;
                q.offer(new Robot(r.x,r.y,left,r.order+1));
            }
            if(!visit[right][r.x][r.y]){
                visit[right][r.x][r.y] = true;
                q.offer(new Robot(r.x,r.y,right,r.order+1));
            }
        }

    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        visit = new boolean[5][M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt()-1;
        int y = sc.nextInt()-1;
        int dir = sc.nextInt()-1;
        endX = sc.nextInt()-1;
        endY = sc.nextInt()-1;
        endDir = sc.nextInt()-1;
/*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visit = new boolean[4][M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        int dir = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken())-1;
        endY = Integer.parseInt(st.nextToken())-1;
        endDir = Integer.parseInt(st.nextToken())-1;
*/
        BFS(new Robot(x,y,dir,0));
        System.out.println(min);
    }
}
