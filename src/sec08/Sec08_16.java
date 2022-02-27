package sec08;

import java.util.*;

class Edge implements Comparable<Edge> {
    public int vex; //정점번호
    public int cost;//가중치 값

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Sec08_16 {
    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public void solution(int v){
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pq.isEmpty()){
            Edge tmp =  pq.poll();
            int now = tmp.vex;          //목적지 정점
            int nowCost = tmp.cost;     //비용
            if(nowCost  > dis[now]){
                continue;
            }
            for (Edge ob : graph.get(now)){
                if(dis[ob.vex] > nowCost + ob.cost){
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.vex, nowCost+ob.cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        Sec08_16 T = new Sec08_16();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //정점의 갯수
        m = sc.nextInt();   //간선의 갯수
        graph = new ArrayList<>();      //Edge리스트를 저장하는 ArrayList
        for (int i = 0; i <=n ; i++) {
            graph.add(new ArrayList<Edge>());   //n개만큼 생성
        }
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();       //a부터
            int b = sc.nextInt();       //b까지
            int c = sc.nextInt();       //c의 비용이 든다.
            graph.get(a).add(new Edge(b,c));
        }
        T.solution(1);
        for (int i = 2; i <= n; i++) {
            if(dis[i] != Integer.MAX_VALUE){
                System.out.println(i + " : " + dis[i]);
            }else{
                System.out.println(i+" : impossible");
            }
        }
    }
}
