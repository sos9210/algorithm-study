package programmers.level2;

public class P42839 {
    static int answer = 0;
    public static int solution(String numbers) {
        char[] chars = numbers.toCharArray();
        for (int i = 1; i <= numbers.length(); i++) {
            dfs(chars,i,"",0);
        }
        return answer;
    }
    public static void dfs(char[] chars,int length,String result,int idx){
        if(length == idx){
            int cnt = 0;
            int resultInt = Integer.parseInt(result);
            if(resultInt == 1) answer++;
            for (int i = 2; i < resultInt/2; i++) {
                if(resultInt % i != 0){
                    cnt++;
                }
            }
            if(cnt > 0) answer++;
            return;
        }
        for (int i = idx; i < chars.length; i++) {
            dfs(chars,length,result+chars[i],idx+1);
        }
    }
    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
}
