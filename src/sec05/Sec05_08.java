package sec05;

import java.util.*;


public class Sec05_08 {
    class Person {

        int id;
        int priority;

        public Person(int id, int priority){
            this.id = id;
            this.priority = priority;
        }
    }
    public int solution(int n, int m, int[] arr){
        int answer = 0;

        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i,arr[i]));
        }
        while (!queue.isEmpty()){
            Person tmp = queue.poll();
            for (Person x : queue) {
                if(x.priority > tmp.priority){
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                answer++;
                if(tmp.id == m) return answer;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Sec05_08 T = new Sec05_08();
        System.out.println(T.solution(n,m,arr));
        return ;
    }
}
