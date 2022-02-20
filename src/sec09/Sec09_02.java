package sec09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Meet implements Comparable<Meet>{
    int start;
    int end;
    public Meet(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meet o) {
        if(this.end == o.end){
            return this.start - o.start;
        }else{
            return this.end - o.end;
        }
    }
}
public class Sec09_02 {
    public int solution(int n, List<Meet> list){
        /*
        int answer = 1;
        Collections.sort(list);
        Meet meet = list.get(0);
        for (int i = 1; i < n; i++) {
            if(meet.end <= list.get(i).start){
                ++answer;
                meet = list.get(i);
            }
        }
        return answer;
         */
        //영상풀이
        int answer = 0;
        Collections.sort(list);
        int et = 0;
        for (Meet mt :list) {
            if(mt.start >= et){
                answer++;
                et = mt.end;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Sec09_02 T = new Sec09_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Meet> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Meet(start,end));
        }
        System.out.println(T.solution(n,list));
    }
}
