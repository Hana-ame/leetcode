class Solution {
    // public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
    //     char[] chars = s.toCharArray();
    //     Node root = buildTree(chars, 0, s.length() - 1);
    //     int[] res = new int[queryIndices.length];
    //     for (int i = 0; i < queryIndices.length; i++) {
    //         char c = queryCharacters.charAt(i);
    //         int index = queryIndices[i];
    //         res[i] = query(chars, root, 0, s.length() - 1, index, c);
    //     }
    //     return res;
    // }

    // private Node buildTree(char[] chars, int l, int r) {
    //     Node node = new Node(l, r);
    //     if (l == r) {
    //         return node;
    //     }
    //     int mid = (l + r) >>> 1;
    //     node.left = buildTree(chars, l, mid);
    //     node.right = buildTree(chars, mid + 1, r);
    //     merge(chars, node, l, r, mid);
    //     return node;
    // }

    // private int query(char[] chars, Node root, int l, int r, int i, char c) {
    //     if (l == r) {
    //         chars[i] = c;
    //     } else {
    //         int mid = (l + r) >>> 1;
    //         if (i <= mid) {
    //             query(chars, root.left, l, mid, i, c);
    //         } else {
    //             query(chars, root.right, mid + 1, r, i, c);
    //         }
    //         merge(chars, root, l, r, mid);
    //     }
    //     return root.max;
    // }

    // private void merge(char[] chars, Node root, int l, int r, int mid) {
    //     root.max = Math.max(root.left.max, root.right.max);
    //     root.pre = root.left.pre;
    //     root.suf = root.right.suf;
    //     if (chars[mid] == chars[mid + 1]) {
    //         root.max = Math.max(root.max, root.left.suf + root.right.pre);
    //         if (root.left.max == mid - l + 1) {
    //             root.pre += root.right.pre;
    //         }
    //         if (root.right.max == r - mid) {
    //             root.suf += root.left.suf;
    //         }
    //     }
    // }

    static class Node {
        // 前缀，后缀，最大
        int p = 1, s = 1, max = 1;
        // 区间信息
        int l, r;
        Node left = null, right = null;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    char [] cs;
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        cs = s.toCharArray();
        Node root = buildTree(0, cs.length-1);
        int[] res = new int[queryIndices.length];
        for (int i = 0; i < queryIndices.length; i++) {
            char c = queryCharacters.charAt(i);
            int index = queryIndices[i];
            res[i] = query(root, 0, s.length() - 1, index, c);
        }
        return res;
    }
    public int query(Node root, int l, int r, int qi, char c){
        if (l==r){
            cs[qi] = c;
        }else{
            int mid = (l+r)/2;
            if (qi<=mid){
                query(root.left, l, mid, qi, c);
            }else{
                query(root.right, mid+1, r, qi, c);
            }
            merge(root, l, r, mid);
        }
        return root.max;

    }

    public Node buildTree(int l, int r){// 闭区间
        Node n = new Node(l,r);
        if (l==r) return n;
        int mid = (l+r)/2;
        n.left = buildTree(l, mid);
        n.right = buildTree(mid+1, r); 
        merge(n, l, r, mid);
        return n;
    }
    public void merge(Node n, int l, int r, int mid){
        // [l,mid] [mid+1,r] => [l,r]
        // 计算左区间
        if(n.left.p == (mid-l+1) && cs[mid] == cs[mid+1]){ // 如果全长相等的情况 // 可以合并
            n.p = n.left.p+n.right.p; // 长度
        }else{
            n.p = n.left.p;
        }
        // 计算右区间
        if(n.right.s == (r-mid) && cs[mid] == cs[mid+1]){ // 如果全长相等的情况 // 可以合并
            n.s = n.left.s+n.right.s; // 长度
        }else{
            n.s = n.right.s;
        }
        // 计算中间分割区间
        // int mlen = 0;
        if (cs[mid] == cs[mid+1]){
            n.max = n.left.s+n.right.p;
        }else{
            n.max = 0;
            // mlen = Math.max(n.left.s,n.right.p);
        }
        // 找到max
        n.max = Math.max(n.max, n.left.max);
        n.max = Math.max(n.max, n.right.max);
        // n.max = Math.max(n.max, mlen);
        
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestRepeating("lptxlmmlcvfihnsulmomex","t",new int[]{1});
    }
}
