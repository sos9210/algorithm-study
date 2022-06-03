package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class P42839 {
    static boolean[] visit;
    static Set<Integer> set = new HashSet<>();  // 011 , 11 같은 중복을 제거하기위해 set을 사용한다.
    public static int solution(String numbers) {
        visit = new boolean[numbers.length()];
        dfs(numbers,"",0);
        return set.size();
    }
    public static void dfs(String numbers,String current,int idx){
        if(numbers.length() == idx){
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {

            if(!visit[i]){//numbers의 해당 인덱스를 조회했는지 여부 확인
                visit[i] = true;
                String number = current + numbers.charAt(i);
                if(check(number)){
                    set.add(Integer.parseInt(number));
                }

                dfs(numbers,number,idx+1);
                visit[i] = false;
            }
        }
    }
    //소수 체크
    public static boolean check(String number){
        int num = Integer.parseInt(number);
        for (int i = 2; i <= num/2; i++) {
            if(i!=num && num % i == 0){
                return false;
            }
        }
        if(num <= 1) return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
}
