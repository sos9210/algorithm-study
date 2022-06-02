package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P42577 {
    public static boolean solution(String[] phone_book) {
        Map<String,Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i],i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123","456","789"}));
        //System.out.println(solution(new String[]{"12","123","1235","567","88"}));
    }
}
