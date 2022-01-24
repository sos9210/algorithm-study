package sec05;

import java.util.Scanner;
import java.util.Stack;

public class Sec05_04 {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x:str.toCharArray()) {
            if(Character.isDigit(x)){
                stack.push(x-48);
            }else{
                int rt = stack.pop();
                int lt = stack.pop();
                if(x == '+'){
                    stack.push(lt+rt);
                }
                else if(x == '-'){
                    stack.push(lt - rt);
                }
                else if(x == '/'){
                    stack.push(lt / rt);
                }
                else if(x == '*'){
                    stack.push(lt * rt);
                }
            }
        }

        return stack.pop();
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.next();
        Sec05_04 T = new Sec05_04();
        System.out.println(T.solution(str));
        return ;
    }
}
