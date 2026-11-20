package class1120;

public class Efficiency {

    // (1) Linear search.
    public static boolean linearContains(int[] haystack, int needle) {
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == needle) {
                return true;
            }
        }
        return false;
    }

    // (2) Binary search.
    // assume haystack is sorted.
    public static boolean binaryContains(int[] haystack, int needle) {
        return containsBetween(haystack, needle, 0, haystack.length - 1);
    }

    // look for needle between index low & high (inclusive).
    public static boolean containsBetween(int[] haystack, int needle, int low, int high) {
        if (low > high) {
            return false;
        }
        int mid = (low + high) / 2;
        if (needle < haystack[mid]) {
            return containsBetween(haystack, needle, low, mid - 1);
        }
        if (needle > haystack[mid]) {
            return containsBetween(haystack, needle, mid + 1, high);
        }
        return true;
    }

    // (3) True if any value appears in values more than once.
    public static boolean hasDuplicates(int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                if (i != j && values[i] == values[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // (4) 2 to the nth power, for n >= 0.
    public static int power2(int n) {
        if (n == 0) {
            return 1;
        } else {
            return 2 * power2(n - 1);
        }
    }

    // (5) Also 2 to the nth power.
    public static int power2Twice(int n) {
        if (n == 0) {
            return 1;
        } else {
            return power2Twice(n - 1) + power2Twice(n - 1);
        }
    }

    public static final int TIMEOUT_SECONDS = 1;

    public static void main(String[] args) throws InterruptedException {
        timeAll(10000);
        timeAll(20000);
        timeAll(30000);
    }

    // Times all five on their worst case for input size n.
    public static void timeAll(int n) throws InterruptedException {
        int[] haystack = new int[n];
        for (int i = 0; i < n; i++) {
            haystack[i] = i;
        }
        // n is bigger than everything in haystack, so neither search finds it.
        int needle = n;

        System.out.printf("n = %,d%n", n);
        time("linear search", () -> linearContains(haystack, needle));
        time("binary search", () -> binaryContains(haystack, needle));
        time("hasDuplicates", () -> hasDuplicates(haystack));
        time("power2", () -> power2(n));
        time("power2Twice", () -> power2Twice(n));
        System.out.println();
    }

    // Runs algorithm and prints how long it took, giving up after TIMEOUT_SECONDS.
    public static void time(String name, Runnable algorithm) throws InterruptedException {
        System.out.printf("  %-15s", name);
        String[] result = new String[1];
        Thread thread = new Thread(() -> {
            long start = System.nanoTime();
            try {
                algorithm.run();
                result[0] = formatTime(System.nanoTime() - start);
            } catch (StackOverflowError e) {
                result[0] = "stack overflow";
            }
        });
        // Java can't stop a thread that's still running, so a timed-out
        // algorithm keeps going in the background until the program ends.
        thread.setDaemon(true);
        thread.start();
        thread.join(TIMEOUT_SECONDS * 1000);
        if (thread.isAlive()) {
            System.out.println("more than " + TIMEOUT_SECONDS + " s");
        } else {
            System.out.println(result[0]);
        }
    }

    public static String formatTime(long nanoseconds) {
        if (nanoseconds < 1_000) {
            return nanoseconds + " ns";
        } else if (nanoseconds < 1_000_000) {
            return String.format("%.1f µs", nanoseconds / 1e3);
        } else if (nanoseconds < 1_000_000_000) {
            return String.format("%.1f ms", nanoseconds / 1e6);
        } else {
            return String.format("%.2f s", nanoseconds / 1e9);
        }
    }
}
