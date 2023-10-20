package Nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TestNemo {
  
  @Test
  public void Test00SubmarineInitializesCorrectly() { 
	  checkDefaultPosition ( defaultSubmarine() );
  }
  
  @Test
  public void Test01SubmarineDoesNothingWhenReceivingEmptyCommand() {
	  checkDefaultPosition ( defaultSubmarine().move("") );
  }
  
  @Test
  public void Test02Part1SubmarineMovesDownOnceReceivingAChar() {
      assertEquals ( - 1, defaultSubmarine().move('d').getDepth() );
  }
  
  @Test
  public void Test02Part2SubmarineMovesDownOnceReceivingAString() {
	  assertEquals ( - 1, defaultSubmarine().move("d").getDepth() );
  }
  
  @Test
  public void Test03SubmarineDoesnotEmergeFromSurface() {
	  assertEquals ( 0,  defaultSubmarine().move('u').getDepth() );
  }
  
  @Test
  public void Test04SubmarineMovesForwardOnce() { 
        checkPosition ( defaultSubmarine().move('f') , new Coordinates(0, 1), 0, north() );
  }
  
  @Test
  public void Test05SubmarineRotatesLeftOnce() {  
        checkPosition ( defaultSubmarine().move('l') , defaultCoordinates(), 0, west() );
  }
  
  @Test
  public void Test06SubmarineRotatesRightOnce() { 
        checkPosition ( defaultSubmarine().move('r') , defaultCoordinates(), 0, east() );
  }
  
  @Test
  public void Test07SubmarineHasNoProblemsMovingDownTooDeep() {
        assertEquals( defaultSubmarine().move("dddddddddd").getDepth() , -10 );
  }
  
  @Test
  public void Test08SubmarineDoesNotEmergeFromSurfaceEvenWhenInsistedOn() {
        assertEquals( 0, defaultSubmarine().move("uuuuu").getDepth() );  
  }
  
  public void Test09MovesUpAndDown() {
      Submarine sub = defaultSubmarine();
      sub.move("ddddd");
      assertEquals(sub.getDepth(), -5);
      sub.move("uuu");
      assertEquals(sub.getDepth(), -2);
  }
  
  @Test
  public void Test10SubmarineCanReleaseCapsuleOnSurface() {
	  Submarine sub = defaultSubmarine();
	  assertEquals(sub.getDepth(), 0);
	  sub.move('m');
	  checkDefaultPosition(sub);
  }
  
  @Test
  public void Test11SubmarineCanReleaseCapsuleOnImmersionLevel1() {
	  Submarine sub = defaultSubmarine();
	  sub.move("dm");
	  assertEquals(sub.getDepth(), -1);
	  checkPosition( sub, defaultCoordinates(), -1, north() );
  }
  
  @Test
  public void Test12Part1SubmarineCannotReleaseCapsuleDeeperThanAllowed() {
	  Submarine sub = defaultSubmarine();
	  sub.move("dd");
	  assertEquals(sub.getDepth(), -2);
	  assertThrowsLike(DepthState.CannotReleaseCapsule, ()-> sub.move('m'));
  }
  
  @Test
  public void Test12Part2SubmarineCannotReleaseCapsuleDeeperThanAllowedOnTheSameCommandMessage() {
	  assertThrowsLike(DepthState.CannotReleaseCapsule, ()-> defaultSubmarine().move("dddddm"));
  }
  
  @Test
  public void Test13SubmarineRotatesRightCirculary() {
	  testCircularRotation( 'r', east(), west() );
  }
  
  @Test
  public void Test14SubmarineRotatesLeftCirculary() {
	  testCircularRotation( 'l', west(), east() );
  }
  
  @Test
  public void test15SubmarineMovesCorrectlyWhenFacingNorth() {
      checkPosition( defaultSubmarine().move("ffff") , new Coordinates(0, 4), 0, north() );
  }
  

  @Test
  public void test16SubmarineMovesCorrectlyWhenFacingSouth() {
      checkPosition( defaultSubmarine().move("rrffff") , new Coordinates(0, -4), 0, south() );
  }

  @Test
  public void test17SubmarineMovesCorrectlyWhenFacingEast() {
      checkPosition( defaultSubmarine().move("rffff") , new Coordinates(4, 0), 0, east() );
  }
  
  @Test
  public void test18SubmarineMovesCorrectlyWhenFacingWest() {
      checkPosition( defaultSubmarine().move("lffff") , new Coordinates(-4, 0), 0, west() );
  }
 
  @Test
  public void Test19SubmarineCanMoveDownAfterReleasingACapsule() {
      assertEquals( defaultSubmarine().move("mdmddd").getDepth() , -4 );
  }
  
  @Test
  public void test20SubmarineDoesNothingWhenReceivingNonMovingCommandsOnANonMovingState() {
      checkDefaultPosition( defaultSubmarine().move("mumuu") );
  }
  
  @Test
  public void Test21SubmarineExecutesCommandsInOrder() {
      checkPosition ( defaultSubmarine().move("dlfflfd") , new Coordinates(-2, -1), -2, south() );
  }
  
  @Test
  public void test23SubmarineMovesInSquareBackToOriginalPosition() {
      checkDefaultPosition( defaultSubmarine().move("frfrfrfr") );
  }
  
  @Test
  public void test22SubmarineMovesDiagonally() {
      checkPosition( defaultSubmarine().move("ddlfrfum") , new Coordinates(-1, 1), -1, north() );
  }
  
  @Test
  public void test23SubmarineMovesInComplexPath() {
      Submarine sub = defaultSubmarine();
      sub.move("fdlfruuurrr");
      checkPosition(sub, new Coordinates(-1, 1), 0, west() );
  }

  @Test
  public void test24SubmarineMovesInComplexPath2() {
      Submarine sub = defaultSubmarine();
      sub.move("mumdmumddfru");
      checkPosition(sub, new Coordinates(0, 1), -1, east() );
  }

  @Test
  public void test25SubmarineMovesInComplexPath3() {
      Submarine sub = defaultSubmarine();
      sub.move("fdfrmfru");
      checkPosition(sub, new Coordinates(1, 2), 0, south() );
  }
  
  
  private Submarine defaultSubmarine() {
		return new Submarine ( defaultCoordinates(), north() );
  }

  private Coordinates defaultCoordinates() {
		return new Coordinates(0, 0);
  }

  private void checkDefaultPosition(Submarine sub) {
	   checkPosition(sub, defaultCoordinates(), 0, north());
  }

  private void checkPosition(Submarine sub, Coordinates coordinates, int z, Orientation direction) {
	   assertEquals(coordinates, sub.getCoordinates());
	   assertEquals(z, sub.getDepth());
	   assertEquals(direction, sub.getOrientation());
  }
  
  private OrientationNorth north() {
	  return new OrientationNorth();
  }
	
  private OrientationEast east() {
	  return new OrientationEast();
  }
	
  private OrientationSouth south() {
	  return new OrientationSouth();
  }
	
  private OrientationWest west() {
	  return new OrientationWest();
  }
	
  public void testCircularRotation(char directionRoL, Orientation FirstOrientation, Orientation LastOrientation) {
	  Submarine sub = defaultSubmarine();
	  assertEquals(sub.getOrientation(), north());
	  sub.move(directionRoL);
	  assertEquals(sub.getOrientation(), FirstOrientation);
	  sub.move(directionRoL);
	  assertEquals(sub.getOrientation(), south());
	  sub.move(directionRoL);
	  assertEquals(sub.getOrientation(), LastOrientation);
	  sub.move(directionRoL);
	  checkDefaultPosition (sub);
  }
  
  private void assertThrowsLike( String message, Executable executable ) {
	  assertEquals( message,
			  assertThrows( Exception.class, executable ).getMessage() );
  }
  
}
