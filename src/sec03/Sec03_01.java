package sec03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sec03_01 {
    /* // 내가푼것
    public int[] solution(int[] a,int[] b) {
        int p1=0,p2=0;
        int[] answer = new int[a.length+b.length];
        for (int i = 0; p1 < a.length && p2 < b.length; i++) {
            if(a[p1] <= b[p2]){
                answer[i] = a[p1];
                ++p1;
            }else{
                answer[i] = b[p2];
                ++p2;
            }
        }
        if(p1 == a.length){
            for (int i = p2+p1; p2 < b.length; i++) {
                answer[i] = b[p2];
                ++p2;
            }
        }else{
            for (int i = p1+p2; p1 < b.length; i++) {
                answer[i] = a[i];
                ++p1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for (int i=0; i < n; ++i) {
            arr1[i] = in.nextInt();
        }
        n = in.nextInt();
        int[] arr2 = new int[n];
        for (int i=0; i < n; ++i) {
            arr2[i] = in.nextInt();
        }
        Sec03_01 T = new Sec03_01();
        for (int x: T.solution(arr1,arr2)) {
            System.out.print(x+" ");
        }
    }
     */
    public ArrayList<Integer> solution(int n,int m,int[] a,int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while (p1<n && p2<m){
            if(a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while (p1<n) answer.add(a[p1++]);
        while (p2<m) answer.add(b[p2++]);
        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for (int i=0; i < n; ++i) {
            arr1[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for (int i=0; i < m; ++i) {
            arr2[i] = in.nextInt();
        }
        Sec03_01 T = new Sec03_01();
        for (int x: T.solution(n,m,arr1,arr2)) {
            System.out.print(x+" ");
        }
    }
}
