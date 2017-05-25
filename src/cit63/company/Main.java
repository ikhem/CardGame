/*
Im Khem
CIT 63 - Beginning Java Programming
Spring 2017
Final Project - BlackJack Java Implementation
*/

package cit63.company;

import java.util.Scanner;

class Main {

    public static Deck deck;
    public static Player player;
    public static Hand dealer;
    public static double pot;
    public static double bet;
    public static boolean in_play;
    public static String playAgain;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        playAgain = "Y";
        pot = 0;
        player = new Player();

        System.out.print("Welcome to the Lucky Dragon Casino. What's your name player: ");
        player.setName(scanner.nextLine());

        while (playAgain.equalsIgnoreCase("Y")) {

            // Set declarations for the start of a new hand

            in_play = true;
            int selection = 0;
            bet = 0;
            player.newHand();
            dealer = new Hand();

            // Generate a new deck and shuffle cards

            deck = new Deck();
            deck.shuffle();

            // Deal cards to player and dealer

            for (int i = 0; i < 2; i++) {
                player.addCard(deck.dealCard());
                dealer.addCard(deck.dealCard());
            }

            display_table();

            while (selection != 3 && in_play) {

                System.out.print("\n1. Bet\n" +
                                 "2. Hit\n" +
                                 "3. Stand\n" +
                                 "\nSelection: ");

                selection = scanner.nextInt();

                switch (selection) {
                    case 1:
                        bet();
                        display_table();
                        break;
                    case 2:
                        Hit();
                        break;
                    case 3:
                        Stand();
                        break;
                }
            }
        }

    }

    public static void bet(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWhat's your wager " + player.getName() + " ? ");
        bet = scanner.nextDouble();

        player.bet(bet);
        pot += bet*2;

    }

    public static void display_table() {

        System.out.print("\n*************** BlackJack ***************\n\n");

        System.out.printf("Pot: $%.2f", pot);

        System.out.print("\n\n" + player.getName() + "'s Hand: ");
        player.displayHand();

        // For testing purposes shows the value of the hand
        //System.out.println("Value: " + player.getValue());

        System.out.print("\nDealers Hand: ");

        // Displays all cards except for the hidden card
        for(int i = 0; i < dealer.getSize() - 1 ; i++)
            dealer.displayCard(i);

        // Displays a question mark for the hidden card until the end of the hand
        if(in_play)
            System.out.print("? ");
        else
            dealer.displayCard(dealer.getSize()-1);

        // For testing purposes shows the value of the hand
        //System.out.println("Value: " + dealer.getValue());

        System.out.printf("\n\n" + player.getName() + "'s Balance: $%.2f", player.getWallet());

        System.out.print("\n\n*****************************************\n");

    }

    public static void Hit() {

        Scanner scanner = new Scanner(System.in);
        String result = "";

        if(in_play){
            if(player.getValue() <= 21){
                player.addCard(deck.dealCard());
            }

            if(player.getValue() > 21){
                result = player.getName() + " has busted!\n";
                pot = 0;
                in_play = false;
            }

        }

        display_table();
        System.out.print(result);

        if(!in_play) {
            System.out.print("\nNew Deal? (Y/N)");
            playAgain = scanner.nextLine();
        }
    }

    public static void Stand() {

        Scanner scanner = new Scanner(System.in);
        String result = " ";

        if (in_play) {

            while (dealer.getValue() < 17) {
                dealer.addCard(deck.dealCard());
            }

            if (dealer.getValue() > 21) {
                result = "Dealer has busted!\n";
                player.deposit(pot);
                pot = 0;
                playAgain = "N";
            } else if (player.getValue() <= dealer.getValue()) {
                result = "Dealer Wins! Better luck next time " + player.getName() + ".\n";
                pot = 0;
                playAgain = "N";
            } else if (player.getValue() > dealer.getValue()) {
                result = player.getName() +" Wins!\n";
                player.deposit(pot);
                pot = 0;
                playAgain = "N";
            }

            in_play = false;
            display_table();
            System.out.print(result);

        }

        System.out.print("\nNew Deal? (Y/N) ");
        playAgain = scanner.nextLine();

    }

}