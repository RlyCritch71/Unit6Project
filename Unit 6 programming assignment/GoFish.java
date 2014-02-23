import java.util.*;
public class GoFish
{
    public static void main( String [] args )
    {
        Scanner reader = new Scanner( System.in );
        
        Card [] deck = new Card[52];
        
        loadDeck( deck );
       
        
        
        
        
        
        
    }
    
    public static void loadDeck( Card [] d )
    {
        int p = 0;
        
        for(int x = 1; x <= 4; x++)
        {
            for(int y = 2; y <= 14; y++)
            {
                d[p] = new Card(x, y);
                p++;
            }
        }
    }
}
