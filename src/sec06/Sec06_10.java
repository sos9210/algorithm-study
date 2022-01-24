package sec06;

import java.util.*;

public class Sec06_10 {
    public int count(int[] arr, int dist){
        int cnt = 1;
        int ep = arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i]-ep >= dist){
                cnt++;
                ep = arr[i];
            }
        }

        return cnt;
    }
// 5 3
// 1 2 4 8 9
// 3
    public int solution(int n, int c, int[] arr){
        Arrays.sort(arr);
        int answer = 0;
        int lt = 1;
        int rt = arr[n-1];

        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(count(arr, mid) >= c){
                answer = mid;
                lt = mid + 1;
            } else{
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Sec06_10 T = new Sec06_10();
        System.out.println(T.solution(n,c,arr));
        return ;
    }

}
