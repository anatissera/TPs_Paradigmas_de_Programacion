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
        assertEquals(sub.getOrientation(), "North");
	  
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
        assertEquals(0, sub.getDepth());
        assertEquals("North", sub.getOrientation());
	  
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
  public void Test04() { // se mueve hacia adelante
        Submarine sub = new Submarine();
        int initialDepth = sub.getDepth();
        sub.move("f");

        assertEquals (initialDepth, sub.getDepth());
	  
  }
  @Test
  public void Test05() { // rotar a la izquierda
        Submarine sub = new Submarine();
        int initialDepth = sub.getDepth();
        sub.move("l");

        assertEquals (initialDepth, sub.getDepth());
	  
  }
  @Test
  public void Test06() { // rotar a la derecha
        Submarine sub = new Submarine();
        int initialDepth = sub.getDepth();
        sub.move("r");

        assertEquals (initialDepth, sub.getDepth());

  @Test
  public void Test07() {
          // no pasa nada si le insistimos en emerger cuando está en superficie.
          Submarine sub = new Submarine();
          sub.move("uuuu");
          // verificar que no emerge más de lo que puede (arriba de 0)
          assertEquals(0, sub.getDepth());
	  
  }
  @Test
  public void Test08() {
          //no hay problemas con sumergirse demasiado
          Submarine sub = new Submarine();
          sub.move("dddd");
          // verificar que no tira error

  }
  @Test
  public void Test09() {
      // la cápsula sólo se puede lanzar en superficie o en el primer nivel de inmersión.
      //	En estos casos lanzar la cápsula no tiene ningún efecto detectable en el submarino.
      // (verificar que "dd" no tira error)

	  
  }
  @Test
  public void Test10() {
      //	Si se intenta liberar a mayor profundidad de lo permitido el submarino se destruye.
      // (verificar que "ddm" tira error)

  }
  @Test
  public void Test11() {
	  
  }
  
  private void assertThrowsLike( String message, Executable executable ) {
	    assertEquals( message,
                assertThrows( Exception.class, executable ).getMessage() );
	  }
  
}
