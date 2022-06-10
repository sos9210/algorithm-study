package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class P42578 {
    public static int solution(String[][] clothes) {
        int answer = 1; //처음에 1로시작
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],1)+1); //옷종류를 키, 값을 기본1로 하고 +1해준다.
        }
        for (String key : map.keySet()) {
            answer *= map.get(key);
        }
        return answer-1;
    }
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}
