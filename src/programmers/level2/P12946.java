package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

//https://shoark7.github.io/programming/algorithm/tower-of-hanoi
//https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%95%98%EB%85%B8%EC%9D%B4%EC%9D%98-%ED%83%91-Java
//하노이의 탑
public class P12946 {
    static ArrayList<int[]> seq;
    public static int[][] solution(int n) {
        seq = new ArrayList<>();

        dfs(n, 1, 3, 2);

        int[][] answer = new int[seq.size()][2];
        for(int i = 0 ; i < seq.size() ; ++i){
            int[] cmd = seq.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];
        }


        return answer;
    }

    public static void dfs(int n, int from, int to, int via){
        int[] move = {from, to};

        if(n == 1) {
            seq.add(move);
        } else {
            //시작점에서 경유지
            dfs(n - 1, from, via, to);
            seq.add(move);
            //경유지에서 도착점
            dfs(n - 1, via, to, from);
        }
    }

    public static void main(String[] args) {
/*        Arrays.stream(solution(2)).forEach(v -> {
            Arrays.stream(v).forEach(s -> System.out.print(s+" "));
            System.out.println();
        } );*/
        Arrays.stream(solution(3)).forEach(v -> {
            Arrays.stream(v).forEach(s -> System.out.print(s+" "));
            System.out.println();
        } );
    }
}
