package programmers.level2;

import java.util.Arrays;

//구명보트
public class P42885 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = 0;
        //최대 2명만 탈수있다.
        //몸무게가 가장많이나가는사람과 적게나가는사람을 같이 태운다.
        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                index++;
            }
            answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        //System.out.println(solution(new int[]{70,50,80,50},100));//3
        //System.out.println(solution(new int[]{30,70,50,50},100));//2
        //System.out.println(solution(new int[]{70, 80, 50},100));//3
        System.out.println(solution(new int[]{30, 30, 50,20,30},100));//3
    }
}
