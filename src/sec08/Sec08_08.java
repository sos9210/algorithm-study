package sec08;

import java.util.Scanner;

public class Sec08_08 {
    static int[] combi;
    static int n,m;
    public void DFS(int L, int s){
        if(L == m){ //레벨이 뽑는갯수와 같으면 출력
            for (int i: combi) {
                System.out.print(i+" ");
            }
            System.out.println();
        }else{
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L+1,i+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sec08_08 T = new Sec08_08();
        n = sc.nextInt(); // 1부터 n까지
        m = sc.nextInt(); // m개를 뽑는 방법의 수
        combi = new int[m];
        T.DFS(0,1);

    }
}
