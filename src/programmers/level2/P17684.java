package programmers.level2;

import java.util.*;

public class P17684 {
    public static int[] solution(String msg) {
        //사전
        Map<String,Integer> dictionary = new HashMap<>();

        //색인번호목록
        List<Integer> list = new ArrayList<>();

        //사전에 A-Z까지를 key, 1-26까지 값으로 넣는다.
        for (int i = 1; i <= 26; i++) {
            dictionary.put(String.valueOf((char)(64+i)),i);
        }


        for (int i = 0; i < msg.length(); i++) {
            for (int j = i+1; j <= msg.length(); j++) {
                //해당하는 msg의 인덱스번호 i부터j까지의 문자가 사전에 없으면
                if(dictionary.get(msg.substring(i,j)) == null){
                    //i부터j까지의 문자는 사전에 있으므로 해당 값을 찾아서 색인번호목록에 넣는다.
                    list.add(dictionary.get(msg.substring(i,j-1)));

                    //새로운 사전을 추가한다
                    dictionary.put(msg.substring(i,j),dictionary.size()+1); 
                    i = j-2;
                    break;
                }

                //j가 마지막까지 도달하면 이중루프 완전탈출
                if(j == msg.length()){
                    list.add(dictionary.get(msg.substring(i,j)));
                    i = msg.length();
                    break;
                }
            }
        }

        //List -> int[] 변환
        Integer[] integers = list.toArray(new Integer[0]);
        int[] answer = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            answer[i] = integers[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        Arrays.stream(solution("KAKAO")).forEach(v -> System.out.print(v+" "));
        System.out.println();
        Arrays.stream(solution("TOBEORNOTTOBEORTOBEORNOT")).forEach(v -> System.out.print(v+" "));
        System.out.println();
        Arrays.stream(solution("ABABABABABABABAB")).forEach(v -> System.out.print(v+" "));
    }
}
