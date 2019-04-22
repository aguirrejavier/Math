package matrizMath;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatrizMathTest {

	@Test
	public void sumarTest() {
		MatrizMath mat = new MatrizMath(2,2);
		MatrizMath mat2 = new MatrizMath(2, 2);
		MatrizMath esperado = new MatrizMath(2,2);
		Double aux1[][] = { {-2.0,5.0} , {4.0,-7.0}};
		Double aux2[][] = { {7.0,3.0} , {1.0,0.0} };
		Double suma[][] = { {5.0,8.0} , {5.0,-7.0}};
		mat.setMat(aux1);
		mat2.setMat(aux2);
		esperado.setMat(suma);
		assertEquals(mat.sumar(mat2), esperado);
	}
	
	@Test
	public void restarTest() {
		MatrizMath mat = new MatrizMath(3,2);
		MatrizMath mat2 = new MatrizMath(3,2);
		MatrizMath esperado = new MatrizMath(3, 2);
		Double aux1[][] = { {-2.0,5.0} , {4.0,-7.0}, {10.0,2.0}};
		Double aux2[][] = { {7.0,3.0} , {1.0,-7.0} , {3.0,12.0}};
		Double resta[][] = { {-9.0,2.0} , {3.0,0.0}, {7.0,-10.0}};
		mat.setMat(aux1);
		mat2.setMat(aux2);
		esperado.setMat(resta);
		assertEquals(mat.restar(mat2), esperado);
	}
	
	@Test
	public void multiplicarMatrices() {
		MatrizMath mat = new MatrizMath(3,3);
		MatrizMath mat2 = new MatrizMath(3,1);
		MatrizMath esperado = new MatrizMath(3,1);
		Double aux1[][] = {{1.0,2.0,3.0},{1.0,1.0,1.0},{0.0,1.0,-1.0}};
		Double aux2[][] = {{1.0},{2.0},{1.0}};
		Double producto[][] = {{8.0},{4.0},{1.0}};
		mat.setMat(aux1);
		mat2.setMat(aux2);
		esperado.setMat(producto);
		assertEquals(esperado, mat.multiplicar(mat2));
	}

}
