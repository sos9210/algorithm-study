package sec06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Point implements Comparable<Point> {
    public int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override//return this와 o의 자리를 바꾸면 내림차순 현재처럼 돌리면 오름차순이다.
    public int compareTo(Point o) {
        if(this.x == o.x){
            return this.y - o.y;
        }else{
            return this.x - o.x;
        }
    }
}
public class Sec06_07 {
    /*
    public void solution(int n, int[] arr1,int[] arr2) {
        int tmp = 0;
        for (int i = 0; i < n-1; i++) {
            if(arr1[i] > arr1[i+1]) {
                tmp = arr1[i];
                arr1[i] = arr1[i+1];
                arr1[i+1] = tmp;
                tmp = arr2[i];
                arr2[i] = arr2[i+1];
                arr2[i+1] = tmp;
                i = -1;
            }else if(arr1[i] == arr1[i+1]) {
                if(arr2[i] > arr2[i+1]) {
                    tmp = arr1[i];
                    arr1[i] = arr1[i+1];
                    arr1[i+1] = tmp;
                    tmp = arr2[i];
                    arr2[i] = arr2[i+1];
                    arr2[i+1] = tmp;
                    i = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " " + arr2[i]);
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
            arr2[i] = in.nextInt();
        }
        Sec06_07 T = new Sec06_07();
        T.solution(n,arr1,arr2);
        return ;
    }
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Point> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            arr.add(new Point(x,y));
        }
        Collections.sort(arr);
        for (Point o : arr) {
            System.out.println(o.x + " " + o.y);
        }
    }
}
