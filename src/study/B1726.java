package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Robot{
    int x,y,dir,order,go;
    public Robot(int x, int y, int dir, int order, int go){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.order = order;
        this.go = go;
    }
}
public class B1726 {
    static int M,N,endX,endY,endDir, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visit;
                    //상 하 좌 우
    static int[] nx = {-1,1,0,0};
    static int[] ny = {0,0,-1,1};
    private static int findDir(int x, int y,int nextX, int nextY){
        if(nextX < x && nextY == y){          //북
      //      System.out.println("북");
            return 4;
        }else if(nextX > x && nextY == y){     //남
   //         System.out.println("남");
            return 3;
        }else if(nextX == x && nextY < y){    //서
 //           System.out.println("서");
            return 2;
        }else {                         //동
  //          System.out.println("동");
            return 1;
        }
    }
    private static int findOrder(int newDir, int dir){
        if((newDir == 1 && dir == 2) || (newDir == 2 && dir == 1)) return 2;
        else if((newDir == 3 && dir == 4) || (newDir == 4 && dir == 3)) return 2;
        else if(newDir == dir) return 0;
        else return 1;
    }
    private static void BFS(Robot robot){
        Queue<Robot> q = new LinkedList<>();
        q.offer(robot);
        visit[robot.x][robot.y] = true;
        while (!q.isEmpty()){
            Robot r = q.poll();
            if(r.x == 2 && r.y == 2){
                System.out.println();
            }
            if(r.x == endX && r.y == endY){
                int order = r.order;
                order = order+findOrder(endDir, r.dir); //도착지점에오면 원하는 방향으로 회전시킨다.
                min = Math.min(order,min);
                System.out.println(min);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = r.x + nx[i];
                int nextY = r.y + ny[i];
                int newDir = findDir(r.x,r.y,nextX,nextY);      //새로운 방향
                if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && !visit[nextX][nextY] && map[nextX][nextY] == 0){
/*
                    int order = r.order;                    //기존 명령횟수
                    int go = r.go;
                    if(newDir != r.dir) {
                        order = findOrder(newDir,r.dir) + order;   //새로운 방향과 기존 방향이 같지않으면 그 수만큼 명령횟수를 늘리고 직진명령을 내린다.
                        go = 1;
                        q.offer(new Robot(nextX,nextY,newDir,order+1,go));
                    }else if(newDir == r.dir && r.go == 0) {
                        order += 1;  //기존과 방향이 같고 직진 명령을 내리지 않은경우 order + 1 한다.
                        go = 1;
                        q.offer(new Robot(nextX,nextY,newDir,order,go));
                    }else if(newDir == r.dir && r.go == 1){     //기존에 이미 직진명령을 내렸으면.
                        q.offer(new Robot(nextX,nextY,newDir,order,go));
                    }
                    if(nextX != endX && nextY != endY)
                    visit[nextX][nextY] = true;
                    */
                    if(newDir != r.dir && r.go == 0) { //새로운 방향과 기존 방향이 같지않으면 회전명령을 내린다.
                        int order = r.order+1;
                        newDir = findNewDir(newDir,r.dir);
                        q.offer(new Robot(r.x,r.y,newDir,order,0));
                        //visit[r.x][r.y] = true; //회전하면서 !visit[nextX][nextY][newDir]이거에 걸러지는거 아닐까 싶은데..
                    }else if(newDir == r.dir && r.go == 0) { //기존 방향과 새로운 방향이 같고 직진 명령을 내리지 않은경우
                        go(newDir,nextX,nextY,r.order,q);
                    }
                }
            }
        }
        System.out.println(min);
    }
    private static int findNewDir(int newDir, int dir){
        if((newDir == 1 && dir == 4) || (newDir == 4 && dir == 1)){
            return newDir;
        }else if((newDir == 3 && dir == 1 || newDir == 1 && dir == 3)){
            return 2;
        }else if((newDir == 2 && dir == 4) || (newDir == 4 && dir == 2)){
            return 3;
        }
        return 0;
    }
    private static void go(int newDir,int nextX, int nextY, int order,Queue<Robot> r){
        if(newDir == 1 && nextY < N && map[nextX][nextY] == 0 && !visit[nextX][nextY]){ //동쪽으로 계속 갈 수 있는지?
            while(nextY < N && map[nextX][nextY] == 0){
                if(nextY+1 >= N || map[nextX][nextY+1] == 1) break;   //경계밖이거나 벽을만나면 브레이크
                //남북으로 빠져나갈길이 있는지?
                if(nextX+1 < M && map[nextX+1][nextY] == 0){
                    r.offer(new Robot(nextX+1,nextY,newDir,order+1,0));
                    visit[nextX+1][nextY] = true;
                }
                if(nextX-1 >= 0 && map[nextX-1][nextY] == 0){
                    r.offer(new Robot(nextX-1,nextY,newDir,order+1,0));
                    visit[nextX-1][nextY] = true;
                }
                ++nextY;
            }
            r.offer(new Robot(nextX,nextY,newDir,order+1,0));
            visit[nextX][nextY] = true;
        }else if(newDir == 2 && nextY >= 0 && map[nextX][nextY] == 0 && !visit[nextX][nextY]){
            while(nextY >= 0 && map[nextX][nextY] == 0){
                if(nextY-1 < 0 || map[nextX][nextY-1] == 1) break;   //경계밖이거나 벽을만나면 브레이크
                //남북으로 빠져나갈길이 있는지?
                if(nextX+1 < M && map[nextX+1][nextY] == 0){
                    r.offer(new Robot(nextX+1,nextY,newDir,order+1,0));
                    visit[nextX+1][nextY] = true;
                }
                if(nextX-1 >= 0 && map[nextX-1][nextY] == 0){
                    r.offer(new Robot(nextX-1,nextY,newDir,order+1,0));
                    visit[nextX-1][nextY] = true;
                }
                --nextY;
            }
            r.offer(new Robot(nextX,nextY,newDir,order+1,0));
            visit[nextX][nextY] = true;
        }else if(newDir == 3 && nextX >= 0 && map[nextX][nextY] == 0 && !visit[nextX][nextY]){
            while(nextX < M && map[nextX][nextY] == 0){
                if(nextX+1 >= M || map[nextX+1][nextY] == 1) break;   //경계밖이거나 벽을만나면 브레이크
                //동서로 빠져나갈길이 있는지?
                if(nextY+1 < N && map[nextX][nextY+1] == 0){
                    r.offer(new Robot(nextX,nextY+1,newDir,order+1,0));
                    visit[nextX][nextY+1] = true;
                }
                if(nextY-1 >= 0 && map[nextX][nextY-1] == 0){
                    r.offer(new Robot(nextX,nextY-1,newDir,order+1,0));
                    visit[nextX][nextY-1] = true;
                }
                ++nextX;
            }
            r.offer(new Robot(nextX,nextY,newDir,order+1,0));
            visit[nextX][nextY] = true;
        }else if(newDir == 4 && nextX >= 0 && map[nextX][nextY] == 0 && !visit[nextX][nextY]){
            while(nextX >= 0 && map[nextX][nextY] == 0){
                if(nextX-1 < 0 || map[nextX-1][nextY] == 1) break;   //경계밖이거나 벽을만나면 브레이크
                //동서로 빠져나갈길이 있는지?
                if(nextY+1 < N && map[nextX][nextY+1] == 0){
                    r.offer(new Robot(nextX,nextY+1,newDir,order+1,0));
                    visit[nextX][nextY+1] = true;
                }
                if(nextY-1 >= 0 && map[nextX][nextY-1] == 0){
                    r.offer(new Robot(nextX,nextY-1,newDir,order+1,0));
                    visit[nextX][nextY-1] = true;
                }
                --nextX;
            }
            r.offer(new Robot(nextX,nextY,newDir,order+1,0));
            visit[nextX][nextY] = true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        visit = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt()-1;
        int y = sc.nextInt()-1;
        int dir = sc.nextInt();
        endX = sc.nextInt()-1;
        endY = sc.nextInt()-1;
        endDir = sc.nextInt();

        BFS(new Robot(x,y,dir,0,0));


    }
}
