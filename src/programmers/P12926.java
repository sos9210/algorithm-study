package programmers;

public class P12926 {
    public static String solution(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String str = Character.toString(chars[i] + n - 26);
            if('a' <= chars[i] && 'z' >= chars[i] && !Character.isSpaceChar(chars[i])){
                if ('z' < chars[i]+n) {
                    sb.append(str);
                    continue;
                }
            }else if('A' <= chars[i] && 'Z'
                    >= chars[i] && !Character.isSpaceChar(chars[i])){
                if ('Z' < chars[i]+n) {
                    sb.append(str);
                    continue;
                }
            }
            if (Character.isSpaceChar(chars[i])){
                sb.append(" ");
             }else{
                sb.append(Character.toString(chars[i]+n));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
       // System.out.println(solution("A B CDEFGHIZKLMNOPQRSTUVWX Y Z",25));
        System.out.println(solution("z",1));
    }
}
