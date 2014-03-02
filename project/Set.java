
public class Set
{
    private int coefficient, exponent;
    
    public Set( int c, int e )
    {
        coefficient = c;
        exponent = e;
    }
    
    public int getCoef( )
    {
        return coefficient;
    }
    
    public int getExp( )
    {
        return exponent;
    }
    
    public void setCoef( int n )
    {
        coefficient = n;
    }
    
    public void setExp( int n )
    {
        exponent = n;
    }
    
    public String toString( )
    {
        String print;
        if( exponent == 0 )
        {
            print = coefficient + "";
        }
        else if( exponent == 1 )
        {
            print = coefficient + "x";
        }
        else
        {
            print = coefficient + "x" + exponent;
        }
        
        return print;
    }
}
    

