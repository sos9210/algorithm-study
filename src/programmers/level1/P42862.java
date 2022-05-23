package programmers.level1;

public class P42862 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] total = new int[n+2];
        for (int i:lost) {
            total[i]--;
        }
        for (int i:reserve) {
            total[i]++;
        }

        for (int i = 0; i < total.length; i++) {
            if(total[i] == -1){
                if(total[i-1] == 1) {
                    total[i]++;
                    total[i-1]--;
                }else if(total[i+1] == 1) {
                    total[i]++;
                    total[i+1]--;
                }else
                    answer--;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2,4}, new int[]{1,3,5}));
    }
}
