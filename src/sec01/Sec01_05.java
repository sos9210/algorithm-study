package sec01;

public class Sec01_05 {
    public static String solution(String str){
        String answer = "";
        int lt = 0;
        int rt = str.toCharArray().length-1;
        char[] ch = str.toCharArray();
        while (lt < rt) {
            if(!Character.isAlphabetic(ch[lt])){//알파벳이 아니면?
                lt++;
            }
            else if(!Character.isAlphabetic(ch[rt])){//알파벳이 아니면?
                rt--;
            }
            else{
                char tmp = ch[lt];
                ch[lt] = ch[rt];
                ch[rt] = tmp;
                ++lt;
                --rt;
            }
        }
        answer = String.valueOf(ch);
        return answer;
    }
}
