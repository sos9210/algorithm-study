package sec03;

import java.util.Scanner;

public class Sec03_05 {
    public int solution(int n){
        /*  //내가푼것
        int answer = 0,sum = 0, lt = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
            if(sum > n){
                sum = 0;
                i = ++lt;
            }
            if(sum == n){
                ++answer;
                sum = 0;
                i = ++lt;
            }

        }
        return answer;
         */
        int answer = 0, sum = 0, lt = 0;
        int m = n/2+1;
        int [] arr = new int[m];
        for(int i=0; i < m; i++){
            arr[i] = i+1;
        }
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if(sum == n){
                answer++;
            }
            while (sum >= n){
                sum-=arr[lt++];
                if (sum == n){
                    answer ++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        Sec03_05 T = new Sec03_05();
        System.out.println(T.solution(n));
    }
}
