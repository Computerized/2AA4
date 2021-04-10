import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;

public class TestBoard {
	private final int [][] empty = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	private final int [][] full = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
	private Board b1;
	private Board b2;
	
	@Before
	public void setUp() {
		b1 = new Board(empty);
		b2 = new Board(full);
	}
	
	@Test
	public void testSetScore() {
		b1.setScore(12);
		assertTrue(12 == b1.getScore());
	}
	
	@Test
	public void testSetArray() {
		b1.setArray(full);
		assertTrue(Arrays.equals(full, b1.getArray()));
	}
	
	@Test
	public void testHasZeroTrue() {
		assertTrue(b1.hasZero());
	}
	
	@Test
	public void testHasZeroFalse() {
		assertFalse(b2.hasZero());
	}
}