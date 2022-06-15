package programmers.level2;

import java.util.Optional;
//[1차] 캐시
//cache hit = 1 , cache miss = 5
public class P17680 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        //캐시
        String[] cache = new String[cacheSize];
        //캐시사이즈가 0이면 전부 cache miss
        if(cacheSize == 0) return cities.length*5;

        for (int i = 0; i < cities.length; i++) {
            //캐시에 도시이름이 있으면 true 없으면 false
            boolean check = false;
            //캐시에 도시이름이 있는지 확인한다.
            for (int j = 0; j < cacheSize; j++) {
                //대소문자 구분을 하지않으므로 toLowerCase()처리
                if(cache[j] != null && cities[i].toLowerCase().equals(cache[j].toLowerCase())){
                    //캐시에 도시이름이 있으면 해당 캐시를 맨앞으로 보내고 나머지 캐시들은 뒤로 민다.
                    for (int k = j; k > 0; k--) {
                        String tmp = cache[k];
                        cache[k] = cache[k-1];
                        cache[k-1] = tmp;
                    }
                    check = true;
                }
            }
            //cache hit
            if(check) answer+=1;
            //cache miss
            else {
                //캐시배열값들을 앞에서 뒤로 땡겨온다
                for (int j = cacheSize-1; j > 0; j--) {
                    cache[j] = cache[j-1];
                }
                //맨앞 캐시배열에 찾는 도시이름을 저장한다.
                cache[0] = cities[i];
                answer+=5;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //System.out.println(solution(3,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); //50
        //System.out.println(solution(3,new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));  //21
        //System.out.println(solution(2,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));  //60
        //System.out.println(solution(5,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));  //52
        System.out.println(solution(2,new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));  //16
        System.out.println(solution(0,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));  //25
    }
}
