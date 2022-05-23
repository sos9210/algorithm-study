package programmers.level1;

public class P12916 {
    static boolean solution(String s) {
        s = s.toLowerCase();
        char[] c = s.toCharArray();
        int p = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            if(c[i] == 'p') ++p;
            if(c[i] == 'y') ++y;
        }
        if(p == y) return true;
        else return false;
    }
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
    }
}
