class Solution {
    public int maxWidthRamp(int[] nums) {
        int min = 500000;
        int mIdx = -1;
        // ArrayList<Integer> mIdxStack = new ArrayList<Integer>();
        Stack<Integer> mIdxStack = new Stack<Integer>();
        // LinkedList<Integer> mIdxStack = new LinkedList<>();
        // ArrayList<Integer> minStack =  new ArrayList<Integer>();
        int width = 0;
        int ramp = 0;
        for(int i=0; i<nums.length; i++){
            if (nums[i] < min) {
                mIdx = i;
                min = nums[i];
                mIdxStack.push(mIdx);
                // minStack.add(min);
            // }else{
                // System.out.println("min:"+(min)+","+mIdx);
                continue;
            }
            // System.out.println("wat:"+(nums[i]));
//             if (nums[i] - min >= 0){
//                 // System.out.println("hit:"+(i-mIdx));
//                 // ramp = nums[i] - min;
//                 for (int ii = mIdxStack.size()-1; ii>=0; ii--){
//                     // System.out.println("ii:"+ii);
//                     int idx = mIdxStack.get(ii);
//                     // System.out.println("hit:"+idx);
//                     if (nums[i] - nums[idx] >= 0 ){
//                         // int idx  = nums[ii];
//                         if (width < i-idx) width = i-idx;
//                     }
//                 }              
                
//             }                        
        }
        for(int i=nums.length-1; i>=0; i--){
            // while(!mIdxStack.isEmpty() && nums[mIdxStack.peek()] <= nums[i] ){
                while(!mIdxStack.empty() && nums[mIdxStack.peek()] <= nums[i] ){
                width = Math.max(width, i - mIdxStack.pop());
            }
        }
        return width;
    }
}