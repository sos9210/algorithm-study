package programmers.level1;

public class P17681 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
/*
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String num1 = Integer.toBinaryString(arr1[i]);
            String num2 = Integer.toBinaryString(arr2[i]);
            if(n != num1.length()){
                int length = num1.length();
                for (int j = 0; j < n- length; j++) {
                    num1 = "0"+num1;
                }
            }
            if(n != num2.length()){
                int length = num2.length();
                for (int j = 0; j < n-length; j++) {
                    num2 = "0"+num2;
                }
            }
            answer[i] = "";
            for (int j = 0; j < n; j++) {
                if(num1.toCharArray()[j] == '0' && num2.toCharArray()[j] == '0'){
                    answer[i]+=" ";
                }else{
                    answer[i]+="#";
                }
            }
        }
        return answer;
        */
        //훨씬 빠르고 짧다. 그리고 가독성있다..
        String[] answer = new String[n];
        String temp;

        for(int i = 0 ; i < n ; i++){
            temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
            temp = temp.substring(temp.length() - n);
            temp = temp.replaceAll("1", "#");
            temp = temp.replaceAll("0", " ");
            answer[i] = temp;
        }

        return answer;

    }
    public static void main(String[] args) {
        for (String str:solution(5,new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})) {
            System.out.println(str);
        }
    }
}
