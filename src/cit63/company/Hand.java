package cit63.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Hand {
    private ArrayList<Card> playersHand;
    private boolean flag;

    private HashMap<Character, Integer> VALUES = new HashMap<Character, Integer>();

    public Hand() {
        this.playersHand = new ArrayList<Card>();
        flag = false;
        setVALUES();
    }

    public void addCard(Card card){
        playersHand.add(card);
    }

    public int getValue(){
        int hand_value = 0;

        for(Card s : playersHand)
            hand_value += VALUES.get(s.getRank());

        for(Card s : playersHand) {
            if (s.getRank() != 'A')
                return hand_value;
            else if (hand_value + 10 <= 21)
                return hand_value + 10;
            else
                return hand_value;

        }

        return hand_value;
    }

    public void displayCard(int i){
        System.out.print(playersHand.get(i));
    }

    public int getSize(){
        return playersHand.size();
    }

    private void setVALUES(){
        VALUES.put('A', 1);
        VALUES.put('2', 2);
        VALUES.put('3', 3);
        VALUES.put('4', 4);
        VALUES.put('5', 5);
        VALUES.put('6', 6);
        VALUES.put('7', 7);
        VALUES.put('8', 8);
        VALUES.put('9', 9);
        VALUES.put('T', 10);
        VALUES.put('J', 10);
        VALUES.put('Q', 10);
        VALUES.put('K', 10);
    }
}