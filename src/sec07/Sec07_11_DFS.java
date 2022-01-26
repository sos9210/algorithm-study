package sec07;
//DFS
    class Node7{
        int data;
        Node7 lt,rt;
        public Node7(int val){
            data=val;
            lt=rt=null;
        }
    }
public class Sec07_11_DFS {
    Node7 root;
    public int DFS(int L, Node7 root){
        if(root.lt == null && root.rt == null){
            return L;
        }else{
            return Math.min(DFS(L+1,root.lt), DFS(L+1, root.rt));
        }
    }
    public static void main(String[] args) {
        Sec07_11_DFS tree = new Sec07_11_DFS();
        tree.root = new Node7(1);
        tree.root.lt = new Node7(2);
        tree.root.rt = new Node7(3);
        tree.root.lt.lt = new Node7(4);
        tree.root.lt.rt = new Node7(5);
        System.out.println(tree.DFS(0,tree.root));
    }
}
