/*
 * War.java
 * Programmer: Ben Russell
 * Date: 4/23/2023
 * Purpose: Create a simulation of the War card game between two computer players by creating a card class that implements the Comparable interface
 */
import java.util.ArrayList;
public class War {
    public static void main(String[] args) { 

        ArrayList<Card> Deck = new ArrayList<Card>();

        for(int i = 2; i<15; i++){ //FILL DECK
            for(int j= 0; j<4; j++){
                if(j==0){
                    Deck.add(new Card("Hearts", i));
                } else if(j==1){
                    Deck.add(new Card("Diamonds", i));
                } else if(j==2){
                    Deck.add(new Card("Spades", i));
                } else if(j==3){
                    Deck.add(new Card("Clubs", i));
                }
                
            }
        }
        Deck.add(new Card(null, 15));
        Deck.add(new Card(null, 15));

        ArrayList<Card> player1 = new ArrayList<Card>();
        ArrayList<Card> player2 = new ArrayList<Card>();

        while(Deck.size() > 0){ //RANDOMLY SPLIT DECK
            player1.add(Deck.remove((int)(Math.random() * Deck.size())));
            player2.add(Deck.remove((int)(Math.random() * Deck.size())));
        }

        int totalComparisons = 0;

        while(player1.size() > 0  && player2.size() > 0){ //WAR GAME SIMULATION
            ArrayList<Card> center = new ArrayList<Card>();
            totalComparisons += takeTurn(player1, player2, center);
        }

        if(player1.size() > player2.size()){
            System.out.println("Player 1 Wins!");
        } else {
            System.out.println("Player 2 Wins!");
        }

        System.out.println("It took " + totalComparisons + " comparisons to end the game!");
    }

    public static int takeTurn(ArrayList<Card> p1, ArrayList<Card> p2, ArrayList<Card> c){
        c.add(0, p2.remove(0));
        c.add(0, p1.remove(0));

        if(c.get(0).compareTo(c.get(1)) > 0){ // PLAYER 1 WINS
            System.out.print(c.get(0) + " vs. " + c.get(1)); 
            while(c.size() > 0){
                p1.add(c.remove((int)(Math.random() * c.size())));
            }
            System.out.println(" - Player 1 Wins [" + p1.size() + " - " + p2.size() + "]");
            return 1;
        } else if (c.get(0).compareTo(c.get(1)) < 0){ // PLAYER 2 WINS
            System.out.print(c.get(0) + " vs. " + c.get(1)); 
            while(c.size() > 0){
                p2.add(c.remove((int)(Math.random() * c.size())));
            }
            System.out.println(" - Player 2 Wins [" + p1.size() + " - " + p2.size() + "]");
            return 1;
        }else if(p1.size() < 3 || p2.size() < 3) { // WAR, BUT ONE PLAYER CANNOT COMPLETE THE WAR
            if(p1.size() < p2.size()){
                System.out.println("Player 1 could not complete the war");
            } else {
                System.out.println("Player 2 could not complete the war");
            }
            while(p1.size() > 0 && p2.size() > 0){
                p1.remove(0);
                p2.remove(0);
            }
            return 0;
        } else { //WAR
            System.out.println(c.get(0) + " vs. " + c.get(1) + " - WAR");
            c.add(0, p2.remove(0));
            c.add(0, p1.remove(0));
            c.add(0, p2.remove(0));
            c.add(0, p1.remove(0));
            return(1 + takeTurn(p1, p2, c));
        }
    }
}
