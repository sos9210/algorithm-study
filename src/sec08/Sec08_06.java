package sec08;

import java.util.Scanner;

//조합의 경우수(메모이제이션)
public class Sec08_06 {
    static int[][] dy;
    public int DFS(int n, int r){
        if(dy[n][r] > 0){       //이미 탐색한경우 배열에서 찾아와서 바로 반환한다.
            return dy[n][r];
        }
        if(n == r || r == 0){       // n과r이 같거나 r이0 이면 1을 반환한다.(트리 종착점)
            return 1;
        }else{//    nCr ... n=5, r=3일때 트리그래프로 뻗어나가며  5C3 -> ((4C2 -> 3C2, 3C1), (4C3 -> 3C3, 3C2)) ....생략
            return dy[n][r] = DFS(n-1, r) + DFS(n-1,r-1);   //탐색한부분을 배열에 딤고 반환한다
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Sec08_06 T = new Sec08_06();
        int n = in.nextInt();
        int r = in.nextInt();
        dy = new int[n+1][r+1];
        System.out.println(T.DFS(n,r));

    }
}
