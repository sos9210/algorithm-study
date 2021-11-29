package sec01;

public class Sec01_08 {
    public static String solution(String str){
        String answer = "NO";
                                                //A부터Z가 아닌것
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)){
            answer = "YES";
        }
        return answer;
    }
}
