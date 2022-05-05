package sec09;

import java.util.*;

class Lecture implements Comparable<Lecture>{
    int pay,date;
    public Lecture(int pay,int date){
        this.pay = pay;
        this.date = date;
    }
    @Override
    public int compareTo(Lecture o) {
        return o.date - this.date;
    }
}
public class Sec09_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0, max = Integer.MIN_VALUE;

        List<Lecture> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Lecture(a,b));
            if(b > max) max = b;    //제일 긴 날짜
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (;j < n; j++) {
                if(list.get(j).date < i) break;
                pq.offer(list.get(j).pay);
            }
            if(!pq.isEmpty()) answer+=pq.poll();
        }

        System.out.println(answer);
    }
}
