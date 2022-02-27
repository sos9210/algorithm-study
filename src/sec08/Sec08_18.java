package sec08;

import java.util.*;
class Edge2 implements Comparable<Edge2>{
    public int v1;
    public int v2;
    public int cost;
    Edge2(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge2 ob){
        return this.cost-ob.cost;
    }
}

public class Sec08_18 {
    static int[] unf;
    /*외우기*/
    public static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa=Find(a);
        int fb=Find(b);
        if(fa!=fb) unf[fa]=fb;
    }
    /*외우기*/
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();     // 도시의 갯수(정점)
        int m=kb.nextInt();     // 도로의 갯수(간선)
        unf=new int[n+1];
        ArrayList<Edge2> arr=new ArrayList<>();
        for(int i=1; i<=n; i++) unf[i]=i;
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();
            arr.add(new Edge2(a, b, c));        //a와 b를 연결하는 비용 c
        }
        int answer=0;
        Collections.sort(arr);
        for(Edge2 ob : arr){
            int fv1=Find(ob.v1);
            int fv2=Find(ob.v2);
            if(fv1!=fv2){
                answer+=ob.cost;
                Union(ob.v1, ob.v2);
            }
        }
        System.out.println(answer);
    }
}