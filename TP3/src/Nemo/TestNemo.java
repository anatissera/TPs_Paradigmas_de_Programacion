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
  public void Test02SubmarineMovesDown() {
	  
	  Submarine sub = defaultSubmarine();
	  int initialDepth = sub.getDepth();
	  sub.move('d');

      assertEquals (initialDepth - 1, sub.getDepth());
	  checkPosition (sub, defaultCoordinates() , -1, north() );
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
  public void Test05SubmarineRotatesLeft() {  
        checkPosition ( defaultSubmarine().move('l') , defaultCoordinates(), 0, west() );
  }
  
  @Test
  public void Test06SubmarineRotatesRight() { 
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
	  sub.move('m');
	  assertEquals(sub.getDepth(), 0);
  }
  
  @Test
  public void Test11SubmarineCanReleaseCapsuleOnImmersionLevel1() {
	  Submarine sub = defaultSubmarine();
	  sub.move("dm");
	  assertEquals(sub.getDepth(), -1);
  }
  
  @Test
  public void Test12SubmarineCannotReleaseCapsuleDeeperThanAllowed() {
	  Submarine sub = defaultSubmarine();
	  assertThrowsLike(DepthState.CannotReleaseCapsule, ()-> sub.move("ddm"));
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
  public void test20SubmarineDoesNothing() {
      checkDefaultPosition( defaultSubmarine().move("mmuuu") );
  }
  
  @Test
  public void Test21SubmarineExecutesCommandsInOrder() {
      checkPosition ( defaultSubmarine().move("dlfflfd") , new Coordinates(-2, -1), -2, south() );
  }
  
// Adicionales
  
  @Test
  public void test22SubmarineMovesDiagonally() {
      checkPosition( defaultSubmarine().move("ddlfrfum") , new Coordinates(-1, 1), -1, north() );
  }

  @Test
  public void test23SubmarineMovesInSquare() {
      checkDefaultPosition( defaultSubmarine().move("frfrfrfr") );
  }
  
  

  // ya está testeado de alguna otra manera, decidir qué hacer
  
  @Test
  public void testSubmarineMovesInComplexPath() {
      Submarine sub = defaultSubmarine();
      sub.move("frumumfrumm");
      checkPosition(sub, new Coordinates(1, 1), 0, south() );
  }


  @Test
  public void testSubmarineMovesInComplexPath2() {
      Submarine sub = defaultSubmarine();
      sub.move("fdlfruuurrr");
      checkPosition(sub, new Coordinates(-1, 1), 0, west() );
  }

  @Test
  public void testSubmarineMovesInComplexPath3() {
      Submarine sub = defaultSubmarine();
      sub.move("mumdmumddfru");
      checkPosition(sub, new Coordinates(0, 1), -1, east() );
  }

  @Test
  public void testSubmarineMovesInComplexPath4() {
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
