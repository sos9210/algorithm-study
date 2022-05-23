package programmers.level2;

public class P62048 {
    public static long solution(long w, long h) {
        long answer = 1;
        long max = 0;

        long wh = w > h ? w : h;
        for (long i = 1; i <= wh; i++) {
            if(w % i == 0 && h % i == 0){
                max = Math.max(max,i);
            }
        }
        //가로 * 세로 - (가로+세로-최대공약수) = 사용할 수 있는 정사각형 갯수
        answer = w * h-(w+h-max);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(9,6));
    }
}
