package programmers.level2;

//최댓값과 최솟값
public class P12939 {
    public static String solution(String s) {
        String answer = "";
        String[] s1 = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s1.length; i++) {
            max = Math.max(Integer.parseInt(s1[i]),max);
            min = Math.min(Integer.parseInt(s1[i]),min);
        }
        answer = min+" "+max;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
    }
}
