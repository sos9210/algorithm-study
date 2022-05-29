package programmers.level2;

import java.util.*;

public class P17677 {
    public static int solution(String str1, String str2) {
        String s1 = str1.toUpperCase().replaceAll(" ","").replaceAll("[^A-Z]*","");
        String s2 = str2.toUpperCase().replaceAll(" ","").replaceAll("[^A-Z]*","");
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();

        if(s1.equals(s2)) return 65536;

        for (int i = 0; i < s1.length()-1; i++) {
            map1.put(s1.substring(i,i+2),map1.getOrDefault(s1.substring(i,i+2),0)+1);
        }
        for (int i = 0; i < s2.length()-1; i++) {
            map2.put(s2.substring(i,i+2),map2.getOrDefault(s2.substring(i,i+2),0)+1);
        }
        for (String str : map1.keySet()) {
            if(map2.get(str) != null && map2.get(str) != 0)
            map2.put(str,map2.get(str)-1);
        }
        return 1;
    }
    public static void main(String[] args) {
        //System.out.println(solution("FRANCE","french"));
        System.out.println(solution("handshake","shake hands"));
        //System.out.println(solution("E=M*C^2","e=m*c^2"));
    }
}
