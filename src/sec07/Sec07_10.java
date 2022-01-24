package sec07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//송아지찾기
public class Sec07_10 {
    int answer = 0;
    int[] dis={1,-1,5};     //이동거리
    int[] ch;               //조회좌표체킹
    Queue<Integer> q = new LinkedList<>();
                    //현재위치 //송아지위치
    public int BFS(int s, int e){
        ch = new int[10001];// 1 ~ 10000까지 좌표
        ch[s] = 1;           //출발좌표 체킹
        q.offer(s);          //출발좌표 offer
        int level = 0;     //노드레벨
        while(!q.isEmpty()){
            int len = q.size();    // 레벨별 노드갯수
            for (int i = 0; i < len; i++) {
                int x = q.poll();   // x = 현재노드
                for (int j: dis) {  // 이동거리({1,-1,5}) forEach
                    int nx = x+j;   // nx = 자식노드
                    if(nx == e){    // 자식노드와 송아지 위치가 같다면?
                        return level+1;     //현재노드레벨 + 1(자식노드레벨) 을 리턴
                    }
                    if(nx >= 1 && nx<=10000 && ch[nx] == 0){    // nx(자식노드)가 1~10000좌표 사이 && ch에 체킹된적 없는(조회된적없는)좌표
                        ch[nx] =1;      //방문좌표체킹추가
                        q.offer(nx);    //큐에 자식노드 추가
                    }
                }
            }
            level++;
        }
        return 0;
    } // 최소 몇번, 최소 거리 .. 이런거는 BFS알고리즘
    public static void main(String[] args) {
        Sec07_10 T = new Sec07_10();
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();
        System.out.println(T.BFS(s,e));
    }
}
