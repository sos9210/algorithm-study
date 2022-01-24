package sec05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sec05_07 {
    public String solution(String req, String sub){
        /*  //내가푼것..
        String answer = "";
        Queue<Character> queue = new LinkedList<>();
        for (char x:req.toCharArray()) {
            queue.offer(x);
        }
        for (char x:sub.toCharArray()) {
            if(queue.peek() == x){
                queue.poll();
                if(queue.size()==0){
                    return "YES";
                }
            }
        }
        return "NO";
         */
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char x:req.toCharArray()) {
            queue.offer(x);
        }
        for (char x:sub.toCharArray()) {
            if(queue.contains(x)){
                if(x!=queue.poll()){
                    return "NO";
                }
            }
        }
        if(!queue.isEmpty()){
            return "NO";
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String req = in.next();
        String sub = in.next();
        Sec05_07 T = new Sec05_07();
        System.out.println(T.solution(req,sub));
        return ;
    }
}
