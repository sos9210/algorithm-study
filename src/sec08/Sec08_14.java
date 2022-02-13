package sec08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point {
    public int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
// 피자배달거리(DFS)
public class Sec08_14 {

            //n 도시크기 n x n, m 선택할 피자집 갯수, len 도시의 피자집 총 갯수, answer 도시의 최소 피자배달거리
    static int n,m,len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static List<Point> pz,hs;
    public void DFS(int L ,int s) {
        if(L == m){ //DFS 레벨과 살리는 피자집 갯수가 같아질 경우
            int sum = 0;
            for (Point h : hs) {    // 도시의 집 리스트 루프
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {   // 조회하고 있던 m개의 피자집 루프
                                    //각 집의 피자 배달거리 계산하고 dis에 저장된 값과 비교해서 둘중 작은 것을 구한다.
                    dis = Math.min(dis,Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis; // 각 집의 최소 피자 배달거리를 sum에 더해준다 (도시의 피자 배달거리)
            }
            answer = Math.min(answer,sum);  // 기존에 구했던 도시의 피자 배달거리와 현재 탐색한 도시의 피자 배달거리중 가장 작은것을 구한다.
        }else{
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L+1,i+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sec08_14 T = new Sec08_14();

        n = sc.nextInt();
        m = sc.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {       //도시의 모든좌표 조회
                int tmp = sc.nextInt();
                if(tmp == 1) hs.add(new Point(i,j));    //해당 좌표가 집일경우 hs리스트에 넣는다
                else if(tmp == 2) pz.add(new Point(i,j)); //해당 좌표가 피자집일경우 pz리스트에 넣는다
            }
        }
        len = pz.size(); // 도시의 피자집 총 갯수
        combi = new int[m]; // 총 m개의 피자집만 탐색한다
        T.DFS(0,0);
        System.out.println(answer);
    }
}
