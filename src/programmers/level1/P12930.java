package programmers.level1;

import java.util.Locale;

public class P12930 {
    public static String solution(String s) {
        /*  //이방법이 더 깔끔해보이고 성능도 좋다..
        char[] chars = s.toCharArray();
        int idx = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                idx = 0;
            else
                chars[i] = (idx++ % 2 == 0 ? Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]));
        }

        return String.valueOf(chars);
        */
        String[] s1 = s.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s1[i].length(); j++) {
                if(j == 0 || j % 2 == 0) sb.append(s1[i].toUpperCase().charAt(j));
                else sb.append(s1[i].toLowerCase().charAt(j));
            }
            if(i != s1.length-1)sb.append(" ");
        }
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == ' '){
                sb.append(" ");
            }else break;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution(" AD BD cS DA EG  "));
    }
}
