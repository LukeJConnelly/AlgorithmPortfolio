import java.util.Random;

//ARGUMENT GUIDE
// can be empty - runs defaults
// can be in the form args = {size of array to sort}
//eg. args = {"10000"}
// can be in the form args = {starting size of array to sort, maximum size of array to start}
//eg. args = {"10000", "20000"}
// can be in the form args = {starting size of array to sort, maximum size of array to start, yes/no to include dumb sort}
//eg. args = {"100", "1100", "yes"}

import static java.lang.CharSequence.compare;

public class InsertionVSSelection {
    public static void main(String[] args) {
        int n=1000, max=2000;
        if(args.length==1)
        {
            n= Integer.parseInt(args[0]);
            max = n;
        }
        if(args.length>2)
        {
            n= Integer.parseInt(args[0]);
            max = Integer.parseInt(args[1]);
        }
        while(n<=max) {
            int[] arr = new int[n];
            Random rnd = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = rnd.nextInt() % 1000;
            }
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                arr2[i] = rnd.nextInt() % 1000;
            }
            int[] arr3 = new int[n];
            for (int i = 0; i < n; i++) {
                arr3[i] = rnd.nextInt() % 1000;
            }
            long istartTime = System.nanoTime();
            InsertionSort(arr);
            long iendTime = System.nanoTime();
            long iTimeTaken = iendTime - istartTime;
            System.out.println("\nArray size: " + n + "\nInsertion Sort Time: " + iTimeTaken);
            long sstartTime = System.nanoTime();
            SelectionSort(arr3);
            long sendTime = System.nanoTime();
            long sTimeTaken = sendTime - sstartTime;
            System.out.println("Selection Sort Time: " + sTimeTaken);
            if(args.length==3)
            {
                if(args[2].compareTo("yes")==0)
                {
                    System.out.println("Allow a moment please...");
                    long dstartTime = System.nanoTime();
                    DumbSort(arr2);
                    long dendTime = System.nanoTime();
                    long dTimeTaken = dendTime - dstartTime;
                    System.out.println("Dumb Sort Time: " + dTimeTaken);
                }
            }
            n+=1000;
        }
    }

    public static void InsertionSort(int[] arr)
    {
        int n=arr.length;
        for (int i=1;i<n;++i) {
            int pointer=arr[i];
            int j=i-1;
            while (j>=0&&arr[j]>pointer) {
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=pointer;
        }
    }

    public static void SelectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int t = arr[min];
            arr[min] = arr[i];
            arr[i] = t;
        }
    }

    public static void DumbSort(int[] arr)
    {
        int n = arr.length;
        Random rnd = new Random();
        boolean flag=true;
        int i=0;
        while (flag) {
            flag = false;
            for (i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    int t=arr[i+1], rando = rnd.nextInt(i+1);
                    arr[i+1] = arr[rando];
                    arr[rando] = t;
                }
            }
        }
    }
}
