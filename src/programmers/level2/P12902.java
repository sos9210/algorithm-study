package programmers.level2;

//DP
//https://gom20.tistory.com/m/180

public class P12902 {
    public static int solution(int n) {
        int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[1] = 2;
        dp[2] = 3;
        for(int i = 3; i <= n; i++){
            if(i%2 == 0){
                //짝수
                dp[i] = dp[i-1]%mod + dp[i-2]%mod;
            } else {
                // 홀수
                dp[i] = dp[i-1]*2%mod + dp[i-2]%mod;
            }
            dp[i] = dp[i]%mod;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
