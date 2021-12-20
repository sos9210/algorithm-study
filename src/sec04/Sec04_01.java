package sec04;

import java.util.HashMap;
import java.util.Scanner;

public class Sec04_01 {
    public String solution(int cnt, String s){
        String answer = "";
        HashMap<Character,Integer> map = new HashMap<>();
        for (char x: s.toCharArray()) {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int max = Integer.MIN_VALUE;
        for (char key: map.keySet()) {
            if(map.get(key) > max){
                max=map.get(key);
                answer = String.valueOf(key);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        Sec04_01 T = new Sec04_01();
        System.out.println(T.solution(n,str));
        return ;
    }
}
