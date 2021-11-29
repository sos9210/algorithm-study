package sec01;

public class Sec01_02 {
    public static String solution(String str) {
        char[] data = new char[str.toCharArray().length];
/* //내가 푼것
        int cnt = 0;
        for (Character c :str.toCharArray()) {
            char v = c;
            if(Character.isUpperCase(c)){
                v = Character.toLowerCase(c);
            }
            if(Character.isLowerCase(c)){
                v = Character.toUpperCase(c);
            }
            data[cnt] = v;
            ++cnt;
        }
        str = new String(data);
        return str;
*/
        String answer = "";
        for (Character c :str.toCharArray()) {
            if(Character.isUpperCase(c)){
                answer+=Character.toLowerCase(c);
            }
            if(Character.isLowerCase(c)){
                answer+=Character.toUpperCase(c);
            }
        }
        return answer;
    }
}
