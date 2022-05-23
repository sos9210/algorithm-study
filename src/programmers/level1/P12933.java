package programmers.level1;

import java.util.Arrays;

public class P12933 {
    public static long solution(long n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        Long answer = Long.valueOf(sb.toString());
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }
}
