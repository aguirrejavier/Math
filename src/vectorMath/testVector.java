package vectorMath;

import java.util.Vector;

public class testVector {

	public static void main(String[] args) {
		VectorMath vec = new VectorMath(4);
		Double [] cord1 = {1.0,5.1,4.8,0.4};
		Double [] cord2 = {9.0,8.1,4.8,7.4};
		vec.setCoord(cord1);
		
		VectorMath vec2 = vec.clone();
		vec.setCoord(cord2);
		System.out.println(vec2.toString());
		System.out.println(vec.normaInfinita());
	}

}
