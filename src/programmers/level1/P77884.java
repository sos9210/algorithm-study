package programmers.level1;

public class P77884 {
    public static int solution(int left, int right) {
        int answer = 0;
        /*
        for (int i = left; i <= right; i++) {
            int divisor = 0;
            for (int j = 1; j <= i; j++) {
                if(i % j == 0){
                    ++divisor;
                }
            }
            if(divisor % 2 == 0){ //약수의 갯수가 짝수
                answer+=i;
            }else{ //약수의 갯수가 홀수
                answer-=i;
            }
        }
         */
        for (int i = left; i <= right; i++) {
            //제곱수인 경우 약수의 개수가 홀수 ***
            if( i % Math.sqrt(i) == 0){ // Math.sqrt(double) 제곱근을 반환한다.. 25인자 -> 5반환
                answer -= i;
            }else{//제곱수가 아닌 경우 약수의 개수가 짝수 ***
                answer += i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
//        System.out.println(solution(13,17));
        System.out.println(solution(24,27));
    }
}
