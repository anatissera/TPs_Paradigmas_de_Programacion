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
  public void Test00() { 
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
  public void Test01() { //Si le decis que no haga nada, que no haga nada
	  Submarine sub = new Submarine();
	  sub.move("");
//	  assertEquals(0, sub.position_X());
//	  assertEquals(0, sub.position_Y());
//	  assertEquals(0, sub.getDepth());
//    assertEquals("North", sub.getOrientation());
	  
      checkPosition (sub);
      // refactorear tests 0 y 1
	  
  }
  @Test
  public void Test02() { // probar que baja
	  
	  Submarine sub = new Submarine();
	  int initialDepth = sub.getDepth();
	  sub.move("d");

      assertEquals (initialDepth -= 1, sub.getDepth());
      
	  checkPosition (sub, 0, 0 , -1, "North");
	  
  }
  
  @Test
  public void Test03() { // probar que no emerge de la superficie
	  Submarine sub = new Submarine();
	  sub.move("u");
	  
	  assertEquals (0, sub.getDepth());
  }
  @Test
  public void Test04() { // se mueve hacia adelante y no hacia abajo
        Submarine sub = new Submarine();
//        int initialCoordinates = 
        sub.move("f");
        
        checkPosition (sub, 0, 1 , 0, "North");
        
	  
  }
  @Test
  public void Test05() { // rotar a la izquierda y no hacia abajo
        Submarine sub = new Submarine();
        sub.move("l");
        
        checkPosition (sub, 0, 0 , 0, "West");

	  
  }
  @Test
  public void Test06() { // rotar a la derecha y no hacia abajo
        Submarine sub = new Submarine();
        int initialDepth = sub.getDepth();
        sub.move("r");
        
        checkPosition (sub, 0, 0 , 0, "East");

        assertEquals (initialDepth, sub.getDepth());
  }
  
  @Test
  public void Test07() {
	  // ejecuta las todos los comandos de un string
          Submarine sub = new Submarine();
          sub.move("dlfflfd");
          
          checkPosition (sub, -2, -1 , -2, "South");
  }
  
  @Test
  public void Test08() {
          // no pasa nada si le insistimos en emerger cuando está en superficie.
          Submarine sub = new Submarine();
          sub.move("uuuu");
          // verificar que no emerge más de lo que puede (arriba de 0)
          assertEquals(0, sub.getDepth());
	  
  }
  @Test
  public void Test09() {
          //no hay problemas con sumergirse demasiado
          Submarine sub = new Submarine();
          sub.move("dddd");
          // verificar que no tira error
          assertEquals(sub.getDepth(), -4);

  }
  
  @Test
  public void Test10() {
      //	Si se intenta liberar a mayor profundidad de lo permitido el submarino se destruye.
      // (verificar que "ddm" tira error)
	  Submarine sub = new Submarine();
	  assertThrowsLike(Coordinates.NoSePuedeLanzarLaCapsula, ()-> sub.move("ddm"));

  }
  @Test
  public void Test11() { 
	  
  }
  
  @Test
  public void Test12() {
	  
  }
  
  @Test
  public void Test13() {
	  
  }
  
  @Test
  public void Test14() {
	  
  }
  
  @Test
  public void Test15() {
	  
  }
  
  @Test
  public void Test16() {
	  
  }
  
  @Test
  public void Test17() {
	  
  }
  
  @Test
  public void Test18() {
	  
  }
  
  
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
  
}
