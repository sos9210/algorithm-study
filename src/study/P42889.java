package study;

import java.util.*;
//https://velog.io/@yanghl98/프로그래머스-실패율-JAVA자바-2019-카카오-기출
//참고진행하였음
class Rank{
    double count;
    int sn;
    public Rank(double count, int sn){
        this.count = count;
        this.sn = sn;
    }
}
public class P42889 {
    public static int[] solution(int N, int[] stages) {
        int[] user_cnt = new int[N + 2];	// 각 stage에 머물러있는 user 수
        int[] user_total_cnt = new int[N + 1];	// 각 stage에 도달한 전체 user 수
        int[] answer = new int[N];
        for (int i = 0; i < stages.length; i++) {
            user_cnt[stages[i]]++;
        }

        // 스테이지에 도달한 유저 수 누적(?)하여 구하기
        // 맨 마지막 stage는 n번째 + (n+1)번째
        user_total_cnt[N] = user_cnt[N] + user_cnt[N + 1];
        for (int i = N-1; i >= 1; i--) {
            user_total_cnt[i] = user_cnt[i] + user_total_cnt[i + 1];
        }

        List<Rank> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {

            if(user_total_cnt[i]==0){ //스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0
                list.add(new Rank(0, i));
                continue;
            }
            list.add(new Rank((double) user_cnt[i] / user_total_cnt[i],i));
        }
        // fail rate가 높은 순으로 sorting
        Collections.sort(list,((o1,o2) -> Double.compare(o2.count, o1.count)));

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).sn;
        }
        return answer;
    }
    public static void main(String[] args) {
  //      int[] result = solution(5,new int[]{2, 1, 2, 6, 2, 4, 3, 3});
   //     int[] result = solution(8,new int[]{1,2,3,4,5,6,7});
  //      int[] result = solution(5,new int[]{3,1,2,2,2}); // 4,3,2,1,5
        int[] result = solution(5,new int[]{4,4,4,4,4});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
