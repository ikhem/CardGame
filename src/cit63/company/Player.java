package cit63.company;

public class Player {
    private String name;
    private Hand hand;
    private double wallet;

    public Player(){
        this.name= "Mark";
        this.hand = new Hand();
        this.wallet = 1000.0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void newHand(){
        this.hand = new Hand();
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void bet(double wager){
        wallet -= wager;
    }

    public void deposit(double winnings){
        wallet += winnings;
    }

    public void addCard(Card card){
        hand.addCard(card);
    }

    public void displayHand(){
        for(int i = 0; i < hand.getSize(); i++)
            hand.displayCard(i);
    }

    public int getValue(){
        return hand.getValue();
    }
}
