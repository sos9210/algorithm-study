package programmers.level2;

//JadenCase 문자열 만들기
public class P12951 {
    public static String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            if(s1[i].equals("")) {
                sb.append(" ");
                continue;
            }
            if(s1[i].charAt(0) >= 'a' && s1[i].charAt(0) <= 'z'){
                sb.append(s1[i].substring(0,1).toUpperCase());
                sb.append(s1[i].substring(1,s1[i].length()));
            }else{
                sb.append(s1[i].substring(0,s1[i].length()));
            }
            if(i != s1.length-1)sb.append(" ");
        }
        int length = sb.toString().length();
        if(length != s.length()){
            for (int i = 0; i < s.length()-length; i++) {
                sb.append(" ");
            }
        }
        return sb.toString();
        //이게더 짧고 간단해보인다.
/*        String[] sp = s.toLowerCase().split("");
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(String ss : sp) {
            sb.append(flag ? ss.toUpperCase() : ss);
            flag = ss.equals(" ") ? true : false;
        }

        return sb.toString();*/
    }
    public static void main(String[] args) {
        //System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("p 1as  22pp   "));
    }
}
