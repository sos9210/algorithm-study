package programmers;

public class P12948 {
    public static String solution(String phone_number) {
        /* //성능이 더 좋고 간단하다.
        char[] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
        */
        String substring = phone_number.substring(0, phone_number.length() - 4);
        String s = substring.replaceAll("[0-9]", "*");
        return s + phone_number.substring(phone_number.length()-4,phone_number.length());
    }
    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
    }
}
