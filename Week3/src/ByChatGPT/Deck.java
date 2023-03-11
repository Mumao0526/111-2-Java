package ByChatGPT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    private int dealtIndex = 0;

    public Deck() {
        cards = new ArrayList<Card>();
        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        dealtIndex = 0;
    }

    public List<Card> deal(int numCards) {
        if (cards.size() - dealtIndex < numCards) {
            return null;
        }
        List<Card> hand = new ArrayList<Card>();
        for (int i = 0; i < numCards; i++) {
            hand.add(cards.get(dealtIndex));
            dealtIndex++;
        }
        return hand;
    }
}



