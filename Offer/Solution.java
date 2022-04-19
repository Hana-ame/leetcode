
// Definition for a Node.


import java.util.*;
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
class Solution {


    List<Node> nl;
    public Node treeToDoublyList(Node root) {
        nl = new ArrayList<>();
        // 中序遍历加入nl
        mlr(root);
        int n = nl.size();
        if (n == 1){
            root.left = root;
            root.right = root;            
        }else{
            for (int i=0; i+1<n; i++){
                Node e0 = nl.get(i);
                Node e1 = nl.get(i+1);
                e0.right = e1;
                e1.left = e0;
            }
            Node e1 = nl.get(0);
            Node e0 = nl.get(n-1);
            e0.right = e1;
            e1.left = e0;

        }
        return nl.get(0);
    }
    private void mlr(Node root){
        if (root == null) return;
        mlr(root.left);
        nl.add(root);
        mlr(root.right);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        s.treeToDoublyList(root);
    }
}