package programmers.level2;

import java.util.Arrays;

public class P42577 {
    public static boolean solution(String[] phone_book) {
        String text = String.format(" %s", String.join(" ", phone_book));
        
        for (int i = 0; i < phone_book.length; i++) {
            if(text.split(String.format(" %s", phone_book[i])).length > 2){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        //System.out.println(solution(new String[]{"123","456","789"}));
        System.out.println(solution(new String[]{"12","123","1235","567","88"}));
    }
}
