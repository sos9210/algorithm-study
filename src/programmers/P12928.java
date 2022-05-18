package programmers;

public class P12928 {
    public static int solution(int n) {
        int answer = n;

        for (int i = 1; i <= n/2; i++) {
            if(n % i == 0){
                answer += i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(12));
    }
}
