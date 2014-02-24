import java.util.*;
public abstract class Player
{
    protected ArrayList<Card> hand = new ArrayList<Card>( ); 
    int book;
    
    public Player( Card [] deck )
    {
        for( int x = 0; x < 7; x++ )
        {
            hand.add( Card.getCard( deck ) );
        }
    }
    
    public boolean checkBook( )
    {
        int count;
        int [] position = new int[4];
        for( int x = 0; x < hand.size( ); x++ )
        {
            count = 0;
            for( int y = x + 1; y < hand.size( ); x++ )
            {
                if( hand.get( x ) == hand.get( y ) )
                {
                    position[count] = y;
                    count++;
                }
            }
            if( count == 4 )
            {
                for( int a = 0; a < position.length; a++ )
                {
                    hand.remove( position[a] );
                }
                return true; 
            }
        }
        return false;
    }
    
    public abstract void turn( );
    
}
