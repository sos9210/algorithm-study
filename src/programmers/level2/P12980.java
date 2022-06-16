package programmers.level2;

//점프와 순간이동
public class P12980 {
    public static int solution(int n) {
        //N이 0이 될 때까지
        //N이 짝수라면 반을 나누고 N / 2 (순간이동)
        //N이 홀수라면 -1을 빼며 (점프)
        int ans = 0;
        while(n != 0) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }
}
