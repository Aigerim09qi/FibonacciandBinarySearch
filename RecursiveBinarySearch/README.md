import java.util.Arrays;

public class RecursiveBinarySearch {

    // Recursive implementation of Binary Search
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        // Base case 1: Target not found in array bounds
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        // Base case 2: Target found
        if (arr[mid] == target) {
            return mid;
        }

        // Recursive call: Search right or left sub-array
        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, high);
        } else {
            return binarySearchRecursive(arr, target, low, mid - 1);
        }
    }

    // Helper method for cleaner invocations
    public static int binarySearch(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        System.out.println("Array: " + Arrays.toString(arr) + "\n");

        // Example 1: Target in middle region
        int target1 = 23;
        System.out.println("Example 1: Search " + target1);
        System.out.println("Index: " + binarySearch(arr, target1) + "\n");

        // Example 2: Target at the boundary
        int target2 = 2;
        System.out.println("Example 2: Search " + target2);
        System.out.println("Index: " + binarySearch(arr, target2) + "\n");

        // Example 3: Target missing
        int target3 = 100;
        System.out.println("Example 3: Search " + target3);
        System.out.println("Index: " + binarySearch(arr, target3));
    }
}

/*
=======================================================
RECURSIVE BINARY SEARCH CALL TREE / TRACE (3 EXAMPLES)
=======================================================

--- EXAMPLE 1: Target = 23 in [2, 5, 8, 12, 16, 23, 38, 56, 72, 91] ---
binarySearchRecursive(arr, 23, low=0, high=9)
└── mid = 4, arr[4] = 16 (16 < 23)
└── binarySearchRecursive(arr, 23, low=5, high=9)
└── mid = 7, arr[7] = 56 (56 > 23)
└── binarySearchRecursive(arr, 23, low=5, high=6)
└── mid = 5, arr[5] = 23 (Match!) Returns index 5.

--- EXAMPLE 2: Target = 2 in [2, 5, 8, 12, 16, 23, 38, 56, 72, 91] ---
binarySearchRecursive(arr, 2, low=0, high=9)
└── mid = 4, arr[4] = 16 (16 > 2)
└── binarySearchRecursive(arr, 2, low=0, high=3)
└── mid = 1, arr[1] = 5 (5 > 2)
└── binarySearchRecursive(arr, 2, low=0, high=0)
└── mid = 0, arr[0] = 2 (Match!) Returns index 0.

--- EXAMPLE 3: Target = 100 in [2, 5, 8, 12, 16, 23, 38, 56, 72, 91] ---
binarySearchRecursive(arr, 100, low=0, high=9) -> mid=4, arr[4]=16 (16 < 100)
└── binarySearchRecursive(arr, 100, low=5, high=9) -> mid=7, arr[7]=56 (56 < 100)
└── binarySearchRecursive(arr, 100, low=8, high=9) -> mid=8, arr[8]=72 (72 < 100)
└── binarySearchRecursive(arr, 100, low=9, high=9) -> mid=9, arr[9]=91 (91 < 100)
└── binarySearchRecursive(arr, 100, low=10, high=9) -> (low > high) Base case! Returns -1.


=======================================================
ALGORITHM EXPLANATION
=======================================================
1. Recursive Structure:
   Instead of adjusting loop pointers, the function passes updated
   sub-array bounds (`low` and `high`) as parameters to the next stack frame.

2. Base Cases:
    - Base Case 1 (Success): arr[mid] == target -> Returns mid.
    - Base Case 2 (Failure): low > high -> Search range collapsed, returns -1.


      */