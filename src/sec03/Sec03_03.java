package sec03;

import java.util.Scanner;

public class Sec03_03 {
    public int solution(int n, int k, int[] arr){
        /* //Sliding window 한칸씩 밀어가면서 체크
        int answer = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        answer = sum;
        for (int i = k; i < n-k; i++) {
            sum = sum-arr[i-k]+arr[i];
            if(answer < sum){
                answer = sum;
            }
        }
        return answer;
         */
        //강의
        int answer = 0, sum=0;
        for (int i = 0; i < k; i++) {
            sum+=arr[i];
        }
        answer = sum;
        for (int i = 0; i < n; i++) {
            sum+=(arr[i]-arr[i-k]);
            answer=Math.max(answer,sum);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Sec03_03 T = new Sec03_03();
        System.out.println(T.solution(n,k,arr));
    }
}
