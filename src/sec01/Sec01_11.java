package sec01;

public class Sec01_11 {
    public static String solution(String str){
         //내가푼것
        String answer = "";
        int cnt = 1;
        for (int i=0; str.length() > i; ++i) {
            if(i != str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                cnt += 1;
            }else{
                answer += String.valueOf(str.charAt(i));
                if(cnt > 1){
                    answer += String.valueOf(cnt);
                }
                cnt = 1;
            }
        }
        return answer;
         /*
        //강의코드
        String answer = "";
        str=str+" ";
        int cnt=1;
        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i)==str.charAt(i+1)){
                cnt++;
            }else{
                answer+=str.charAt(i);
                if(cnt>1){
                    answer+=String.valueOf(cnt);
                }
                cnt=1;
            }

        }
        return answer;
        */
    }
}
