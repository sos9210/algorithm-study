package programmers.level2;

import java.util.*;

public class P42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();

        //각 기능 개발에 걸리는 시간을 찾는다.
        for (int i = 0; i < progresses.length; i++) {
            list.add(findDuration(progresses[i],speeds[i]));
        }

        //각 기능 개발에 걸리는 시간들중 함께 배포가 가능한것끼리 묶어서 카운트한다.
        for (int i = 0; i < list.size();) {
            int cnt = 0;
            for (int j = i+1; j <= list.size(); j++) {
                cnt++;
                if(j >= list.size() || list.get(j) > list.get(i)){
                    countList.add(cnt);
                    break;
                }
            }
            if(cnt > 0) i += cnt;
        }

        //int[]배열로 치환하는 작업.
        Integer[] integers = countList.toArray(new Integer[countList.size()]);
        int[] answer = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            answer[i] = integers[i];
        }
        return answer;
    }
    //각 기능 개발에 걸리는 시간을 찾는다.
    public static int findDuration(int progress, int speed){
        Queue<Integer> q = new LinkedList<>();
        q.offer(progress);
        int count = 0;
        while(!q.isEmpty()){
            int pro = q.poll();
            if(100 > pro){
                q.offer(pro+speed);
                ++count;
            }
        }
        return count;
    }
    public static void main(String[] args) {
       Arrays.stream(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})).forEach( v -> System.out.print(v + " "));
       //Arrays.stream(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})).forEach( v -> System.out.print(v + " "));
    }
}
