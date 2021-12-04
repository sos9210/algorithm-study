package sec02;

import java.util.Scanner;

public class Sec02_07 {
    public int solution(int[] arr){
        int answer = 0;
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0){
                tmp++;
            }
            if(arr[i] == 0){
                tmp = 0;
            }
            answer += tmp;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i < n; ++i) {
            arr[i] = in.nextInt();
        }
        Sec02_07 T = new Sec02_07();
        System.out.println(T.solution(arr));
        return ;
    }
}
