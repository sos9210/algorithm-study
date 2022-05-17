package programmers;

public class P12919 {
    public static String solution(String[] seoul) {
        String answer = "";
        for (int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")){
                return "김서방은 "+i+"에 있다";
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "Kim"}));
    }
}
