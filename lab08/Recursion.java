package lab08;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(fib(5));
        // fibp(5);
        // testPower2();
        // testDoubleChars();
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            int a = fib(n - 2);
            int b = fib(n - 1);
            return a + b;
        }
    }

    public static int fibp(int n) {
        if (n <= 1) {
            return n;
        } else {
            int a = fibp(n - 2);
            System.out.println(n);
            int b = fibp(n - 1);
            return a + b;
        }
    }

    // Returns 2 to the nth power.
    public static int power2(int n) {
        return 0;
    }

    // Returns s with each character doubled: "abc" becomes "aabbcc".
    public static String doubleChars(String s) {
        return "";
    }

    public static void testPower2() {
        for (int n = 0; n <= 10; n++) {
            System.out.println("power2(" + n + ") = " + power2(n));
        }
    }

    public static void testDoubleChars() {
        System.out.println(doubleChars(""));
        System.out.println(doubleChars("a"));
        System.out.println(doubleChars("abc"));
        System.out.println(doubleChars("hello world"));
    }

}
