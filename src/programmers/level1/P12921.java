package programmers.level1;

public class P12921 {

    //에라토스테네스의 체 .. 소수 찾기
    public static int solution(int n) {
        int answer = 0;
        int[] check = new int[n+1];

        for(int i = 2; i <=n; i++) check[i] = i;

        for(int i = 2; i < n;i++){
            if(check[i] == 0) continue; //소수가 아니라면 continue

            for(int j = 2*i; j <=n; j+=i) {
                check[j] = 0; //소수의 배수는 소수를 약수로 가지므로 제외
            }
        }

        for(int i = 0; i <= n; i++){
            if (check[i] != 0) answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(5));
    }
}
