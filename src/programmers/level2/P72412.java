package programmers.level2;

import java.util.*;

//자료구조와 이분탐색 응용문제
public class P72412 {
    //점수를 제외한 나머지 조건이 Key, 그리고 그 Key에 속하는 점수 조건이 value
    static Map<String,List<Integer>> map = new HashMap<>();
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // info 모든 경우의 수 map에 저장
        for (int i = 0; i < info.length; i++) {
            dfs(info[i].split(" "),"",0);
        }
        // map에 저장된 점수 list 오름차순으로 정렬
        // score는 다른 조건과 다르게 같은지여부가 아니라 조건 이상인지를 체크하기때문에 정렬필요
        for (String key : map.keySet())
            Collections.sort(map.get(key));

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }
        return answer;
    }
    public static int binarySearch(String key, int score){
        //map에서 조회된 값들중 query의 점수조건 이상 받은 사람 수를 구한다.
        List<Integer> list = map.get(key);

        //이분탐색 진행을위해 list의 처음과 끝을 변수에 저장
        int start = 0, end = list.size() - 1;
        //이분탐색 진행
        while (start <= end) {
            int mid = (start + end) / 2;    //중간지점
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }
        // key에 해당하는 점수의 총 개수 - 점수보다 크거나 같은 처음 index
        return list.size() - start;
    }
    public static void dfs(String[] info, String pos , int depth){
        if(depth == 4) {
            if(!map.containsKey(pos)){
                map.put(pos,new ArrayList<>());
            }
            map.get(pos).add(Integer.parseInt(info[4]));
            return;
        }
        dfs(info,pos + "-",depth+1);
        dfs(info,pos + info[depth],depth+1);
    }
    public static void main(String[] args) {
        Arrays.stream(solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}
        , new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}))
                .forEach(v -> System.out.print(v +" "));
    }
}
