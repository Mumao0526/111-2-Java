package project1;

public class Card {
    private String face = "Spades ", suit = "A";
    /*
     * Spades 黑桃 Hearts 紅桃 Clubs 梅花 Diamonds 方塊
     */

    // 默認卡牌
    public Card() {
    }

    // 指定卡牌
    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    // 空卡牌
    public Card(String state) {
        if (state.equals("none") == true) {
            this.face = "";
            this.suit = "none";
        }
    }
    
    public String toString() {
        return face + " " + suit;
    }
}
