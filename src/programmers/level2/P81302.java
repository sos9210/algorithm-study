package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Person{
    int x,y,moveCount,beforeX,beforeY;
    public Person(int x, int y,int beforeX, int beforeY, int moveCount){
        this.x = x;
        this.y = y;
        this.beforeX = beforeX;
        this.beforeY = beforeY;
        this.moveCount = moveCount;
    }
}

public class P81302 {
    static int[] answer;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static int[] solution(String[][] places) {
        answer = new int[places.length];
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < places.length; i++) {
            q.clear();
            String[][] map = new String[places.length][places.length];
            for (int j = 0; j < places.length; j++) {
                String str = places[i][j];
                for (int k = 0; k < str.length(); k++) {
                    map[j][k] = String.valueOf(str.charAt(k));
                    if(str.charAt(k) == 'P')q.offer(new Person(j,k,1000,1000,0));
                }
            }
            bfs(i,q,map);
        }
        return answer;
    }
    public static void bfs(int idx,Queue<Person> q, String[][] map){
        if(idx == 1){
            System.out.println();
        }
        if(q.size() == 0) answer[idx] = 0;
        int result = 1;
        while(!q.isEmpty()){
            Person p = q.poll();
            if(p.moveCount > 2){    //이동횟수가 2번초과면?
                continue;
            }
            if(p.moveCount > 0 && map[p.x][p.y].equals("P")) {
                result = 0;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == p.beforeX && ny == p.beforeY) ||map[nx][ny].equals("X")){
                    continue;
                }
                q.offer(new Person(nx,ny,p.x,p.y,p.moveCount+1));
            }
        }
        answer[idx] = result;
    }
    public static void main(String[] args) {
//        Arrays.stream(solution(new String[][]{
//                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
//                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
//                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
//                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
//                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
//        })).forEach(v -> System.out.print(v +" "));
        Arrays.stream(solution(new String[][]{
                {"POPOP",
                 "XXXXX",
                 "OPXPX",
                 "OOXOX",
                 "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        })).forEach(v -> System.out.print(v +" "));
    }
}
