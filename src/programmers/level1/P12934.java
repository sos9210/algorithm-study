package programmers.level1;

public class P12934 {
    public static long solution(long n) {
        //리턴타입 체크 잘하자..
        Double sqrt = Math.sqrt(n);
        if(sqrt.intValue() == sqrt.doubleValue()){
            long intvalue = sqrt.intValue()+1;
            return intvalue * intvalue;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(solution(250000));
    }
}
