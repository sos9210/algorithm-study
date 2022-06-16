package programmers.level2;

import java.util.Arrays;
//이진변환
//toBinaryString() 활용
public class P70129 {
    public static int[] solution(String s) {
        int[] answer = new int[2];
        int changeCount = 0;
        int zeroCount = 0;
        while(true){
            int sLength = s.length(); //현재 문자의 길이
            s = s.replaceAll("0","");   //0 제거
            int c = s.length();                     //0이 제거된 문자의 길이
            ++changeCount;                          //이진변환 카운트
            zeroCount+= sLength-c;                  //제거된 0 개수 카운트
            if(c == 1) break;                       //문자가 1만 남으면 반복문 탈출
            s = Integer.toBinaryString(c);          //이진변환
        }
        answer[0] = changeCount;
        answer[1] = zeroCount;
        return answer;
    }
    public static void main(String[] args) {
        Arrays.stream(solution("110010101001")).forEach(v -> System.out.print(v+" "));
        Arrays.stream(solution("01110")).forEach(v -> System.out.print(v+" "));
    }
}
