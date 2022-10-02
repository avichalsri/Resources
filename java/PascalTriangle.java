
// Print Pascal's Triangle of height n
// Language: JAVA
/*
input:
5
output:
      1
     1 1
    1 2 1
   1 3 3 1
  1 4 6 4 1
 */

import java.util.Scanner;

class PascalTriangle {

    // Finding factorial
    public int factorial(int i) {
        if (i == 0)
            return 1;
        return i * factorial(i - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PascalTriangle obj = new PascalTriangle();

        // Accepting user input for height of triangle
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            // Loop for left spacing
            for (int j = 0; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Loop for nCr
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + obj.factorial(i) / (obj.factorial(i - j) * obj.factorial(j)));
            }
            // New line
            System.out.println();
        }
    }
}