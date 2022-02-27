package sec08;

import java.util.*;

class Lecture implements Comparable<Lecture>{
    public int money;
    public int time;
    Lecture(int money, int time){
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.time - this.time;
    }
}
public class Sec08_15 {
    static int n, max=Integer.MIN_VALUE;
    public int solution(List<Lecture> arr){
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);      // arr을 내림차순으로 정렬
        int j = 0;
        for (int i = max; i >= 1; i--) {    //가장 높은 일자부터 내림차순으로 조회
            for (; j < n; j++) {            
                if(arr.get(j).time < i){   //i가 현재조회하는 리스트의 일자보다 크면 break     //
                    break;
                }
                pq.offer(arr.get(j).money);//그렇지 않으면 큐에 해당 리스트의 money를 저장
            }
            if(!pq.isEmpty()){
                answer += pq.poll();
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Sec08_15 T = new Sec08_15();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m,d));  //강연료(m)과 일자(d)를 생성자 인자로받고 생성한다.
            if(d > max){
                max = d;                //가장 긴 일자
            }

        }
        System.out.println(T.solution(arr));
    }
}
