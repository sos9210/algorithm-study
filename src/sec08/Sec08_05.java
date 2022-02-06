package sec08;

import java.util.Scanner;

public class Sec08_05 {
    static int[] ch,arr,pm;
    static int n ,m;
    public void DFS(int L){
        if(L == m){
            for (int x:pm) {
                System.out.print(x+" ");
            }
            System.out.println();
        }else{
            for (int i = 0; i < n; i++) {
                if(ch[i] == 0){
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Sec08_05 T = new Sec08_05();
        n=in.nextInt();
        m=in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        ch = new int[n];
        pm = new int[m];
        T.DFS(0);


    }
}
