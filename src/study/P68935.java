package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P68935 {
    public static int solution(int n) {
        int answer = 0;
/*
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.offer(n);
        while(!q.isEmpty()){
            int num = q.poll();
            if((num / 3) >= 1){
                list.add(num % 3);
                q.offer(num / 3);
            }else{
                list.add(num);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > 0){
                answer += Math.pow(3,list.size()-(i+1)) * list.get(i);
            }
        }
        */
        String str = "";                //코드가 짧지만 속도면에선 주석처리된 코드보다 떨어짐
        while(n > 0){
                str += String.valueOf(n % 3);
                n = n / 3;
        }
        answer = Integer.parseInt(str,3);
        return answer;
    }
    public static void main(String[] args) {
//        System.out.println(solution(45));
        System.out.println(solution(125));
    }
}
