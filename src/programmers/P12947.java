package programmers;

public class P12947 {
    public static boolean solution(int x) {
        String str = String.valueOf(x);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Character.getNumericValue(str.charAt(i));
        }
        if(x % sum == 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(solution(11));
    }
}
