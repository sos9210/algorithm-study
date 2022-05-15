package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P92334 {
    public static int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        Map<String,Integer> reportMap = new HashMap<>();
        Map<String,Integer> userMap = new HashMap<>();
        for(String str : id_list){
            userMap.put(str,0);
        }
        String[] objects = Arrays.stream(report).distinct().toArray(String[]::new);

        for (String str:objects) {
            String[] split = str.split(" ");
            reportMap.put(split[1],reportMap.getOrDefault(split[1],0)+1);
        }
        for (String str:objects){
            String[] split = str.split(" ");
            if(reportMap.get(split[1]) >= k){
                userMap.put(split[0],userMap.getOrDefault(split[0],0)+1);
            }
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = userMap.get(id_list[i]);
        }

        return answer;
    }
    public static void main(String[] args) {
 //       int[] result = solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},2);
        int[] result = solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},3);
        for (int i:result) {
            System.out.print(i + " ");
        }
    }
}
