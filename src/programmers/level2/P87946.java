package programmers.level2;

//dfs백트래킹 풀이
//피로도
public class P87946 {
    static boolean[] visit;
    static int answer = 1;
    public static int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        dfs(k,dungeons,0);
        return answer;
    }
    public static void dfs(int k, int[][] dungeons, int count) {
        answer = Math.max(count,answer);
        for (int i = 0; i < dungeons.length; i++) {
            if(k >= dungeons[i][0] && !visit[i]){
                visit[i] = true;
                dfs(k-dungeons[i][1],dungeons,count+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(solution(80,new int[][]{{80,20},{50,40},{30,10}}));
    }
}
