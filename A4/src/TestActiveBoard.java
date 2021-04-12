/**
 * Author: Alan Scott, scotta30
 * Revised: 2021-04-12
 * 
 * Description: ActiveBoard test module
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class TestActiveBoard {
	private ActiveBoard AB1,AB2,AB3,AB4;
	private final int[][] noLegal = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	private final int[][] empty = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	private final int[][] legal = {{2,0,2,0},{0,2,2,0},{0,0,4,0},{2,0,4,0}};
	private final int[][] noMoveDownUp = {{0,2,0,0},{0,4,0,0},{0,2,0,0},{0,4,0,0}};
	
	@Before
	public void setUp() {
		AB1 = new ActiveBoard(noLegal);
		AB2 = new ActiveBoard(empty);
		AB3 = new ActiveBoard(legal);
		AB4 = new ActiveBoard(noMoveDownUp);
	}
	
	@Test
	public void testHasLegalMovesTrue() {
		assertTrue(AB3.hasLegalMoves());
	}
	
	@Test
	public void testHasLegalMovesEmpty() {
		assertTrue(AB2.hasLegalMoves());
	}
	
	@Test
	public void testHasLegalMovesFalse() {
		assertFalse(AB1.hasLegalMoves());
	}
	
	@Test
	public void testAddRandomTwo() {
		AB2.addRandomTwo();
		int numTwos = 0;
		int [][] arr = AB2.getArray();
		for (int[] row : arr) {
			for (int item : row) {
				if (item != 0) numTwos ++;
			}
		}
		assertTrue(numTwos == 1);
	}
	
	@Test
	public void testShiftUp() {
		int[][] expected = {{4,2,4,0},{0,0,8,0},{0,0,0,0},{0,0,0,0}};
		AB3.shiftUp();
		int[][] actual = AB3.getArray();
		
		boolean flag = true;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (expected[i][j] != actual[i][j]) flag = false;
		
		assertTrue(flag);
	}
	
	@Test
	public void testShiftDown() {
		int[][] expected = {{0,0,0,0},{0,0,0,0},{0,0,4,0},{4,2,8,0}};
		AB3.shiftDown();
		int[][] actual = AB3.getArray();
		
		boolean flag = true;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (expected[i][j] != actual[i][j]) flag = false;
		
		assertTrue(flag);
	}
	
	@Test
	public void testShiftLeft() {
		int[][] expected = {{4,0,0,0},{4,0,0,0},{4,0,0,0},{2,4,0,0}};
		AB3.shiftLeft();
		int[][] actual = AB3.getArray();
		
		boolean flag = true;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (expected[i][j] != actual[i][j]) flag = false;
		
		assertTrue(flag);
	}
	
	@Test
	public void testShiftRight() {
		int[][] expected = {{0,0,0,4},{0,0,0,4},{0,0,0,4},{0,0,2,4}};
		AB3.shiftRight();
		int[][] actual = AB3.getArray();
		
		boolean flag = true;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (expected[i][j] != actual[i][j]) flag = false;
		
		assertTrue(flag);
	}
	
	@Test
	public void testCanMoveUp() {
		assertFalse(AB4.canMove('U'));
	}
	
	@Test
	public void testCanMoveDown() {
		assertFalse(AB4.canMove('D'));
	}
	
	@Test
	public void testCanMoveLeft() {
		assertTrue(AB4.canMove('L'));
	}
	
	@Test
	public void testCanMoveRight() {
		assertTrue(AB4.canMove('R'));
	}

}
