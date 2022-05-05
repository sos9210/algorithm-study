package sec09;

import java.util.Scanner;
public class Sec09_06 {
    static int N,M;
    static int[] unf;
    public static int find(int v) {
        if(v == unf[v]) return unf[v];
        else return unf[v] = find(unf[v]);
    }               //unf[v] 값을 저장함으로써 압축효과가 생긴다.
    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb) unf[fa] = fb;    //서로 같은 그룹이 아니면 한 그룹으로 만든다.
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        unf = new int[N+1];
        for (int i = 1; i <= N; i++) {
            unf[i] = i;     //먼저 각 인덱스에 값을 인덱스번호로 넣음
        }

        for (int i = 1; i <= M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a,b);         //한 그룹으로 묶기위한 메서드.
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = find(a);
        int fb = find(b);

        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
