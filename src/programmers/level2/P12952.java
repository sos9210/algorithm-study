package programmers.level2;

//N-queen
//https://moonsbeen.tistory.com/34
public class P12952 {
    static boolean[] visited;   //방문여부
    static int[] pick;          //뽑은 위치를 저장. 0번인덱스는 첫 번째 줄에서 퀸의 위치를 의미한다.
    static int count;           //방법의 수
    public static int solution(int n) {
        visited = new boolean[n];
        pick = new int[n];
        count = 0;

        permutation(n, 0);
        return count;
    }
    public static void permutation(int n, int idx) {
        if(n == idx) {
            count++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                pick[idx] = i;
                //이전에 뽑았던 퀸의 위치와 비교하여 뽑을 수 있는 위치라면
                if(check(idx)) permutation(n, idx + 1);
                visited[i] = false;
            }
        }
    }
    public static boolean check(int idx) {
        for(int i = 0; i < idx; i++) {
            if(pick[i] == pick[idx]) return false; //같은 행에 퀸이 존재하면 false
            if(Math.abs(idx - i) == Math.abs(pick[idx] - pick[i])) return false; //대각선에 퀸이 존재한다면 false
        }
        return true;
    }
    public static void main(String[] args) {
        //System.out.println(solution(4));
        System.out.println(solution(2));
    }
}
