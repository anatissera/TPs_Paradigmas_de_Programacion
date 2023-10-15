package Nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TestNemo {
  
  @Test
  public void Test00SubmarineInitializesCorrectly() { 
	  checkDefaultPosition ( new Submarine () );
  }

  
  @Test
  public void Test01SubmarineDoesNothingWhenReceivingEmptyCommand() {
	  checkDefaultPosition ( new Submarine().move("") );
  }
  
  @Test
  public void Test02SubmarineMovesDown() {
	  
	  Submarine sub = new Submarine();
	  int initialDepth = sub.getDepth();
	  sub.move("d");

      assertEquals (initialDepth - 1, sub.getDepth());
      
	  checkPosition (sub, 0, 0 , -1, "North");
  }
  
  @Test
  public void Test03SubmarineDoesnotEmergeFromSurface() {
	  assertEquals (0,  new Submarine().move("u").getDepth() );
  }
  
  @Test
  public void Test04SubmarineMovesForwardOnce() { 
        checkPosition ( new Submarine().move("f") , 0, 1 , 0, "North");
  }
  
  @Test
  public void Test05SubmarineRotatesLeft() {  
        checkPosition ( new Submarine().move("l") , 0, 0 , 0, "West");
  }
  
  @Test
  public void Test06SubmarineRotatesRight() { 
        checkPosition ( new Submarine().move("r") , 0, 0 , 0, "East");
  }
  
  @Test
  public void Test07SubmarineHasNoProblemsMovingDownTooDeep() {
        assertEquals( new Submarine().move("dddddddddd").getDepth() , -10);
  }
  
  @Test
  public void Test08SubmarineDoesNotEmergeFromSurfaceEvenWhenInsistedOn() {
        assertEquals(0, new Submarine().move("uuuuu").getDepth() );  
  }
  
  public void Test09MovesUpAndDown() {
      Submarine sub = new Submarine();
      sub.move("ddddd");
      assertEquals(sub.getDepth(), -5);
      sub.move("uuu");
      assertEquals(sub.getDepth(), -2);
  }
  
  @Test
  public void Test10SubmarineCanReleaseCapsuleOnSurface() {
	  Submarine sub = new Submarine();
	  sub.move("m");
	  assertEquals(sub.getDepth(), 0);
  }
  
  @Test
  public void Test11SubmarineCanReleaseCapsuleOnImmersionLevel1() {
	  Submarine sub = new Submarine();
	  sub.move("dm");
	  assertEquals(sub.getDepth(), -1);
  }
  
  @Test
  public void Test12SubmarineCannotReleaseCapsuleDeeperThanAllowed() {
	  Submarine sub = new Submarine();
	  assertThrowsLike(DepthState.CannotReleaseCapsule, ()-> sub.move("ddm"));
	  assertEquals(sub.getDepth(), -2);
  }
  
  @Test
  public void Test13SubmarineRotatesRightCirculary() {
	  testCircularRotation("r", "East", "West");
  }
  
  @Test
  public void Test14SubmarineRotatesLeftCirculary() {
	  testCircularRotation("l", "West", "East");
  }
  
  @Test
  public void test15SubmarineMovesCorrectlyWhenFacingNorth() {
      checkPosition( new Submarine().move("ffff") , 0, 4, 0, "North" );
  }
  

  @Test
  public void test16SubmarineMovesCorrectlyWhenFacingSouth() {
      checkPosition( new Submarine().move("rrffff") , 0, -4, 0, "South" );
  }

  @Test
  public void test17SubmarineMovesCorrectlyWhenFacingEast() {
      checkPosition( new Submarine().move("rffff") , 4, 0, 0, "East" );
  }
  

  @Test
  public void test18SubmarineMovesCorrectlyWhenFacingWest() {
      checkPosition( new Submarine().move("lffff") , -4, 0, 0, "West" );
  }
 
  @Test
  public void Test19SubmarineCanMoveDownAfterReleasingACapsule() {
      assertEquals( new Submarine().move("mdmddd").getDepth() , -4 );
  }
  
  @Test
  public void test20SubmarineDoesNothing() {
      checkDefaultPosition( new Submarine().move("mmuuu") );
  }
  
  @Test
  public void Test21SubmarineExecutesCommandsInOrder() {
      checkPosition ( new Submarine().move("dlfflfd") , -2, -1 , -2, "South");
  }
  
// Adicionales
  
  @Test
  public void test22SubmarineMovesDiagonally() {
      checkPosition( new Submarine().move("ddlfrfum") , -1, 1, -1, "North");
  }

  @Test
  public void test23SubmarineMovesInSquare() {
      checkDefaultPosition( new Submarine().move("frfrfrfr") );
  }

  // ya está testeado de alguna otra manera, decidir qué hacer
  
  @Test
  public void testSubmarineMovesInComplexPath() {
      Submarine sub = new Submarine();
      sub.move("frumumfrumm");
      checkPosition(sub, 1, 1, 0, "South");
  }


  @Test
  public void testSubmarineMovesInComplexPath2() {
      Submarine sub = new Submarine();
      sub.move("fdlfruuurrr");
      checkPosition(sub, -1, 1, 0, "West");
  }

  @Test
  public void testSubmarineMovesInComplexPath3() {
      Submarine sub = new Submarine();
      sub.move("mumdmumddfru");
      checkPosition(sub, 0, 1, -1, "East");
  }

  @Test
  public void testSubmarineMovesInComplexPath4() {
      Submarine sub = new Submarine();
      sub.move("fdfrmfru");
      checkPosition(sub, 1, 2, 0, "South");
  }
  
  // funciones auxiliares
  private void assertThrowsLike( String message, Executable executable ) {
	   assertEquals( message,
               assertThrows( Exception.class, executable ).getMessage() );
  }
  
  
  private void checkDefaultPosition(Submarine sub) {
	   checkPosition(sub, 0, 0, 0, "North");
  }

  private void checkPosition(Submarine sub, int x, int y, int z, String direction) {
	   assertEquals(x, sub.getPosition_X());
	   assertEquals(y, sub.getPosition_Y());
	   assertEquals(z, sub.getDepth());
	   assertEquals(direction, sub.getOrientation());
  }
	
  public void testCircularRotation(String directionRoL, String FirstOrientation, String LastOrientation) {
	  Submarine sub = new Submarine();
	  assertEquals(sub.getOrientation(), "North");
	  sub.move(directionRoL);
	  assertEquals(sub.getOrientation(), FirstOrientation);
	  sub.move(directionRoL);
	  assertEquals(sub.getOrientation(), "South");
	  sub.move(directionRoL);
	  assertEquals(sub.getOrientation(), LastOrientation);
	  sub.move(directionRoL);
	  checkDefaultPosition (sub);
  }
  
}
