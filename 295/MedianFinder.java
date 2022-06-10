import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> hi;
    PriorityQueue<Integer> lo;
    public MedianFinder() {
        hi = new PriorityQueue<>((o1,o2)->{return o1-o2;});
        lo = new PriorityQueue<>((o1,o2)->{return o2-o1;});        
    }
    
    public void addNum(int num) {
        hi.add(num);
        if (hi.size()>=lo.size()+2){
            lo.add(hi.poll());
        }
        if (hi.size()>0 && lo.size()>0 && hi.peek() < lo.peek()){
            lo.add(hi.poll());
            hi.add(lo.poll());
        }
    }
    
    public double findMedian() {
        if (lo.size()==0){
            return hi.peek();
        }else if(lo.size()<hi.size())
            return hi.peek();
        else if (lo.size()==hi.size())
            return (double)(lo.peek()+hi.peek())/2;
        return 0;
    }
    public static void main(String[] args) {
        var s = new MedianFinder();
        double r;
        s.addNum(-1);
        r = s.findMedian();
        s.addNum(-2);
        r = s.findMedian();
        s.addNum(-3);
        r = s.findMedian();
        s.addNum(-4);
        r = s.findMedian();
        s.addNum(-5);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */