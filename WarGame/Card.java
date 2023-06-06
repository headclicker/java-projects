/*
 * Card.java
 * Programmer: Ben Russell
 * Date: 4/23/2023
 * Purpose: Create a Card class to simulate playing cards for the deck used in the war game, by implementing the Comparabe interface.
 */
public class Card implements Comparable{
    private String suit;
    private int value;
    public Card(String s, int v){
        suit = s;
        value = v;
    }
    public int getValue() {
        return value;
    }
    public String getSuit() {
        return suit;
    }
    public int compareTo(Object o){
        Card c = (Card) o;
        int difference = this.getValue() - c.getValue();
        return difference;
    }
    public String toString(){
        String name = "";
        if(value == 11){
            name = "Jack";
        } else if(value == 12){
            name = "Queen";
        } else if(value == 13){
            name = "King";
        } else if(value == 14){
            name= "Ace";
        } else if(value == 15){
            return("JOKER");
        }
        if(value > 10){
            return(name + " of " + suit);
        }
        return(value + " of " + suit);
    }
}
