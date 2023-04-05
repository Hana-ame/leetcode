import java.util.*;

class Solution {
    class O {
        int index;
        int score;
        O(int _index, int _score){
            index = _index;
            score = _score;
        }
    }
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        PriorityQueue<O> pq = new PriorityQueue<>(new Comparator<O>() {
            public int compare(O o1, O o2) {
                return o1.score - o2.score;
            }
        });
        int n = reward1.length;
        for (int i=0; i<n; i++) {
            pq.add(new O(i, reward2[i]-reward1[i]));
        }
        
        int r = 0;
        for (int i=0; i<n; i++) {
            r += reward2[i];
        }

        for (int i=0; i<k; i++) {
            O o = pq.poll();
            r -= o.score;
        }

        return r;
        
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] reward1 = new int[]{1,1,3,4};
        int [] reward2 = new int[]{4,4,1,1};
        solution.miceAndCheese(reward1, reward2, 2);
    }
}

