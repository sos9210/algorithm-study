package sec06;

import java.util.Scanner;

public class Sec06_02 {
    public int[] solution(int[] arr, int n){

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; ++j) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Sec06_02 T = new Sec06_02();
        for (int i :T.solution(arr,n)) {
            System.out.print(i+" ");
        }
        return ;
    }
}
