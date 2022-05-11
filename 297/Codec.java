import java.util.*;
// Definition for a binary tree node.
public class Codec {
    StringBuilder sb;
    int MaxI = -1;
    int [] memo;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        sb = new StringBuilder();
        sb.append("[");
        Deque<TreeNode> que1 = new ArrayDeque<>();
        Deque<TreeNode> que2 = new ArrayDeque<>();
        que2.add(root);
        int nullnum = 0;
        nullnum += isnull(root.left);
        nullnum += isnull(root.right);
        // sb.append(String.valueOf(root.val));
        while(que2.size()*2 > nullnum){
            que1 = que2;
            que2 = new ArrayDeque<>();
            nullnum = 0;
            while (!que1.isEmpty()){
                TreeNode n = que1.pollFirst();
                if (n.val==Integer.MIN_VALUE)
                    sb.append("null");
                else    
                    sb.append(String.valueOf(n.val));   
                sb.append(",");
                if (n.val == Integer.MIN_VALUE) continue;
                que2.addLast(ifnull(n.left));
                que2.addLast(ifnull(n.right));                
                nullnum += isnull(n.left);
                nullnum += isnull(n.right);
            }            
        }
        que1 = que2;
        while (!que1.isEmpty()){
            TreeNode n = que1.pollFirst();
            if (n.val==Integer.MIN_VALUE)
                sb.append("null");
            else    
                sb.append(String.valueOf(n.val));   
            sb.append(",");
            if (n.val == Integer.MIN_VALUE) continue;
            que2.addLast(ifnull(n.left));
            que2.addLast(ifnull(n.right));                
            nullnum += isnull(n.left);
            nullnum += isnull(n.right);
        }            
        while (sb.length()-5>=0 && sb.substring(sb.length()-5, sb.length()).equals("null,"))
            sb.setLength(sb.length()-5);
        if (sb.charAt(sb.length()-1) == ',')  
            sb.setCharAt(sb.length()-1, ']');
        else
            sb.append("]");
        return sb.toString();
    }
    private TreeNode ifnull(TreeNode n){
        if (n==null) 
            return new TreeNode(Integer.MIN_VALUE);
        return n;
    }
    private int isnull(TreeNode n){
        if (n==null) return 1;
        return 0;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) return null;
        String [] ss = data.substring(1, data.length()-1).split(",");
        int i = 0;
        TreeNode root = builder(ss, i);
        Deque<TreeNode> que = new ArrayDeque<>();
        que.addLast(root);
        while (!que.isEmpty()){
            TreeNode n = que.pollFirst();
            n.left = builder(ss, ++i);
            n.right = builder(ss, ++i);
            if (n.left != null)
                que.addLast(n.left);
            if (n.right != null)
                que.addLast(n.right);
        }
        return root;
    }
    private TreeNode builder(String [] ss, int i){
        if (i>=ss.length) return null;
        if ("null".equals(ss[i])) return null;
        TreeNode node = new TreeNode(Integer.valueOf(ss[i]));
        // node.left = builder(ss, i*2+1);
        // node.right = builder(ss, i*2+2);
        return node;
    }
    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        
        TreeNode ans = deser.deserialize(
            "[1]"
        );
        String tree = ser.serialize(ans);
        
        System.out.println(tree);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
