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
		
		LOsT [] losts = {outcome};
	}
}
