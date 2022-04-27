package study;

import java.util.Scanner;

public class B17090 {
    static int N,M;
    static char[][] miro;
    static int count;
    static boolean[][] visit;
    static boolean[][] memory;
    private static void DFS(int x, int y) {
        if(visit[x][y]){    //한번 방문한곳 또 오면 무한루프이므로 리턴시킨다.
            memory[x][y] = false;
            visit[x][y] = false;
            return;
        }
        if(!(x >= 1 && y >= 1 && x <= N && y <= M) || memory[x][y]){ //경계를 벗어나거나 한번 지나온곳이면 count+1하고 리턴
            memory[x][y] = true;    //탈출했으므로 현재 위치 체크한다.
            count++;
            return;
        }
        //무한루프(visit), 탈출경로(memory) 모두 일단 true로 체크한다.
        visit[x][y] = true;
        memory[x][y] = true;
        if(miro[x][y] == 'U'){
            DFS(x-1,y);
            if (!memory[x-1][y]) memory[x][y] = false;  //리턴된 DFS가 false면 탈출에 실패한 것이므로 false로 체크한다.

        }else if(miro[x][y] == 'R'){
            DFS(x,y+1);
            if (!memory[x][y+1]) memory[x][y] = false;

        }else if(miro[x][y] == 'D'){
            DFS(x+1,y);
            if (!memory[x+1][y]) memory[x][y] = false;

        }else if(miro[x][y] == 'L'){
            DFS(x,y-1);
            if (!memory[x][y-1]) memory[x][y] = false;

        }
        visit[x][y] = false;   //각 스타트 지점마다 별도로 체크해야 하므로 탈출 성공여부와 상관없이 false로 풀어준다.
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visit = new boolean[N+2][M+2];  //무한루프인지 체크하는 배열
        memory = new boolean[N+2][M+2]; //탈출이 가능한 경로인지 체크하는 배열
        miro = new char[N+2][M+2];
        for (int i = 1; i <= N; i++) {
            String str = sc.next();
            for (int j = 1; j <= M; j++) {
                miro[i][j] = str.charAt(j-1);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                DFS(i,j);
//                visit = new boolean[N+2][M+2]; //시간을 생각보다 많이 잡아먹으므로 DFS에서 리턴하면서 false로 풀어주자
            }
        }
        System.out.println(count);
    }
}
