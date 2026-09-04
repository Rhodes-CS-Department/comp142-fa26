package class0904;

// A client program using Die.java.
public class Roll {
    public static void main(String[] args) {
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        int[] counts = new int[13];
        
        for (int i = 0; i < 100; i++) {
            die1.roll();
            die2.roll();
            
            int dots1 = die1.getDots();
            int dots2 = die2.getDots();
            int sum = dots1 + dots2;

            counts[sum]++;
        }

        System.out.println("Sum:\tTally:");
        for (int i = 2; i <= 12; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < counts[i]; j++) {
                System.out.print("|");
            }    
            System.out.println();
        }
    }
}
