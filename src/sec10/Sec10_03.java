package sec10;

import java.util.Scanner;
//3. 최대 부분 증가수열
public class Sec10_03 {
    static int[] dy;
    public int solution(int[] arr) {
        int answer=0;

        dy = new int[arr.length];
        dy[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] > arr[j] && dy[j] > max){
                    max = dy[j];
                }
                dy[i] = max+1;
                answer = Math.max(answer,dy[i]);
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Sec10_03 T = new Sec10_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
