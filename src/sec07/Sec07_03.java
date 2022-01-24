package sec07;

public class Sec07_03 {
    public int DFS(int n){
        if(n == 1){
            return 1;
        }else{
            return n * DFS(n-1);
        }
    }
    public static void main(String[] args) {
        Sec07_03 T = new Sec07_03();
        System.out.println(T.DFS(5));
    }
}
