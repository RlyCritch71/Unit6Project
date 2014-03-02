import java.util.*;

public class PolynomialClient
{
    public static void main( String [] args )
    {
        Scanner reader = new Scanner( System.in );
        ArrayList<Set> poly1 = new ArrayList<Set>( );
        ArrayList<Set> poly2 = new ArrayList<Set>( );
        ArrayList<Set> sum = new ArrayList<Set>( );
        ArrayList<Set> mult = new ArrayList<Set>( );
        int a, b;
        
        System.out.println( "Enter the first polynomial. Enter 0 0 to quit." );
        do
        {
            a = reader.nextInt( );
            b = reader.nextInt( );
            if( a != 0 || b != 0 )
            {
                Set p1 = new Set( a, b );
                poly1.add( p1 );
            }
        }while( ( a != 0 ) || ( b != 0 ) );
        
        System.out.println( "Enter the second polynomial. Enter 0 0 to quit." );
        do
        {
            a = reader.nextInt( );
            b = reader.nextInt( );
            if( a != 0 || b != 0 )
            {
                Set p2 = new Set( a, b );
                poly2.add( p2 );
            }
        }while( ( a != 0 ) || ( b != 0)  );
        
        simplify( poly1 );
        simplify( poly2 );
        
        sort( poly1 );
        sort( poly2 );
        
        System.out.println( "Here are your two polynomials:" );
        print( poly1 );
        print( poly2 );
        
        addition( sum, poly1, poly2 );
        simplify( sum );
        sort( sum );
        
        System.out.println( "Here are there sum:" );
        System.out.println( sum );
        print( sum );
        
        multiplication( mult, poly1, poly2 );
        simplify( mult );
        sort( mult );
        
        System.out.println( "Here is there product:" );
        print( mult );
    }
    
    public static void sort( ArrayList<Set> list)
    {
        boolean flag;
        Set temp = new Set( 0, 0 );
            for( int x = 0; x < list.size( ); x++ )
            {
                flag = true;
                
                for( int y = 0; y < list.size( ) - 1; y++ )
                {
                    if( list.get( y ).getExp( ) < list.get( y + 1 ).getExp( ) )
                    {
                        Set s1 = new Set( list.get( y ).getCoef( ), list.get( y ).getExp( ) );
                        Set s2 = new Set( list.get( y + 1 ).getCoef( ), list.get( y + 1 ).getExp( ) );
                        temp = s1;
                        list.set( y, s2 );
                        list.set( y + 1, temp );
                        flag = false;
                    }
                }
                if( flag )
                {
                    break;
                }
            }
    
    }
    
    public static void simplify( ArrayList<Set> poly )
    {
        for( int x  = 0; x < poly.size( ); x++ )
        {
            for( int y = x + 1; y < poly.size( ); y++ )
            {
                if( poly.get( x ).getExp( ) == poly.get( y ).getExp( ) )
                {
                    poly.get( x ).setCoef( poly.get( x ).getCoef( ) + poly.get( y ).getCoef( ) );
                    poly.remove( y );
                }
            }
        }
    }
    
    public static void multiplication( ArrayList<Set> mult, ArrayList<Set> poly1, ArrayList<Set> poly2 )
    {
        for( int x = 0; x < poly1.size( ); x++ )
        {
            for( int y = 0; y < poly2.size( ); y++ )
            {
                int c = poly1.get( x ).getCoef( ) * poly2.get( y ).getCoef( );
                int e = poly1.get( x ).getExp( ) + poly2.get( y ).getExp( );
                Set temp = new Set( c, e );
                mult.add( temp );
            }
        }
    }
    
    public static void addition( ArrayList<Set> sum, ArrayList<Set> poly1, ArrayList<Set> poly2 )
    {
        for( int x = 0; x < poly1.size( ); x++ )
        {
            for( int y = 0; y < poly2.size( ); y++ )
            {
                if( poly1.get( x ).getExp( ) == poly2.get( y ).getExp( ) )
                {
                    int c = poly1.get( x ).getCoef( ) + poly2.get( y ).getCoef( );
                    int e = poly2.get( y ).getExp( );
                    Set temp = new Set( c, e );
                    sum.add( temp );
                }
                else if( x < y )
                {
                    int c = poly2.get( y ).getCoef( );
                    int e = poly2.get( y ).getExp( );
                    Set temp = new Set( c, e );
                    sum.add( temp );
                }
                else if( y < x )
                {
                    int c = poly1.get( y ).getCoef( );
                    int e = poly1.get( y ).getExp( );
                    Set temp = new Set( c, e );
                    sum.add( temp );
                }
            }
        }
    }
    
    public static void print( ArrayList<Set> poly )
    {        
        System.out.print( poly.get( 0 ) );
        
        for( int x = 1; x < poly.size( ); x++ )
        {
                System.out.print( " + " + poly.get( x ) );
        }
            
        System.out.println( );    
    }
}
