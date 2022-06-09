package programmers.level2;

//2 x n 타일링 (DP)
public class P12900 {
    //https://deveric.tistory.com/61
    //피보나치 수열과 같은 원리다.
    public static int solution(int n) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < n - 1; i++) {
            // 숫자가 너무 커지는 것을 방지하기 위해 나머지를 구한다.
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
