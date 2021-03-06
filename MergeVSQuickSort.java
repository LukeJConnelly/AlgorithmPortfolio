import java.util.Random;

//ARGUMENT GUIDE
// can be empty - runs defaults
// can be in the form args = {size of array to sort}
//eg. args = {"10000"}
// can be in the form args = {starting size of array to sort, maximum size of array to start}
//eg. args = {"10000", "20000"}

public class MergeVSQuickSort {
    public static void main(String[] args) {
        int n=1000, max=2000;
        if(args.length==1)
        {
            n= Integer.parseInt(args[0]);
            max=n;
        }
        if(args.length==2)
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
            long qstartTime = System.nanoTime();
            QuickSort(arr, 0, arr.length-1);
            long qendTime = System.nanoTime();
            long qTimeTaken = qendTime - qstartTime;
            System.out.println("\nArray size: " + n + "\nQuick Sort Time: " + qTimeTaken);
            long estartTime = System.nanoTime();
            QuickSortEnhanced(arr3, 0, arr3.length-1);
            long eendTime = System.nanoTime();
            long eTimeTaken = eendTime - estartTime;
            System.out.println("Enhanced Quick Sort Time: " + eTimeTaken);
            long mstartTime = System.nanoTime();
            MergeSort(arr2, 0, arr2.length-1);
            long mendTime = System.nanoTime();
            long mTimeTaken = mendTime - mstartTime;
            System.out.println("Merge Sort Time: " + mTimeTaken);
            n += 1000;
        }
    }

    public static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = low-1;
        for (int j=low; j<high; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void QuickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            QuickSort(arr, low, pi-1);
            QuickSort(arr, pi+1, high);
        }
    }

    public static void QuickSortEnhanced(int arr[], int low, int high)
    {
        if (high-low>0&&high-low<10)
        {
            int n=high-low;
            for (int i=low+1;i<n;++i) {
                int pointer=arr[i];
                int j=i-1;
                while (j>=low&&arr[j]>pointer) {
                    arr[j+1]=arr[j];
                    j=j-1;
                }
                arr[j+1]=pointer;
            }
        }
        if (low < high)
        {
            int pi = partition(arr, low, high);
            QuickSort(arr, low, pi-1);
            QuickSort(arr, pi+1, high);
        }
    }

    public static void Merge(int arr[], int l, int m, int r)
    {
        int subPointer1 = m-l +1;
        int subPointer2 = r - m;

        int SubTemp1[] = new int [subPointer1];
        int SubTemp2[] = new int [subPointer2];
        for (int i=0; i<subPointer1; ++i) {
            SubTemp1[i] = arr[l + i];
        }
        for (int j=0; j<subPointer2; ++j) {
            SubTemp2[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0;
        int toBeSet = l;
        while (i < subPointer1 && j < subPointer2)
        {
            if (SubTemp1[i] <= SubTemp2[j])
            {
                arr[toBeSet] = SubTemp1[i];
                i++;
            }
            else
            {
                arr[toBeSet] = SubTemp2[j];
                j++;
            }
            toBeSet++;
        }
        while (i < subPointer1)
        {
            arr[toBeSet] = SubTemp1[i];
            i++;
            toBeSet++;
        }
        while (j < subPointer2)
        {
            arr[toBeSet] = SubTemp2[j];
            j++;
            toBeSet++;
        }
    }
    public static void MergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            MergeSort(arr, l, m);
            MergeSort(arr , m+1, r);
            Merge(arr, l, m, r);
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
}
