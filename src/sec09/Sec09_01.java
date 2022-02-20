package sec09;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Body implements Comparable<Body>{
    int height;
    int weight;
    public Body(int height, int weight){
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Body o) {
            return o.height - this.height;
    }
}
public class Sec09_01 {


    public int solution(List<Body> list, int n) {
        int cnt = 0;
        Collections.sort(list);
        int max = Integer.MIN_VALUE;

        for (Body o:list) {
            if(o.weight > max){
                max = o.weight;
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Sec09_01 T = new Sec09_01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Body> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            list.add(new Body(height,weight));
        }
        System.out.println(T.solution(list,n));
    }
}
