/**
 * Author: 
 * Revised: 
 * 
 * Description: 
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

public class TestAttributeT
{
	private AttributeT att0,att1;
	private IndicatorT[] inds = {IndicatorT.desPrinciples, IndicatorT.desProcess};

	@Before
	public void setUp() {
		att0 = new AttributeT("",new IndicatorT[0]);
		att1 = new AttributeT("Ind",inds);
	}
	
    @Test
    public void testEmptyGetName()
    {
    	
        assertTrue(att0.getName().equals(""));
    }
    
    @Test
    public void testGetName() {
    	assertTrue(att1.getName().equals("Ind"));
    }
    
    @Test
    public void testEmptyInds() {
    	assertTrue(att0.getIndicators().length == 0);
    }
    
    @Test
    public void testGetInds() {
    	IndicatorT[] ins = att1.getIndicators();
    	assertTrue(ins[0] == IndicatorT.desPrinciples && ins[1] == IndicatorT.desProcess);
    }

}
