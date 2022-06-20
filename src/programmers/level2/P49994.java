package programmers.level2;
//방문 길이
public class P49994 {
    public static int solution(String dirs) {
        int[][] map = new int[11][11];                  //지도
        boolean[][][] visit = new boolean[4][11][11];   //방문체크

        //방향
        int[] nx = {-1,0,1,0};
        int[] ny = {0,-1,0,1};
        int answer = 0;
        int x = 5;
        int y = 5;
        for (int i = 0; i < dirs.length(); i++) {
            int dir = 0;
            char command = dirs.charAt(i);
            if(command == 'U') dir = 0;
            else if(command == 'L') dir = 1;
            else if(command == 'D') dir = 2;
            else if(command == 'R') dir = 3;

            int dx = x + nx[dir];
            int dy = y + ny[dir];
            //map크기를 벗어나면 continue
            if(dx < 0 || dy < 0 || dx >= 11 || dy >= 11) continue;
            //방문한적 없는 길이라면
            if(!visit[dir][dx][dy]){
                //해당길 방문 체크
                visit[dir][dx][dy] = true;
                dir = (dir%2 == 0) ? 2-dir : 4-dir;
                //반대방향도 방문체크해준다. (방문한적없는길 이므로 양방향 체크)
                visit[dir][x][y] = true;
                answer++;
            }
            x = dx;
            y = dy;
        }

        return answer;
    }
    public static void move(int x, int y, char command){

    }
    public static void main(String[] args) {
        //System.out.println(solution("ULURRDLLU"));
        //System.out.println(solution("LULLLLLLU"));
        System.out.println(solution("UDU"));
        //System.out.println(solution("UUUUUUUUU"));
        //System.out.println(solution("RRRRRRRRR"));
    }
}
