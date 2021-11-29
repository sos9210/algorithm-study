package sec01;

public class Sec01_10 {
    public static String solution(String str,char c){
        int[] answer = new int[str.length()];
        int p = 1000;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c){
                p=0;
            }else{
                p++;
            }
            answer[i]=p;
        }
        p = 1000;
        for (int i = str.length()-1; i>=0; i--) {
            if(str.charAt(i) == c){
                p=0;
            }else{
                p++;
                answer[i] = Integer.min(answer[i],p);
            }
        }

        String ans = "";
        for (int i = 0; i < answer.length; i++) {
            ans += String.valueOf(answer[i]);
            if(!(i==answer.length-1)){
                ans+=" ";
            }
        }
        return ans;
    }
}
