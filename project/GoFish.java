import java.util.*;
public class GoFish
{
    public static void main( String [] args )
    {
        Scanner reader = new Scanner( System.in );
        int userTurn1 = 0, userTurn2 = 0, compTurn1 = 0, compTurn2 = 0;
        boolean checku, checkc, keepOnu = false, keepOnc = false, dealt;
        String again;
        
        do
        {
            Card [] deck = new Card[52];
            loadDeck( deck );  
        
            User u1 = new User( deck );
            Computer c1 = new Computer( deck );
        
            System.out.println( "Welcome to Go-Fish" );
            directions( );
        
            do
            {
                do
                {
                    System.out.println( "Your Hand:" );
                    userTurn1 = u1.turn( );
                    checku = checkUTurn( userTurn1, c1, u1 );
                    if( !checku )
                    {
                        System.out.println( "Computer didnt have the card. To fish from pond press enter" );
                        String e = reader.nextLine( );
                        userTurn2 = pond( u1, deck );
                        System.out.println( "You got a " + userTurn2 + " from the pond." );
                        if( userTurn1 == userTurn2 )
                        {
                            keepOnu = true;
                        }
                        else
                        {
                            keepOnu = false;
                        }
                    }
                    else if( checku )
                    {
                        System.out.println( "Your fish was Successful." );
                        keepOnu = true;
                    }
                    c1.addUG( userTurn1 );
                    u1.checkBook(  );
                }while( keepOnu );
                
                System.out.println( );
                
                do
                {
                    System.out.println( "Computer's turn..." );
                    compTurn1 = c1.turn( );
                    checkc = checkCTurn( compTurn1, u1, c1 );
                    if( !checkc )
                    {
                        System.out.println( "Computer took from pond" );
                        compTurn2 = pond( c1, deck );
                        if( compTurn1 == compTurn2 )
                        {
                            keepOnc = true;
                        }
                        else
                        {
                            keepOnc = false;
                        }
                    }
                    else if( checkc )
                    {
                        System.out.println( "Computer took a " + compTurn1 + " from you." );
                        keepOnc = true;
                    }
                    c1.checkBook( );
                }while( keepOnc );
                dealt = Card.getDealt( deck );
            }while( !dealt && ( u1.getSize( ) != 0 && c1.getSize( ) != 0 ) );
            
            if( u1.getBook( ) > c1.getBook( ) )
            {
                System.out.println( "You Won!!!" );
            }
            else if( u1.getBook( ) == c1.getBook( ) )
            {
                System.out.println( "It was a tie." );
            }
            else
            {
                System.out.println( "Computer won." );
            }
            System.out.println( );
            System.out.println( "Would you like to play again? Yes or No" );
            again = reader.nextLine( );
            while( !again.equalsIgnoreCase( "yes" ) && !again.equalsIgnoreCase( "no" ) )
            {
                System.out.println( "Re-Enter, Either yes or no" );
                again = reader.nextLine( );
            }
        }while( again.equalsIgnoreCase( "yes" ) );
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
    
    public static boolean checkUTurn( int v, Computer c, User u )
    {
        for( int x  = 0; x < c.getSize( ); x++ )
        {
            if( v == c.getVal( x ) )
            {
                u.sAdd( c, v );
                c.pRemove( x );
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean checkCTurn( int v, User u, Computer c )
    {
        for( int x  = 0; x < u.getSize( ); x++ )
        {
            if( v == u.getVal( x ) )
            {
                c.sAdd( u, v );
                u.pRemove( x );
                return true;
            }
        }
        return false;
    }
    
    public static void directions( )
    {
        System.out.println( "Direcections: " );
        System.out.println( "When asked to 'fish' only put the following numbers in: " );
        System.out.println( "2 - 10, then 11 - Jack, 12 - Queen, 13 - King, 14 - Ace" );
        System.out.println( "Thank you. Enjoy!" );
        System.out.println( );
        System.out.println( );
    }
    
    public static int pond( Player p, Card[] deck)
    {
        Card c = new Card( 0, 0 );
        c = Card.getCard( deck );
        p.pAdd( c );
        
        return c.getValue( );
    }
}
