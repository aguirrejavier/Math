package vectorMath;

import java.util.Arrays;

import excepciones.DistDimException;
import excepciones.InvalidDimException;

public class VectorMath {
	
	private final int dim;
	private Double coord[];
	
	public int getDim() {
		return dim;
	}
	
	public Double[] getCoord() {
		return coord;
	}

	public void setCoord(Double[] coord) {
		if(dim!=coord.length)
			throw new DistDimException("El vector de coordenadas debe tener igual dimension a VectorMath");
		this.coord = coord;
	}

	public VectorMath(int dim) throws InvalidDimException{
		if(dim<2)
			throw new InvalidDimException("La dimension debe ser mayor a 2");
		this.dim=dim;
		this.coord = new Double[dim];
	}
	
	public VectorMath sumar(VectorMath vec) throws DistDimException{
		if(dim!=vec.dim)
			throw new DistDimException("Los vectores tienen distinta dimensión");
		VectorMath suma = new VectorMath(dim);
		for(int i=0; i<dim; i++)
			suma.coord[i]=coord[i]+vec.coord[i];
		return suma;
	}
	
	
	public VectorMath restar(VectorMath vec) throws DistDimException{
		if(dim!=vec.dim)
			throw new DistDimException("Los vectores tienen distinta dimension");
		VectorMath resta = new VectorMath(dim);
		for(int i=0; i<dim; i++)
			resta.coord[i]=coord[i]-vec.coord[i];
		return resta;
	}
	
	
	public Double productoPunto(VectorMath vec) throws DistDimException{
		if(dim!=vec.dim)
			throw new DistDimException("Los vectores tienen distinta dimension");
		Double acum=0.0;
		for(int i=0; i<dim; i++)
			acum+=coord[i]*vec.coord[i];
		return acum;
	}
	
	public VectorMath productoEscalar(Double escalar) {
		VectorMath producto = new VectorMath(dim);
		for(int i=0; i<dim; i++) {
			producto.coord[i]=coord[i]*escalar;	
		}
		return producto;
	}
	
	
	
	@Override
	public String toString() {
		return "VectorMath [dim=" + dim + ", coord=" + Arrays.toString(coord) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(coord);
		result = prime * result + dim;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VectorMath other = (VectorMath) obj;
		if (!Arrays.equals(coord, other.coord))
			return false;
		if (dim != other.dim)
			return false;
		return true;
	}

	
}
