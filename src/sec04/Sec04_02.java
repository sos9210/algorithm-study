package sec04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sec04_02 {
    public String solution(String str1, String str2){
    /*  //내가푼것
        String answer = "YES";
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char x: str1.toCharArray()) {
            map1.put(x,map1.getOrDefault(x,0)+1);
        }
        for (char x: str2.toCharArray()) {
            map2.put(x,map2.getOrDefault(x,0)+1);
        }
        for (char x:map1.keySet()) {
            if(!(map1.get(x) == map2.get(x))){
                answer = "NO";
            }
        }
        return answer;
     */
        //강의
        String answer = "YES";
        HashMap<Character,Integer> map = new HashMap<>();
        for (char x: str1.toCharArray()) {
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for (char x: str2.toCharArray()) {
            if(!map.containsKey(x) || map.get(x)==0){
                return "NO";
            }
            map.put(x,map.get(x)-1);
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        String input2 = in.nextLine();
        Sec04_02 T = new Sec04_02();
        System.out.println(T.solution(input1,input2));
        return ;
    }
}
