package sec02;

import java.util.ArrayList;
import java.util.Scanner;

public class Sec02_06 {

    public ArrayList<Integer> solution(int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int res = res=0;
            while (tmp > 0 ){
                int t=tmp%10;
                res=res*10+t;
                tmp=tmp/10;
            }
            if(isPrime(res)){
                answer.add(res);
            }
        }
        return answer;
    }

    private boolean isPrime(int res) {
        if(res == 1) return false;
        for (int i = 2; i < res; i++) {
            if(res%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Sec02_06 T = new Sec02_06();
        int input1 = in.nextInt();
        int[] arr = new int[input1];
        for (int i = 0; i < input1; i++) {
            arr[i] = in.nextInt();
        }
        for (int x:T.solution(arr)) {
            System.out.print(x+" ");
        }
        return ;
    }
}
