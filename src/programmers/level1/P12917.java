package programmers.level1;

import java.util.Arrays;

public class P12917 {
    public static String solution(String s) {
        //속도는 이중for문이 더 괜찮게나옴.
/*        String answer = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(chars[i] < chars[j]){
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                }
            }
        }
        return String.valueOf(chars);*/
        char[] sol = s.toCharArray();
        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }
}
