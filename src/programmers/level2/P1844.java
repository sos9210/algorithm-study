package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
class Position {
    int x,y,count;
    public Position (int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
public class P1844 {
    public static int solution(int[][] maps) {
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(0,0,1));
        int min = Integer.MAX_VALUE;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        while(!q.isEmpty()){
            Position p = q.poll();
            if(p.count > min) continue;
            if(p.x == maps.length-1 && p.y == maps[0].length-1){
                min = Math.min(p.count,min);
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length || visit[nx][ny] || maps[nx][ny] == 0){
                    continue;
                }
                visit[nx][ny] = true;
                q.offer(new Position(nx,ny, p.count+1));
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
    //dfs는 시간복잡도에서 실패함.
    /*
    static int min = Integer.MAX_VALUE;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visit;
    public static int solution(int[][] maps) {
        visit = new boolean[maps.length][maps[0].length];
        dfs(maps,0,0,0);
        if(min == Integer.MAX_VALUE) return -1;
        return min+1;
    }
    public static void dfs(int[][] maps, int count, int x, int y){
        if(count > min){
            return;
        }
        if(x == maps.length-1 && y == maps[0].length-1){
            min = Math.min(count,min);
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length || visit[nx][ny] || maps[nx][ny] == 0){
                continue;
            }
            visit[nx][ny] = true;
            dfs(maps,count+1,nx,ny);
            visit[nx][ny] = false;
        }
    }
    */
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1}, {1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
        //System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }
}
