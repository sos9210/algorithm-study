package sec06;

import java.util.Arrays;
import java.util.Scanner;

public class Sec06_08 {
    public int solution(int n, int m, int[] arr) {
        /*
        int answer = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i; j < n; j++) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(arr[i] == m) {
                answer = i+1;
                break;
            }
        }
        return answer;
         */
        //이분검색
        int answer = 0;

        Arrays.sort(arr);
        int lt=0, rt=n-1;
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(arr[mid] == m){
                answer = mid+1;
                break;
            }
            if(arr[mid] > m){
                rt = mid - 1;
            }else{
                lt = mid + 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Sec06_08 T = new Sec06_08();
        System.out.println(T.solution(n,m,arr));

    }
}
