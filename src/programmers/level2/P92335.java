package programmers.level2;

//k진수에서 소수 개수 구하기
public class P92335 {
    public static int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n, k);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            //해당 문자열인덱스가 0이 아니면
            if(num.charAt(i) != '0'){
                sb.append(num.charAt(i));
            //sb의 문자열길이가 0이 아니면
            }else if(sb.toString().length() != 0){
                //sb에 들어있는 숫자가 2보다 크고 소수라면 answer 1증가
                if(Long.valueOf(sb.toString()) >= 2 && check(sb.toString())) {
                    answer++;
                }
                //sb 초기화
                sb = new StringBuilder();
            }
        }
        //sb에 저장된 문자열이 없으면 바로 answer리턴
        if(sb.toString().equals("")) return answer;

        //sb에 저장된 숫자가 2보다크고 소수라면 answer 1증가
        if(Long.valueOf(sb.toString()) >= 2 && check(sb.toString())) {
            answer++;
        }
        return answer;
    }

    /*
    * 해당 문제는 소수를 구하는 것이 아닌 단순히 해당 숫자가 소수인지 여부만 체크
    * 소수를 구한다면 에라토스테네스의 체 사용해야함
    * */
    public static boolean check(String num){
        long number = Long.valueOf(num);

        //i부터 제곱근까지 루프
        for (int i = 2; i <= Math.sqrt(number); i++) {
            //소수인지 체크한다.
            if(number % i == 0) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        //System.out.println(solution(437674,3));
        //System.out.println(solution(110011,10));
        System.out.println(solution(16,10));
        //System.out.println(solution(2203301,10));
    }
}
