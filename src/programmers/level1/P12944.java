package programmers.level1;

public class P12944 {
    public static double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        answer = (double) sum/arr.length;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4}));
    }
}
