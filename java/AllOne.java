import java.util.*;

class AllOne {

    class Node {
        Node prev;
        Node next;
        Set<String> ks;
        int cnt;

        public Node() {
            this("", 0);
        }
        public Node(String s, int cnt){
            this.cnt = cnt;
            this.ks = new HashSet<String>();
            ks.add(s);            
        }
        public Node insert(Node n){
            n.prev = this;
            n.next = this.next;
            this.next.prev = n;
            this.next = n;
            return n;
        }
        public void remove(){
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }

    }

    Node root;
    Map<String, Node> nodes;


    public AllOne() {
        root = new Node();
        root.prev = root;
        root.next = root;  
        nodes = new HashMap<String, Node>();
    }
    
    public void inc(String key) {
        if (nodes.containsKey(key)){
            Node t = nodes.get(key);
            Node n = t.next;
            if (n == root || n.cnt > t.cnt+1){ // 新建的情况
                Node nn = t.insert(new Node(key, t.cnt+1));
                nodes.put(key, nn);
            } else { // 丢进下一个
                n.ks.add(key);
                nodes.put(key, n);
            }
            t.ks.remove(key);
            if (t.ks.isEmpty()){
                t.remove();
            }
        }else{//new
            if ( root.next == root || root.next.cnt > 1){ // 新建的情况
                nodes.put(key, root.insert(new Node(key,1)));
            }else{
                root.next.ks.add(key);
                nodes.put(key, root.next);
            }
        }
    }
    
    public void dec(String key) {
        Node t = nodes.get(key);
        if (t.cnt == 1) {
            nodes.remove(key);
        }else{
            Node prev = t.prev;
            if (prev == root || prev.cnt < t.cnt-1 ){
                Node nn = t.prev.insert(new Node(key, t.cnt-1)); // 同加入
                nodes.put(key, nn);
            }else{ //
                prev.ks.add(key); // 加入这个key
                nodes.put(key, prev);
            }
        }
        
        t.ks.remove(key); // 消掉这个key
        if (t.ks.isEmpty()){
            t.remove();
        }
    }
    
    public String getMaxKey() {
        return root.prev != null ? root.prev.ks.iterator().next() : "";
    }
    
    public String getMinKey() {
        return root.next != null ? root.next.ks.iterator().next() : "";
    }

    public static void main(String[] args) {
        AllOne s = new AllOne();
        // s.AllOne();
        s.inc("a");
        s.inc("a");
        s.inc("a");
        s.dec("a");
        s.dec("a");
    }
}
