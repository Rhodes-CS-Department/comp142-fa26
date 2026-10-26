package class1023;

public class RecursionSol {

    public static void main(String[] args) {
        testWarmup();

        testIsPalindrome();
        testCountChar();
        testAllLowercase();
        testSumDigits();
        testPower();
        testPowerBig();
    }

    public static void mystery1(int n) {
        if (n == 0) {
            return;
        } else {
            mystery1(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void mystery2(int n) {
        if (n == 0) {
            return;
        } else {
            System.out.print(n + " ");
            mystery2(n - 1);
        }
    }

    public static void mystery3(int n) {
        if (n == 0) {
            return;
        } else {
            mystery3(n - 1);
            System.out.print(n + " ");
            mystery3(n - 1);
        }
    }

    // Together: true if s reads the same forwards and backwards.
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        } else {
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            String middle = s.substring(1, s.length() - 1);
            return first == last && isPalindrome(middle);
        }
    }

    // 1. The number of times c appears in s.
    public static int countChar(String s, char c) {
        if (s.length() == 0) {
            return 0;
        } else {
            int countRest = countChar(s.substring(1), c);
            if (s.charAt(0) == c) {
                return countRest + 1;
            } else {
                return countRest;
            }
        }
    }

    // 2. True if every character of s is lowercase.
    // Character.isLowerCase(c) tells you whether one char c is lowercase.
    public static boolean allLowercase(String s) {
        if (s.length() == 0) {
            return true;
        } else {
            return Character.isLowerCase(s.charAt(0)) && allLowercase(s.substring(1));
        }
    }

    // 3. The sum of the digits of n, for n >= 0.
    // Hint: make the recursive call on n / 10.
    public static int sumDigits(int n) {
        if (n < 10) {
            return n;
        } else {
            return sumDigits(n / 10) + n % 10;
        }
    }

    // Together: x to the nth power, for n >= 0.
    // First version: x * x^(n-1), as in lab 8. testPowerBig overflows the stack.
    public static long powerSlow(long x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * powerSlow(x, n - 1);
        }
    }

    // Calling power(x, n / 2) twice instead of storing it is correct but slower than powerSlow.
    public static long power(long x, int n) {
        if (n == 0) {
            return 1;
        } else {
            long half = power(x, n / 2);
            if (n % 2 == 0) {
                return half * half;
            } else {
                return x * half * half;
            }
        }
    }

    public static void testWarmup() {
        mystery1(3);
        System.out.println();
        mystery2(3);
        System.out.println();
        mystery3(3);
        System.out.println();
    }

    public static void testIsPalindrome() {
        System.out.println(isPalindrome("racecar") + " " + isPalindrome("abba") + " " + isPalindrome("abca") + " " + isPalindrome(""));
    }

    public static void testCountChar() {
        System.out.println(countChar("mississippi", 's') + " " + countChar("mississippi", 'p') + " " + countChar("", 'a'));
    }

    public static void testAllLowercase() {
        System.out.println(allLowercase("hello") + " " + allLowercase("heLlo") + " " + allLowercase("hellO") + " " + allLowercase(""));
    }

    public static void testSumDigits() {
        System.out.println(sumDigits(2026) + " " + sumDigits(7) + " " + sumDigits(0));
    }

    public static void testPower() {
        System.out.println(power(2, 10) + " " + power(3, 5) + " " + power(5, 0));
    }

    public static void testPowerBig() {
        System.out.println(power(1, 1000000));
    }
}
