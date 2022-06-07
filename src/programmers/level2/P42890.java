package programmers.level2;

import java.util.*;

//후보키
public class P42890 {
    static boolean[] visit;
    static List<String> candi = new ArrayList<>();
    public static int solution(String[][] relation) {
        //컬럼 사이즈만큼 dfs실행
        int columnCount = relation[0].length;
        visit = new boolean[columnCount];
        for (int i = 0; i < columnCount; i++) {
            dfs(relation, 0, 0, i + 1);
        }
        int answer = candi.size();
        return answer;
    }
    public static void dfs(String[][] relation,int start, int depth, int end){
        if(end == depth){
            List<Integer> list = new ArrayList<>();
            String key = "";
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    key += String.valueOf(i);
                    list.add(i);
                }
            }
            //유일성을 만족하는지 체크한다.
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < relation.length; i++) {
                String s = "";
                for (Integer j : list) {
                    s += relation[i][j];
                }
                //중복되는 컬럼이 있으면 리턴시킨다.(유일성만족X)
                if (map.containsKey(s)) {
                    return;
                } else {
                    map.put(s, 0);
                }
            }

            //최소성 만족여부 체크
            for (String s : candi) {
                int count = 0;
                for(int i = 0; i < key.length(); i++){
                    String subS = String.valueOf(key.charAt(i));
                    if(s.contains(subS)) count++;
                }
                if (count == s.length()) return;
            }
            //후보키 추가
            candi.add(key); //컬럼 인덱스번호를 문자열로 저장한다.(0, 12 ..등)
            return;
        }

        for (int i = start; i < visit.length; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            dfs(relation, i, depth + 1, end);
            visit[i] = false;
        }
    }
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}}));
    }
}
