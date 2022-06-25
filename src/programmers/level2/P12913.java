package programmers.level2;

//땅따먹기
//DP
//https://bada744.tistory.com/125
public class P12913 {
    public static int solution(int[][] land) {
        //차례대로 내려가기만 하면 최대값을 구할 수 없음
        //이전행과 현재행을 비교하면서 최대값을 구해야함.
        /*
        int answer1 = 0;
        int before = -1;
        for (int i = 0; i < land.length; i++) {
            int max = -1;
            int beforeTmp = before;
            for (int j = 0; j < land[i].length; j++) {
                if(j != beforeTmp){
                    if(max < land[i][j]){
                        max = land[i][j];
                        before = j;
                    }
                }
            }
            answer1 += max;
        }
        return answer1;
         */
        int answer = 0;
        for(int i=1; i<land.length; i++){
            //0 ~ 3번째까지 (해당 칸의 점수 + 이전 칸에서 특정열을 제외한 최대값)
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][1], land[i-1][0]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][0]);
        }

        for (int i = 0; i < land[land.length-1].length; i++) {
            answer = Math.max(answer,land[land.length-1][i]);
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}})); //16
        System.out.println(solution(new int[][] {{1,1,1,1}, {2,2,2,3}, {3,3,3,6}, {4,4,4,7}})); //14
        System.out.println(solution(new int[][] {{9, 5, 2, 3}, {9, 8, 6, 7}, {8, 9, 7, 1}, {100, 9, 8, 1}})); //125
    }
}
