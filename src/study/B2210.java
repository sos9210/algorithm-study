package study;

import java.util.*;
class Board1 {
    int x,y,size;
    String digit;
    public Board1 (int x,int y, int size, String digit){
        this.x = x;
        this.y = y;
        this.size = size;
        this.digit = digit;
    }
}
public class B2210 {
    static String[][] board = new String[5][5];
    static int[] nx = {0,0,1,-1};
    static int[] ny = {1,-1,0,0};
    static int result = 0;
  //  static boolean visit[] = new boolean[999999];
    static Map<String,Boolean> visit = new HashMap<>();
    private static int BFS(int x, int y) {
        Queue<Board1> q = new LinkedList<>();
        q.offer(new Board1(x,y,1,board[x][y]));
        int size = 0;
        while(!q.isEmpty()){
            Board1 bd = q.poll();
            int dx = bd.x;
            int dy = bd.y;
            if(bd.size == 6){
                if(visit.get(bd.digit) == null){
                    size += 1;
                    visit.put(bd.digit,true);
                }
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = dx+nx[i];
                int nextY = dy+ny[i];
                if(nextX >= 0 && nextY >= 0 && nextX < 5 && nextY < 5 && visit.get(bd.digit+board[nextX][nextY]) == null){
                    q.offer(new Board1(nextX,nextY, bd.size+1, bd.digit+board[nextX][nextY]));
                }
            }
        }
        return size;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.next();
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result += BFS(i,j);
            }
        }

        System.out.println(result);
    }
}
