package programmers.level2;

import java.util.*;

//숫자블록
public class P12923 {
    static int max = 10000000;//배열에 들어갈 수 있는 최댓값

    public static int findMinority(int num){ //소수찾기 함수
        if(num==1){ return 0; } //1은 소수가 x

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0&&(num/i)<=max){
                return num/i;
            }
        }
        return 1; //1과 자기자신을 제외하고 소수가 없을 경우 1
    }
    public static int[] solution(long begin, long end) {
        //매개변수로 주어진 begin과 end의 최대범위가 int범위 안쪽이므로 굳이 long타입일 필요는 없을듯..
        int s = (int)begin, e = (int)end;//int 형변환

        int[] answer = new int[e-s+1];

        for(int i=s; i<=end; i++){
            answer[i-s] = findMinority(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        Arrays.stream(solution(1, 10)).forEach(v -> System.out.print(v+" "));
        //Arrays.stream(solution(4, 10)).forEach(v -> System.out.print(v+" "));
    }
}
