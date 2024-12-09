using System;
using System.Collections;
using System.Collections.Generic;


public class Solution {
    public string LargestWordCount(string[] messages, string[] senders) {
        Dictionary<string, int> dic = new Dictionary<string, int>();
        int n = senders.Length;
        for(int i = 0; i < n; i++)
        {
            string name = senders[i];
            string msg = messages[i];
            if(!dic.ContainsKey(name))
            {
                dic.Add(name, 0);
            }
            dic[name] += GetWords(msg);
        }
        string ret = "";
        int count = 0;
        foreach(var item in dic)
        {
            if(item.Value > count)
            {
                ret = item.Key;
                count = item.Value;
            }
            else if(item.Value == count)
            {
                if(IsLarger(item.Key, ret))
                {
                    ret = item.Key;
                }
            }
        }
        return ret;
    }
    
    private int GetWords(string s)
    {
        int ret = 1;
        foreach(char c in s)
        {
            if(c == ' ')
            {
                ret++;
            }
        }
        return ret;
    }
    
    private bool IsLarger(string a, string b)
    {
        for(int i = 0; i < Math.Max(a.Length, b.Length); i++)
        {
            if(i >= a.Length)
            {
                return false;
            }
            if(i >= b.Length)
            {
                return true;
            }
            if(a[i] != b[i])
            {
                return a[i] - b[i] > 0;
            }
        }
        return false;
    }


    public static void Main(string[] args)
    {
        
        string a = "aa";
        string b = "a";
        var v = "aa".CompareTo("A");
        Console.WriteLine(v);
    }


}