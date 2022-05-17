package programmers;

public class P12922 {
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < n+2; i++) {
            if(i%2 == 0) sb.append("수");
            else if(i%2 != 0) sb.append("박");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
