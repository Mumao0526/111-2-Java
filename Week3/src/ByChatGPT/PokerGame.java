package ByChatGPT;

import java.util.List;

public class PokerGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        List<Card> hand1 = deck.deal(5);
        List<Card> hand2 = deck.deal(5);
        if (hand1 == null || hand2 == null) {
            System.out.println("Not enough cards to deal.");
            return;
        }
        System.out.println("Hand 1: " + hand1);
        System.out.println("Hand 2: " + hand2);
    }
}
