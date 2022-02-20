package sec09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Time implements Comparable<Time> {
    public int time;
    public char state;
    public Time(int time, char state){
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time o) {
        if(this.time == o.time){
            return this.state - o.state;
        }else{
            return this.time - o.time;
        }
    }
}
public class Sec09_03 {
    public int solution(List<Time> list){
        int answer = Integer.MIN_VALUE;
        Collections.sort(list);
        int cnt = 0;
        for (Time t:list) {
            if(t.state == 's'){
                cnt++;
            }else{
                cnt--;
            }
            answer = Math.max(answer,cnt);
        }
        return answer;
    }
    public static void main(String[] args) {
        Sec09_03 T = new Sec09_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Time(start,'s'));
            list.add(new Time(end,'e'));
        }
        System.out.println(T.solution(list));
    }
}
