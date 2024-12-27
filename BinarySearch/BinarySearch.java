/*
 * Author:  Daniella Seum, dseum2023@my.fit.edu
 * Course:  CSE 2010, Summer 2024
 * Project: Binary Search
 */
import java.util.Arrays;
 
public class BinarySearch {
   
   public static void main (final String[] args) {
      // Initialize the sorted array
      int[] array = {1, 3, 5, 7, 9, 10, 12, 14, 16, 18, 20};
      
      // Define the search range
      int left = 0;
      int right = array.length - 1;
      
      // Specify the target element to search for
      int target = 7;
      
      // Perform binary search
      final int result = binarySearch(array, left, right, target);
      
      // Display the result
      if (result != -1) 
         System.out.println("Element is present at index " + result);
      else
         System.out.println("Element is not present in array");
   }
   
   public static int binarySearch(int[] A, int L, int R, int T) {
      if (L > R) 
         return -1;
      else {
         int M = (L + R) / 2;
         if (A[M] < T)
            return binarySearch(A, M + 1, R, T);
         else if (A[M] > T)
            return binarySearch(A, L, M - 1, T);
         else
            return M; 
      }
   }
}
