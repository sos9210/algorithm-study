package sec02;

import java.util.Scanner;

public class Sec02_08 {
    public int[] solution(int[] arr){
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] < arr[j]){
                    cnt++;
                }
                answer[i] = cnt;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i < n; ++i) {
            arr[i] = in.nextInt();
        }
        Sec02_08 T = new Sec02_08();
        for (int x:T.solution(arr)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
