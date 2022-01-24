package sec06;

import java.util.Scanner;

public class Sec06_03 {
    public int[] solution(int[] arr, int n){
        for (int i = 1; i < n; i++) {
            int tmp = arr[i],j;
            for (j = i-1; j >= 0; j--) {
                if(tmp < arr[j]){
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }else{
                    break;
                }
            }
            arr[j+1] = tmp;
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
        Sec06_03 T = new Sec06_03();
        for (int i :T.solution(arr,n)) {
            System.out.print(i+" ");
        }
        return ;
    }
}
