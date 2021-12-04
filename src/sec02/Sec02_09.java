package sec02;

import java.util.Scanner;

public class Sec02_09 {
    public int solution(int[][] arr){
        //내가 푼것
        /*
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[i][j];
                answer = Integer.max(sum,answer);
            }
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][i];
                answer = Integer.max(sum,answer);
            }
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][arr.length-(j+1)];
                answer = Integer.max(sum,answer);
            }
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][j];
                answer = Integer.max(sum,answer);
            }
        }

        return answer;
         */
    //강의
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        for (int i = 0; i < arr.length; i++) {
            sum1=sum2=0;
            for (int j = 0; j < arr.length; j++) {
                sum1 = arr[i][j];
                sum2 = arr[j][i];
            }
            answer = Math.max(answer,sum1);
            answer = Math.max(answer,sum2);
        }
        sum1=sum2=0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][arr.length-(i+1)];
        }
        answer = Math.max(answer,sum1);
        answer = Math.max(answer,sum2);
        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i=0; i < n; ++i) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        Sec02_09 T = new Sec02_09();
        System.out.println(T.solution(arr));
        return ;
    }
}
