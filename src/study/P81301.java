package study;

public class P81301 {
    public static String stringToInt(String str){
        str = str.replaceAll("(zero)","0");
        str = str.replaceAll("(one)","1");
        str = str.replaceAll("(two)","2");
        str = str.replaceAll("(three)","3");
        str = str.replaceAll("(four)","4");
        str = str.replaceAll("(five)","5");
        str = str.replaceAll("(six)","6");
        str = str.replaceAll("(seven)","7");
        str = str.replaceAll("(eight)","8");
        str = str.replaceAll("(nine)","9");
        return str;
    }
    public static int solution(String s){
        String str = stringToInt(s);
        return Integer.parseInt(str);
    }
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }
}
