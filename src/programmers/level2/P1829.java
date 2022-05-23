package programmers.level2;

import java.util.*;

public class P1829 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = Integer.MIN_VALUE;
        boolean[][] check = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //탐색영역은 이미 체크된영역이 아니어야하고 0인 영역은 제외한다.
                if(!check[i][j] && picture[i][j] != 0){
                    check[i][j] = true;     //탐색영역 체크
                    numberOfArea++;         //영역갯수 카운트
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,search(i,j,m,n,picture,check));
                }
            }
        }
        int[] answer = new int[2];

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static int search(int x, int y,int m, int n, int[][] picture, boolean[][] check){
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            x = poll[0];
            y = poll[1];
            for (int k = 0; k < 4; k++) {
                int nextX = dx[k] + x;
                int nextY = dy[k] + y;
                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && picture[x][y] != 0 && picture[nextX][nextY] == picture[x][y] && !check[nextX][nextY]) {
                    check[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                    ++count;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] solution = solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        Arrays.stream(solution).forEach(v -> System.out.print(v + " "));
    }
}
