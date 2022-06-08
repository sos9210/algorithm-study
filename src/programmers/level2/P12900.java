package programmers.level2;

//2 x n 타일링
class Tile {
    int x,y;
    public Tile (int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class P12900 {
    static int[][] floor;
    public static int solution(int n) {
        int answer = 0;
        floor = new int[n][2]; //가로세로
        dfs(2*n,0,0);
        return answer;
    }
    public static void dfs(int width, int x, int y){
        if(width == x * y){
            
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
