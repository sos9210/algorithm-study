package sec01;

import java.util.ArrayList;

public class Sec01_04 {
    public static ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        /*
        for (String x: str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        */
        for (String x: str) {
            char[] s = x.toCharArray();
            int lt=0, rt=x.length()-1;
            while (lt<rt){
                char tmp=s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp=String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }
}
