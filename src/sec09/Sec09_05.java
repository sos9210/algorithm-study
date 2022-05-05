package sec09;

import java.util.*;

class Edge implements Comparable<Edge>{
    int vtx, cost;
    public Edge(int vtx, int cost) {
        this.vtx = vtx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {  //오름차순
        return this.cost - o.cost;
    }
}
public class Sec09_05 {
    static int[] dis;
    static List<List<Edge>> list;
    public static void solution(){
        //PriorityQueue는 compareTo(Edge o)의 정의된 상태에따라 우선순위가 바뀐다.
        Queue<Edge> pq = new PriorityQueue<>();     //현재는 cost가 가장 낮은값이 우선순위다.
        //1번 정점부터 탐색시작 ( 1번은 시작위치이므로 비용이 0으로 시작)
        pq.offer(new Edge(1,0));
        dis[1] = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int nowCost = edge.cost;
            int nowVtx = edge.vtx;
            //현재 비용이 전에 방문했던 비용보다 비싸면 continue (최소비용을 구해야하기때문에 이 이상 실행은 의미가없음)
            if(nowCost > dis[nowVtx]) continue;
            for (Edge e:list.get(nowVtx)) { //현재 정점에서 뻗어나갈 수 있는 정점들을 확인한다.
                if(dis[e.vtx] > nowCost + e.cost){  //전에 방문했던 비용보다 현재 비용이 더 싸면 ?
                    dis[e.vtx] = nowCost + e.cost;  //최소비용 갱신
                    pq.offer(new Edge(e.vtx, nowCost + e.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //정점의 갯수
        int m = sc.nextInt();   //간선의 갯수
        dis = new int[n+1];
        list = new ArrayList<>();   //List<List<edge>>
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            dis[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            //정점 a에서 정점 b까지는 가는데 드는 비용 c
            list.get(a).add(new Edge(b,c));
        }

        solution();

        for (int i = 2; i <= n; i++) {
            if(dis[i] == Integer.MAX_VALUE) System.out.println(i + " : impossible");
            else System.out.println(i +" : "+ dis[i]);
        }
    }
}
