package programmers.level2;

//모음사전
public class P84512 {
    public static int solution(String word) {
        int answer = 0;
        //A E I O U .. 5개
        //최대 5자리니까 총 5+25+125+625+3125 = 3905개의 경우의 수가 나온다.
        int total= 3905;
        String aeiou="AEIOU";
        for(String str: word.split("")){
            //781, 156, 31, 6, 1
            total/= 5;
            answer+= total*aeiou.indexOf(str)+1;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
    }
}
