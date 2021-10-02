package Algos;
 
import java.util.Scanner;
 
public class maxHistogramArea {
 
    public static void main(String[] args) {
 
        Scanner scn = new Scanner(System.in);
        /*input number of bars in the histogram*/   
        int n = scn.nextInt();
            long[] a = new long[n];
            /*input height of each bar*/
            for (int i = 0; i < a.length; i++) {
                a[i] = scn.nextLong();
            }
 
            System.out.println(solve(a));
    }
 
    public static long solve(long[] a) {
        /*final max rectangular area to be returned*/
        long ans = 0;
 
        /*considering every bar as a starting point of an area*/
        for (int i = 0; i < a.length; i++) {
            /*for keeping track of shortest bar encountered yet
             * when 'i' is chosen as the starting point of an area*/
            long min = Integer.MAX_VALUE;
            /* area when  when 'i' is chosen as the starting point
             * of an area*/
            long rv=0;
            for (int j = i; j < a.length; j++) {
                /*current area will be the height of the shortest
                 * bar multiplied with the number of bars*/
                min = Math.min(min, a[j]);
                rv = Math.max(rv, min * (j - i+1));
            }
            /*updating overall max with the current max*/
            ans = Math.max(ans, rv);
        }
        return ans;
    }
 
}
