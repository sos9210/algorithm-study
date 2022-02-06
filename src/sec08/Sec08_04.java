package sec08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Sec08_04 {

    static int level = Integer.MAX_VALUE;
    static Integer[] arr;
/*      //BFS방식.. 이 더 나아보인다.
        public int BFS(int target, int typesOfCoin, int[] coins, int[] check) {
            Queue<Integer> q = new LinkedList<>();
            check[target] = 1;
            q.offer(target);
            int level = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int exchange = q.poll();
                    for (int j = 0; j < typesOfCoin; j++) {
                        int nextExchange = exchange - coins[j];
                        if (nextExchange > 0 && check[nextExchange] == 0) {
                            check[nextExchange] = 1;
                            q.offer(nextExchange);
                        } else if (nextExchange == 0) return (level + 1);
                    }
                }
                level++;
            }
            return (-1);
        }

        public static void main(String[] args) {
            Main T = new Main();
            Scanner in = new Scanner(System.in);
            int typesOfCoin = in.nextInt();
            int[] coins = new int[typesOfCoin];
            for (int i = 0; i < typesOfCoin; i++) coins[i] = in.nextInt();
            int target = in.nextInt();
            int[] check = new int[target + 1];
            System.out.println(T.BFS(target, typesOfCoin, coins, check));
            return;
        }
    }
    */

    public void DFS(int L, int n, int m, int sum) {
        if (L >= level || sum > m) {
            return;
        }
        if (m == sum) {
            level = Math.min(level, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, n, m, arr[i] + sum);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Sec08_04 T = new Sec08_04();
        int n = in.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int m = in.nextInt();
        T.DFS(0, n, m, 0);
        System.out.println(level);
        return;
    }
}
