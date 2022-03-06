package sec10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//가장높은탑쌓기
class Brick implements Comparable<Brick>{
    public int s,h,w;
    Brick(int s, int h, int w){
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s - this.s;
    }
}
public class Sec10_04 {
    static int[] dy;
    public int solution(List<Brick> arr){
        Collections.sort(arr);
        dy[0] = arr.get(0).h;
        int answer = dy[0];

        for (int i = 1; i < arr.size(); i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if(arr.get(j).w > arr.get(i).w && dy[j] > max){
                    max = dy[j];
                }
                dy[i] = max+arr.get(i).h;
                answer = Math.max(answer,dy[i]);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Sec10_04 T = new Sec10_04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n];
        List<Brick> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(i,new Brick(s,h,w));
        }
        System.out.println(T.solution(arr));
    }
}
