import java.util.*;
public class Card
{
    private int suit, value;
    private boolean dealt;
    
    // 2 - 10, 11 - J, 12 - Q, 13 - K, 14 - A
    // 1 - hearts, 2 - spades, 3 - diamonds, 4 - clubs
    
    public Card( int s, int v )
    {
        suit = s;
        value = v;
        dealt = false;
    }
    
    public String toString( )
    {
        String v = "", s = "";
        
            switch(suit)
            {
                case 1: s = "Hearts";
                        break;
                case 2: s = "Spades";
                        break;
                case 3: s = "Diamonds";
                        break;
                case 4: s = "Clubs";
                        break;
            }
            
            switch(value)
            {
                case 14: v = "Ace";
                         break;
                case 13: v = "King";
                         break;
                case 12: v = "Queen";
                         break;
                case 11: v = "Jack";
                         break;
                default: v = "" + value;
                         break;
            }
        
        return v + " of " + s;
    }
    
    public static Card getCard (Card [] d)
    {
        Random randy = new Random();
        int p = randy.nextInt(52);
        
            while( d[p].dealt == true )
            {
                p = randy.nextInt(52);
            }
            
        d[p].dealt = true;
        
        return d[p];
    }
}
