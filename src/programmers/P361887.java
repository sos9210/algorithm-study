package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P361887 {
    public static void main(String[] args) {
/*        String s = "Zbcdefg";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(chars[i]);
        }

        System.out.println(sb.reverse().toString());*/
        int[] numbers = {1,2,3,4,6,7,8,0};
        Map<Integer,Integer> map = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i],numbers[i]);
        }
        for (int i = 0; i <= 9; i++) {
            if(map.get(i)==null){
                answer += i;
            }
        }
    }
}
