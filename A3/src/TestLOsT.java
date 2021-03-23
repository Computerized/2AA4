/**
 * Author: 
 * Revised: 
 * 
 * Description: 
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;

public class TestLOsT
{
	private LOsT lost1;
	
	@Before
	public void setUp() {
		lost1 = new LOsT("LOsT",1,2,3,4);
		Norm.setNLOs(false);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorBelowZero() {
		new LOsT("",1,-1,1,1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorAllZero() {
		new LOsT("",0,0,0,0);
	}

    @Test
    public void testGetName()
    {
        assertTrue(lost1.getName().equals("LOsT"));
    }
    
    @Test
    public void testEqualsSameObject() {
    	assertTrue(lost1.equals(lost1));
    }
    
    @Test
    public void testEqualsDifferentObject() {
    	assertTrue(lost1.equals(new LOsT("LOsT",1,2,3,4)));
    }
    
    @Test
    public void testMeasuresFalse() {
    	Norm.setNLOs(false);
    	double [] exp = {1.0,2.0,3.0,4.0};
    	assertTrue(Arrays.equals(lost1.measures(), exp));
    }
    
    @Test
    public void testMeasuresTrue() {
    	Norm.setNLOs(true);
    	double [] exp = {0.1,0.2,0.3,0.4};
    	assertTrue(Arrays.equals(lost1.measures(), exp));
    }
    
    @Test (expected=UnsupportedOperationException.class)
    public void testUnsupportedMeasuresInd() {
    	lost1.measures(IndicatorT.assumpt);
    }
    
    @Test (expected=UnsupportedOperationException.class)
    public void testUnsupportedMeasuresAtt() {
    	lost1.measures(new AttributeT("",new IndicatorT[0]));
    }
    
    

}
