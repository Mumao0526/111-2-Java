package project1;

import java.util.Random;


/*
 *  宣告 DeckOfPokor XXX = new DeckOfPokor()
 *  
 *  重置牌組 reset()
 *  洗牌 shuffle()
 *  發牌 dealCard(int)，回傳Card類型
 * 
 */

public class DeckOfPokor {
    public Card[] arr = new Card[52]; // 牌組
    private Card nullCard = new Card("none"); // 空的卡牌
    private int usedCardNum = 0; // 不在牌組內的牌數
    private String[] face = { "Spades", "Hearts", "Clubs", "Diamonds" }; // 卡牌花色定義
    private String[] suit = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" }; // 卡牌數值定義

    // 創建牌組
    public DeckOfPokor() {
        for (int i = 0,num = 0; i < face.length; i++) {
            for (int j = 0; j < suit.length; j++,num++) {
                arr[num] = new Card(face[i], suit[j]);
            }
        }
    }

    // 洗牌
    public void shuffle() {
        Random ranNum = new Random();
        int num1;
        int num2;
        Card buffer = new Card();
        // 牌組內剩餘的牌做隨機交換
        for (int i = usedCardNum; i < (52 - usedCardNum) / 2; i++) {
            num1 = ranNum.nextInt(52 - usedCardNum) + usedCardNum;
            num2 = ranNum.nextInt(52 - usedCardNum) + usedCardNum;

            buffer = arr[num1];
            arr[num1] = arr[num2];
            arr[num2] = buffer;
        }
    }

    // 發牌
    public Card[] dealCard(int num) {
        Card[] req = new Card[num];

        if (usedCardNum >= 52) {
          // 牌組內沒牌
            for(int i = 0; i < num ; i++) {
                req[i] = nullCard;
            }
            return req;
        }
  
        if (num + usedCardNum <= 52) {
            // 發牌數不超過牌組內的剩餘數量
            for (int i = usedCardNum, k = 0; i < usedCardNum + num; i++, k++) {
                req[k] = arr[i];
            }
            usedCardNum += num;
        } else {
            // 發牌數超過牌組內的剩餘數量
            int noneCardnum = (num + usedCardNum) - 52;
            int k = 0;
            
            // 能發的先發一發
            for (int i = usedCardNum; i < 52; i++, k++) {
                req[k] = arr[i];
            }
            usedCardNum = 52;   // 牌組內的牌全都發出去
            
            // 牌組發完改發空牌
            for(int i = 0; i < noneCardnum;i++,k++) {
                req[k] = nullCard;
            }   
        }
        return req;
    }
    
    // 重置牌組
    public void reset() {
        usedCardNum = 0;
        
        for (int i = 0,num = 0; i < face.length; i++) {
            for (int j = 0; j < suit.length; j++,num++) {
                arr[num] = new Card(face[i], suit[j]);
            }
        }
    }

}
