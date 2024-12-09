import java.util.*;
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return - values[a] + values[b];
        });
        for ( int i = 0; i < values.length; i++ ) {
            pq.add(i);
        }
        
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while ( numWanted > 0 && !pq.isEmpty()) {
            int idx = pq.poll();
            if (map.getOrDefault(labels[idx], 0) >= useLimit){
                continue;
            }
            map.put(labels[idx], map.getOrDefault(labels[idx], 0) + 1);
            ans += values[idx];
            numWanted--;
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] values = new int[]{5,4,3,2,1};
        int[] labels = new int[]{1,1,2,2,3};
        solution.largestValsFromLabels(values, labels, 3, 1);
    }
}

