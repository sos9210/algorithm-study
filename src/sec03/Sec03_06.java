package sec03;

import java.util.Scanner;

public class Sec03_06 {
    public int solution (int[] arr,int cnt, int n){
        /* // 내가푼것
        int answer = 0, lt = 0, rt = 0 , length = 0;
        for (int i = 0; i < cnt; i++) {
            if(arr[i] == 0){
                rt++;
                if(rt > n){
                    i = ++lt;
                    rt = 0;
                    if(answer < length){
                        answer = length;
                    }
                    length = 0;
                }else{
                    length++;
                }
            }else{
                length++;
            }
        }

        return answer;
         */
        int lt = 0, t = 0, answer = 0;
        for (int rt = 0; rt < cnt; rt++) {
            if(arr[rt] == 0){
                t++;
            }
            while(t > n) {
                if(arr[lt] == 0){
                    t--;
                }
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int cnt = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = in.nextInt();
        }
        Sec03_06 T = new Sec03_06();
        System.out.println(T.solution(arr,cnt,n));
    }
}
