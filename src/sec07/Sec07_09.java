package sec07;

import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    int data;
    Node2 lt, rt;
    public Node2(int val){
        data = val;
        lt=rt=null;
    }
}

public class Sec07_09 {
    Node2 root;
    public void BFS(Node2 root){
        Queue<Node2> q = new LinkedList<>();
        q.offer(root);
        int level=0;
        while(!q.isEmpty()){
            int len = q.size();
          System.out.print(level+" : ");
            for (int i = 0; i < len; i++) {
                Node2 cur = q.poll();
                System.out.print(cur.data+" ");
                if(cur.lt != null){
                    q.offer(cur.lt);
                }
                if(cur.rt != null){
                    q.offer(cur.rt);
                }
            }
            level++;
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Sec07_09 tree = new Sec07_09();
        tree.root = new Node2(1);
        tree.root.lt = new Node2(2);
        tree.root.rt = new Node2(3);
        tree.root.lt.lt = new Node2(4);
        tree.root.lt.rt = new Node2(5);
        tree.root.rt.lt = new Node2(6);
        tree.root.rt.rt = new Node2(7);
        tree.BFS(tree.root);
    }
}
