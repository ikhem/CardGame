package cit63.company;

public class Card {
    private char rank;
    private char suit;

    public Card(){
        this.rank = ' ';
        this.suit = ' ';
    }

    public Card(char rank, char suit){
        this.rank = rank;
        this.suit = suit;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public char getRank() {
        return rank;
    }

    public void setRank(char rank) {
        this.rank = rank;
    }

    public String toString(){
        if(rank == 'T')
            return "" + "10" + suit + " ";
        else
            return "" + rank + "" + suit + " ";
    }

}
