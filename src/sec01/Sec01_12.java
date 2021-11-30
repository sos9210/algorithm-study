package sec01;

public class Sec01_12 {
    public static String solution(int n, String str){
        /*//내가한것
        String answer = "";
        String tmp = "";
        int cnt = 7;
        for (int i = 0; i < n; ++i) {
            tmp = "";
            for(int j=cnt-7; j < cnt; ++j){
                if(str.charAt(j) == "#".charAt(0))
                    tmp += "1";
                if(str.charAt(j) == "*".charAt(0))
                    tmp += "0";
           }
            cnt+=7;
            int parse = Integer.parseInt(tmp,2);
            answer += (char)parse;
        }
        return answer;
         */
        //강의
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = str.substring(0,7).replace("#","1").replace("*","0");
            int num = Integer.parseInt(tmp,2);
            str = str.substring(7);
            answer += (char)num;
        }
        return answer;
    }
}
