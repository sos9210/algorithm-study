package sec08;

import java.util.Scanner;

public class Sec08_17 {
    static int[] unf;
    public static int Find(int v){  //그냥외워버리는게 편함
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa=Find(a);
        int fb=Find(b);
        if(fa!=fb) unf[fa]=fb;
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();     //학생수
        int m=kb.nextInt();     //숫자쌍의 갯수
        unf=new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;   // 학생들을 배열안에 넣는다
        for(int i=1; i<=m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            Union(a, b);        //학생 a와 학생 b를 한 집합으로 만든다.
        }
        int a=kb.nextInt();
        int b=kb.nextInt();
        int fa=Find(a);
        int fb=Find(b);
        if(fa==fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
