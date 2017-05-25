package cit63.company;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();

    private final char[] RANKS = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
    private final char[] SUITS = {'\u2663','\u2660','\u2665','\u2666'};

    public Deck(){
        for(int i = 0; i < RANKS.length; i++){
            for(int j = 0; j < SUITS.length; j++){
                Card card = new Card();
                card.setRank(RANKS[i]);
                card.setSuit(SUITS[j]);
                deck.add(card);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card dealCard(){
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

    public void displayDeck(){
        for(Card s : deck){
            System.out.print(s);
        }
    }
}
