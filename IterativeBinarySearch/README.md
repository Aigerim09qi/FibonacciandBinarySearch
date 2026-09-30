import java.util.Arrays;

public class IterativeBinarySearch {

    // Iterative implementation of Binary Search
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids potential integer overflow

            if (arr[mid] == target) {
                return mid; // Target element found
            }

            if (arr[mid] < target) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }

        return -1; // Target element not found
    }

    public static void main(String[] args) {
        // Example 1: Target in the middle
        int[] arr1 = {1, 3, 5, 7, 9, 11, 13};
        int target1 = 7;
        System.out.println("Example 1: Array " + Arrays.toString(arr1) + ", Target = " + target1);
        System.out.println("Index: " + binarySearch(arr1, target1) + "\n");

        // Example 2: Target in the right half
        int[] arr2 = {2, 4, 6, 8, 10, 12, 14, 16};
        int target2 = 14;
        System.out.println("Example 2: Array " + Arrays.toString(arr2) + ", Target = " + target2);
        System.out.println("Index: " + binarySearch(arr2, target2) + "\n");

        // Example 3: Target element missing
        int[] arr3 = {10, 20, 30, 40, 50};
        int target3 = 25;
        System.out.println("Example 3: Array " + Arrays.toString(arr3) + ", Target = " + target3);
        System.out.println("Index: " + binarySearch(arr3, target3));
    }
}

/*
=======================================================
ITERATIVE BINARY SEARCH TRACE & EXPLANATION (3 EXAMPLES)
=======================================================

--- EXAMPLE 1: Target = 7 in [1, 3, 5, 7, 9, 11, 13] ---
- Iteration 1: low=0, high=6 -> mid = 3, arr[mid] = 7.
  Matches target! Returns index 3 immediately.

--- EXAMPLE 2: Target = 14 in [2, 4, 6, 8, 10, 12, 14, 16] ---
- Iteration 1: low=0, high=7 -> mid = 3, arr[mid] = 8.
  8 < 14 -> Adjusts left boundary: low = mid + 1 = 4.
- Iteration 2: low=4, high=7 -> mid = 5, arr[mid] = 12.
  12 < 14 -> Adjusts left boundary: low = mid + 1 = 6.
- Iteration 3: low=6, high=7 -> mid = 6, arr[mid] = 14.
  Matches target! Returns index 6.

--- EXAMPLE 3: Target = 25 in [10, 20, 30, 40, 50] ---
- Iteration 1: low=0, high=4 -> mid = 2, arr[mid] = 30.
  30 > 25 -> Adjusts right boundary: high = mid - 1 = 1.
- Iteration 2: low=0, high=1 -> mid = 0, arr[mid] = 10.
  10 < 25 -> Adjusts left boundary: low = mid + 1 = 1.
- Iteration 3: low=1, high=1 -> mid = 1, arr[mid] = 20.
  20 < 25 -> Adjusts left boundary: low = mid + 1 = 2.
- Loop Termination: low > high (2 > 1). Search terminates. Returns -1.


=======================================================
ALGORITHM EXPLANATION
=======================================================
1. Divide and Conquer Logic:
   Binary search halves the search space with every iteration by
   comparing the target to the middle element (arr[mid]).

2. State Progression:
    - If target == arr[mid]: The item is located.
    - If target > arr[mid]: Discard the left half by setting low = mid + 1.
    - If target < arr[mid]: Discard the right half by setting high = mid - 1.

3. Complexity Analysis:
    - Time Complexity: O(log n) because the array size is halved at each step.
    - Space Complexity: O(1) constant auxiliary space (iterative loop).
      */