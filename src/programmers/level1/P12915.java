package programmers.level1;

import java.util.Arrays;

class Strings implements Comparable<Strings>{
    String str;
    int n;
    public Strings(String str, int n){
        this.str = str;
        this.n = n;
    }

    @Override
    public int compareTo(Strings o) {
        if(str.toCharArray()[n] != o.str.toCharArray()[n]) return str.toCharArray()[n] - o.str.toCharArray()[n];
        for (int i = 0; i < Math.max(o.str.length(),str.length()); i++) {
            if(str.toCharArray()[i] != o.str.toCharArray()[i]){
                return str.toCharArray()[i] - o.str.toCharArray()[i];
            }
        }
        return 0;
    }
}
public class P12915 {
    public static String[] solution(String[] strings, int n) {
        Strings[] stri = new Strings[strings.length];
        for (int i = 0; i < strings.length; i++) {
            stri[i] = new Strings(strings[i],n);
        }
        Arrays.sort(stri);
        String[] answer = new String[strings.length];
        for (int i = 0; i < stri.length; i++) {
            answer[i] = stri[i].str;
        }
        return answer;
    }
    public static void main(String[] args) {
        for (String str:solution(new String[]{"abce", "abcd", "cdx"},2)) {
            System.out.println(str+" ");
        }
    }
}
