package programmers.level2;

//멀리뛰기
//DP
public class P12914 {
    public static long solution(int n) {
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<2001; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(3));
    }
}
