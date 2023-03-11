package project1;

public class PokerGame_test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DeckOfPokor poker = new DeckOfPokor();
        int num = 26;
        int num2 = 30;
        Card[] arr = new Card[num];
        Card[] arr2 = new Card[num2];
        

        poker.shuffle();    // 洗牌
        // 發牌
        arr = poker.dealCard(num);
        
        for (int i = 0; i < num; i++)
            System.out.print(arr[i] + " ; ");
        System.out.println();
        
        // 洗牌測試
        poker.shuffle();
        arr2 = poker.dealCard(num2);

        for (int i = 0; i < num2; i++)
            System.out.print(arr2[i] + " ; ");
        
        
        System.out.println();
        
        // 超發測試
        arr2 = poker.dealCard(3);

        for (int i = 0; i < 3; i++)
            System.out.print(arr2[i] + " ; ");
        
        Card aCard = new Card();
        System.out.println(aCard);
    }

}
