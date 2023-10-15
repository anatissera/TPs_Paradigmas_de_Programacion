package Nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TestNemo {
  
  @Test
  public void Test00SubmarineInitializesCorrectly() { 
	  Submarine sub = new Submarine ();
	  
	  checkPosition (sub);
	  //en qué profundidad está: aparece en la superficie
//	  assertEquals(sub.getDepth(), 0);
//	  
//	  //coordenada inicial, posición en superficie. ¿Cuál es la posición?
//	  assertEquals(sub.position_X(), 0);
//	  assertEquals(sub.position_Y(), 0);
//	  
//	  //dirección: a dónde mira ¿Dónde está mirando?
//      assertEquals(sub.getOrientation(), "North");
	  
  } // lo que pasa con la profundidad no es lo mismo que en la superficie
  // la profundidad explota
  // la superficie no

  
  @Test
  public void Test01SubmarineDoesNothingWhenEmptyCommand() { //Si le decis que no haga nada, que no haga nada
	  Submarine sub = new Submarine();
	  sub.move("");
	  
      checkPosition (sub);
	  
  }
  @Test
  public void Test02SubmarineMovesDown() {
	  
	  Submarine sub = new Submarine();
	  int initialDepth = sub.getDepth();
	  sub.move("d");

      assertEquals (initialDepth -= 1, sub.getDepth());
      
	  checkPosition (sub, 0, 0 , -1, "North");
	  
  }
  
  @Test
  public void Test03SubmarineDoesnotEmergeFromSurface() {
	  Submarine sub = new Submarine();
	  sub.move("u");
	  
	  assertEquals (0, sub.getDepth());
  }
  
  @Test
  public void Test04SubmarineMovesForwardOnce() { 
        Submarine sub = new Submarine();
        sub.move("f");
        
        checkPosition (sub, 0, 1 , 0, "North");
  }
  
  @Test
  public void Test05SubmarineRotatesLeft() { 
        Submarine sub = new Submarine();
        sub.move("l");
        
        checkPosition (sub, 0, 0 , 0, "West");
  }
  
  @Test
  public void Test06SubmarineRotatesRight() { 
        Submarine sub = new Submarine();
        sub.move("r");
        
        checkPosition (sub, 0, 0 , 0, "East");
  }
  
  @Test
  public void Test07SubmarineHasNoProblemsMovingDownTooDeep() {
          Submarine sub = new Submarine();
          sub.move("dddddddddd");
          assertEquals(sub.getDepth(), -10);
  }
  
  @Test
  public void Test08SubmarineDoesNotEmergeFromSurfaceEvenWhenInsistedOn() {
         
          Submarine sub = new Submarine();
          sub.move("uuuuu");
          assertEquals(0, sub.getDepth());  
  }
  
  public void Test09MovesUpAndDown() {

      Submarine sub = new Submarine();
      sub.move("ddddd");
      assertEquals(sub.getDepth(), -5);
      sub.move("uuu");
      assertEquals(sub.getDepth(), -2);
      
      // verificar que no tira error
  }
  
  @Test
  public void Test10SubmarineCanReleaseCapsuleOnSurface() {
	  Submarine sub = new Submarine();
	  sub.move("m");
  }
  
  @Test
  public void Test11SubmarineCanReleaseCapsuleOnImmersionLevel1() {
	  Submarine sub = new Submarine();
	  sub.move("dm");
  }
  
  @Test
  public void Test12SubmarineCannotReleaseCapsuleDeeperThanAllowed() {
	  Submarine sub = new Submarine();
	  assertThrowsLike(DepthState.CannotReleaseCapsule, ()-> sub.move("ddm"));
  }
  @Test
  public void Test13SubmarineRotatesRightCirculary() {
	  Submarine sub = new Submarine();
      sub.move("r");
      assertEquals(sub.getOrientation(), "East");
      sub.move("r");
      assertEquals(sub.getOrientation(), "South");
      sub.move("r");
      assertEquals(sub.getOrientation(), "West");
      sub.move("r");
      checkPosition (sub);

  }
  
  @Test
  public void Test14SubmarineRotatesLeftCirculary() {
	  
	  Submarine sub = new Submarine();
	  sub.move("l");
	  assertEquals(sub.getOrientation(), "West");
	  sub.move("l");
	  assertEquals(sub.getOrientation(), "South");
	  sub.move("l");
	  assertEquals(sub.getOrientation(), "East");
	  sub.move("l");
	  checkPosition (sub);

  }
  
  @Test
  public void test15SubmarineMovesCorrectlyWhenFacingNorth() {
      Submarine sub = new Submarine();
      sub.move("ffff");
      checkPosition(sub, 0, 4, 0, "North");
  }
  

  @Test
  public void test16SubmarineMovesCorrectlyWhenFacingSouth() {
      Submarine sub = new Submarine();
      sub.move("rrffff");
      checkPosition(sub, 0, -4, 0, "South");
  }

  @Test
  public void test17SubmarineMovesCorrectlyWhenFacingEast() {
      Submarine sub = new Submarine();
      sub.move("rffff");
      checkPosition(sub, 4, 0, 0, "East");
  }
  

  @Test
  public void test18SubmarineMovesCorrectlyWhenFacingWest() {
      Submarine sub = new Submarine();
      sub.move("lffff");
      checkPosition(sub, -4, 0, 0, "West");
  }
 
  @Test
  public void Test19SubmarineCanMoveDownAfterReleasingACapsule() {
      Submarine sub = new Submarine();
      sub.move("mdmddd");
      
      assertEquals(sub.getDepth(), -4);
  }
  
  @Test
  public void Test20SubmarineExecutesCommandsInOrder() {
      Submarine sub = new Submarine();
      sub.move("dlfflfd");
          
      checkPosition (sub, -2, -1 , -2, "South");
  }
  
// Adicionales
  
  @Test
  public void testSubmarineDoesNothing() {
      Submarine sub = new Submarine();
      sub.move("mmuuu");
      checkPosition(sub);
  }


  @Test
  public void testSubmarineMovesForward() {
      Submarine sub = new Submarine();
      sub.move("frfrfrfr");
      checkPosition(sub, 0, 0, 0, "North");
  }

  @Test
  public void testSubmarineMovesDown() {
      Submarine sub = new Submarine();
      sub.move("dfd");
      checkPosition(sub, 0, 1, -2, "North");
  }

  @Test
  public void testSubmarineMovesDiagonally() {
      Submarine sub = aSubmarine();
      sub.move("ddlfrfum");
      checkPosition(sub, -1, 1, -1, "North");
  }

  @Test
  public void testSubmarineMovesInComplexPath() {
      Submarine sub = aSubmarine();
      sub.move("frumumfrumm");
      checkPosition(sub, 1, 1, 0, "South");
  }


  @Test
  public void testSubmarineComplexPath() {
      Submarine sub = aSubmarine();
      sub.move("fdlfruuurrr");
      checkPosition(sub, -1, 1, 0, "West");
  }

  @Test
  public void testSubmarinePerformsMixedMoves() {
      Submarine sub = aSubmarine();
      sub.move("mumdmumddfru");
      checkPosition(sub, 0, 1, -1, "East");
  }

  @Test
  public void testSubmarineComplexCommands() {
      Submarine sub = aSubmarine();
      sub.move("fdfrmfru");
      checkPosition(sub, 1, 2, 0, "South");
  }
  //
  
  private void assertThrowsLike( String message, Executable executable ) {
	    assertEquals( message,
                assertThrows( Exception.class, executable ).getMessage() );
	  }
  
  
  private void checkPosition(Submarine sub) {
	    checkPosition(sub, 0, 0, 0, "North");
	}

	private void checkPosition(Submarine sub, int x, int y, int z, String direction) {
	    assertEquals(x, sub.getPosition_X());
	    assertEquals(y, sub.getPosition_Y());
	    assertEquals(z, sub.getDepth());
	    assertEquals(direction, sub.getOrientation());
	}
	
    private Submarine aSubmarine() {
        return new Submarine();
    }
  
}
