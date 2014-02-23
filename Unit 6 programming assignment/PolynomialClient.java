import java.util.*;

public class PolynomialClient
{
    public static void main( String [] args )
    {
        Scanner reader = new Scanner( System.in );
        ArrayList<Set> poly1 = new ArrayList<Set>( );
        ArrayList<Set> poly2 = new ArrayList<Set>( );
        int a, b;
        
        System.out.println( "Enter the first polynomial. Enter 0 0 to quit." );
        do
        {
            a = reader.nextInt( );
            b = reader.nextInt( );
            Set p1 = new Set( a, b );
            poly1.add( p1 );
        }while( a != 0 && b != 0 );
        
        System.out.println( "Enter the second polynomial. Enter 0 0 to quit." );
        do
        {
            a = reader.nextInt( );
            b = reader.nextInt( );
            Set p2 = new Set( a, b );
            poly2.add( p2 );
        }while( a != 0 && b != 0 );
    }
    
    public static void Sort( ArrayList<Set> list)
    {
        boolean flag;
        int temp, s1, s2;
        
            for( int x = 0; x < list.size( ); x++ )
            {
                flag = true;
                
                for( int y = 0; y < list.size( ); y++ )
                {
                    if( list.get( y ).getExp( ) > list.get( y + 1 ).getExp( ) )
                    {
                        //figure out how to sort 
                    }
                }
            }
    
    }
}
