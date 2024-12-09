class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length, i = 0, j = 0;
        while (j < n) {
            if (arr[i] == 0) j++;
            i++; j++;
        }
        i--; j--;
        while (i >= 0) {
            if (j < n) 
                arr[j] = arr[i];
            if (arr[i] == 0 && --j >= 0) 
                arr[j] = 0;
            i--; j--;
        }
    }
    public static void main(String[] args) {
        
        var so = new Solution();
        so.duplicateZeros(new int[]{0,0,0});
    }
}