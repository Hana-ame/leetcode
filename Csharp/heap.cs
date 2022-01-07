using System;
using System.Collections.Generic;
using System.Text;
// using Microsoft.VisualStudio.TeamSystem.Data.DataGenerator;


namespace Application
{
    class Heap
    {
        public static void Heapify(int root, int[] arr, int len)
        {
            if ((root<<1)+1>=len) return;
            int childi;
            if ((root<<1)+2>=len)
            {
                childi = (root<<1) + 1;
            }else{
                childi = (arr[(root<<1) + 1] > arr[(root<<1) + 2]) ? (root<<1) + 1 : (root<<1) + 2;     // 大顶堆
                // Console.WriteLine("childi??: {0}",childi);
            }
            // Console.WriteLine("childi: {0}",childi);
            if (arr[root] < arr[childi]) // 大顶堆
            {
                int t = arr[root];
                arr[root] = arr[childi];
                arr[childi] = root;
                Heapify(childi, arr, len);
            }
        }
        public static void Init(int[] arr, int len)
        {
            for (int i = len/2 ; i >= 0 ; i--)
            {
                Heapify(i, arr, len);
            }
        }
        public static void Sort(int[] arr, int len)
        {
            Init(arr,len); 
            for (int i = len-1; i>0; i--)        
            {
                int t = arr[0]; arr[0] = arr[i]; arr[i] = t;
                Heapify(0,arr,i);
            }
        }
    }
    
    class Execute
    {
        static void Main(string[] args)
        {
            Heap r = new Heap();
            int n;
            int [] arr;

            n = 100;            
            arr  =getRandomArr(n);
            // for (int i = 0; i<arr.Length; i++){ //debug
            //     Console.WriteLine(arr[i]);
            // }
            Heap.Sort(arr,n);

            // Heap.Heapify(0,arr,3);
            // for (int i = 0; i<arr.Length; i++){ //debug
            //     Console.WriteLine(arr[i]);
            // }

            // Heap.Init(arr,n);            
            // for (int i = 0; i<arr.Length; i++){ //debug
            //     Console.WriteLine(arr[i]);
            // }

            // for (int i = n-1; i>0; i--)        
            // {
            //     int t = arr[0]; arr[0] = arr[i]; arr[i] = t;
            //     Heap.Heapify(0,arr,i);
            // }
            
            // for (int i = 0; i<arr.Length; i++){ //debug
            //     Console.WriteLine(arr[i]);
            // }
            int range = 100000000;
            for (int i=range; i<=range; i*=10)
            {
                for (int j = 5; j>0; j--)
                {
                arr  =getRandomArr(i);
                DateTime start  = System.DateTime.Now;

                // Array.Sort(arr);

                DateTime stop  = System.DateTime.Now;
                TimeSpan ts = stop.Subtract(start);
                Console.WriteLine("n = {0}, 花费时间{1}ms.",i,ts.TotalMilliseconds);
                // for (int i = 0; i<arr.Length; i++){ //debug
                //     Console.WriteLine(arr[i]);
                // }
                // return;
                }                
            }

            for (int i=range; i<=range; i*=10)
            {
                for (int j = 5; j>0; j--)
                {
                arr  =getRandomArr(i);
                DateTime start  = System.DateTime.Now;

                Heap.Sort(arr,i);

                DateTime stop  = System.DateTime.Now;
                TimeSpan ts = stop.Subtract(start);
                Console.WriteLine("n = {0}, 花费时间{1}ms.",i,ts.TotalMilliseconds);
                // for (int i = 0; i<arr.Length; i++){ //debug
                //     Console.WriteLine(arr[i]);
                // }
                // return;
                }                
            }
            
            
        }
        static int [] getRandomArr(int n){
            int [] rArr = new int[n];
            Random randNum = new Random();
            for (int i = 0; i < rArr.Length; i++)
            {
                rArr[i] = randNum.Next(0, n*2);
                // rArr[i] = i;
            }
            return rArr;
        }
    }
}
