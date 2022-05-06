package study;

public class P77484 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int count = 0;
        int zero_count = 0;
        for (int i :lottos) {
            if(i == 0) ++zero_count;
            for (int j :win_nums) {
                if(i == j) {
                    ++count;
                }
            }
        }
        answer[0] = 7-(count+zero_count) == 7 ? 6 : 7-(count+zero_count);
        answer[1] = 7-count == 7 ? 6 : 7-count;

        return answer;
    }
    public static void main(String[] args) {
        int[] solution = solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        for (int i :solution) {
            System.out.println(i  +  " ");
        }
    }
}
