package programmers.level2;

public class P12953 {
    public static int solution(int[] arr) {
        long multiple = arr[0];
        int answer = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            multiple *= arr[i];
            max = Math.max(arr[i],max);
        }

        for (int i = max; i < multiple/2; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if(i%arr[j] == 0){
                    ++count;
                }else{
                    break;
                }
            }
            if(count == arr.length) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2,6,8,14}));
        System.out.println(solution(new int[] {12}));
    }
}
