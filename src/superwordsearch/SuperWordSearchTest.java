package superwordsearch;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;


public class SuperWordSearchTest {
    private static SuperWordSearch wrapSearch;
    private static SuperWordSearch noWrapSearch;
    
    @Before
    public void init() throws Exception {
        noWrapSearch = new SuperWordSearch(3, 3, SuperWordSearch.Mode.NO_WRAP, "ABC", "DEF", "GHI");
        wrapSearch = new SuperWordSearch(4, 3, SuperWordSearch.Mode.WRAP, "ABC", "DEF", "GHI", "JKL");
    }

    /*
    3 3
    ABC
    DEF
    GHI
    NO_WRAP
    5
    FED
    CAB
    GAD
    BID
    HIGH
    */
    @Test
    public void testNoWrapSearch() throws Exception {
        List<Subscript> s0 = noWrapSearch.search("FED");
        List<Subscript> s1 = noWrapSearch.search("CAB");
        List<Subscript> s2 = noWrapSearch.search("GAD");
        List<Subscript> s3 = noWrapSearch.search("BID");
        List<Subscript> s4 = noWrapSearch.search("HIGH");
        assertTrue(s0 != null);
        System.out.print(s0.get(0));
        System.out.print(s0.get(s0.size()-1));
        System.out.println();
        assertNull(s1);
        System.out.println("CAB NOT FOUND");
        assertNull(s2);
        System.out.println("GAD NOT FOUND");
        assertNull(s3);
        System.out.println("BID NOT FOUND");
        assertNull(s4);
        System.out.println("HIGH NOT FOUND");
    }
    
    /*
    4 3
	ABC
	DEF
	GHI
	JKL
	WRAP
	5
	FED
	CAB
	AEIJBFG
	LGEC
	HIGH
    */
    @Test
    public void testWrapSearch() throws Exception {
        List<Subscript> s0 = wrapSearch.search("FED");
        List<Subscript> s1 = wrapSearch.search("CAB");
        List<Subscript> s2 = wrapSearch.search("AEIJBFG");
        List<Subscript> s3 = wrapSearch.search("LGEC");
        List<Subscript> s4 = wrapSearch.search("HIGH");
        assertTrue(s0 != null);
        System.out.print(s0.get(0));
        System.out.print(s0.get(s0.size()-1));
        System.out.println();
        assertTrue(s1 != null);
        System.out.print(s1.get(0));
        System.out.print(s1.get(s1.size()-1));
        System.out.println();
        assertTrue(s2 != null);
        System.out.print(s2.get(0));
        System.out.print(s2.get(s2.size()-1));
        System.out.println();
        assertTrue(s3 != null);
        System.out.print(s3.get(0));
        System.out.print(s3.get(s3.size()-1));
        System.out.println();
        assertNull(s4);
        System.out.println("HIGH NOT FOUND");
    }
}