package Nemo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class NemoTest {
  
  @Test
  public void Test00() { 
	  Submarine sub = new Submarine ();
	  //en qué profundidad está: aparece en la superficie
	  assertEquals(sub.getDepth(), 0);
	  assertEquals(sub.position_X(), 0);
	  assertEquals(sub.position_Y(), 0);
	  
//	  assertEquals(sub.getOrientation(), "Norte");
	  
  } // lo que pasa con la profundidad no es lo mismo que en la superficie
  // la profundidad explota
  // la superficie no
  
  //coordenada inicial, posición en superficie. ¿Cuál es la posición?
  
  //dirección: a dónde mira ¿Dónde está mirando?
  
  @Test
  public void Test01() { //Si le decis que no haga nada, que no haga nada
	  Submarine sub = new Submarine();
	  sub.move("");
	  assertEquals(0, sub.position_X());
	  assertEquals(0, sub.position_Y());
	  
  }
  @Test
  public void Test02() { // probar pasarle un caracter, sube y baja
	  Submarine sub = new Submarine();
	  int initialDepth = sub.getDepth();
	  sub.move("d");
	  
	  assertEquals (initialDepth -= 1, sub.getDepth());
	 
	  
  }
  @Test
  public void Test03() {
	  Submarine sub = new Submarine();
	  int initialDepth = sub.getDepth();
	  sub.move("u");
	  
	  assertEquals (initialDepth += 1, sub.getDepth());
  }
  @Test
  public void Test04() {
	  
  }
  @Test
  public void Test05() {
	  
  }
  @Test
  public void Test06() {
	  
  }
  @Test
  public void Test07() {
	  
  }
  @Test
  public void Test08() {
	  
  }
  @Test
  public void Test09() {
	  
  }
  @Test
  public void Test10() {
	  
  }
  @Test
  public void Test11() {
	  
  }
  @Test
  public void Test12() {
	  
  }
  
//  private void assertThrowsLike( String message, Executable executable ) {
//	    
//	    assertEquals( message,
//	                  assertThrows( Exception.class, executable ).getMessage() );
//	  }
  
}
