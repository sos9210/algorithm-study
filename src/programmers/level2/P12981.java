package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//영어 끝말잇기
public class P12981 {
    public static int[] solution(int n, String[] words) {
        Map<String,Boolean> map = new HashMap<>();
        int idx = 0;    //words배열 인덱스
        char beforeChar = words[0].charAt(0);   //전 단어의 끝 문자
        int cycle = 1;  //싸이클수
        //n명의 사람이 한바퀴도는것을 싸이클로 지정
        while(true){
            for (int i = 1; i <= n && idx < words.length; i++) {

                //이미 한번 map에 저장된 단어거나 전 단어의 끝문자와 현재 단어의 첫문자가 일치하지 않는경우 return한다
                if(map.getOrDefault(words[idx],false) || beforeChar != words[idx].charAt(0)){
                    return new int[]{i,cycle};
                }
                //끝말잇기에 이상이 없으면 해당문자를 map에 저장
                map.put(words[idx],true);
                //현재단어의 끝문자를 beforeChar에 저장
                beforeChar = words[idx].charAt(words[idx].length()-1);
                idx++;
            }
            //idx가 words배열보다 같거나커지면 반복문 탈출
            if(idx >= words.length) break;
            cycle++;
        }

        //아무도 틀리지않았으면 0,0반환
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        Arrays.stream(solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})).forEach(v -> System.out.print(v+" "));
        Arrays.stream(solution(5,new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})).forEach(v -> System.out.print(v+" "));
        Arrays.stream(solution(2,new String[]{"hello", "one", "even", "never", "now", "world", "draw"})).forEach(v -> System.out.print(v+" "));
    }
}
