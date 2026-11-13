package hearts;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private Scanner scan;

    public HumanPlayer() {
        scan = new Scanner(System.in);
    }

    private void printHand(List<Card> hand) {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i + ": " + hand.get(i));
        }
    }

    public Card play(GameState s, List<Card> hand) {
        printHand(hand);
        System.out.println("Choose a card (# in hand): ");
        int index = scan.nextInt();
        while (index < 0 || index >= hand.size()
                || !Rules.playValid(s, hand, hand.get(index))) {
            System.out.println("You can't play that; choose again: ");
            index = scan.nextInt();
        }
        return hand.get(index);
    }

    public Card[] pass(GameState s, List<Card> hand) {
        printHand(hand);
        System.out.println("Choose first card to pass(# in hand): ");
        int firstIndex = scan.nextInt();
        Card first = hand.get(firstIndex);
        System.out.println("Choose second card to pass(# in hand): ");
        int secondIndex = scan.nextInt();
        Card second = hand.get(secondIndex);
        System.out.println("Choose third card to pass(# in hand): ");
        int thirdIndex = scan.nextInt();
        Card third = hand.get(thirdIndex);
        return new Card[]{first, second, third};
    }

    public boolean isHuman() {
        return true;
    }
}
