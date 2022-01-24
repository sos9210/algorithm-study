package sec06;

import java.util.Scanner;

public class Sec06_01 {
    public int[] solution(int n, int[] arr){
        /* //내가 푼것
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] > arr[j]){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
        */
        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[idx]){
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Sec06_01 T = new Sec06_01();
        for (int x:T.solution(n,arr)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
