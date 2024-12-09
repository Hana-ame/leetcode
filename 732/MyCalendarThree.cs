public class MyCalendarThree {
    SortedList<int, int> bookList;

    public MyCalendarThree()    {
        bookList = new SortedList<int, int>();
    }

    public int Book(int start, int end) {
        if(!bookList.ContainsKey(start)) {
            bookList.Add(start, 0);
        }
        bookList[start]++;
        if (!bookList.ContainsKey(end)) {
            bookList.Add(end, 0);
        }
        bookList[end]--;
        int max = 0;
        int cur = 0;
        foreach (var item in bookList) {
            cur += item.Value;
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.Book(start,end);
 */