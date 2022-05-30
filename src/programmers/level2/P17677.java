package programmers.level2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P17677 {
    /*
    예를 들어 "ab+"가 입력으로 들어오면, "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.
    따라서 처음부터
    String s1 = str1.toUpperCase().replaceAll(" ","").replaceAll("[^A-Z]*","");
    String s2 = str2.toUpperCase().replaceAll(" ","").replaceAll("[^A-Z]*","");
    이런식으로 replace하는건 틀린방법이다.

    문제를 잘 확인하자.
     */
    public static int solution(String str1, String str2) {
        String s1 = str1.toUpperCase();
        String s2 = str2.toUpperCase();
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();

        if(s1.equals(s2)) return 65536;
        int totalCnt = 0;

        Pattern p = Pattern.compile("[^A-Za-z]");
        Matcher m = null;
        for (int i = 0; i <= s1.length()-2; i++) {
            String key = s1.substring(i, i+2);
            m = p.matcher(key);
            if(m.find()) continue;
            map1.put(key, map1.getOrDefault(key, 0) + 1);
            totalCnt++;
        }
        for (int i = 0; i <= s2.length()-2; i++) {
            String key = s2.substring(i, i+2);
            m = p.matcher(key);
            if(m.find()) continue;
            map2.put(key, map2.getOrDefault(key, 0) + 1);
            totalCnt++;
        }
        int interCnt = 0;
        for(String key : map1.keySet()){
            if(map2.get(key) == null) continue;
            interCnt += Math.min(map2.get(key), map1.get(key));
        }
        int unionCnt = totalCnt - interCnt;
        if(unionCnt == 0) return 65536;
        return interCnt*65536/unionCnt;
    }
    public static void main(String[] args) {
        System.out.println(solution("FRANCE","french"));
        System.out.println(solution("handshake","shake hands"));
        System.out.println(solution("aa1+aa2","AAAA12"));
        System.out.println(solution("E=M*C^2","e=m*c^2"));
    }
}
