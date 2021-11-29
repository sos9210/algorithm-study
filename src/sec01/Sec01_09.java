package sec01;

public class Sec01_09 {
    public static int solution(String str){
        /* //내가푼것
        int answer = 0;
        str = str.replaceAll("[^0-9]","");
        answer = Integer.valueOf(str);
        System.out.println(answer);
        return answer;
         */
        /*
        //강의 1번방법
        int answer = 0;
        for (char x : str.toCharArray()) {
            //문자열 '0'=48  , '9' = 57
            if(x >= 48 && x <= 57){
                answer = answer * 10 + (x - 48);
            }
        }
        return answer;
        */
        // 강의 2번방법
        String answer = "";
        for (char x : str.toCharArray()) {
            //숫자인지 여부
            if(Character.isDigit(x)){
                answer+=x;
            }
        }
        return Integer.parseInt(answer);
    }
}
