package study;

import java.util.*;
//DFS
public class B2667_DFS {
    static int size;
    static int[][] map;
    static int[][] visit;
    static int[] dx =  {0,0,1,-1};
    static int[] dy =  {1,-1,0,0};
    static List<Integer> arr = new ArrayList<>();
    public int solution(int x, int y,int count){
        visit[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;
            //다음x좌표와 y좌표가 0이상이고 map size미만이어야 하고 아파트가있는 좌표여야하고 방문한적이 없어야한다.
            if(nextX < size && nextX >= 0 && nextY < size && nextY >= 0 && map[nextX][nextY] == 1 && visit[nextX][nextY] == 0){
                count = solution(nextX,nextY,count+1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        map = new int[size][size];
        visit = new int[size][size];

        for (int i = 0; i < size; i++) {
            String tmp = sc.next();
            for (int j = 0; j < size; j++) {
                int num = Integer.parseInt(String.valueOf(tmp.toCharArray()[j]));
                map[i][j] = num;
            }
        }
        B2667_DFS T = new B2667_DFS();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int total = 0;
                //아파트가 있고 방문한적이없는곳
                if(map[i][j] == 1 && visit[i][j] == 0){
                    total = T.solution(i,j,1);
                }
                if(total!=0){
                    arr.add(total);
                }
            }
        }
        Collections.sort(arr);
        System.out.println(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

    }
}
