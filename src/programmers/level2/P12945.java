package programmers.level2;

//피보나치 수
public class P12945 {
    public static int solution(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1; arr[2] = 1;

        for (int i = 1; i < n; i++) {
            //n이 최대 100000이기 때문에 int범위가 초과되니 for문이 돌때마다 %1234567을 계산해준다.
            arr[i+1] = (arr[i-1] + arr[i])%1234567;
        }

        return arr[n];
    }
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(5));
        System.out.println(solution(7));
        System.out.println(solution(100000));
    }
}
