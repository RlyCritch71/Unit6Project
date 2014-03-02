import java.util.*;

public class Computer extends Player
{
    Scanner reader = new Scanner( System.in );
    private ArrayList<Integer> userGuesses = new ArrayList<Integer>( );
    
    public Computer( Card [] deck )
    {
        super( deck );
    }
    
    public int turn( )
    {        
        if( userGuesses.size( ) > 0 )
        {
            for( int x = 0; x < hand.size( ); x++ )
            {
                for( int y = 0; y < userGuesses.size( ); y++ )
                {
                    if( hand.get( x ).getValue( ) == userGuesses.get( y ) )
                    {
                        return hand.get( x ).getValue( );
                    }
                }
            }
        }
        
        return hand.get( 0 ).getValue( );
    }
    
    public void addUG( int n )
    {
        userGuesses.add( n );
    }
}
