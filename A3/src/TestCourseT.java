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

public class TestCourseT
{
	private final String courseName = "Course Name";
	private final IndicatorT [] inds = {IndicatorT.engInSoc, IndicatorT.openEnded, IndicatorT.tools};
	private LOsT outcome;
	private CourseT course;
	
	@Before
	public void setUp() {
		course = new CourseT(courseName, inds);
		outcome = new LOsT("Test",1,2,3,4);
		Norm.setNInd(true);
		Norm.setNAtt(true);
	}

	@Test
    public void testGetIndicators()
    {
        IndicatorT [] indsOut = course.getIndicators();
        assertTrue(Arrays.equals(indsOut, inds));
    }
	
	@Test
	public void testGetLOs() {
		LOsT [] outcome = {new LOsT("LOsTTest",1,2,3,4)};
		course.addLO(IndicatorT.engInSoc, outcome[0]);
		LOsT[] newOutcome = course.getLOs(IndicatorT.engInSoc);
		assertTrue(Arrays.equals(outcome, newOutcome));
	}
	
	@Test
	public void testAddLOs() {
		LOsT [] outcome = {this.outcome};
		course.addLO(IndicatorT.engInSoc, this.outcome);
		LOsT[] newOutcome = course.getLOs(IndicatorT.engInSoc);
		assertTrue(Arrays.equals(outcome, newOutcome));
	}
	
	@Test
	public void testDelLOs() {
		course.addLO(IndicatorT.engInSoc, outcome);
		LOsT [] before = course.getLOs(IndicatorT.engInSoc);
		course.delLO(IndicatorT.engInSoc, outcome);
		LOsT [] after = course.getLOs(IndicatorT.engInSoc);
		assertFalse(Arrays.equals(before, after));
	}
	
	@Test
	public void testDelLOsEmpty() {
		LOsT [] before = course.getLOs(IndicatorT.engInSoc);
		course.delLO(IndicatorT.engInSoc, outcome);
		LOsT [] after = course.getLOs(IndicatorT.engInSoc);
		assertTrue(Arrays.equals(before, after));
	}
	
	@Test
	public void testMember() {
		course.addLO(IndicatorT.engInSoc, outcome);
		LOsT [] losts = {outcome};
		assertTrue(course.member(IndicatorT.engInSoc, losts));
	}
	
	@Test
	public void testNotMember() {
		LOsT [] losts = {outcome};
		assertFalse(course.member(IndicatorT.engInSoc, losts));
	}
	
	@Test
	public void testMemberEmpty() {
		assertTrue(course.member(IndicatorT.engInSoc, new LOsT[0]));
	}
	
	@Test
	public void testMeasureIndNormTrue() {
		Norm.setNInd(true);
		LOsT test1 = new LOsT("test1",1,1,1,1);
		LOsT test2 = new LOsT("test2",2,2,2,2);
		LOsT test3 = new LOsT("test3",2,2,2,2);
		course.addLO(IndicatorT.engInSoc, test1);
		course.addLO(IndicatorT.engInSoc, test2);
		course.addLO(IndicatorT.engInSoc, test3);
		double [] expected = {0.25,0.25,0.25,0.25};
		double [] out = course.measures(IndicatorT.engInSoc);
		assertTrue(Arrays.equals(expected, out));
	}
	
	@Test
	public void testMeasureIndNormFalse() {
		Norm.setNInd(false);
		LOsT test1 = new LOsT("test1",2,2,2,2);
		LOsT test2 = new LOsT("test2",1,2,3,4);
		LOsT test3 = new LOsT("test3",1,2,4,2);
		course.addLO(IndicatorT.engInSoc, test1);
		course.addLO(IndicatorT.engInSoc, test2);
		course.addLO(IndicatorT.engInSoc, test3);
		double [] out = course.measures(IndicatorT.engInSoc);
		double [] expected = {4.0,6.0,9.0,8.0};
		assertTrue(Arrays.equals(out, expected));
	}
	
	@Test
	public void testmMeasureIndEmpty() {
		double [] out = course.measures(IndicatorT.engInSoc);
		double [] expected = {0.0,0.0,0.0,0.0};
		assertTrue(Arrays.equals(out, expected));
	}
	
	@Test
	public void testMeasureAttTrue() {
		Norm.setNAtt(true);
		LOsT test1 = new LOsT("test1",1,1,1,1);
		LOsT test2 = new LOsT("test2",1,1,1,1);
		LOsT test3 = new LOsT("test3",1,1,1,1);
		course.addLO(IndicatorT.engInSoc, test1);
		course.addLO(IndicatorT.engInSoc, test2);
		course.addLO(IndicatorT.engInSoc, test3);
		LOsT test4 = new LOsT("test4",1,1,1,1);
		LOsT test5 = new LOsT("test5",1,1,1,1);
		LOsT test6 = new LOsT("test6",1,1,1,1);
		course.addLO(IndicatorT.openEnded, test4);
		course.addLO(IndicatorT.openEnded, test5);
		course.addLO(IndicatorT.openEnded, test6);
		IndicatorT[] inds = {IndicatorT.engInSoc, IndicatorT.openEnded};
		AttributeT att = new AttributeT("testAtt", inds);
		double [] expected = {0.25,0.25,0.25,0.25};
		double [] out = course.measures(att);
		assertTrue(Arrays.equals(expected, out));
	}
	
	@Test
	public void testMeasureAttFalse() {
		Norm.setNAtt(false);
		LOsT test1 = new LOsT("test1",1,1,1,1);
		LOsT test2 = new LOsT("test2",1,1,1,1);
		LOsT test3 = new LOsT("test3",1,1,1,1);
		course.addLO(IndicatorT.engInSoc, test1);
		course.addLO(IndicatorT.engInSoc, test2);
		course.addLO(IndicatorT.engInSoc, test3);
		LOsT test4 = new LOsT("test4",1,1,1,1);
		LOsT test5 = new LOsT("test5",1,1,1,1);
		LOsT test6 = new LOsT("test6",1,1,1,1);
		course.addLO(IndicatorT.openEnded, test4);
		course.addLO(IndicatorT.openEnded, test5);
		course.addLO(IndicatorT.openEnded, test6);
		IndicatorT[] inds = {IndicatorT.engInSoc, IndicatorT.openEnded};
		AttributeT att = new AttributeT("testAtt", inds);
		double [] expected = {0.5,0.5,0.5,0.5};
		double [] out = course.measures(att);
		assertTrue(Arrays.equals(expected, out));
	}
	
	@Test
	public void testMeasureAttEmpty() {
		IndicatorT[] inds = {};
		AttributeT att = new AttributeT("testAtt", inds);
		double [] expected = {0.0,0.0,0.0,0.0};
		double [] out = course.measures(att);
		assertTrue(Arrays.equals(expected, out));
	}
	
	@Test (expected=UnsupportedOperationException.class)
	public void testMeasureException() {
		course.measures();
	}
}
