package sec03;

import java.util.Scanner;

public class Sec03_04 {
    public int solution(int n, int m, int[] arr){
    /*  //내가푼것
        int answer = 0, sum = 0, j = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum >= m){
                if(sum == m){
                    ++answer;
                }
                sum=0;
                ++j;
                i = j-1;
            }
        }
        return answer;
     */
     //강의
        int answer = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if(sum == m){
                answer++;
            }
            while(sum >= m){
                sum-=arr[lt++];
                if(sum == m){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Sec03_04 T = new Sec03_04();
        System.out.println(T.solution(n,m,arr));
    }
}
