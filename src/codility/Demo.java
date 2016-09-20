package codility;

public class Demo {
    public int solution(int[] A) {
        if (A  ==   null )  {
            return   - 1 ;
       } 
        long  sum  =   0l ;
        long  subSum  =   0l ;
        for ( int  i  =   0 ; i  <  A.length; i ++ )  {
           sum  +=  A[i];
       } 
         for ( int  i  =   0 ; i  <  A.length; i ++ )  {
            if (subSum  ==  sum  -  subSum  -  A[i])  {
                return  i;
           } else  {
               subSum  +=  A[i];
           } 
       } 
        return   - 1 ;
    }
}
