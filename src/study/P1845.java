package study;

import java.util.HashSet;
import java.util.Set;

public class P1845 {
    public static int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        //모든 숫자를 Set에 넣어준다.
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        //1부터 카운터시작.
        //카운트가 set의 사이즈를 넘지않고, nums길이의 반을 넘지않는 경우에만 반복한다.
        for (int i = 1; i <= set.size() && i <= nums.length/2; i++) {
            answer = i;
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,3}));
    }
}
