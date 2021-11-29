package sec01;

public class Sec01_07 {
    public static String solution(String str){
        /* //내가구현
        String answer = "";

        StringBuilder sb = new StringBuilder();
        sb.append(str.toUpperCase());
        if(sb.toString().equals(sb.reverse().toString())){
            answer = "YES";
        }else{
            answer = "NO";
        }
        return answer;
         */
        /*//강의1번방법
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            if(str.charAt(i) != str.charAt(len-i-1)){
                answer = "NO";
                return answer;
            }
        }
        return answer;
        */

        //강의 2번방법
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)){
            answer = "YES";
        }
        return answer;
    }
}
