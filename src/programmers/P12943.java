package programmers;

public class P12943 {
    public static int solution(int num) {
        int answer = 0;
        while (num > 1) {
            answer++;
            if(answer == 500) break;
            if(num % 2 == 0){
                num = num / 2;
            }else{
                num = num * 3 + 1;
            }
        }
        return answer == 500 || num < 0 ? -1 : answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(626331));
    }
}
