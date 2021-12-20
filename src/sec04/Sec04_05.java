package sec04;

import java.util.*;

public class Sec04_05 {
    public int solution(List<Integer> list, int k){
        /* // 내가 푼것..
        int answer = 0, sum = 0;
        Collections.sort(list);
        Collections.reverse(list);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            for (int j = i+1; j < list.size()-1; j++) {
                sum += list.get(j);
                for (int l = j+1; l < list.size()-2; l++) {
                    sum += list.get(l);
                    set.add(sum);
                    sum -= list.get(l);
                }
                sum -= list.get(j);
            }
            sum -= list.get(i);
        }
        List<Integer> list2 = new ArrayList<>();
        for (Integer x : set) {
            list2.add(x);
        }
        Collections.sort(list2);
        Collections.reverse(list2);
        try {
            return list2.get(k-1);
        }catch (Exception e){
            return -1;
        }
         */
        int answer = -1;
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < list.size()-2; i++) {
            for (int j = i+1; j < list.size()-1; j++) {
                for (int l = j+1; l < list.size(); l++) {
                    set.add(list.get(i) + list.get(j) + list.get(l));
                }
            }
        }
        int cnt = 0;
        for (int x: set) {
            cnt++;
            if(cnt == k){
                return x;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        Sec04_05 T =new Sec04_05();
        System.out.println(T.solution(list,k));
        return ;
    }
}
