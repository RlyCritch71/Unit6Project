import java.util.*;
public class User extends Player
{
    Scanner reader = new Scanner( System.in );
    public User( Card [] deck )
    {
        super( deck );
    }
    
    public void turn( )
    {
        int choice;
        for( int x = 0; x < hand.size( ); x++ )
        {
            System.out.println( hand.get( x ) );
        }
        
        System.out.println( "Fish for what card." );
        choice = reader.nextInt( );
    }
}
