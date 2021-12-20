package sec04;

import java.util.*;

public class Sec04_04 {
    public int solution(String s, String t){
        int answer = 0;
        Map<Character,Integer> maps = new HashMap<>();
        Map<Character,Integer> mapt = new HashMap<>();
        for (char x:t.toCharArray()) {
            maps.put(x,maps.getOrDefault(x,0)+1);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < t.length()-1; i++) {
            mapt.put(chars[i],mapt.getOrDefault(chars[i],0)+1);
        }
        int lt = 0;
        for (int rt = t.length()-1; rt < s.length(); rt++) {
            mapt.put(chars[rt],mapt.getOrDefault(chars[rt],0)+1);
            if(mapt.equals(maps)){
                ++answer;
            }
            mapt.put(chars[lt], mapt.get(chars[lt])-1);
            if(mapt.get(chars[lt]) == 0){
                mapt.remove(chars[lt]);
            }
            ++lt;
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        Sec04_04 T = new Sec04_04();
        System.out.println(T.solution(s,t));
        return ;
    }
}
