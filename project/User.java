import java.util.*;
public class User extends Player
{
    Scanner reader = new Scanner( System.in );
    
    public User( Card [] deck )
    {
        super( deck );
    }
    
    public int turn( )
    {
        int choice;
        for( int x = 0; x < hand.size( ); x++ )
        {
            System.out.println( hand.get( x ) );
        }
        
        do
        {
            System.out.println( "Fish for what card." );
            choice = reader.nextInt( );
        }while( choice < 2 && choice > 14 );
        
        return choice;
    }
}
