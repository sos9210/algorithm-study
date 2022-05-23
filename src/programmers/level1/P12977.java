package programmers.level1;

public class P12977 {
    public static int solution(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                int sum = nums[i]+nums[j]+nums[k];
                    if(isCheck(sum)){
                        result++;
                    }
                }
            }
        }
        return result;
    }
    private static boolean isCheck(int num){
        for (int i = 2; i < num; i++) { //소수는 2랑 3뿐만아니라 2 ~ 체크하고자하는 수 이전까지로 해서 체킹해야됨...
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,7,6,4}));
    }
}
