public class Solution {
    public string SimplifyPath(string path) {
        string[] arr =  path.Split('/');
        // Console.WriteLine("{0}", string.Join("/", arr.Take(2)));
        int len = arr.Length;
        int ptr = 1;
        for (int i = 1; i<len; i++)
        // foreach (string item in arr)
        {
            // Console.WriteLine(arr[i]);           

            // 迭代器会慢一点
            // if (item == "." || item == "") continue;
            // if (item == ".." ) {
            //     if (ptr>1) ptr--; 
            //     continue;
            // }
            // arr[ptr] = item;
            // ptr++;
            if (arr[i].Length <= 2){
                if (arr[i] == "." || arr[i].Length == 0) continue;
                if (arr[i] == ".." ) {
                    if (ptr>1) ptr--; 
                    continue;
                }
            }
            arr[ptr] = arr[i];
            ptr++;
        }
        if (ptr==1) return "/";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i<ptr; i++)
        {
            builder.Append('/');
            builder.Append(arr[i]);
        }
        return builder.ToString();

        // return string.Join("/", arr.Take(ptr));
    }
}