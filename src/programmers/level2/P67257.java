package programmers.level2;

import java.util.ArrayList;

public class P67257 {
    static char[] prior = {'+', '-', '*'};
    static boolean[] check = new boolean[3];
    static ArrayList<Long> nums = new ArrayList<Long>();
    static ArrayList<Character> ops = new ArrayList<Character>();
    static long answer;

    public static long solution(String expression) {
        answer = 0;

        String num="";
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
                num += expression.charAt(i);
            }else{
                nums.add(Long.parseLong(num));  //숫자를 List에 넣는다.
                num = "";
                ops.add(expression.charAt(i));  //연산자를 List에 넣는다.
            }
        }
        nums.add(Long.parseLong(num));
        dfs(0, new char[3]);

        return answer;
    }

    public static Long calc(Long num1, Long num2, char op){
        long num = 0;
        switch (op){
            case '+' : {
                return num1 + num2;
            }
            case '-' : {
                return num1 - num2;
            }
            case '*' : {
                return num1 * num2;
            }
        }
        return num;
    }

    public static void dfs(int count, char[] p){
        if(count == 3){ //연산 순서가 정해지면 계산시작
            ArrayList<Long> cNums = new ArrayList<>(nums);
            ArrayList<Character> cOps = new ArrayList<Character>(ops);

            for(int i=0;i<p.length;i++){
                for(int j=0; j< cOps.size(); j++){
                    if(p[i] == cOps.get(j)){
                        Long res = calc(cNums.remove(j), cNums.remove(j), p[i]);
                        cNums.add(j, res);
                        cOps.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(cNums.get(0)));
            return;

        }
        //+-* 연산 순서를 정한다.
        for(int i=0; i< 3; i++){
            if(!check[i]){
                check[i] = true;
                p[count] = prior[i];
                dfs(count+1,p);
                check[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
        System.out.println(solution("50*6-3*2"));
    }
}
