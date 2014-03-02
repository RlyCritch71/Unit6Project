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
    
    public void checkBook( )
    {
        int count;
        int [] position = new int[4];
        for( int x = 0; x < hand.size( ); x++ )
        {
            count = 0;
            for( int y = x + 1; y < hand.size( ) ; y++ )
            {
                if( hand.get( x ).getValue( ) == hand.get( y ).getValue( ) )
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
                book++;
                break;
            }
        }
    }
    
    public abstract int turn( );
    
    public int getVal( int n )
    {
        int number;
        number = hand.get( n ).getValue( );
        return number;
    }
    
    public int getSize( )
    {
        int size;
        size = hand.size( );
        return size;
    }
    
    public void pRemove( int n )
    {
        hand.remove( n );
    }
    
    public void sAdd( Player p, int n )
    {
        Card temp = new Card( 0, 0 );
        temp = getHCard( p, n );
        int pos = p.hand.indexOf( temp );
        hand.add( p.hand.get( pos ) );
    }
    
    public void pAdd( Card c )
    {
        hand.add( c );
    }
    
    public static Card getHCard( Player p, int v )
    {
        for( int x = 0; x < p.hand.size( ); x++ )
        {
            if( p.hand.get( x ).getValue( ) == v )
            {
                return p.hand.get( x );
            }
        }
        return p.hand.get( 0 );
    }
    
    public int getBook( )
    {
        return book;
    }
}
