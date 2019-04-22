package vectorMath;

import static org.junit.Assert.*;

import org.junit.Test;

public class VectorMathTest {
	@Test
	public void sumarTest() {
		VectorMath[] vecs = {new VectorMath(2), new VectorMath(2), new VectorMath(2)};
		Double[] coord = {2.0,4.0};
		Double[] coord2 = {5.0,-7.0};
		Double[] coordSuma = {7.0,-3.0};
		vecs[0].setCoord(coord);
		vecs[1].setCoord(coord2);
		vecs[2].setCoord(coordSuma);
		assertEquals(vecs[2], vecs[0].sumar(vecs[1]));
	}
	
	@Test
	public void restarTest() {
		VectorMath[] vecs = {new VectorMath(3), new VectorMath(3), new VectorMath(3)};
		Double[][] coords = {{2.0,-6.0,15.0},{-5.0,10.0,-20.0},{7.0,-16.0,35.0}};
		for(int i=0; i<3; i++) 
			vecs[i].setCoord(coords[i]);
		assertEquals(vecs[2], vecs[0].restar(vecs[1]));
	}
	
	@Test
	public void productoPuntoTest() {
		VectorMath[] vecs = {new VectorMath(3), new VectorMath(3)};
		Double[][] coords = { {2.0,-6.0,15.0} , {-5.0,10.0,-20.0}};
		Double esperado = -370.0;
		vecs[0].setCoord(coords[0]);
		vecs[1].setCoord(coords[1]);
		assertEquals(esperado, vecs[0].productoPunto(vecs[1]));
	}
	
	@Test
	public void productoEscalarTest() {
		VectorMath[] vecs = {new VectorMath(3), new VectorMath(3)};
		Double[][] coords = { {2.0,-6.0,15.0} ,{3.0,-9.0,22.5}};
		Double escalar = 1.5;
		vecs[0].setCoord(coords[0]);
		vecs[1].setCoord(coords[1]);
		assertEquals(vecs[1], vecs[0].productoEscalar(escalar));
	}
}