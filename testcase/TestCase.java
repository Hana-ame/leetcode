import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

class TestCase{
    public static String getHTMLwithCookie(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.addRequestProperty("Cookie","csrftoken=ZoxTudevemei4JKwVglPTqJk20vnUIKmGQxgSmvLnVj1mPXZhkROeYGutz0Jp2e5");
        conn.addRequestProperty("Cookie","LEETCODE_SESSION=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuZXh0X2FmdGVyX29hdXRoIjoiL3Byb2JsZW1zL3JhbmRvbS1wb2ludC1pbi1ub24tb3ZlcmxhcHBpbmctcmVjdGFuZ2xlcy8iLCJfYXV0aF91c2VyX2lkIjoiNDE3NTk1NCIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiMzk4ODQ3Yjg3MWEwMWE2MDhjNGYyYjMxNzQ0YTFhMjhhNDk5ZTEyZmJmYTgzYjcyMzc1ODZjMDY5YmIxNTY2ZCIsImlkIjo0MTc1OTU0LCJlbWFpbCI6ImFkbWluQGhhbmEtc3dlZXQudG9wIiwidXNlcm5hbWUiOiJoYW5hLWFtZWxpYSIsInVzZXJfc2x1ZyI6ImhhbmEtYW1lbGlhIiwiYXZhdGFyIjoiaHR0cHM6Ly9hc3NldHMubGVldGNvZGUuY24vYWxpeXVuLWxjLXVwbG9hZC91c2Vycy9oYW5hLWFtZWxpYS9hdmF0YXJfMTYzOTgxMTU4OC5wbmciLCJwaG9uZV92ZXJpZmllZCI6ZmFsc2UsIl90aW1lc3RhbXAiOjE2NTQ3NTQ2MjIuNTMzNzk4NywiZXhwaXJlZF90aW1lXyI6MTY1NzMwNjgwMCwidmVyc2lvbl9rZXlfIjowLCJsYXRlc3RfdGltZXN0YW1wXyI6MTY1NTI0NTEyM30.qtPCjf450MVJAqM96bSBNCHv1lN3L1FAW_N6BtbJcYA");
        conn.addRequestProperty("Cookie","_bl_uid=4klgg45I6qFm2a6880tszF82s6I2");
        conn.addRequestProperty("Cookie","aliyungf_tc=c3a2eadd51ce3159e540788a93768994f26327b9e9b826de3be538dbdf8dcce1");
        conn.addRequestProperty("Cookie","NEW_PROBLEMLIST_PAGE=1");
        try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()) )) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }
    public static int[][] UnMarshalInt2D(String t){
        String inner = t.substring(2,t.length()-2);
        String [] arr2d = inner.split("\\], \\["); // fuck this https://stackoverflow.com/questions/21816788/unclosed-character-class-error
        // int m = arr.length;
        int [][] res = new int[arr2d.length][];
        for (int i=0;i<arr2d.length;i++){
            String [] arr1d = arr2d[i].split(", ");
            res[i] = new int[arr2d.length];
            for (int j=0; j<arr1d.length; j++){
                // System.out.println(arr1d[j]);
                res[i][j] = Integer.parseInt(arr1d[j]);
            }
        }
        return res;
    }
    public static int[] UnMarshalInt1D(String t){
        String inner = t.substring(1,t.length()-1);
        String [] arr1d = inner.split(", ");
        int [] res = new int[arr1d.length];
        for (int j=0; j<arr1d.length; j++){
            // System.out.println(arr1d[j]);
            res[j] = Integer.parseInt(arr1d[j]);
        }        
        return res;
    }
    public static int UnMarshalInt(String t){
        return Integer.parseInt(t);
    }
    // String url = "";
    int i = 0;
    String txt = "";    
    String [] txtArr = null;
    TestCase(String url) throws Exception {
        // url = _url;
        i=0;
        txt = getHTMLwithCookie(url);
        txtArr = txt.split("\n");
    }
    public int[][] UnMarshalInt2D(){
        i++;
        return UnMarshalInt2D(txtArr[i-1]);
    }
    public int[] UnMarshalInt1D(){
        i++;
        return UnMarshalInt1D(txtArr[i-1]);
    }
    public int UnMarshalInt(){
        i++;
        return UnMarshalInt(txtArr[i-1]);
    }
    
    public static void main(String[] args) {
        String res = null;
        try{
            res = getHTMLwithCookie("https://leetcode.cn/submissions/detail/325354314/testcase/");
        }catch (Exception e){
            e.printStackTrace();
        }
        var a = UnMarshalInt2D(res);
        System.out.println(a);
    }
}