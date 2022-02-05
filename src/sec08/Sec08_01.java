package sec08;

import java.util.Scanner;

public class Sec08_01 {
    static String answer="NO";
    static int n,total;
    boolean flag = false;
    public void DFS(int L, int sum, int[] arr){
        if(flag == true || (sum > total/2 && total%2 == 0)){
            return;
        }
        if(L == n) {
            if((total-sum) == sum){
                answer = "YES";
                flag = true;
            }
        }else{
            DFS(L+1,sum+arr[L],arr);        //arr배열L 원소를 더한다.
            DFS(L+1,sum,arr);                   // 더하지 않는다.
        }
    }
    public static void main(String[] args){
        Sec08_01 T = new Sec08_01();
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            total+=arr[i];
        }
        T.DFS(0,0,arr);
        System.out.println(answer);
        return ;
    }
}
