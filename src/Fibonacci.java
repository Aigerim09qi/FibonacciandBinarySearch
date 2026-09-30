public class Fibonacci {
    public static int fibonacci(int n){
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);

    }
    public static void main(String[] args){
        int[] examples = {3, 4, 5};
        for (int n: examples) {
            System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
        }
    }
}
