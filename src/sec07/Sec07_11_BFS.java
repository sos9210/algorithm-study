package sec07;

import java.util.LinkedList;
import java.util.Queue;

//BFS
    class Node77{
        int data;
    Node77 lt,rt;
        public Node77(int val){
            data=val;
            lt=rt=null;
        }
    }

public class Sec07_11_BFS {
    Node77 root;
    public int BFS(Node77 root){
        Queue<Node77> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                Node77 cur = q.poll();
                if(cur.lt == null && cur.rt == null){
                    return level;
                }
                if(cur.lt != null){
                    q.offer(cur.lt);
                }
                if(cur.rt != null){
                    q.offer(cur.rt);
                }
            }
            level++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Sec07_11_BFS tree = new Sec07_11_BFS();
        tree.root = new Node77(1);
        tree.root.lt = new Node77(2);
        tree.root.rt = new Node77(3);
        tree.root.lt.lt = new Node77(4);
        tree.root.lt.rt = new Node77(5);
        System.out.println(tree.BFS(tree.root));
    }
}
