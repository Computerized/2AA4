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
	private CourseT course;
	
	@Before
	public void setUp() {
		course = new CourseT(courseName, inds);
	}

	@Test
    public void testGetIndicators()
    {
        IndicatorT [] indsOut = course.getIndicators();
        assertTrue(Arrays.equals(indsOut, inds));
    }

}
