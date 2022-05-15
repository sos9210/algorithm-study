package programmers;

public class P42840 {
    public static int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int[] cnt = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i%5]){
                cnt[0] = cnt[0]+1;
            }
            if(answers[i] == two[i%8]){
                cnt[1] = cnt[1]+1;
            }
            if(answers[i] == three[i%10]){
                cnt[2] = cnt[2]+1;
            }
        }
        int[] total = new int[3];
        int max = Math.max(cnt[0],cnt[1]);
        max = Math.max(max,cnt[2]);
        int maxCount = 0;
        for (int i = 0; i < 3; i++) {
            if(max == cnt[i]){
                maxCount++;
                total[i] = i+1;
            }
        }
        int[] answer = new int[maxCount];
        int answerCnt = 0;
        for (int i = 0; i < 3; i++) {
            if(total[i] != 0) {
                answer[answerCnt] = total[i];
                answerCnt++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] solution = solution(new int[]{1,3,2,4,2});
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i]+" ");
        }
    }
}
