package programmers.level1;

public class P86051 {
    public static int solution(int[] numbers){
        int number = 0;
        for (int i = 0; i < numbers.length; i++) {
            number+=numbers[i];
        }
        return 45-number;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
    }
}
