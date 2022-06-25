package programmers.level2;

public class P12911 {
    public static int solution(int n) {
        int answer = n;
        String s1 = Integer.toString(n,2);
        int nOne = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == '1'){
                nOne++;
            }
        }
        while(true){
            String s2 = Integer.toString(++answer, 2);
            int answerOne = 0;
            for (int i = 0; i < s2.length(); i++) {
                if(s2.charAt(i) == '1'){
                    answerOne++;
                }
            }
            if(answerOne == nOne) break;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(78));
    }
}
