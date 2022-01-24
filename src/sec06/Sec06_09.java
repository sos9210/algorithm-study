package sec06;

import java.util.Arrays;
import java.util.Scanner;

public class Sec06_09 {
    public int count(int[] arr, int capacity){
        int cnt = 1, sum = 0;
        for (int x : arr){
            if(sum+x > capacity){
                cnt++;
                sum = x;
            }else{
                sum += x;
            }
        }
        return cnt;
    }
    public int solution(int n, int m, int[] arr){
        int answer = 0;
//        9
//                        lt = 9 , rt = 45
//        1 2 3 4 5 6 7 8 9

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while(lt <= rt){
            int mid=(lt+rt)/2;      //반으로 나눠서
            if(count(arr,mid) <= m){    //비교한다.
                answer = mid;
                rt=mid-1;
            }else{
                lt = mid+1;
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
        Sec06_09 T = new Sec06_09();
        System.out.println(T.solution(n,m,arr));
    }
}
