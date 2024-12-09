class Solution {
    public String orderlyQueue(String s, int k) {
        if(k==1){
            String r = s;
            for(int i=0; i<s.length(); i++){
                if(r.compareTo(s.substring(i,s.length())+s.substring(0,i))>0){
                    r = s.substring(i,s.length())+s.substring(0,i);
                }
            }
            return r;
        }else{
            PriorityQueue<Character> pq = new PriorityQueue<>();
            for(int i=0; i<s.length(); i++){
                pq.add(s.charAt(i));
            }
            StringBuilder sb = new StringBuilder();
            while(!pq.isEmpty()){
                sb.append(pq.poll());
            }
            return sb.toString();
        }
    }
}