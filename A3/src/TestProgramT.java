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

public class TestProgramT {
	
	private ProgramT program = new ProgramT();
	private final IndicatorT [] inds1 = {IndicatorT.assumpt, IndicatorT.awarePEO,IndicatorT.desPrinciples};
	private final IndicatorT [] inds2 = {IndicatorT.assumpt, IndicatorT.awarePEO,IndicatorT.desProcess};
	private final IndicatorT [] shared = {IndicatorT.assumpt, IndicatorT.awarePEO};
	private final AttributeT att = new AttributeT("Shared Indicators", shared);
	private CourseT course1, course2;
	
	@Before
	public void setUp() {
		Norm.setNAtt(false);
		Norm.setNInd(false);
		course1 = new CourseT("Course 1", inds1);
		course2 = new CourseT("Course 2", inds2);
		course1.addLO(IndicatorT.assumpt, new LOsT("Goal 1",1,1,1,1));
		course1.addLO(IndicatorT.assumpt, new LOsT("Goal 2",2,2,2,2));
		course2.addLO(IndicatorT.assumpt, new LOsT("Goal 3",3,3,3,3));
		course2.addLO(IndicatorT.assumpt, new LOsT("Goal 4",4,4,4,4));
		course1.addLO(IndicatorT.awarePEO, new LOsT("Goal 5",1,1,1,1));
		course1.addLO(IndicatorT.awarePEO, new LOsT("Goal 6",2,2,2,2));
		course2.addLO(IndicatorT.awarePEO, new LOsT("Goal 7",3,3,3,3));
		course2.addLO(IndicatorT.awarePEO, new LOsT("Goal 8",4,4,4,4));
		program.add(course1);
		program.add(course2);
	}
	
	@Test (expected=UnsupportedOperationException.class)
    public void testMeasureNoParam()
    {
        program.measures();
    }
	
	@Test (expected=UnsupportedOperationException.class)
	public void testMeasureInd() {
		program.measures(IndicatorT.assumpt);
	}
	
	@Test
	public void testMeasure() {
		double [] expected = {0.25,0.25,0.25,0.25};
		double [] out = program.measures(att);
		assertTrue(Arrays.equals(out, expected));
	}
	
	@Test
	public void testMeasureNotExists() {
		double [] expected = {0.0,0.0,0.0,0.0};
		IndicatorT [] inds2 = {IndicatorT.estOutcomes, IndicatorT.math};
		AttributeT att2 = new AttributeT("", inds2);
		double [] out = program.measures(att2);
		assertTrue(Double.isNaN(out[0]));
	}

}
