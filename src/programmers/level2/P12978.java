package programmers.level2;

import java.util.*;

class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost-ob.cost;
    }
}
//PriorityQueue(우선순위 큐), 다익스트라
//배달
public class P12978 {
    public static int solution(int N, int[][] road, int K) {
        int answer=0;
        List<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        int[] ch=new int[N+1];  //마을개수만
        Arrays.fill(ch, Integer.MAX_VALUE);
        for(int i=0; i<road.length; i++){
            int a=road[i][0];
            int b=road[i][1];
            int c=road[i][2];
            //양방향
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        ch[1] = 0;
        pQ.offer(new Edge(1, 0));
        //1번부터 각 마을까지 얼마나 걸리는지 구한다.
        while(!pQ.isEmpty()){
            Edge e = pQ.poll();
            for(Edge ne : graph.get(e.vex)){
                if(ch[ne.vex] > ch[e.vex] + ne.cost){
                    ch[ne.vex] = ch[e.vex] + ne.cost;
                    pQ.offer(ne);
                }
            }
        }
        for(int distance : ch){
            //배달거리가 K이하인지
            if(distance <= K) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3));
    }
}
