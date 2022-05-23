package programmers.level1;

public class P82612 {
    public static long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += price * i;
        }
        answer = sum - money;
        return answer <= 0 ? 0 : answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(3,20,4));
    }
}
