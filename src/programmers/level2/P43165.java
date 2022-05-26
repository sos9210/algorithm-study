package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class P43165 {
    public static int solution(int[] numbers, int target) {
        int answer = DFS(0,0,target,numbers);
        return answer;
    }
    public static int DFS(int idx,int sum, int target ,int[] numbers){
        //numbers를 모두 합친 값이 target인 경우이고 탐색깊이가 numbers의 길이와 같을때 1을 리턴한다.
        if(sum == target && idx == numbers.length){
            return 1;
        }
        //탐색깊이가 numbers의 길이와 같기만 한다면 0리턴
        if(idx == numbers.length) return 0;
        int result = DFS(idx+1,sum+numbers[idx],target,numbers) + DFS(idx+1,sum+(numbers[idx]*(-1)),target,numbers);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1},3));
        //System.out.println(solution(new int[]{4,1,2,1},4));
    }
}
