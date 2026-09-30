public class RecursiveFibonacci {

    
    public static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        int[] examples = {3, 4, 5};

        System.out.println("=== RECURSIVE FIBONACCI EXAMPLES ===");
        for (int n : examples) {
            System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
        }
    }
}

/*
=======================================================
CALL TREE VISUALISATION AND EXPLANATION (3 EXAMPLES)
=======================================================

Example 1: n = 3
fibonacci(3)
├── fibonacci(2)
│   ├── fibonacci(1) -> returns 1
│   └── fibonacci(0) -> returns 0
│   Result for Fibonacci(2): 1 + 0 = 1
└── fibonacci(1) -> returns 1
Total Result: 1 + 1 = 2
In this example we have n=3, it evaluates the recursive formula: fibonacci(3-1) + (3 -2), which translates to fibonacci(2) + fibonacci(1).
Fibonacci(2) breaks down into fibonacci(1) + fibonachi(0). fibonacci(1) is a base case so it gives back 1, the same with 0. Then fibonacci(2) adds them together(1+0) and gets 1.
Fibonacci(1) is base case and gives back 1.
Finally, fibonacci adds the left answer (1) and the right (1), the result is 2.


Example 2: n = 4
fibonacci(4)
├── fibonacci(3)
│   ├── fibonacci(2)
│   │   ├── fibonacci(1) -> 1
│   │   └── fibonacci(0) -> 0
│   │   Result: 1
│   └── fibonacci(1) -> 1
│   Result: 2
└── fibonacci(2)
├── fibonacci(1) -> 1
└── fibonacci(0) -> 0
Total Result: 1
Total Result: 2 + 1 = 3
In this example fibonacci(4) needs to calculate fibonacci(3) + fibonacci(2)
Fibonacci(3) breaks down into fibonacci(2) and fibonacci(1) and gives back 2
Fibonacci(2) breaks down into fibonacci(1) + fibonacci(0) and gives back 1
Final Result fibonacci(4) adds 2 + 1 = 3

Example 3: n = 5
fibonacci(5)
├── fibonacci(4) -> returns 3
└── fibonacci(3) -> returns 2
Total Result: 3 + 2 = 5
In this example the computer need calculate fibonacci(4) + fibonacci(3)
Fibonacci(4) it goes all the way down the left tree for fibonacci(4) and gets 3
Fibonacci(3) repeat action fibonacci(4) and gets 2
Final Result fibonacci(5) adds the 3+2=5

*/