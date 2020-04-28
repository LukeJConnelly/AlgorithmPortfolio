/******************************************************************************
 *  Compilation:  javac ThreeSumA.java
 *  Execution:    java ThreeSum input.txt
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 ******************************************************************************/
import java.util.Arrays;
import java.lang.*;

//ARGUMENT GUIDE
//should take the name (including extension) of any file containing only a list of integers
//the file should be in the same directory as this file
//eg. args = {"8Kints.txt"}

public class ThreeSumA {

    // Do not instantiate.
    private ThreeSumA() { }



    /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param  a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     *         such that {@code a[i] + a[j] + a[k] == 0}
     */
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    } 

    /**
     * Reads in a sequence of integers from a file, specified as a command-line argument;
     * counts the number of triples sum to exactly zero; prints out the time to perform
     * the computation.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)  {
        In in;
        if(args.length==0)
        {
            in = new In("1Kints.txt");
        }
        else {
            in = new In(args[0]);
        }
        int[] a = in.readAllInts();
        long startTime = System.nanoTime();
        int count = count(a);
        long endTime = System.nanoTime();
        long TimeTaken = endTime - startTime;
        System.out.println("ThreeSumA Time: "+TimeTaken);
    } 
} 


