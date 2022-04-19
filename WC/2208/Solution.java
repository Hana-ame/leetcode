import java.util.PriorityQueue;

class Solution {
    // class Node{
    //     double a;
    //     int b;
    //     Node(double a, int b){
    //         this.a = a;
    //         this.b = b;
    //     }
    // }
    public int halveArray(int[] nums) {
// 初始化？
long sumlong = 0;
PriorityQueue<Double> numbers = new PriorityQueue<>(
    (b,a)->{
       return Double.compare(a,b);
});

for (int i=0; i<nums.length; i++){
    sumlong+=nums[i];
    numbers.add((double)(nums[i]));
}
double sum = (double)sumlong;
double half = sum/2;

int res = 0;
while (sum>half){
    Double n = numbers.poll();
    double t = n/2;
    sum -= t;    
    numbers.add(t);
    res ++;
}
return res;


    }
    public static void main(String[] args) {
        Solution s = new  Solution();
        System.out.println(s.halveArray(new int[]{5,19,8,1}));
    }
}