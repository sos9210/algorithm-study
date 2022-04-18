package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Position13459 {
    int redX,redY,blueX,blueY,count;
    public Position13459(int redX, int redY,int blueX, int blueY,int count ){
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
        this.count = count;
    }
}
public class B13459 {
    static int N,M,goalX,goalY;
    static char[][] board;
    static boolean[][] visitRed;
    static boolean[][] visitBlue;
    //상 하 좌 우
    static int[] nx = {1,-1,0,0};
    static int[] ny = {0,0,-1,1};
    public static int BFS(Position13459 p){
        Queue<Position13459> q = new LinkedList<>();
        q.offer(p);

        visitRed[p.redX][p.redY] = true;
        visitBlue[p.blueX][p.blueY] = true;

        while (!q.isEmpty()){
            Position13459 position = q.poll();
            int count = position.count;
            int i = 0;
            while (i < 4) {
                boolean redflag = false;    //빨간공과 파란공이 모두 멈출때까지
                boolean blueflag = false;
                boolean flag = false;
                int nextRedX = position.redX + nx[i];
                int nextRedY = position.redY + ny[i];
                int nextBlueX = position.blueX + nx[i];
                int nextBlueY = position.blueY + ny[i];
/*                if(nextRedX == 4 && nextRedY == 1){
                    System.out.println("aa");
                }*/

                int redCnt = 0;
                int blueCnt = 0;
                //빨간공이 움직이지못하면 true
                if(!visitRed[nextRedX][nextRedY] && nextRedX >= 0 && nextRedX < N && nextRedY >= 0 && nextRedY < M)
                while(!redflag){
                    //빨간공이 벽을 만나면 그 전 위치까지만 이동
                    if(board[nextRedX][nextRedY] == '#') {
                        redCnt--;
                        redflag = true;
                        nextRedX -= nx[i];
                        nextRedY -= ny[i];
                        //빨간공이 출구를 만나면 원래있던 위치만 빈공간으로
                   }else if(nextRedX == goalX && nextRedY == goalY){
                        redflag = true;
                        flag = true;

                    }else{ //빨간공이 움직일 수 있으면 해당방향으로 계속 이동
                        redCnt++;
                        nextRedX += nx[i];
                        nextRedY += ny[i];
                    }
                }
                //파란공이 움직이지못하면 true
                if(!visitBlue[nextBlueX][nextBlueY] && nextBlueX >= 0 && nextBlueX < N && nextBlueY >= 0 && nextBlueY < M)
                while(!blueflag) {
                    //파란공이 벽을 만나면 그 전 위치까지만 이동
                    if (board[nextBlueX][nextBlueY] == '#') {
                        blueCnt--;
                        blueflag = true;
                        nextBlueX -= nx[i];
                        nextBlueY -= ny[i];
                        //파란공이 출구를 만나면 원래있던 위치만 빈공간으로
                    }else if(nextBlueX == goalX && nextBlueY == goalY){
                        blueflag = true;
                        flag = false;

                    } else {//파란공이 움직일 수 있으면 해당방향으로 계속 이동
                        blueCnt++;
                        nextBlueX += nx[i];
                        nextBlueY += ny[i];

                    }
                }
                // 이동한 위치가 빨간공과 파란공 겹친다면
                if(nextRedX == nextBlueX && nextRedY == nextBlueY){
                    // 빨간공의 이동방향에 파란공이 있었다면 파란공 바로옆에 위치
                    int rx = 0 ,ry = 0;
                    for (int j = 0; j <= redCnt; j++) {
                        rx += nx[i]; ry += ny[i];
                        if(position.redX + rx == position.blueX && position.redY + ry == position.blueY){
                            nextRedX -= nx[i];
                            nextRedY -= ny[i];
                            break;
                        }
                    }
                    //파란공의 이동방향에 빨간공이 있었다면 파란공 바로옆에 위치
                    int bx = 0 ,by = 0;
                    for (int j = 0; j <= blueCnt; j++) {
                        bx += nx[i]; by += ny[i];
                        if (position.blueX + bx == position.redX && position.blueY + by == position.redY) {
                            nextBlueX -= nx[i];
                            nextBlueY -= ny[i];
                            break;
                        }
                    }
                }
                //둘다 움직이지 못하면
                if(redflag && blueflag) {
                    if(count > 10) return 0;
                    if(flag == true){
                        return 1;
                    }
                    //방문한적있으면 큐에 넣지 않는다.
                    if(!visitRed[nextRedX][nextRedY] || ! visitBlue[nextBlueX][nextBlueY]){
                        Position13459 pos = new Position13459(nextRedX,nextRedY,nextBlueX,nextBlueY,count+1);
                        q.offer(pos);
                    }
                    visitRed[nextRedX][nextRedY] = true;
                    visitBlue[nextBlueX][nextBlueY] = true;
                }
                ++i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N][M];
        visitRed = new boolean[N][M];
        visitBlue = new boolean[N][M];
        int redX = 0;
        int redY = 0;
        int blueX = 0;
        int blueY = 0;
        for (int i = 0; i < N; i++) {
            String a = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = a.charAt(j);
                if (board[i][j] == 'B') {
                    blueX = i;
                    blueY = j;
                }
                if (board[i][j] == 'R') {
                    redX = i;
                    redY = j;
                }
                if(board[i][j] == 'O'){
                    goalX = i;
                    goalY = j;
                }
            }
        }
        visitRed[redX][redY] = true;
        visitBlue[blueX][blueY] = true;
        System.out.println(BFS(new Position13459(redX,redY,blueX,blueY,0)));
    }
}
