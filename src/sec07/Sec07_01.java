package sec07;

public class Sec07_01 {
    public void DFS(int n){
        if(n == 0) return;
        else {
            DFS(n-1);
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        Sec07_01 T = new Sec07_01();
        T.DFS(3);
    }
}
